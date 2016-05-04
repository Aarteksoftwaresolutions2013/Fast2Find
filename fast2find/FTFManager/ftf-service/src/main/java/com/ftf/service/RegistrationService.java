package com.ftf.service;
import com.ftf.model.BusinessAndEventInformation;
import com.ftf.model.CustomerInformation;
public interface RegistrationService {
	public boolean custInfoAdd(CustomerInformation customerInformation);
	public boolean addBusinessAndEvent(
			BusinessAndEventInformation businessAndEventInformation);
	/*public void sendMail(final String emailId, final String password);*/
  public void updatePaidStatus();
  public boolean editBusinessCustomerInfo(BusinessAndEventInformation businessAndEventInformation);

}
