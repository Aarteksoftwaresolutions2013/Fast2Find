package com.ftf.repository;

import java.util.List;

import com.ftf.model.EmailAlert;

public interface EmailAlertRepository {
	public List<EmailAlert> getAlertEmail(String monthly);
	public List<EmailAlert> getWeeklyEmail(String weekly);
	public boolean custInfoAdd(EmailAlert emailAlert);

}
