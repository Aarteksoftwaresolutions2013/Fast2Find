package com.ftf.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ftf.model.Login;
import com.ftf.service.ForgotService;

@Component
public class SecurityValidator implements Validator {
  @Autowired
  private ForgotService forgotService;

  public boolean supports(Class<?> clazz) {
    return Login.class.isAssignableFrom(clazz);
  }

  @SuppressWarnings("rawtypes")
  public void validate(Object target, Errors errors) {
    Login login = (Login) target;
    if (login.getEmailId() != null && login.getEmailId().trim().length() > 0) {
      String regex = "[0-9]+";
      if (login.getEmailId().matches(regex)) {
        errors.rejectValue("emailId", "error.email.number");
      } else {
        Pattern pattern = Pattern.compile("^[^<>'\"/;`%]*$");
        Matcher matcher = pattern.matcher(login.getEmailId());
        if (!matcher.matches()) {
          errors.rejectValue("emailId", "error.email.spcecial");
        } else {
          boolean b = ValidationUtil.validateEmail(login.getEmailId());
          if (login.getEmailId().contains("@") != true && !b) {
            errors.rejectValue("emailId", "error.forgot.password");
          } else if (login.getEmailId().contains(".com") != true
              && login.getEmailId().contains(".net") != true && !b) {
            errors.rejectValue("emailId", "error.forgot.password");
          } else if (!b) {
            errors.rejectValue("emailId", "error.email.required");
          } else {
            List password = null;
            password = forgotService.getPassword(login.getEmailId());
            if (password.isEmpty()) {
              errors.rejectValue("emailId", "error.forgot.invaliduser");
            }
          }
        }
      }
    }
  }
}
