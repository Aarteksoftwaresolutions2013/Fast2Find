package com.ftf.service;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface WSSearchService {
	public List getSearchDetails(String[] catagory, String address,
			String searchDate);

	public List getDataWithInRange(String[] catagory, String address,
			String searchDate, String latitude, String longitude);
}
