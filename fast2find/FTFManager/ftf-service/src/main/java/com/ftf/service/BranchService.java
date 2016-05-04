package com.ftf.service;
import java.util.List;

import com.ftf.model.Branch;
public interface BranchService {
	public boolean businessEventInfoAdd(Branch branch);
	public List<Branch> getbusiness(Integer businessAndEventId);
	public Branch getBusinessInfoById(Integer branchId);
	public List<Branch> getEventName(Integer businessAndEventId);
  public List<Object> getSubCategoryName(Integer categoryId);
  public List<Object> getCategoryName(Integer categoryId);
  public boolean addEventInformation(Branch branch);
}
