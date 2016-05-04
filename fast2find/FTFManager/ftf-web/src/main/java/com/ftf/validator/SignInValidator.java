package com.ftf.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ftf.model.BusinessAndEventInformation;
import com.ftf.model.Login;
import com.ftf.service.LoginService;
import com.ftf.util.Encryption;
import com.ftf.util.IConstant;

@Component
public class SignInValidator implements Validator {
  @Autowired
  private LoginService loginService;
  BusinessAndEventInformation andEventInformation = null;

  public boolean supports(Class<?> clazz) {
    return Login.class.isAssignableFrom(clazz);
  }
  /**
   * validate() method use for check null and email format
   */
  public void validate(Object target, Errors errors) {
    Login userRegistration = (Login) target;
    if (userRegistration.getEmailId() == null || userRegistration.getEmailId() == ""
        || userRegistration.getPassword() == null || userRegistration.getPassword() == "") {
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.email.empty");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password.empty");
    } else {
      if (userRegistration.getEmailId() != null
          && userRegistration.getEmailId().trim().length() > 0) {
        boolean b = ValidationUtil.validateEmail(userRegistration.getEmailId());
        if (userRegistration.getEmailId().contains("@") != true && !b) {
          errors.rejectValue("emailId", "error.email.first.rule");
        } else if (userRegistration.getEmailId().contains(".com") != true
            && userRegistration.getEmailId().contains(".net") != true && !b) {
          errors.rejectValue("emailId", "error.email.second.rule");
        } else if (!b) {
          errors.rejectValue("emailId", "error.email.required");
        } else {
          String passValidation = userRegistration.getPassword();
          userRegistration = loginService.userSignIn(userRegistration);
          if (userRegistration == null) {
            errors.rejectValue("emailId", "error.email.invaliduser");
          } else {
            if (!Encryption.decrypt(userRegistration.getPassword()).equals(passValidation)) {
              errors.rejectValue("emailId", "error.password.invaliduser");
            } else {
              andEventInformation = loginService.eventInfo(userRegistration.getLoginId());
              if (andEventInformation != null) {
                if (andEventInformation.getLogin().getStatus().equals(IConstant.expired)) {
                  errors.rejectValue("emailId", "error.expired.invaliduser");
                }
              }
            }

          }
        }
      }
    }
  }
}
