package com.ftf.controller.ws;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ftf.model.Login;
import com.ftf.service.ForgotService;
import com.ftf.util.IConstant;

@Controller
public class ForgotPasswordWebServiceController {
	@Autowired
	private ForgotService forgotService;
	
	/**
	 * getPassword() use for get password from database using email Id.
	 * sendMail() use for send mail to user.
	 * @param login
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/forGotPassword", method = RequestMethod.POST)
	public @ResponseBody
	Map<Object, Object> forgot(@RequestBody Login login,
			HttpServletResponse response) {
		List passwordList = new ArrayList();
		String password = null;
		passwordList = forgotService.getPassword(login.getEmailId());
		if (!passwordList.isEmpty()) {
			password = (String) passwordList.get(0);
			forgotService.sendMail(password, login.getEmailId());
		}
		Map<Object, Object> map = new HashMap<Object, Object>();
		if (passwordList.isEmpty()) {
			map.put(IConstant.RESPONSE, IConstant.FAILURE_CODE);
			map.put(IConstant.DATA, password);
			map.put(IConstant.SUCCESS_MESSAGE, IConstant.FORGOT_FAIL_MESSAGE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS_CODE);
			map.put(IConstant.DATA, password);
			map.put(IConstant.SUCCESS_MESSAGE, IConstant.FORGOT_SUCCESS_MESSAGE);
		}
		return map;
	}
}
