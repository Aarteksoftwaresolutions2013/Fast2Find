package com.ftf.repository;

import java.util.List;

import com.ftf.model.Audit;
import com.ftf.model.Branch;

public interface GenerateEventGraphRepository {
	public List<Audit> getEventWeeklyDetails(Integer loginId);
	public List<Audit> getEventMonthlyDetails(Integer loginId);
	public List<Audit> getEventThreeMonthlyDetails(Integer loginId);
	public List<Audit> getEventYearlyDetails(Integer loginId);
	public List<Branch> getBranchEventId(Integer businessAndEventId);
}
