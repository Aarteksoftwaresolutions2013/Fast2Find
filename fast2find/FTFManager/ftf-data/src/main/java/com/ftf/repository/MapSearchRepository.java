package com.ftf.repository;

import java.util.List;

import com.ftf.model.Branch;
import com.ftf.model.CustomerComment;

@SuppressWarnings("rawtypes")
public interface MapSearchRepository {
	public List getSearchDetails(String[] catagory, String city,
			String address2, String zipCode,String searchDate,String[] subCategory);

	public List<Branch> findBySearchName(String searchValues);

	public List<Branch> getMapInformation(Integer branchId,String searchDate);

	public List<Branch> getEventSearchInfo(String[] catagory, String city,
			String address2, String zipCode,String searchDate);

	public List<Branch> getEventInformation(Integer branchId,String searchDate);

	public List getSearchDataImpl(String[] catagory,String searchDate, String[] subCategory);

	public List getEventSearch(String[] catagory,String searchDate);

  public List<CustomerComment> getCustomerComment(int branchId);
}
