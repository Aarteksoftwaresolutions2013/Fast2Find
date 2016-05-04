package com.ftf.repository;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface WSSearchRepository {
	public List getSearchDetails(String[] catagory, String city,
			String address2, String zipCode, String searchDate);
	public List getSearchDataImpl(String[] catagory, String searchDate);
	public List getDataNearBy(String[] catagory, String searchDate,
			String latitude, String longitude);

}
