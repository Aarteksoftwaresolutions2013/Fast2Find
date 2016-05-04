package com.ftf.repository;
import com.ftf.model.BusinessAndEventInformation;
import com.ftf.model.CustomerInformation;
public interface RegistrationRepository {
	public boolean custInfoAdd(CustomerInformation customerInformation);
	public boolean addBusinessAndEvent(
			BusinessAndEventInformation businessAndEventInformation);
  public void updatePaidStatus();
  public boolean editBusinessCustomerInfo(BusinessAndEventInformation businessAndEventInformation);
}
