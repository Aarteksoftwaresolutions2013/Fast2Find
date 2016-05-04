package com.ftf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ftf.model.Login;
import com.ftf.service.ForgotService;
import com.ftf.util.IConstant;
import com.ftf.validator.SecurityValidator;

@Controller
public class ForgotPasswordController {
  @Autowired
  private ReCaptcha reCaptchaService = null;

  @Autowired
  private ForgotService forgotService;

  @Autowired
  private SecurityValidator securityValidator;

  /**
   * showSecurity method use to show forgot password page
   * Method for recaptch. Method for forgot password.
   */
  @RequestMapping("/security")
  public String showSecurity(Map<String, Object> map, Model model) {
    map.put("Login", new Login());
    return "security";
  }


  /**
   * checkAnswer method use to check captch.
   * getPassword method use to get password from database.
   * sendMail method use to send mail to user.
   * @param email id
   * @param password
   */
  @RequestMapping(value = "/recaptcha", method = RequestMethod.POST)
  public String verify(@ModelAttribute("Login") Login login, BindingResult result, ModelMap model,
      Map<String, Object> map, HttpServletRequest request) {
    String challenge = request.getParameter("recaptcha_challenge_field");
    String response = request.getParameter("recaptcha_response_field");
    String remoteAddr = request.getRemoteAddr();
    @SuppressWarnings("rawtypes")
    List password = new ArrayList();
    String pass = null;
    if (!response.isEmpty()) {
      ReCaptchaResponse reCaptchaResponse = reCaptchaService.checkAnswer(remoteAddr, challenge,
          response);
      if (reCaptchaResponse.isValid()) {
        securityValidator.validate(login, result);
        if (result.hasErrors()) {
          return "security";
        } else {
          password = forgotService.getPassword(login.getEmailId());
          if (!password.isEmpty()) {
            pass = (String) password.get(0);
          }
          forgotService.sendMail(pass, login.getEmailId());
          model.addAttribute("message", IConstant.FORGOT_MESSAGE);
          return "redirect:/signIn.do";
        }
      } else {
        model.addAttribute("message", IConstant.WRONG_CAPTCH);
        return "security";
      }
    } else {
      model.addAttribute("message", IConstant.BLANK_CAPTCH);
      return "security";
    }
  }

}
