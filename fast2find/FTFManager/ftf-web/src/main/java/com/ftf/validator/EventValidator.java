package com.ftf.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ftf.model.Branch;

@Component
public class EventValidator implements Validator {

  public boolean supports(Class<?> clazz) {
    return Branch.class.isAssignableFrom(clazz);
  }

  public void validate(Object target, Errors errors) {
    Branch branch = (Branch) target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventName", "error.eventName.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventKioskName", "error.kisokName.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventOwnerFName",
        "error.eventOwnerFirstName.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventOwnerLName",
        "error.eventOwnerLastName.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNo", "error.phoneNumber.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location.address", "error.Address.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location.cityName", "error.CityName.empty");
    ValidationUtils
        .rejectIfEmptyOrWhitespace(errors, "location.stateName", "error.StateName.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location.zipCode", "error.ZipCode.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventEmail", "error.email.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maxCapacity", "error.maxCapacity.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "updateStage", "error.updateStage.empty");
    /*
     * ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dailyEventTicket",
     * "error.dailyEventTicket.empty");
     * ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullEventTicket",
     * "error.fullEventTicket.empty");
     */
    if (branch.getEventStartDateAndTime().compareTo(branch.getEventEndDateAndTime()) > 0) {
      errors.rejectValue("eventStartDateAndTime", "error.date.startAndEnd");
    }
    if (branch.getLocation().getCountryName().equals("selected")) {
      errors.rejectValue("location.countryName", "error.country.select");
    }
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login.emailId", "error.email.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login.password", "error.password.empty");
    if ((branch.getEventEmail() != null && branch.getEventEmail() != "")
        || (branch.getRepeatEmail() != null && branch.getRepeatEmail() != "")) {
      if (!branch.getEventEmail().equals(branch.getRepeatEmail())) {
        errors.rejectValue("repeatEmail", "error.repeatEmail.same");
      }
    }
    if (branch.getEventEmail() != null && branch.getEventEmail().trim().length() > 0) {
      boolean b = ValidationUtil.validateEmail(branch.getEventEmail());
      if (branch.getEventEmail().contains("@") != true && !b) {
        errors.rejectValue("eventEmail", "error.email.first.rule");
      } else if (branch.getEventEmail().contains(".com") != true
          && branch.getEventEmail().contains(".net") != true && !b) {
        errors.rejectValue("eventEmail", "error.email.second.rule");
      } else if (!b) {
        errors.rejectValue("eventEmail", "error.email.required");
      }
    }
    if (branch.getLogin().getEmailId() != null
        && branch.getLogin().getEmailId().trim().length() > 0) {
      boolean b = ValidationUtil.validateEmail(branch.getLogin().getEmailId());
      if (branch.getLogin().getEmailId().contains("@") != true && !b) {
        errors.rejectValue("login.emailId", "error.email.first.rule");
      } else if (branch.getLogin().getEmailId().contains(".com") != true
          && branch.getLogin().getEmailId().contains(".net") != true && !b) {
        errors.rejectValue("login.emailId", "error.email.second.rule");
      } else if (!b) {
        errors.rejectValue("login.emailId", "error.email.required");
      }
    }
    if (branch.getLocation().getZipCode() != null && branch.getLocation().getZipCode() != "") {
      String regex = "(.)*(\\d)(.)*";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(branch.getLocation().getZipCode());
      boolean isMatched = matcher.matches();
      if (isMatched) {
        System.out.println("PASS");
      } else {
        errors.rejectValue("location.zipCode", "error.zipFormat.rule");
      }
    }
    if (branch.getContactNo() != null && branch.getContactNo() != "") {
      Pattern pattern = Pattern.compile("[+-]?\\d{1,3}(-\\d{3})*\\.?\\d+");
      Matcher matcher = pattern.matcher(branch.getContactNo());
      if (!matcher.matches()) {
        errors.rejectValue("contactNo", "error.contactNo.invalid");
      }
    }
  }
}
