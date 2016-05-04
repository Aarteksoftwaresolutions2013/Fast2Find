package com.ftf.service;

import com.ftf.model.EmailAlert;

public interface EmailAlertService {
	public void startTime();
	public boolean addEmailRequest(EmailAlert emailAlert);
}
