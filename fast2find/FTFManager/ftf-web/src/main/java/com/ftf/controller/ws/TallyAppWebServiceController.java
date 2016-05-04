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

import com.ftf.model.Audit;
import com.ftf.service.TallyAppService;
import com.ftf.util.IConstant;

@Controller
public class TallyAppWebServiceController {
  @Autowired
  private TallyAppService tallyAppService;

  /**
   * Increase male or female counter into database.
   * @param audit
   * @param response
   */
  @RequestMapping(value = "/increaseTallyAppCounter", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> increaseCount(@RequestBody Audit audit, HttpServletResponse response) {
    boolean status = false;
    if (audit != null) {
      status = tallyAppService.increaseCounter(audit);
    }
    Map<Object, Object> map = new HashMap<Object, Object>();
    if (status == true) {
      map.put(IConstant.RESPONSE, IConstant.SUCCESS_CODE);
      map.put(IConstant.DATA, status);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.TALLYAPP_SUCCESS_MESSAGE);
    } else {
      map.put(IConstant.RESPONSE, IConstant.FAILURE_CODE);
      map.put(IConstant.DATA, status);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.TALLYAPP_FAILURE_MESSAGE);
    }
    return map;
  }

  /**
   * Decrease male or female counter into data base
   * @param audit
   * @param response
   */
  @RequestMapping(value = "/decreaseTallyAppCounter", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> decreaseCount(@RequestBody Audit audit, HttpServletResponse response) {
    boolean status = false;
    if (audit != null) {
      status = tallyAppService.decreaseCounter(audit);
    }
    Map<Object, Object> map = new HashMap<Object, Object>();
    if (status == true) {
      map.put(IConstant.RESPONSE, IConstant.SUCCESS_CODE);
      map.put(IConstant.DATA, status);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.TALLYAPP_DECREASE_COUNTER_SUCCESS_MESSAGE);
    } else {
      map.put(IConstant.RESPONSE, IConstant.FAILURE_CODE);
      map.put(IConstant.DATA, status);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.TALLYAPP_FAILURE_DECREASE_MESSAGE);
    }
    return map;
  }

}
