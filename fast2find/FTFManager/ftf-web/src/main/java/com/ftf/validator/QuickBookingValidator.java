package com.ftf.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ftf.model.QuickBooking;

@Component
public class QuickBookingValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return QuickBooking.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfPerson",
				"error.numberOfPerson.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tableBookingTime",
				"error.tableBookingTime.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "service",
				"error.service.empty");
	}
}
