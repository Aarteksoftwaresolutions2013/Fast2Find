package com.ftf.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.model.BusinessAndEventInformation;
import com.ftf.repository.UpdateCustomerRepository;
import com.ftf.service.UpdateCustomerService;
import com.ftf.util.Encryption;
import com.ftf.util.IConstant;

@Service
public class UpdateCustomerServiceImpl implements UpdateCustomerService {

  @Autowired
  private UpdateCustomerRepository updateCustomerRepository;

  /**
   * getCustomerInfoAdd() use to fetch customer information from database.
   * decrypt() use to decrypted password.
   * 
   * @param loginId
   * @param password
   */
  public BusinessAndEventInformation getCustomerInfoAdd(Integer loginId) {
    List<Object> list = new ArrayList<Object>();
    BusinessAndEventInformation businessAndEventInformation = new BusinessAndEventInformation();
    list = updateCustomerRepository.getCustomerInfoAdd(loginId);
    for (Object object : list) {
      businessAndEventInformation = (BusinessAndEventInformation) object;
      businessAndEventInformation.getLogin().setPassword(
          Encryption.decrypt(businessAndEventInformation.getLogin().getPassword()));
    }
    return businessAndEventInformation;
  }

  /**
   * updateCustomerInfoAdd() use to save updated information into database.
   * 
   * @param password
   */
  public boolean updateCustomerInfoAdd(BusinessAndEventInformation businessAndEventInformation) {
    boolean status = false;
    if (businessAndEventInformation != null) {
      if (businessAndEventInformation.getCustomerCatagory().equals(IConstant.free)) {
        businessAndEventInformation.getLogin().setPaidStatus(IConstant.PAID_USER_NO);
      } else {
        businessAndEventInformation.getLogin().setPaidStatus(IConstant.PAID_USER_YES);
      }
      /*
       * businessAndEventInformation.getLogin().setPaidStatus(IConstant.
       * PAID_USER_YES);
       * businessAndEventInformation.setCustomerCatagory(IConstant.PER_YEAR);
       */
      businessAndEventInformation.getLogin().setPassword(
          Encryption.encrypt(businessAndEventInformation.getLogin().getPassword()));
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      Date date = new Date();
      businessAndEventInformation.setIsDeleted(IConstant.IS_DELETED);
      businessAndEventInformation.setUpdatedOn((dateFormat.format(date)));
      businessAndEventInformation.getLogin().setStatus(IConstant.ACTIVE);
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
      status = updateCustomerRepository.updateCustomerInfoAdd(businessAndEventInformation);
      return status;
    }
    return status;
  }

  public BusinessAndEventInformation getInformation(Integer loginId) {
    List<Object> list = new ArrayList<Object>();
    BusinessAndEventInformation businessAndEventInformation = new BusinessAndEventInformation();
    list = updateCustomerRepository.getInformation(loginId);
    for (Object object : list) {
      businessAndEventInformation = (BusinessAndEventInformation) object;
      businessAndEventInformation.getLogin().setPassword(
          Encryption.decrypt(businessAndEventInformation.getLogin().getPassword()));
    }
    return businessAndEventInformation;
  }
}
