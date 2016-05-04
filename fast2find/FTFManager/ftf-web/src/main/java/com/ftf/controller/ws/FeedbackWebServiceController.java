package com.ftf.controller.ws;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ftf.model.FeedbackDetails;
import com.ftf.service.FeedbackService;
import com.ftf.util.IConstant;

@Controller
public class FeedbackWebServiceController {

  @Autowired
  private FeedbackService feedbackService;

  /**
   * feedbackInfoAdd() use to save customer feedback into database.
   * @param feedbackDetails
   * @param response
   * @return
   */
  @RequestMapping(value = "/feedbackWebServiceInfo", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> feedbackInfo(@RequestBody FeedbackDetails feedbackDetails,
      HttpServletResponse response) {
    boolean status;
    Map<Object, Object> map = new HashMap<Object, Object>();
    System.out.println(feedbackDetails.getFeedbackInfo());
    status = feedbackService.feedbackInfoAdd(feedbackDetails);
    if (status) {
      map.put(IConstant.RESPONSE, IConstant.SUCCESS_CODE);
      map.put(IConstant.DATA, status);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.FEEDBACK_SUCCESS_MESSAGE);
    } else {
      map.put(IConstant.RESPONSE, IConstant.FAILURE_CODE);
      map.put(IConstant.DATA, status);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.FEEDBACK_FAILURE_MESSAGE);
    }
    return map;
  }

}
