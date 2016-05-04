package com.ftf.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.ftf.model.EmailAlert;

@Component
public class EmailAlertValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return EmailAlert.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "catagory",
				"error.catagory.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "music",
				"error.music.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city",
				"error.emailcity.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAlertTime",
				"error.time.empty");
	}
}
