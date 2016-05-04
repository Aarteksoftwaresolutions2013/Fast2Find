package com.ftf.service;

import com.ftf.model.Branch;
import com.ftf.model.BusinessAndEventInformation;
import com.ftf.model.CustomerInformation;
import com.ftf.model.Login;

public interface LoginService {
	public Login userSignIn(Object object);
	public CustomerInformation custInfo(int loginId);
	public BusinessAndEventInformation eventInfo(int loginId);
	public Branch branchInfo(int loginId);
  public Login adminSignIn(Object object);
}
