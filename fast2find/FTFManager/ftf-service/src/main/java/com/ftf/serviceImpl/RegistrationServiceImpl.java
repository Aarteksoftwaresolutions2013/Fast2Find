package com.ftf.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.model.BusinessAndEventInformation;
import com.ftf.model.CustomerInformation;
import com.ftf.repository.RegistrationRepository;
import com.ftf.service.RegistrationService;
import com.ftf.util.Encryption;
import com.ftf.util.IConstant;

@Service
public class RegistrationServiceImpl implements RegistrationService {
  @Autowired
  private RegistrationRepository registrationRepository;

  public boolean custInfoAdd(CustomerInformation customerInformation) {
    boolean status = false;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    customerInformation.setIsDeleted(IConstant.IS_DELETED);
    customerInformation.setCreatedOn(dateFormat.format(date));

    customerInformation.getLogin().setStatus(IConstant.ACTIVE_STATUS);
    if (customerInformation.getCustomerCatagory() != null) {
      if (customerInformation.getCustomerCatagory().equals(IConstant.free)) {
        customerInformation.getLogin().setPaidStatus(IConstant.PAID_USER_NO);

      } else {
        customerInformation.getLogin().setPaidStatus(IConstant.PAID_USER_YES);

      }
    } else {
      customerInformation.getLogin().setPaidStatus(IConstant.PAID_USER_NO);

    }
    customerInformation.getLogin().setPassword(
        Encryption.encrypt(customerInformation.getLogin().getPassword()));
    status = registrationRepository.custInfoAdd(customerInformation);
    if (status == true) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * addBusinessAndEvent() use to save user information into database. set
   * isDeleted one If customer category is paid than set paid status yes
   * otherwise no.
   * 
   * @param businessAndEventInformation
   */
  public boolean addBusinessAndEvent(BusinessAndEventInformation businessAndEventInformation) {
    boolean status = false;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    businessAndEventInformation.setIsDeleted(IConstant.IS_DELETED);
    if (businessAndEventInformation.getSameAddress() != null) {
      if (businessAndEventInformation.getSameAddress().equals("on")) {
        businessAndEventInformation.getLocation().setBillingAddress(
            businessAndEventInformation.getLocation().getAddress());
        businessAndEventInformation.getLocation().setBillingCityName(
            businessAndEventInformation.getLocation().getCityName());
        businessAndEventInformation.getLocation().setBillingCountryName(
            businessAndEventInformation.getLocation().getCountryName());
        businessAndEventInformation.getLocation().setBillingStateName(
            businessAndEventInformation.getLocation().getStateName());
        businessAndEventInformation.getLocation().setBillingZipCode(
            businessAndEventInformation.getLocation().getZipCode());
      }
    }
    businessAndEventInformation.setCreatedOn(dateFormat.format(date));
    businessAndEventInformation.getLogin().setPassword(
        Encryption.encrypt(businessAndEventInformation.getLogin().getPassword()));
    if (businessAndEventInformation.getLogin().getUserType().equals(IConstant.CUSTOMER)) {
      businessAndEventInformation.getLogin().setStatus(IConstant.ACTIVE_STATUS);

      if (businessAndEventInformation.getCustomerCatagory() != null) {
        if (businessAndEventInformation.getCustomerCatagory().equals(IConstant.free)) {
          businessAndEventInformation.getLogin().setPaidStatus(IConstant.PAID_USER_NO);
        } else {
          businessAndEventInformation.getLogin().setPaidStatus(IConstant.PAID_USER_NO);
        }
      } else {
        businessAndEventInformation.getLogin().setPaidStatus(IConstant.PAID_USER_NO);
      }
      /*
       * businessAndEventInformation.getLogin().setPaidStatus(IConstant.
       * PAID_USER_YES);
       * businessAndEventInformation.setCustomerCatagory(IConstant.PER_YEAR);
       */
    }
    if (businessAndEventInformation.getLogin().getUserType().equals(IConstant.BUSINESS)) {
      businessAndEventInformation.getLogin().setStatus(IConstant.ACTIVE_STATUS);
      /* businessAndEventInformation.setCreatedOn(dateFormat.format(date)); */
      businessAndEventInformation.getLogin().setPaidStatus(IConstant.PAID_USER_YES);
      businessAndEventInformation.setBusinessCatagory(IConstant.PER_YEAR);
    }
    if (businessAndEventInformation.getLogin().getUserType().equals(IConstant.EVENT)) {
      businessAndEventInformation.getLogin().setStatus(IConstant.ACTIVE_STATUS);
      businessAndEventInformation.setCreatedOn(dateFormat.format(date));
      businessAndEventInformation.getLogin().setPaidStatus(IConstant.PAID_USER_YES);
      businessAndEventInformation.setEventCatagory(IConstant.PER_YEARLY);
    }
    /*
     * businessAndEventInformation.getLogin().setStatus(
     * IConstant.ACTIVE_STATUS);
     * businessAndEventInformation.setCreatedOn(dateFormat.format(date));
     * businessAndEventInformation.getLogin().setPassword(
     * Encryption.encrypt(businessAndEventInformation.getLogin()
     * .getPassword())); businessAndEventInformation.getLogin().setPaidStatus(
     * IConstant.PAID_USER_YES);
     */
    status = registrationRepository.addBusinessAndEvent(businessAndEventInformation);
    if (status == true) {
      return true;
    } else {
      return false;
    }
  }

  public void updatePaidStatus() {
    registrationRepository.updatePaidStatus();
  }

  public boolean editBusinessCustomerInfo(BusinessAndEventInformation businessAndEventInformation) {
    boolean status = false;
    if (businessAndEventInformation.getSameAddress() != null) {
      if (businessAndEventInformation.getSameAddress().equals("on")) {
        businessAndEventInformation.getLocation().setBillingAddress(
            businessAndEventInformation.getLocation().getAddress());
        businessAndEventInformation.getLocation().setBillingCityName(
            businessAndEventInformation.getLocation().getCityName());
        businessAndEventInformation.getLocation().setBillingCountryName(
            businessAndEventInformation.getLocation().getCountryName());
        businessAndEventInformation.getLocation().setBillingStateName(
            businessAndEventInformation.getLocation().getStateName());
        businessAndEventInformation.getLocation().setBillingZipCode(
            businessAndEventInformation.getLocation().getZipCode());
      }
    }
    businessAndEventInformation.getLogin().setPassword(
        Encryption.encrypt(businessAndEventInformation.getLogin().getPassword()));
    if (businessAndEventInformation.getLogin().getUserType().equals(IConstant.BUSINESS)) {
      businessAndEventInformation.getLogin().setStatus(IConstant.ACTIVE_STATUS);
      /* businessAndEventInformation.setCreatedOn(dateFormat.format(date)); */
      businessAndEventInformation.getLogin().setPaidStatus(IConstant.PAID_USER_YES);
      businessAndEventInformation.setBusinessCatagory(IConstant.PER_YEAR);
      businessAndEventInformation.setIsDeleted(IConstant.IS_DELETED);
      businessAndEventInformation.setTermAndCondition(IConstant.TERM_AND_CONDITION);
    }
    if (businessAndEventInformation.getLogin().getUserType().equals(IConstant.EVENT)) {
      businessAndEventInformation.getLogin().setStatus(IConstant.ACTIVE_STATUS);
      businessAndEventInformation.getLogin().setPaidStatus(IConstant.PAID_USER_YES);
      businessAndEventInformation.setEventCatagory(IConstant.PER_YEARLY);
      businessAndEventInformation.setIsDeleted(IConstant.IS_DELETED);
      businessAndEventInformation.setTermAndCondition(IConstant.TERM_AND_CONDITION);
    }
    status = registrationRepository.editBusinessCustomerInfo(businessAndEventInformation);
    if (status == true) {
      return true;
    } else {
      return false;
    }
  }

}
