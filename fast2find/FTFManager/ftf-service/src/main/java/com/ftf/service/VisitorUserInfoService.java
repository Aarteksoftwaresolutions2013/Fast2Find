package com.ftf.service;

import com.ftf.model.ContactUs;
import com.ftf.model.VisitorUser;

public interface VisitorUserInfoService {
	public void addVisitorMessage(VisitorUser visitorUser);
	public boolean addContactMessage(ContactUs contactUs);
}
