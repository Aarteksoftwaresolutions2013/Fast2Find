package com.ftf.service;

import java.util.List;

import com.ftf.model.Branch;
import com.ftf.model.CustomerComment;
@SuppressWarnings("rawtypes")
public interface MapSearchService {
	public List getSearchDetails(String[] catagory, String address,String searchDate, String[] subCategory);

	public List<Branch> searchAllMaps(String searchValues);

	public List<Branch> getMapInformation(Integer branchId,String searchDate);

	public List<Branch> getEventSearchInfo(String[] catagory, String address,String searchDate);

	public List<Branch> getEventInformation(Integer branchId,String searchDate);

  public List<CustomerComment> getCustomerComment(int branchId);

}
