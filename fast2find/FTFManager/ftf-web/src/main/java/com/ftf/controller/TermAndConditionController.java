package com.ftf.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TermAndConditionController {

  /**
   * showTACPage() use to show term and condition page.
   * 
   * @param map
   * @param model
   * @return
   */
  @RequestMapping("/termAndCondition")
  public String showTACPage(Map<String, Object> map, Model model) {
    return "termAndCondition";
  }

  /**
   * showHelpPage() method for show help page.
   * 
   * @param map
   * @param model
   * @return
   */
  @RequestMapping("/help")
  public String showHelpPage(Map<String, Object> map, Model model) {
    return "help";
  }
}
