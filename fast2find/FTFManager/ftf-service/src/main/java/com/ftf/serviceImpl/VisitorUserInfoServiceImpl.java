package com.ftf.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.model.ContactUs;
import com.ftf.model.VisitorUser;
import com.ftf.repository.VisitorRepository;
import com.ftf.service.VisitorUserInfoService;
import com.ftf.util.IConstant;

@Service
public class VisitorUserInfoServiceImpl implements VisitorUserInfoService {
	@Autowired
	private VisitorRepository visitorRepository;

	/**
	 * addVisitorMessage() use for save visitor information into database.
	 * set isDeleted one as active
	 * @param visitorUser
	 */
	public void addVisitorMessage(VisitorUser visitorUser) {
		visitorUser.setIsDeleted(IConstant.IS_DELETED);
		visitorRepository.addVisitorMessage(visitorUser);
	}

	public boolean addContactMessage(ContactUs contactUs) {
		boolean status = false;
		if (contactUs != null) {
			contactUs.setIsDeleted(IConstant.IS_DELETED);
			status = visitorRepository.addContactMessage(contactUs);
			return status;
		} else {
			return status;
		}
	}

}
