package com.ftf.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.model.Branch;
import com.ftf.model.CustomerComment;
import com.ftf.repository.MapSearchRepository;
import com.ftf.service.MapSearchService;
import com.ftf.util.DateFormat;

@Service
@SuppressWarnings("rawtypes")
public class MapSearchServiceImpl implements MapSearchService {
  @Autowired
  private MapSearchRepository mapSearchRepository;
  private static int count;
/**
 * getSearchDetails method use for get all business information when user enter full address and select category and subcategory.
 * date format should be yyyy/MM/dd
 * getSearchDataImpl method use for get all business when use enter only city or address or state or zip code
 * @param catagory
 * @param address
 * @param searchDate
 * @param subCategory
 */
  public List getSearchDetails(String[] catagory, String address, String searchDate,
      String[] subCategory) {
    String demoDate = DateFormat.getYYYYMMDDDate(searchDate);
    System.out.println(demoDate);
    List audits = new ArrayList();
    String city = null;
    String address2 = null;
    String zipCode = null;
    if (!address.isEmpty()) {
      String[] splitAddress = address.split(",");
      if (splitAddress.length == 3) {
        city = splitAddress[0];
        address2 = splitAddress[1];
        zipCode = splitAddress[2];
        audits = mapSearchRepository.getSearchDetails(catagory, city, address2, zipCode,
            DateFormat.getYYYYMMDDDate(searchDate), subCategory);
      } else {
        List searchList = mapSearchRepository.getSearchDataImpl(catagory,
            DateFormat.getYYYYMMDDDate(searchDate), subCategory);
        audits = searchData(searchList, address);
      }
    }

    return audits;
  }
/**
 * findBySearchName method use get all address according to enter a word
 * This method use for autocomplete
 * @param searchValues
 */
  public List<Branch> searchAllMaps(String searchValues) {
    System.out.println("Inside ServiceImpl..");
    searchValues = searchValues.trim();
    searchValues = '%' + searchValues + '%';
    List<Branch> searchList = mapSearchRepository.findBySearchName(searchValues);
    return searchList;
  }

  /**
   * getMapInformation method get business information according to branchid from database
   * @param branchId
   * @param searchDate
   */
  public List<Branch> getMapInformation(Integer branchId, String searchDate) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String createdDate = dateFormat.format(date);
    searchDate = createdDate.toString();
    List<Branch> infoMapList = mapSearchRepository.getMapInformation(branchId, searchDate);
    return infoMapList;
  }
/**
 * getEventSearchInfo method use when full address enter by user.
 * getEventSearch method use when use enter only city or address or state etc.
 * @param catagory
 * @param city
 * @param address
 * @param searchDate
 */
  @SuppressWarnings("unchecked")
  public List<Branch> getEventSearchInfo(String[] catagory, String address, String searchDate) {
    List<Branch> audits = new ArrayList<Branch>();
    String city = null;
    String address2 = null;
    String zipCode = null;
    if (!address.isEmpty()) {
      String[] splitAddress = address.split(",");
      if (splitAddress.length == 3) {
        city = splitAddress[0];
        address2 = splitAddress[1];
        zipCode = splitAddress[2];
        audits = mapSearchRepository.getEventSearchInfo(catagory, city, address2, zipCode,
            DateFormat.getYYYYMMDDDate(searchDate));
      } else {

        List searchList = mapSearchRepository.getEventSearch(catagory,
            DateFormat.getYYYYMMDDDate(searchDate));
        audits = eventSearchData(searchList, address);

      }
    }
    return audits;
  }
/**
 * getEventInformation method use to get event information from data base.
 * @param branchId
 * @param searchDate 
 */
  public List<Branch> getEventInformation(Integer branchId, String searchDate) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String createdDate = dateFormat.format(date);
    searchDate = createdDate.toString();
    List<Branch> eventInfoList = mapSearchRepository.getEventInformation(branchId, searchDate);
    return eventInfoList;
  }

  /**
   * searchData method use to find duplicate entry. 
   * @param finallist
   * @param search
   */
  @SuppressWarnings("unchecked")
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

  @SuppressWarnings("unchecked")
  public List eventSearchData(List finallist, String search) {
    String s[] = search.split("\\s*(=>|,|\\s)\\s*");
    List temp = new ArrayList();
    for (int i = 0; i < s.length; i++) {
      for (Iterator iterator = finallist.iterator(); iterator.hasNext();) {
        Object obj[] = (Object[]) iterator.next();
        String address = (String) obj[4];
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
 * getCustomerComment method use to get customer comment from database.
 * All customer comment show on map pin point.
 * @param branchId
 */
  public List<CustomerComment> getCustomerComment(int branchId) {
    List<CustomerComment> commentList = mapSearchRepository.getCustomerComment(branchId);
    return commentList;
  }
}
