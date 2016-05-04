package com.ftf.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ftf.model.Login;
import com.ftf.model.QuickBooking;
import com.ftf.model.VisitorUser;
import com.ftf.service.QuickBookingService;
import com.ftf.util.IConstant;
import com.ftf.validator.QuickBookingValidator;

@Controller
public class QuickBookingController {

  @Autowired
  private QuickBookingService quickBookingService;

  @Autowired
  private QuickBookingValidator quickBookingValidator;

  /**
   * showQuickBooking method use to show business quick booking page.
   * @param map
   * @param model
   * @param branchId
   * @param businessName
   * @param feePerson
   * @return
   */
  @RequestMapping("/showQuickBookingPage")
  public String showQuickBooking(Map<String, Object> map, Model model,
      @RequestParam(required = false) Integer branchId,
      @RequestParam(required = false) String businessName,
      @RequestParam(required = false) String feePerson) {
    map.put("VisitorUser", new VisitorUser());
    map.put("QuickBooking", new QuickBooking());
    model.addAttribute("branchId", branchId);
    model.addAttribute("feePerPerson", feePerson);
    model.addAttribute("descreption", businessName);
    return "quickBooking";
  }
/**
 * addBooking method use to save business quick booking information into database.
 * validate method use to validate page field like blank validation etc.
 * @param quickBooking
 * @param result
 * @param model
 * @param request
 * @return
 */
  @RequestMapping(value = "/quickBookingAction", method = { RequestMethod.GET, RequestMethod.POST })
  public String businessQuick(@ModelAttribute("QuickBooking") QuickBooking quickBooking,
      BindingResult result, ModelMap model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    Login loginSession = (Login) session.getAttribute("loginType");
    final String emailId = loginSession.getEmailId();
    boolean status = false;
    quickBookingValidator.validate(quickBooking, result);
    if (result.hasErrors()) {
      return "quickBooking";
    }
    model.put("QuickBooking", new QuickBooking());
    status = quickBookingService.addBooking(quickBooking, emailId);
    if (status) {
      model.addAttribute("message", IConstant.QUICKBOOKING_SUCCESS_MESSAGE);
      return "redirect:/quickBookingSuccess.do";
    } else {
      model.addAttribute("message", IConstant.QUICKBOOKING_FAILURE_MESSAGE);
      return "quickBooking";
    }

  }

  /**
   * businessInfo method use to show quick booking page for book special event.
   * @param map
   * @param model
   * @param branchId
   * @param businessName
   * @param fullEventPrice
   * @param dayPrice
   * @param comment
   * @return
   */
  @RequestMapping("/eventQuickBooking")
  public String businessInfo(Map<String, Object> map, Model model,
      @RequestParam(required = false) Integer branchId,
      @RequestParam(required = false) String businessName,
      @RequestParam(required = false) String fullEventPrice,
      @RequestParam(required = false) String dayPrice,
      @RequestParam(required = false) String comment) {
    map.put("VisitorUser", new VisitorUser());
    map.put("QuickBooking", new QuickBooking());
    model.addAttribute("branchId", branchId);
    model.addAttribute("descreption", businessName);
    model.addAttribute("fullEventPrice", fullEventPrice);
    model.addAttribute("dayPrice", dayPrice);
    model.addAttribute("comment", comment);
    return "eventQuickBooking";
  }

  /**
   * addeventBooking method use to save special event information into data base.
   * @param quickBooking
   * @param result
   * @param model
   * @param request
   * @param emailId
   */
  @RequestMapping(value = "/eventQuickBookingAction", method = { RequestMethod.GET,
      RequestMethod.POST })
  public String eventQuickBooking(@ModelAttribute("QuickBooking") QuickBooking quickBooking,
      BindingResult result, ModelMap model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    Login loginSession = (Login) session.getAttribute("loginType");
    final String emailId = loginSession.getEmailId();
    boolean status = false;
    /*
     * quickBookingValidator.validate(quickBooking, result); if
     * (result.hasErrors()) { return "quickBooking"; }
     */
    model.put("QuickBooking", new QuickBooking());
    status = quickBookingService.addeventBooking(quickBooking, emailId);
    if (status) {
      model.addAttribute("message", IConstant.QUICKBOOKING_SUCCESS_MESSAGE);
      return "redirect:/quickBookingSuccess.do";
    } else {
      model.addAttribute("message", IConstant.QUICKBOOKING_FAILURE_MESSAGE);
      return "eventQuickBooking";
    }

  }
/**
 * success method use to show quick booking success page after perform quick booking successfully.
 * @param map
 * @param model
 * @param message
 * @return
 */
  @RequestMapping("/quickBookingSuccess")
  public String success(Map<String, Object> map, Model model,
      @RequestParam(required = false) String message) {
    model.addAttribute("message", message);
    return "quickBookingSuccess";
  }

}
