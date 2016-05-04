package com.ftf.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.ftf.model.Catageory;
import com.ftf.model.EmailAlert;
import com.ftf.model.Login;
import com.ftf.service.CatageoryService;
import com.ftf.service.EmailAlertService;
import com.ftf.util.IConstant;
import com.ftf.validator.EmailAlertValidator;

@Controller
public class EmailAlertController {

  @Autowired
  private EmailAlertService emailAlertService;

  @Autowired
  private EmailAlertValidator emailAlertValidator;

  @Autowired
  private CatageoryService catageoryService;

  /**
   * showFrontPage method use to show email alert page getAllCatageoryName
   * method use to get all category name from database.
   * 
   * @param message
   */
  @RequestMapping("/emailAlert")
  public String showFrontPage(Map<String, Object> map, Model model,
      @RequestParam(required = false) String message) {
    List<Catageory> catageoryList = new ArrayList<Catageory>();
    map.put("EmailAlert", new EmailAlert());
    model.addAttribute("message", message);
    catageoryList = catageoryService.getAllCatageoryName();
    if (catageoryList != null) {
      model.addAttribute("catageory", catageoryList);
    }
    return "emailAlert";
  }

  /**
   * businessUpdateInfo method use for email alert action getAllCatageoryName
   * method use to get all category name form database. addEmailRequest method
   * use to save email alert information.
   */
  @RequestMapping(value = "/emailAlertAction", method = { RequestMethod.GET, RequestMethod.POST })
  public String businessUpdateInfo(@ModelAttribute("EmailAlert") EmailAlert emailAlert,
      BindingResult result, ModelMap model, Map<String, Object> map, HttpServletRequest request) {
    List<Catageory> catageoryList = new ArrayList<Catageory>();
    boolean status = false;
    emailAlertValidator.validate(emailAlert, result);
    if (result.hasErrors()) {
      catageoryList = catageoryService.getAllCatageoryName();
      if (catageoryList != null) {
        model.addAttribute("catageory", catageoryList);
      }
      return "emailAlert";
    }
    HttpSession session = request.getSession();
    Login login = (Login) session.getAttribute("loginType");
    if (login != null) {
      emailAlert.setEmailId(login.getEmailId());
    }
    model.put("EmailAlert", new EmailAlert());
    status = emailAlertService.addEmailRequest(emailAlert);
    if (status) {
      model.addAttribute("message", IConstant.EMAIL_ALERT_SUCCESS);
      return "redirect:/emailAlert.do";
    } else {
      model.addAttribute("message", IConstant.EMAIL_ALERT_ERROR);
      return "redirect:/emailAlert.do";
    }
  }
}
