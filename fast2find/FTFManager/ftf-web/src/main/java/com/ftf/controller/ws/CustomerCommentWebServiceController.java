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
import com.ftf.model.CustomerComment;
import com.ftf.service.CustomerCommentService;
import com.ftf.util.IConstant;

@Controller
public class CustomerCommentWebServiceController {
  @Autowired
  private CustomerCommentService customerCommentService;

  /**
   * This web service use to save customer comment sendby by customer from
   * particular business like resturant, pub etc. use 200 code for success use
   * 400 code for failure.
   * @param customerComment
   * @param response
   */
  @RequestMapping(value = "/customerComment", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> feedbackInfo(@RequestBody CustomerComment customerComment,
      HttpServletResponse response) {
    boolean status;
    Map<Object, Object> map = new HashMap<Object, Object>();
    status = customerCommentService.addCustomerComment(customerComment);
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
