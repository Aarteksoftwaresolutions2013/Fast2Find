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

import com.ftf.model.FeedbackDetails;
import com.ftf.service.FeedbackService;
import com.ftf.util.IConstant;

@Controller
public class FeedbackController {
  @Autowired
  private FeedbackService feedbackService;

  /**
   * showFeedbackPage Method for show Feedback page.
   */
  @RequestMapping("/feedback")
  public String showFeedbackPage(Map<String, Object> map, Model model) {
    map.put("FeedbackDetails", new FeedbackDetails());
    return "feedback";
  }

  /**
   * feedbackInfoAdd Method use to save user feedback into database.
   * @param feedbackDetails
   */
  @RequestMapping(value = "/feedbackInfo", method = RequestMethod.POST)
  public String feedbackInfo(@ModelAttribute("FeedbackDetails") FeedbackDetails feedbackDetails,
      BindingResult result, ModelMap model, Map<String, Object> map) {
    boolean status = false;
    model.put("FeedbackDetails", new FeedbackDetails());
    status = feedbackService.feedbackInfoAdd(feedbackDetails);
    if (status) {
      model.addAttribute("successMsg", IConstant.FEEDBACK_SUCCESS);
    } else {
      model.addAttribute("successMsg", "UnSuccessfully");
    }
    return "feedback";
  }
}
