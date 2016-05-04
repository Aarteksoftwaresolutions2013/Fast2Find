package com.ftf.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.repository.WSSearchRepository;
import com.ftf.service.WSSearchService;

@Service
@SuppressWarnings({ "rawtypes", "unchecked" })
public class WSSearchServiceImpl implements WSSearchService {
  @Autowired
  private WSSearchRepository wsSearchRepository;

  /**
   * fetch business information from database based on full address and category
   * 
   * @param catagory
   * @param city
   * @param address
   * @param searchDate
   */
  private static int count;

  public List getSearchDetails(String[] catagory, String address, String searchDate) {
    List audits = new ArrayList();
    List mapList = new ArrayList();
    String city = null;
    String address2 = null;
    String zipCode = null;
    if (!address.isEmpty()) {
      String[] splitAddress = address.split(",");
      if (splitAddress.length == 3) {
        city = splitAddress[0];
        address2 = splitAddress[1];
        zipCode = splitAddress[2];
        audits = wsSearchRepository.getSearchDetails(catagory, city, address2, zipCode, searchDate);
      } else {

        List searchList = wsSearchRepository.getSearchDataImpl(catagory, searchDate);
        audits = searchData(searchList, address);
      }
      if (!audits.isEmpty()) {
        for (Object obj : audits) {
          Map auditMap = new HashMap();
          Object[] objs = (Object[]) obj;
          auditMap.put("NO_OF_MALE_IN", objs[0] == null ? 0 : objs[0]);
          auditMap.put("NO_OF_FEMALE_IN", objs[1] == null ? 0 : objs[1]);
          auditMap.put("NO_OF_MALE_OUT", objs[2] == null ? 0 : objs[2]);
          auditMap.put("NO_OF_FEMALE_OUT", objs[3] == null ? 0 : objs[3]);
          auditMap.put("BRANCH_NAME", objs[4] == null ? 0 : objs[4]);
          auditMap.put("BRANCH_TYPE", objs[5]);
          auditMap.put("MAXCAPACITY", objs[6]);
          auditMap.put("EVENT_START_DATEANDTIME", objs[7]);
          auditMap.put("EVENT_END_DATEANDTIME", objs[8]);
          auditMap.put("MUSIC", objs[9] == null ? 0 : objs[9]);
          auditMap.put("CONTACT_NO", objs[10]);
          auditMap.put("LATITUDE", objs[11]);
          auditMap.put("LONGITUDE", objs[12]);
          auditMap.put("CITY_NAME", objs[13]);
          auditMap.put("ADDRESS", objs[14]);
          auditMap.put("STATE_NAME", objs[15]);
          auditMap.put("ZIP_CODE", objs[16]);
          auditMap.put("COUNTRY_NAME", objs[17]);
          auditMap.put("BRANCH_ID", objs[18]);
          auditMap.put("EVENT_NAME", objs[19] == null ? 0 : objs[19]);
          auditMap.put("SEARCH_DATA", objs[20]);
          auditMap.put("EVENT_STAGE", objs[21] == null ? 0 : objs[21]);
          auditMap.put("EVENT_KIOSK_NAME", objs[22] == null ? 0 : objs[22]);
          auditMap.put("DAY_PRICE", objs[23] == null ? 0 : objs[23]);
          auditMap.put("FULL_EVENT_PRICE", objs[24] == null ? 0 : objs[24]);
          mapList.add(auditMap);
        }
      }
    }

    return mapList;
  }

  public List searchData(List finallist, String search) {
    String s[] = search.split("\\s*(=>|,|\\s)\\s*");
    List temp = new ArrayList();
    for (int i = 0; i < s.length; i++) {

      for (Iterator iterator = finallist.iterator(); iterator.hasNext();) {

        Object obj[] = (Object[]) iterator.next();
        String address = (String) obj[20];
        if (address.toLowerCase().contains(s[i].toLowerCase())) {
          temp.add(address);
          ++count;
        } else {
          iterator.remove();
        }
      }
    }
    return finallist;
  }

  /**
   * fetch data from database near to 5km range.
   * 
   * @param category
   * @param searchDate
   * @param latitude
   * @param longitude
   */
  public List getDataWithInRange(String[] catagory, String address, String searchDate,
      String latitude, String longitude) {
    List audits = new ArrayList();
    List mapList = new ArrayList();
    if (!address.isEmpty()) {
      List searchList = wsSearchRepository.getDataNearBy(catagory, searchDate, latitude, longitude);
      audits = searchData(searchList, address);
      if (!audits.isEmpty()) {
        for (Object obj : audits) {
          Map auditMap = new HashMap();
          Object[] objs = (Object[]) obj;
          auditMap.put("NO_OF_MALE_IN", objs[0] == null ? 0 : objs[0]);
          auditMap.put("NO_OF_FEMALE_IN", objs[1] == null ? 0 : objs[1]);
          auditMap.put("NO_OF_MALE_OUT", objs[2] == null ? 0 : objs[2]);
          auditMap.put("NO_OF_FEMALE_OUT", objs[3] == null ? 0 : objs[3]);
          auditMap.put("BRANCH_NAME", objs[4] == null ? 0 : objs[4]);
          auditMap.put("BRANCH_TYPE", objs[5]);
          auditMap.put("MAXCAPACITY", objs[6]);
          auditMap.put("EVENT_START_DATEANDTIME", objs[7]);
          auditMap.put("EVENT_END_DATEANDTIME", objs[8]);
          auditMap.put("MUSIC", objs[9] == null ? 0 : objs[9]);
          auditMap.put("CONTACT_NO", objs[10]);
          auditMap.put("LATITUDE", objs[11]);
          auditMap.put("LONGITUDE", objs[12]);
          auditMap.put("CITY_NAME", objs[13]);
          auditMap.put("ADDRESS", objs[14]);
          auditMap.put("STATE_NAME", objs[15]);
          auditMap.put("ZIP_CODE", objs[16]);
          auditMap.put("COUNTRY_NAME", objs[17]);
          auditMap.put("BRANCH_ID", objs[18]);
          auditMap.put("EVENT_NAME", objs[19] == null ? 0 : objs[19]);
          auditMap.put("SEARCH_DATA", objs[20]);
          mapList.add(auditMap);
        }
      }
    }

    return mapList;
  }
}
