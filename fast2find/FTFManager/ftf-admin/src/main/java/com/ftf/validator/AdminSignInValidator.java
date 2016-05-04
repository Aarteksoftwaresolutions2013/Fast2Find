package com.ftf.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ftf.model.Login;
import com.ftf.service.LoginService;

@Component
public class AdminSignInValidator implements Validator {
	@Autowired
	private LoginService loginService;

	public boolean supports(Class<?> clazz) {
		return Login.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Login userRegistration = (Login) target;
		if (userRegistration.getEmailId() == null
				|| userRegistration.getEmailId() == ""
				|| userRegistration.getPassword() == null
				|| userRegistration.getPassword() == "") {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId",
					"error.email.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
					"error.password.empty");
		} else {
			if (userRegistration.getEmailId() != null
					&& userRegistration.getEmailId().trim().length() > 0) {
				boolean b = ValidationUtil.validateEmail(userRegistration
						.getEmailId());
				if (userRegistration.getEmailId().contains("@") != true && !b) {
					errors.rejectValue("emailId", "error.email.first.rule");
				} else if (userRegistration.getEmailId().contains(".com") != true
						&& userRegistration.getEmailId().contains(".net") != true
						&& !b) {
					errors.rejectValue("emailId", "error.email.second.rule");
				} else if (!b) {
					errors.rejectValue("emailId", "error.email.required");
				} else {
					userRegistration = loginService
							.adminSignIn(userRegistration);
					if (userRegistration == null) {
						errors.rejectValue("emailId", "error.email.invaliduser");
					} 
				}
			}
		}
	}
}
