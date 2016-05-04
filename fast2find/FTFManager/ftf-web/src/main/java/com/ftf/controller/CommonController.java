package com.ftf.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ftf.model.ContactUs;
import com.ftf.service.VisitorUserInfoService;
import com.ftf.util.IConstant;
import com.ftf.validator.ContactUsValidator;

@Controller
public class CommonController {

  @Autowired
  private VisitorUserInfoService visitorUserInfoService;

  @Autowired
  private ContactUsValidator contactUsValidator;

  /**
   * showFaq method use to show faq page
   */
  @RequestMapping("/faq")
  public String showFaq(Map<String, Object> map, Model model) {
    return "faq";
  }

  /**
   * showcontactUsPage method use to show contact us page
   * 
   * @param message
   */
  @RequestMapping("/contactUs")
  public String showcontactUsPage(Map<String, Object> map, Model model,
      @RequestParam(required = false) String message) {
    model.addAttribute("message", message);
    map.put("ContactUs", new ContactUs());
    return "contactUs";
  }

  /**
   * addContactMessage method use to save contact us information
   * 
   * @param contactUs
   */
  @RequestMapping(value = "/contactAction", method = RequestMethod.POST)
  public String feedbackInfo(@ModelAttribute("ContactUs") ContactUs contactUs,
      BindingResult result, ModelMap model, Map<String, Object> map) {
    boolean status = false;
    contactUsValidator.validate(contactUs, result);
    if (result.hasErrors()) {
      return "contactUs";
    }
    model.put("ContactUs", new ContactUs());
    status = visitorUserInfoService.addContactMessage(contactUs);
    if (status) {
      model.addAttribute("message", IConstant.CONTACTUS_SUCCESS_MESSAGE);
    } else {
      model.addAttribute("message", IConstant.CONTACTUS_FAILURE_MESSAGE);
    }
    return "redirect:/contactUs.do";
  }

  /**
   * showAboutPage method use to show about page
   */
  @RequestMapping("/about")
  public String showAboutPage(Map<String, Object> map, Model model) {
    return "about";
  }

  /**
   * showNewsPage method use to show news page
   */
  @RequestMapping("/news")
  public String showNewsPage(Map<String, Object> map, Model model) {
    return "news";
  }

  /**
   * showSupportPage method use to show support page
   */
  @RequestMapping("/support")
  public String showSupportPage(Map<String, Object> map, Model model) {
    return "support";
  }

  /**
   * showsocialMediaPage method use to show socialMedia page
   */
  @RequestMapping("/socialMedia")
  public String showsocialMediaPage(Map<String, Object> map, Model model) {
    return "socialMedia";
  }

  /**
   * showprivacyPolicyPage method use to show privacy policy page
   */
  @RequestMapping("/privacyPolicy")
  public String showprivacyPolicyPage(Map<String, Object> map, Model model) {
    return "privacyPolicy";
  }

  /**
   * show pricing page.
   * @param map
   * @param model
   * @return
   */
  @RequestMapping("/pricing")
  public String showPricingPage(Map<String, Object> map, Model model) {
  return "pricing";
  }
}
