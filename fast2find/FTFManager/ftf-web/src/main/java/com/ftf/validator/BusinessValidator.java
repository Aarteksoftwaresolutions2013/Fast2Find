package com.ftf.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ftf.model.Branch;

@Component
public class BusinessValidator implements Validator {

  public boolean supports(Class<?> clazz) {
    return Branch.class.isAssignableFrom(clazz);
  }
  public void validate(Object target, Errors errors) {
    Branch branch = (Branch) target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchName", "error.businessName.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maxCapacity", "error.maxCapacity.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNo", "error.phoneNumber.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location.address", "error.Address.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location.cityName", "error.CityName.empty");
    ValidationUtils
        .rejectIfEmptyOrWhitespace(errors, "location.stateName", "error.StateName.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location.zipCode", "error.ZipCode.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "chargePerPerson",
        "error.numberOfPerson.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quickBookingFeePerTable",
        "error.tableBookingTime.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login.emailId", "error.email.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login.password", "error.password.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "catagoryList", "error.service.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "music", "error.music.empty");
    String openTime = branch.getOperatingHours().getStartTime().replaceAll(",", "");
    String closeTime = branch.getOperatingHours().getEndTime().replaceAll(",", "");
    if (openTime == null || openTime.isEmpty() || openTime.trim().isEmpty()) {
      errors.rejectValue("operatingHours.startTime", "error.openTime.empty");
    }
    if (closeTime == null || closeTime.isEmpty() || closeTime.trim().isEmpty()) {
      errors.rejectValue("operatingHours.endTime", "error.closeTime.empty");
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
   
    if (branch.getContactNo() != null && branch.getContactNo() != "") {
      if (branch.getContactNo().length() < 10) {
        errors.rejectValue("contactNo", "error.contactNo.length");
      }
    }
    if(branch.getBranchId()==null)
    {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm aa");
    Date date = new Date();
    Date date2;
    try {
      date2 = dateFormat.parse(branch.getEventRepeatDate());
      if (date.compareTo(date2) > 0) {
        errors.rejectValue("eventRepeatDate", "error.date.repeatDate");
      }
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    }
    
    if (branch.getEventStartDateAndTime().compareTo(branch.getEventEndDateAndTime()) > 0) {
      errors.rejectValue("eventStartDateAndTime", "error.date.startAndEnd");
    }
  }
}
