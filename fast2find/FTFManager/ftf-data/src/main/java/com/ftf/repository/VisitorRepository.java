package com.ftf.repository;

import com.ftf.model.ContactUs;
import com.ftf.model.VisitorUser;

public interface VisitorRepository {
	public void addVisitorMessage(VisitorUser visitorUser);
	public boolean addContactMessage(ContactUs contactUs);
}
