package com.ftf.service;

import com.ftf.model.BusinessAndEventInformation;

public interface UpdateCustomerService {
	public BusinessAndEventInformation getCustomerInfoAdd(Integer loginId);
	public boolean updateCustomerInfoAdd(BusinessAndEventInformation businessAndEventInformation);
  public BusinessAndEventInformation getInformation(Integer loginId);
}
