package com.ftf.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import com.ftf.model.ContactUs;

@Component
public class ContactUsValidator {
  public boolean supports(Class<?> clazz) {
    return ContactUs.class.isAssignableFrom(clazz);
  }

  public void validate(Object target, Errors errors) {
    ContactUs contactUs = (ContactUs) target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "error.companyName.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNo", "error.mobileNo.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "error.message.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.city.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.email.empty");
    if (contactUs.getEmailId() != null && contactUs.getEmailId().trim().length() > 0) {
      boolean b = ValidationUtil.validateEmail(contactUs.getEmailId());
      if (contactUs.getEmailId().contains("@") != true && !b) {
        errors.rejectValue("emailId", "error.email.first.rule");
      } else if (contactUs.getEmailId().contains(".com") != true
          && contactUs.getEmailId().contains(".net") != true && !b) {
        errors.rejectValue("emailId", "error.email.second.rule");
      } else if (!b) {
        errors.rejectValue("emailId", "error.email.required");
      }
    }
  }
}
