package com.ftf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.ftf.service.CatageoryService;
import com.ftf.service.LoginService;
import com.ftf.validator.AdminSignInValidator;

@Controller
public class LoginController {

  @Autowired
  private LoginService loginService;

  @Autowired
  private AdminSignInValidator signInValidator;

  @Autowired
  private CatageoryService catageoryService;

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

  @RequestMapping(value = "/userSignIn", method = RequestMethod.POST)
  public String signInAction(@ModelAttribute("Login") Login login, BindingResult result,
      ModelMap model, Map<String, Object> map, HttpServletRequest request,
      HttpServletResponse response) {
    signInValidator.validate(login, result);
    if (result.hasErrors()) {
      return "signIn";
    }
    login = loginService.adminSignIn(login);
    if (login == null) {
      return "redirect:/signIn.do";
    } else {
      HttpSession session = request.getSession();
      session.setAttribute("loginType", login);
      return "redirect:/dashboard.do";
    }
  }

  @RequestMapping("/logout")
  public String showLogout(Map<String, Object> map, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.invalidate();
    return "redirect:/signIn.do";
  }

  @SuppressWarnings("rawtypes")
  @RequestMapping("/dashboard")
  public String showDashboard(Map<String, Object> map, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    Login loginMember = (Login) session.getAttribute("loginType");
    if (loginMember != null) {
      List list = new ArrayList();
      list=catageoryService.getCategoryAndSubCategory();
      if (!list.isEmpty()) {
        model.addAttribute("list", list);
      }
      return "dashboard";
    } else {
      return "redirect:/signIn.do";
    }
  }
}