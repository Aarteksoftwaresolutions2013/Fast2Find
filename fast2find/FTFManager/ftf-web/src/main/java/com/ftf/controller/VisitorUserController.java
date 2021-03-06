package com.ftf.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftf.model.VisitorUser;
import com.ftf.service.VisitorUserInfoService;

@Controller
public class VisitorUserController {
	@Autowired
	private VisitorUserInfoService visitorUserInfoService;

	/**
	 * addVisitorMessage() for save visitor information into database.
	 * @param visitorUser
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/visitorMessage", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(VisitorUser visitorUser, BindingResult result,
			ModelMap model, Map<String, Object> map, HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		String returnText;
		visitorUser.setEmailId(email);
		visitorUser.setName(name);
		visitorUser.setMessage(message);
		visitorUserInfoService.addVisitorMessage(visitorUser);
		returnText ="Message has been added";
		return returnText;
	}

}
