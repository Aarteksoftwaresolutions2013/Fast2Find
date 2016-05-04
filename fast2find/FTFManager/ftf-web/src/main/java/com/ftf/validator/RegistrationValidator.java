package com.ftf.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ftf.model.BusinessAndEventInformation;
import com.ftf.util.IConstant;

@Component
public class RegistrationValidator implements Validator {

  public boolean supports(Class<?> clazz) {
    return BusinessAndEventInformation.class.isAssignableFrom(clazz);
  }

  public void validate(Object target, Errors errors) {
    String regex = "(.)*(\\d)(.)*";
    Pattern pattern = Pattern.compile(regex);
    BusinessAndEventInformation userRegistration = (BusinessAndEventInformation) target;
    String input = userRegistration.getLocation().getZipCode();
    if (userRegistration.getLogin().getUserType().equals("global")) {
      errors.rejectValue("login.userType", "error.userType.empty");
    }
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location.address", "error.address.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location.cityName", "error.city.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location.stateName", "error.state.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location.zipCode", "error.zipCode.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmEmail", "error.confirmEmail.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
        "error.confirmPassword.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender",
    "error.gender.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
    "error.title.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "error.dob.empty");
    if (userRegistration.getLocation().getCountryName().equals("selected")) {
      errors.rejectValue("location.countryName", "error.country.select");
    }
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login.emailId", "error.email.empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login.password", "error.password.empty");

    if (userRegistration.getLogin().getUserType().equals(IConstant.CUSTOMER))
      if (userRegistration.getCustomerCatagory() == null) {
        errors.rejectValue("eventCatagory", "error.payment.select");
      }

    if (userRegistration.getLocation().getZipCode() != null
        && userRegistration.getLocation().getZipCode() != "") {
      Matcher matcher = pattern.matcher(input);
      boolean isMatched = matcher.matches();
      if (isMatched) {
        System.out.println("PASS");
      } else {
        errors.rejectValue("location.zipCode", "error.zipFormat.rule");
      }
    }
    if (userRegistration.getLocation().getBillingZipCode() != null
        && userRegistration.getLocation().getBillingZipCode() != "") {
      Matcher matcher = pattern.matcher(userRegistration.getLocation().getBillingZipCode());
      boolean isMatched = matcher.matches();
      if (isMatched) {
        System.out.println("PASS");
      } else {
        errors.rejectValue("location.billingZipCode", "error.zipFormat.rule");
      }
    }
    if ((userRegistration.getLogin().getEmailId() != null && userRegistration.getLogin()
        .getEmailId() != "")
        || (userRegistration.getConfirmEmail() != null && userRegistration.getConfirmEmail() != "")) {
      if (!userRegistration.getLogin().getEmailId().equals(userRegistration.getConfirmEmail())) {
        errors.rejectValue("confirmEmail", "error.confirmEmail.same");
      }
    }
    if ((userRegistration.getLogin().getPassword() != null && userRegistration.getLogin()
        .getPassword() != "")
        || (userRegistration.getConfirmPassword() != null && userRegistration.getConfirmPassword() != "")) {
      int length = userRegistration.getLogin().getPassword().length();
      if (length < 3) {
        errors.rejectValue("login.password", "error.password.length");
      } else {
        if (!userRegistration.getLogin().getPassword()
            .equals(userRegistration.getConfirmPassword())) {
          errors.rejectValue("confirmPassword", "error.confirmPassword.same");
        }
      }
    }
    if (userRegistration.getLogin().getEmailId() != null
        && userRegistration.getLogin().getEmailId().trim().length() > 0) {
      boolean b = ValidationUtil.validateEmail(userRegistration.getLogin().getEmailId());
      if (userRegistration.getLogin().getEmailId().contains("@") != true && !b) {
        errors.rejectValue("login.emailId", "error.email.first.rule");
      } else if (userRegistration.getLogin().getEmailId().contains(".com") != true
          && userRegistration.getLogin().getEmailId().contains(".net") != true && !b) {
        errors.rejectValue("login.emailId", "error.email.second.rule");
      } else if (!b) {
        errors.rejectValue("login.emailId", "error.email.required");
      }
    }
    if (userRegistration.getDateOfBirth().equals("Date of Birth")) {
      errors.rejectValue("dateOfBirth", "error.age.emptydob");
    }
    if (userRegistration.getDateOfBirth() != null && userRegistration.getDateOfBirth() != "") {
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
      System.out.println(sdf.format(date));
      String dateOfBirth = userRegistration.getDateOfBirth();
      String currentDate = sdf.format(date).toString();
      try {
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        int age = 0;
        int factor = 0;
        Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(dateOfBirth);
        Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(currentDate);
        cal1.setTime(date1);
        cal2.setTime(date2);
        if (cal2.get(Calendar.DAY_OF_YEAR) < cal1.get(Calendar.DAY_OF_YEAR)) {
          factor = -1;
        }
        age = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR) + factor;
        System.out.println("Your age is: " + age);
        if (age <=13) {
          errors.rejectValue("dateOfBirth", "error.age.empty");
        }
      } catch (ParseException e) {
        System.out.println(e);
      }
    }
  }
}
