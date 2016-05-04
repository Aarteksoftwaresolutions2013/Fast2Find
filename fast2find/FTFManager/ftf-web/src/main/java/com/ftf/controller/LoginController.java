package com.ftf.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.ftf.model.Login;
import com.ftf.service.LoginService;
import com.ftf.util.IConstant;
import com.ftf.validator.SignInValidator;

@Controller
public class LoginController {
  private static final Logger logger = Logger.getLogger(LoginController.class);
  @Autowired
  private LoginService loginService;

  @Autowired
  private SignInValidator signInValidator;

  /**
   * showSignIn method for show SignIn page. signInAction method use for
   * validate user is Valid and Invalid VisitorUser is model
   */
  @RequestMapping("/signIn")
  public String showSignIn(Map<String, Object> map, Model model,
      @RequestParam(required = false) String message) {
    model.addAttribute("message", message);
    map.put("Login", new Login());
    return "signIn";
  }

  /**
   * signInAction() is a signIn action.If user is successfully signIn then he
   * will get appropriate page for example customer get customer section and
   * business user get business section
   */
  @RequestMapping(value = "/userSignIn", method = RequestMethod.POST)
  public String signInAction(@ModelAttribute("Login") Login login, BindingResult result,
      ModelMap model, Map<String, Object> map, HttpServletRequest request,
      HttpServletResponse response) {
    logger.error(".......signInAction() inside a loginController.....");
    BusinessAndEventInformation andEventInformation = null;
    signInValidator.validate(login, result);
    if (result.hasErrors()) {
      return "signIn";
    }
    login = loginService.userSignIn(login);
    if (login == null) {
      return "redirect:/signIn.do";
    }
    int loginId = login.getLoginId();
    andEventInformation = loginService.eventInfo(loginId);
    HttpSession session = request.getSession();
    session.setAttribute("login", andEventInformation);
    session.setAttribute("loginType", login);
    if (login.getUserType().equals(IConstant.CUSTOMER)) {
      return "redirect:/customer.do";
    } else if (login.getUserType().equals(IConstant.BUSINESS)) {
      return "redirect:/business.do";
    } else if (login.getUserType().equals(IConstant.EVENT)) {
      return "redirect:/event.do";
    } else if (login.getUserType().equals(IConstant.ADMIN)) {
      return "redirect:/admin.do";
    }
    return "redirect:/signIn.do";
  }

  /**
   * showLogout() method use for destory the session.
   */
  @RequestMapping("/logout")
  public String showLogout(Map<String, Object> map, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.invalidate();
    return "redirect:/signIn.do";
  }

  /**
   * showCustomer() method use for show customer page.
   */
  @RequestMapping("/customer")
  public String showCustomer(Map<String, Object> map, Model model, HttpServletRequest request) {
    return "customer";
  }

  /**
   * showBusiness() method use for show business page.
   */
  @RequestMapping("/business")
  public String showBusiness(Map<String, Object> map, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    BusinessAndEventInformation loginMember = (BusinessAndEventInformation) session
        .getAttribute("login");
    if (loginMember != null) {
      return "business";
    } else {
      return "redirect:/signIn.do";
    }
  }

  /**
   * showBusiness() method use for show event page.
   */
  @RequestMapping("/event")
  public String showEvent(Map<String, Object> map, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    BusinessAndEventInformation loginMember = (BusinessAndEventInformation) session
        .getAttribute("login");
    if (loginMember != null) {
      return "event";
    } else {
      return "redirect:/signIn.do";
    }
  }

  /**
   * showAdmin() method use for show admin page.
   */
  @RequestMapping("/admin")
  public void showAdmin(Map<String, Object> map, Model model, HttpServletResponse response) {
    try {
      response.sendRedirect("http://fast2find.com/ftf-admin/signIn.do");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
