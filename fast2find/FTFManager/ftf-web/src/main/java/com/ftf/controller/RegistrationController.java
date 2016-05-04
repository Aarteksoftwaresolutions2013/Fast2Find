package com.ftf.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ftf.model.BusinessAndEventInformation;
import com.ftf.model.PaypalDetails;
import com.ftf.service.ForgotService;
import com.ftf.service.RegistrationService;
import com.ftf.service.UpdateCustomerService;
import com.ftf.service.PaymentService;
import com.ftf.util.IConstant;
import com.ftf.validator.RegistrationValidator;

@Controller
public class RegistrationController {

  private static final Logger logger = Logger.getLogger(RegistrationController.class);
  @Autowired
  private RegistrationService registrationService;

  @Autowired
  private ForgotService forgotService;

  @Autowired
  private UpdateCustomerService updateCustomerService;

  @Autowired
  private RegistrationValidator registrationValidator;

  @Autowired
  private PaymentService paymentService;

  /**
   * showFrontPage() method for show registration page.
   * 
   * @param map
   * @param model
   * @param successMsg
   * @param param
   * @param request
   * @return
   */
  @RequestMapping("/registration")
  public String showFrontPage(Map<String, Object> map, Model model,
      @RequestParam(required = false) String successMsg,
      @RequestParam(required = false) String param, HttpServletRequest request) {
    HttpSession session = request.getSession();
    BusinessAndEventInformation regModel = (BusinessAndEventInformation) session
        .getAttribute("regModel");
    map.put("BusinessAndEventInformation", new BusinessAndEventInformation());
    if (regModel != null && param == null) {
      map.put("BusinessAndEventInformation", regModel);
    }
    model.addAttribute("successMsg", successMsg);
    return "registration";
  }

  /**
   * addBusinessAndEvent() method use to save user information into database
   * sendConfirmation() method send registration confirmation mail to customer
   * If user register as customer than after registration
   * 
   * @param businessAndEventInformation
   *          request send to paypalButton for payment information
   * @param result
   * @param model
   * @param map
   * @param request
   * @param param
   * @return
   */
  @RequestMapping(value = "/addBusinessAndEventInfo", method = RequestMethod.POST)
  public String userRegistration(
      @ModelAttribute("BusinessAndEventInformation") BusinessAndEventInformation businessAndEventInformation,
      BindingResult result, ModelMap model, Map<String, Object> map, HttpServletRequest request,
      @RequestParam(required = false) String param) {
    HttpSession session = request.getSession();
    session.setAttribute("regModel", businessAndEventInformation);
    boolean status = false;
    registrationValidator.validate(businessAndEventInformation, result);
    if (result.hasErrors()) {
      return "registration";
    }
    status = registrationService.addBusinessAndEvent(businessAndEventInformation);
    if (status) {
      if ((businessAndEventInformation.getLogin().getUserType().equals(IConstant.BUSINESS))
          || (businessAndEventInformation.getLogin().getUserType().equals(IConstant.EVENT))) {
        forgotService.sendConfirmation(businessAndEventInformation.getLogin().getPassword(),
            businessAndEventInformation.getLogin().getEmailId());
        model.addAttribute("successMsg", IConstant.REGISTRATION_SUCCESS_MSG);
        return "redirect:/registration.do";
      }
      if (businessAndEventInformation.getLogin().getUserType().equals(IConstant.CUSTOMER)) {
        if (businessAndEventInformation.getCustomerCatagory().equals(IConstant.free)) {
       /*   forgotService.sendConfirmation(businessAndEventInformation.getLogin().getPassword(),
              businessAndEventInformation.getLogin().getEmailId());*/
          model.addAttribute("successMsg", IConstant.REGISTRATION_SUCCESS_MSG);
        } else {
          model.addAttribute("successMsg", IConstant.SUCCESS_MESSAGE_FOR_FREEUSER);
          return "redirect:/paypalButton.do";
        }
      }
      return "redirect:/registration.do";
    } else {
      model
          .addAttribute(
              "successMsg",
              "You have already registered with us</br>please use:&nbsp;<a href='signIn.do'>Login</a>&nbsp;OR&nbsp;<a href='security.do'>Forgot Password</a>");
      return "redirect:/registration.do";
    }
  }

  /**
   * updateCustomerService() method use to fetch customre infrmation from data
   * base and show on registration page.
   * 
   * @param map
   * @param model
   * @param businessAndEventInformation
   * @param request
   * @param loginId
   */
  @RequestMapping(value = "/updateInfo", method = { RequestMethod.GET, RequestMethod.POST })
  public String showUpdatePage(Map<String, Object> map, ModelMap model,
      BusinessAndEventInformation businessAndEventInformation, HttpServletRequest request) {
    map.put("BusinessAndEventInformation", new BusinessAndEventInformation());
    HttpSession session = request.getSession();
    BusinessAndEventInformation loginMember = (BusinessAndEventInformation) session
        .getAttribute("login");
    if (loginMember != null) {
      Integer loginId = loginMember.getLogin().getLoginId();
      String method = request.getMethod();
      if (method.equals("GET")) {
        businessAndEventInformation = updateCustomerService.getCustomerInfoAdd(loginId);
        model.put("BusinessAndEventInformation", businessAndEventInformation);
        return "registrationUpdatePage";
      }
    } else {
      return "frontPage";
    }
    return "frontPage";
  }

  /**
   * updateCustomerInfoAdd() method use to uodate customer information.
   * 
   * @param businessAndEventInformation
   * @param result
   * @param model
   * @param map
   * @param request
   * @return
   */
  @RequestMapping(value = "/updateregistrationInfo", method = RequestMethod.POST)
  public String UpdatePage(
      @ModelAttribute("BusinessAndEventInformation") BusinessAndEventInformation businessAndEventInformation,
      BindingResult result, ModelMap model, Map<String, Object> map, HttpServletRequest request) {
    boolean status = false;
    registrationValidator.validate(businessAndEventInformation, result);
    if (result.hasErrors()) {
      return "registrationUpdatePage";
    }
    map.put("BusinessAndEventInformation", new BusinessAndEventInformation());
    status = updateCustomerService.updateCustomerInfoAdd(businessAndEventInformation);
    if (status) {
      model.addAttribute("successMsg", IConstant.UPDATE_SUCCESS_MESSAGE);
    } else {
      model.addAttribute("successMsg", IConstant.UPDATE_FAILURE_MESSAGE);
    }
    return "redirect:/updateSuccess.do";
  }

  /**
   * showUpdatePage() method use to show customer update success page.
   * @param map
   * @param model
   * @param successMsg
   * @return
   */
  @RequestMapping("/updateSuccess")
  public String showUpdatePage(Map<String, Object> map, Model model,
      @RequestParam(required = false) String successMsg) {
    map.put("BusinessAndEventInformation", new BusinessAndEventInformation());
    model.addAttribute("successMsg", successMsg);
    return "registrationUpdatePage";
  }

  /**
   * showPayment() method use to show payment page for subscribe button
   * @param map
   * @param model
   * @param successMsg
   * @return
   */
  @RequestMapping("/paypalButton")
  public String showPayment(Map<String, Object> map, Model model,
      @RequestParam(required = false) String successMsg) {
    model.addAttribute("successMsg", successMsg);
    return "paypalButton";
  }

  /**
   * savePaymentInformation() method use to save all transaction information into database.
   * updatePaidStatus() use to update paid_status  yes into database 
   * @param paypalDetails
   * @param result
   * @param model
   * @param map
   * @param request
   * @return
   */
  @RequestMapping(value = "/notify", method = { RequestMethod.GET, RequestMethod.POST })
  public String savePaymentDetails(@ModelAttribute("PaypalDetails") PaypalDetails paypalDetails,
      BindingResult result, ModelMap model, Map<String, Object> map, HttpServletRequest request) {
    System.out.println("....Inside a testDemo Controller....");
    try {
      /* if (request.getParameter("txn_id") != null) { */
      logger.error("-----Inside a savePaymentDetails method of Registration controller----");
      System.out.println("---Transaction Id----" + request.getParameter("txn_id"));
      System.out.println("****** payer_id******* : " + request.getParameter("payer_id"));
      System.out.println("****** first_name******* : " + request.getParameter("first_name"));
      System.out.println("****** subscr_id******* : " + request.getParameter("subscr_id"));
      System.out.println("****** payer_status******* : " + request.getParameter("payer_status"));
      System.out.println("****** business******* : " + request.getParameter("business"));
      System.out.println("****** payer_email******* : " + request.getParameter("payer_email"));
      System.out.println("****** last_name******* : " + request.getParameter("last_name"));
      System.out.println("****** address_state******* : " + request.getParameter("address_state"));
      System.out
          .println("****** receiver_email******* : " + request.getParameter("receiver_email"));
      System.out.println("****** recurring******* : " + request.getParameter("recurring"));
      System.out.println("****** txn_type******* : " + request.getParameter("txn_type"));
      System.out.println("****** item_name******* : " + request.getParameter("item_name"));
      System.out.println("****** mc_currency******* : " + request.getParameter("mc_currency"));
      System.out.println("****** residence_country******* : "
          + request.getParameter("residence_country"));
      System.out.println("****** test_ipn******* : " + request.getParameter("test_ipn"));
      System.out.println("****** ipn_track_id******* : " + request.getParameter("ipn_track_id"));
      System.out.println("****** PAyment Date******* : " + request.getParameter("payment_date"));
      System.out.println("****** MC_GROSS******* : " + request.getParameter("mc_gross"));
      logger.error("----MC_GROSS----Inside Logger" + request.getParameter("mc_gross"));
      paypalDetails.setTransactionId(request.getParameter("txn_id"));
      paypalDetails.setFirstName(request.getParameter("first_name"));
      paypalDetails.setLastName(request.getParameter("last_name"));
      paypalDetails.setPayeEmail(request.getParameter("payer_email"));
      paypalDetails.setPayerStatus(request.getParameter("payer_status"));
      paypalDetails.setSubscribeDate(request.getParameter("payment_date"));
      paypalDetails.setSubscribeId(request.getParameter("subscr_id"));
      paypalDetails.setTestIpn(request.getParameter("test_ipn"));
      paypalDetails.setAmount(request.getParameter("mc_gross"));
      paypalDetails.setTxnType(request.getParameter("txn_type"));
      paymentService.savePaymentInformation(paypalDetails);
      registrationService.updatePaidStatus();
      /*
       * } else { System.out.println("Invalid"); }
       */
    } catch (Exception e) {
      logger.error("Exception in ipn response : " + e.getMessage());
      e.printStackTrace();
    }
    return "paypalButton";
  }
  
  @RequestMapping(value = "/updateBusinessAndEventCust", method = { RequestMethod.GET, RequestMethod.POST })
  public String showMyAccountPage(Map<String, Object> map, ModelMap model,
      BusinessAndEventInformation businessAndEventInformation, HttpServletRequest request) {
    map.put("BusinessAndEventInformation", new BusinessAndEventInformation());
    HttpSession session = request.getSession();
    BusinessAndEventInformation loginMember = (BusinessAndEventInformation) session
        .getAttribute("login");
    if (loginMember != null) {
      Integer loginId = loginMember.getLogin().getLoginId();
      String method = request.getMethod();
      if (method.equals("GET")) {
        businessAndEventInformation = updateCustomerService.getInformation(loginId);
        model.put("BusinessAndEventInformation", businessAndEventInformation);
        return "editCustomerInfo";
      }
    } else {
      return "frontPage";
    }
    return "frontPage";
  }
  
  @RequestMapping(value = "/businessAndEventInformationEdit", method = RequestMethod.POST)
  public String updateAction(
      @ModelAttribute("BusinessAndEventInformation") BusinessAndEventInformation businessAndEventInformation,
      BindingResult result, ModelMap model, Map<String, Object> map, HttpServletRequest request,
      @RequestParam(required = false) String param) {
    HttpSession session = request.getSession();
    session.setAttribute("regModel", businessAndEventInformation);
    boolean status = false;
    registrationValidator.validate(businessAndEventInformation, result);
    if (result.hasErrors()) {
      return "editCustomerInfo";
    }
    status = registrationService.editBusinessCustomerInfo(businessAndEventInformation);
    if (status) {
      model.addAttribute("successMsg", IConstant.UPDATE_SUCCESS_MESSAGE);
    } else {
      model.addAttribute("successMsg", IConstant.UPDATE_FAILURE_MESSAGE);
    }
    return "redirect:/updateCustomerInformation.do";
  }
  @RequestMapping("/updateCustomerInformation")
  public String successPage(Map<String, Object> map, Model model,
      @RequestParam(required = false) String successMsg) {
    map.put("BusinessAndEventInformation", new BusinessAndEventInformation());
    model.addAttribute("successMsg", successMsg);
    return "editCustomerInfo";
  }
}