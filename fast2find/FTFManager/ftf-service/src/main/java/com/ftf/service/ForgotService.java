package com.ftf.service;

import java.util.List;

public interface ForgotService {

	 @SuppressWarnings("rawtypes")
	 public List getPassword(String email);
	 public void sendMail(final String pass,final String email);
  public void sendConfirmation(String password, String emailId);
}
