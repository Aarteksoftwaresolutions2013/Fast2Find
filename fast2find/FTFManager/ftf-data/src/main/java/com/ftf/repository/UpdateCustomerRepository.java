package com.ftf.repository;

import java.util.List;

import com.ftf.model.BusinessAndEventInformation;

public interface UpdateCustomerRepository {
  public List<Object> getCustomerInfoAdd(Integer loginId);
  public boolean updateCustomerInfoAdd(BusinessAndEventInformation businessAndEventInformation);
  public List<Object> getInformation(Integer loginId);
}
