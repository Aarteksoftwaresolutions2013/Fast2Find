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

import com.ftf.model.Branch;
import com.ftf.model.BusinessAndEventInformation;
import com.ftf.model.CustomerInformation;
import com.ftf.model.Login;
import com.ftf.service.LoginService;
import com.ftf.util.IConstant;

@Controller
public class LoginWebServiceController {
  @Autowired
  private LoginService loginService;

  /**
   * Web service Controller for Login. EmailId and Password two parameter pass
   * in URL. password use in encrypted format. If userId and password are not
   * match then get a 400 status(400 means Bad Request). If userID and password
   * are match then get a Customer Information in the form of JSON.
   */
  @RequestMapping(value = "/loginWebService", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> webLogin(@RequestBody Login login, HttpServletResponse response) {
    CustomerInformation customerInformation = new CustomerInformation();
    BusinessAndEventInformation andEventInformation = new BusinessAndEventInformation();
    Branch branch = new Branch();
    login = loginService.userSignIn(login);
    Map<Object, Object> map = new HashMap<Object, Object>();
    if (login == null) {
      map.put(IConstant.RESPONSE, IConstant.FAILURE_CODE);
      map.put(IConstant.DATA, login);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.ACCESS_DENIED);
    } else {
      String userType = login.getUserType();
      int loginId = login.getLoginId();
      if (userType.equals(IConstant.BUSINESS) || userType.equals(IConstant.EVENT)) {
        andEventInformation = loginService.eventInfo(loginId);
        map.put(IConstant.RESPONSE, IConstant.SUCCESS_CODE);
        map.put(IConstant.DATA, andEventInformation);
        map.put(IConstant.SUCCESS_MESSAGE, IConstant.AUTHENTICATE_SUCCESS);
        ;
      } else if (userType.equals(IConstant.TALLY_USER)) {
        branch = loginService.branchInfo(loginId);
        map.put(IConstant.RESPONSE, IConstant.SUCCESS_CODE);
        map.put(IConstant.DATA, branch);
        map.put(IConstant.SUCCESS_MESSAGE, IConstant.AUTHENTICATE_SUCCESS);
      } else {
        customerInformation = loginService.custInfo(loginId);
        map.put(IConstant.RESPONSE, IConstant.SUCCESS_CODE);
        map.put(IConstant.DATA, customerInformation);
        map.put(IConstant.SUCCESS_MESSAGE, IConstant.AUTHENTICATE_SUCCESS);
      }
    }
    return map;
  }
}
