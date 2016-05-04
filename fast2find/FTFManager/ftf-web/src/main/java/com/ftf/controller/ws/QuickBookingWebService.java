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
import com.ftf.model.QuickBooking;
import com.ftf.service.QuickBookingService;
import com.ftf.util.IConstant;

@Controller
public class QuickBookingWebService {
  @Autowired
  private QuickBookingService quickBookingService;
  
  /**
   * addBooking() use to save quick booking information into database.
   * @param quickBooking
   * @param response
   * @return
   */
  @RequestMapping(value = "/quickBookingWSAction", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> quickBooking(@RequestBody QuickBooking quickBooking,
      HttpServletResponse response) {
    boolean status;
    Map<Object, Object> map = new HashMap<Object, Object>();
    status = quickBookingService.addBooking(quickBooking);
    if (status) {
      map.put(IConstant.RESPONSE, IConstant.SUCCESS_CODE);
      map.put(IConstant.DATA, status);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.QUICKBOOKING_SUCCESS_MESSAGE);
    } else {
      map.put(IConstant.RESPONSE, IConstant.FAILURE_CODE);
      map.put(IConstant.DATA, status);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.QUICKBOOKING_FAILURE_MESSAGE);
    }
    return map;
  }

  @RequestMapping(value = "/likeAndDislikeAction", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> likeAndDislike(@RequestBody QuickBooking quickBooking,
      HttpServletResponse response) {
    boolean status;
    Map<Object, Object> map = new HashMap<Object, Object>();
    status = quickBookingService.saveComment(quickBooking);
    if (status) {
      map.put(IConstant.RESPONSE, IConstant.SUCCESS_CODE);
      map.put(IConstant.DATA, status);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.COMMENT_SUCCESS_MESSAGE);
    } else {
      map.put(IConstant.RESPONSE, IConstant.FAILURE_CODE);
      map.put(IConstant.DATA, status);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.COMMENT_FAILURE_MESSAGE);
    }
    return map;
  }
}
