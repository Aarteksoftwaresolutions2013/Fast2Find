package com.ftf.repository;

import java.util.List;

import com.ftf.model.Audit;
import com.ftf.model.Branch;

public interface GenerateGraphRepository {
	public List<Audit> getWeeklyDetails(Integer loginId);

	public List<Audit> getMonthlyDetails(Integer loginId);

	public List<Audit> getThreeMonthlyDetails(Integer loginId);

	public List<Audit> getYearlyDetails(Integer loginId);

	public List<Branch> getBranchId(Integer businessAndEventId);
}
