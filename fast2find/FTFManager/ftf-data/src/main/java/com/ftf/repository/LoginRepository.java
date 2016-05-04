package com.ftf.repository;
import java.util.List;

import com.ftf.model.Audit;
public interface LoginRepository {
	public List<Object> userSignIn(String emailId, String password);
	public List<Object> getBranchData(Integer bid);
	public List<Object> custInfo(int loginId);
	public List<Object> eventInfo(int loginId);
	public List<Object> branchInfo(int loginId);
  public List<Object> adminSignIn(String emailId, String password);
  public List<Audit> getMaleAndFemale(int branchId, String todayDate);
}
