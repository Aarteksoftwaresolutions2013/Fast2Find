package com.ftf.repositoryImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ftf.model.Branch;
import com.ftf.model.CustomerComment;
import com.ftf.repository.MapSearchRepository;
import com.ftf.util.IConstant;

@Repository
@SuppressWarnings({ "unchecked", "rawtypes" })
public class MapSearchRepositoryImpl implements MapSearchRepository {
  @Autowired
  private HibernateTemplate hibernateTemplate;

  /**
   * getSearchDetails method use for get all business information when user
   * enter full address and select category and subcategory.
   * @param catagory
   * @param address
   * @param searchDate
   * @param subCategory
   */
  public List getSearchDetails(String[] catagory, String city, String address2, String zipCode,
      String searchDate, String[] subCategory) {
    List searchDataList = null;
    String businessCatagory = " ";
    String catagoryId = " ";
    String subCategoryId = " ";
    for (String s : catagory) {
      businessCatagory = businessCatagory + " OR b.BRANCH_TYPE='" + s + "'";
      catagoryId = catagoryId + " OR cs.CATAGEORY_ID='" + s + "'";
    }
    if (subCategory != null) {
      for (String sc : subCategory) {
        subCategoryId = subCategoryId + " OR scs.SUB_CATAGEORY_ID='" + sc + "'";
      }
    }
    /*
     * Please don't Change SQL Query index because web service depend on it, if
     * you want to add column then add on last index
     */
    SessionFactory sessionFactory = null;
    Session session = null;
    try {
      sessionFactory = hibernateTemplate.getSessionFactory();
      session = sessionFactory.openSession();
      if (catagory[0].equals("event")) {
        Query query = session
            .createSQLQuery("SELECT MAX(a.NO_OF_MALE_IN),MAX(a.NO_OF_FEMALE_IN),MAX(a.NO_OF_MALE_OUT),MAX(a.NO_OF_FEMALE_OUT),b.BRANCH_NAME,b.BRANCH_TYPE,b.MAXCAPACITY,b.EVENT_START_DATEANDTIME,b.EVENT_END_DATEANDTIME,b.MUSIC,b.CONTACT_NO,b.LATITUDE,b.LONGITUDE,l.CITY_NAME,l.ADDRESS,l.STATE_NAME,l.ZIP_CODE,l.COUNTRY_NAME,b.BRANCH_ID,b.EVENT_NAME,b.SEARCH_DATA , oh.START_TIME,oh.END_TIME FROM branch b LEFT OUTER JOIN audit a ON b.BRANCH_ID=a.BRANCH_ID LEFT OUTER JOIN categoryalias cs  ON b.BRANCH_ID=cs.BRANCH_ID LEFT OUTER JOIN subcategoryalias scs  ON cs.CATEGORY_ALIAS_ID=scs.CATEGORY_ALIAS_ID LEFT OUTER JOIN location l ON l.LOCATION_ID=b.LOCATION_ID LEFT OUTER JOIN OperatingHours oh ON b.OPERATING_HOURS_ID=oh.OPERATING_HOURS_ID where b.IS_DELETED="
                + IConstant.IS_DELETED
                + " "
                + "and (l.CITY_NAME='"
                + city
                + "' OR l.ADDRESS='"
                + address2
                + "' OR l.ZIP_CODE='"
                + zipCode
                + "') AND"
                + " b.BRANCH_TYPE='"
                + catagory[0]
                + "' AND b.EVENT_START_DATEANDTIME>='"
                + searchDate
                + "' GROUP BY b.BRANCH_ID ");
        searchDataList = query.list();
      } else {
        Query query = session
            .createSQLQuery("SELECT MAX(a.NO_OF_MALE_IN),MAX(a.NO_OF_FEMALE_IN),MAX(a.NO_OF_MALE_OUT),MAX(a.NO_OF_FEMALE_OUT),b.BRANCH_NAME,b.BRANCH_TYPE,b.MAXCAPACITY,b.EVENT_START_DATEANDTIME,b.EVENT_END_DATEANDTIME,b.MUSIC,b.CONTACT_NO,b.LATITUDE,b.LONGITUDE,l.CITY_NAME,l.ADDRESS,l.STATE_NAME,l.ZIP_CODE,l.COUNTRY_NAME,b.BRANCH_ID,b.EVENT_NAME,b.SEARCH_DATA , oh.START_TIME,oh.END_TIME FROM branch b LEFT OUTER JOIN audit a ON b.BRANCH_ID=a.BRANCH_ID LEFT OUTER JOIN categoryalias cs  ON b.BRANCH_ID=cs.BRANCH_ID LEFT OUTER JOIN subcategoryalias scs  ON cs.CATEGORY_ALIAS_ID=scs.CATEGORY_ALIAS_ID AND DATE(a.TIME_STAMP)='"
                + searchDate
                + "' LEFT OUTER JOIN location l ON l.LOCATION_ID=b.LOCATION_ID LEFT OUTER JOIN OperatingHours oh ON b.OPERATING_HOURS_ID=oh.OPERATING_HOURS_ID where b.IS_DELETED="
                + IConstant.IS_DELETED
                + " "
                + "and (l.CITY_NAME='"
                + city
                + "' OR l.ADDRESS='"
                + address2
                + "' OR l.ZIP_CODE='"
                + zipCode
                + "') AND"
                + "(b.BRANCH_TYPE='select'"
                + businessCatagory
                + " OR cs.CATAGEORY_ID='0'"
                + catagoryId
                + " OR scs.SUB_CATAGEORY_ID='0'" + subCategoryId + ")GROUP BY b.BRANCH_ID ");
        searchDataList = query.list();
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
    return searchDataList;
  }
  
  /**
   * findBySearchName method use get all address according to enter a word
   * This method use for autocomplete
   * @param searchValues
   */
  public List<Branch> findBySearchName(String searchValues) {
    List<Branch> searchDataList = null;
    searchDataList = hibernateTemplate.find(
        "select DISTINCT b.searchData from Branch b where b.searchData LIKE ?", searchValues);
    return searchDataList;
  }
  
  /**
   * getMapInformation method get business information according to branchid from database
   * @param branchId
   * @param searchDate
   */
  public List<Branch> getMapInformation(Integer branchId, String searchDate) {
    List<Branch> mapInformationList = null;
    /*
     * Please don't Change SQL Query index because web service depend on it, if
     * you want to add column then add on last index
     */
    SessionFactory sessionFactory = null;
    Session session = null;
    try {
      sessionFactory = hibernateTemplate.getSessionFactory();
      session = sessionFactory.openSession();
      Query query = session
          .createSQLQuery("SELECT MAX(a.NO_OF_MALE_IN),MAX(a.NO_OF_FEMALE_IN),MAX(a.NO_OF_MALE_OUT),MAX(a.NO_OF_FEMALE_OUT),b.BRANCH_NAME,b.BRANCH_TYPE,b.MAXCAPACITY,b.EVENT_START_DATEANDTIME,b.EVENT_END_DATEANDTIME,b.MUSIC,b.CONTACT_NO,b.LATITUDE,b.LONGITUDE,l.CITY_NAME,l.ADDRESS,l.STATE_NAME,l.ZIP_CODE,l.COUNTRY_NAME,b.BRANCH_ID,b.CHARGE_PER_PERSON,b.QUICK_BOOKING_FEE_PER_TABLE,b.ENTRY_TICKETS,b.BOTTLE_SERVICE_BOOKING,b.HOUR_OF_OPERATION,b.DECRIPTION,b.ADDITIONAL_INFO,oh.START_TIME,oh.END_TIME FROM branch b LEFT OUTER JOIN audit a ON b.BRANCH_ID=a.BRANCH_ID  AND DATE(a.TIME_STAMP)='"
              + searchDate
              + "' LEFT OUTER JOIN location l ON l.LOCATION_ID=b.LOCATION_ID LEFT OUTER JOIN OperatingHours oh ON b.OPERATING_HOURS_ID=oh.OPERATING_HOURS_ID where b.IS_DELETED="
              + IConstant.IS_DELETED
              + " "
              + "and b.BRANCH_ID='"
              + branchId
              + "' GROUP BY b.BRANCH_ID ");
      mapInformationList = query.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
    return mapInformationList;
  }

  /**
   * getEventSearchInfo method use to get all event that are registered with
   * Fast2Find.
   * @param catagory
   * @param city
   * @param address2
   * @param zipCode
   * @param searchDate
   */
  public List<Branch> getEventSearchInfo(String[] catagory, String city, String address2,
      String zipCode, String searchDate) {
    List<Branch> searchDataList = null;
    String businessCatagory = " ";
    for (String s : catagory) {
      businessCatagory = businessCatagory + " OR b.branchType='" + s + "'";
      System.out.println("Branch" + businessCatagory);
      /*
       * Please don't Change SQL Query index because web service depend on it,
       * if you want to add column then add on last index
       */
      searchDataList = hibernateTemplate
          .find("select b.branchId, b.eventStartDateAndTime,b.eventEndDateAndTime,b.eventName from  Branch b WHERE b.isDeleted="
              + IConstant.IS_DELETED
              + " AND (b.location.cityName='"
              + city
              + "' OR b.location.address='"
              + address2
              + "' OR b.location.zipCode='"
              + zipCode
              + "')and (b.branchType='select'"
              + businessCatagory
              + ") and b.eventStartDateAndTime>='" + searchDate + "' ");
    }
    return searchDataList;
  }

  /**
   * getEventInformation method use to get event information from data base.
   * @param branchId
   * @param searchDate
   */
  public List<Branch> getEventInformation(Integer branchId, String searchDate) {
    List<Branch> eventSearchInfoList = null;
    /*
     * Please don't Change SQL Query index because web service depend on it, if
     * you want to add column then add on last index
     */
    SessionFactory sessionFactory = null;
    Session session = null;
    try {
      sessionFactory = hibernateTemplate.getSessionFactory();
      session = sessionFactory.openSession();
      Query query = session
          .createSQLQuery("SELECT MAX(a.NO_OF_MALE_IN),MAX(a.NO_OF_FEMALE_IN),MAX(a.NO_OF_MALE_OUT),MAX(a.NO_OF_FEMALE_OUT),b.EVENT_NAME,b.BRANCH_TYPE,b.MAXCAPACITY,b.EVENT_START_DATEANDTIME,b.EVENT_END_DATEANDTIME,b.CONTACT_NO,b.LATITUDE,b.LONGITUDE,l.CITY_NAME,l.ADDRESS,l.STATE_NAME,l.ZIP_CODE,l.COUNTRY_NAME,b.BRANCH_ID,b.FULL_EVENT_TICKET,b.DECRIPTION,b.EVENT_KIOSK_NAME,b.DAILY_EVENT_TICKET,b.UPDATE_STAGE  ,b.ALLOW_QUICKBOOKING FROM branch b LEFT OUTER JOIN audit a ON b.BRANCH_ID=a.BRANCH_ID AND DATE(a.TIME_STAMP)='"
              + searchDate
              + "' LEFT OUTER JOIN location l ON l.LOCATION_ID=b.LOCATION_ID where b.IS_DELETED="
              + IConstant.IS_DELETED
              + " "
              + "and b.BRANCH_ID='"
              + branchId
              + "' GROUP BY b.BRANCH_ID ");
      eventSearchInfoList = query.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
    return eventSearchInfoList;
  }

  /**
   * getSearchDataImpl method use for get all business when use enter only city
   * or address or state or zip code
   * @param catagory
   * @param address
   * @param searchDate
   * @param subCategory
   */
  public List getSearchDataImpl(String[] catagory, String searchDate, String[] subCategory) {
    List searchDataList = null;
    String businessCatagory = " ";
    String catagoryId = " ";
    String subCategoryId = " ";
    for (String s : catagory) {
      businessCatagory = businessCatagory + " OR b.BRANCH_TYPE='" + s + "'";
      catagoryId = catagoryId + " OR cs.CATAGEORY_ID='" + s + "'";
    }
    if (subCategory != null) {
      for (String sc : subCategory) {
        subCategoryId = subCategoryId + " OR scs.SUB_CATAGEORY_ID='" + sc + "'";
      }
    }
    /*
     * Please don't Change SQL Query index because web service depend on it, if
     * you want to add column then add on last index
     */
    SessionFactory sessionFactory = null;
    Session session = null;
    try {
      sessionFactory = hibernateTemplate.getSessionFactory();
      session = sessionFactory.openSession();
      if (catagory[0].equals("event")) {
        Query query = session
            .createSQLQuery("SELECT MAX(a.NO_OF_MALE_IN),MAX(a.NO_OF_FEMALE_IN),MAX(a.NO_OF_MALE_OUT),MAX(a.NO_OF_FEMALE_OUT),b.BRANCH_NAME,b.BRANCH_TYPE,b.MAXCAPACITY,b.EVENT_START_DATEANDTIME,b.EVENT_END_DATEANDTIME,b.MUSIC,b.CONTACT_NO,b.LATITUDE,b.LONGITUDE,l.CITY_NAME,l.ADDRESS,l.STATE_NAME,l.ZIP_CODE,l.COUNTRY_NAME,b.BRANCH_ID,b.EVENT_NAME,b.SEARCH_DATA , oh.START_TIME,oh.END_TIME FROM branch b LEFT OUTER JOIN audit a ON b.BRANCH_ID=a.BRANCH_ID LEFT OUTER JOIN categoryalias cs  ON b.BRANCH_ID=cs.BRANCH_ID LEFT OUTER JOIN subcategoryalias scs  ON cs.CATEGORY_ALIAS_ID=scs.CATEGORY_ALIAS_ID AND DATE(a.TIME_STAMP)='"
                + searchDate
                + "' LEFT OUTER JOIN location l ON l.LOCATION_ID=b.LOCATION_ID LEFT OUTER JOIN OperatingHours oh ON b.OPERATING_HOURS_ID=oh.OPERATING_HOURS_ID where b.IS_DELETED="
                + IConstant.IS_DELETED
                + " AND b.BRANCH_TYPE='"
                + catagory[0]
                + "' AND b.EVENT_START_DATEANDTIME>='" + searchDate + "' GROUP BY b.BRANCH_ID ");
        searchDataList = query.list();
      } else {
        Query query = session
            .createSQLQuery("SELECT MAX(a.NO_OF_MALE_IN),MAX(a.NO_OF_FEMALE_IN),MAX(a.NO_OF_MALE_OUT),MAX(a.NO_OF_FEMALE_OUT),b.BRANCH_NAME,b.BRANCH_TYPE,b.MAXCAPACITY,b.EVENT_START_DATEANDTIME,b.EVENT_END_DATEANDTIME,b.MUSIC,b.CONTACT_NO,b.LATITUDE,b.LONGITUDE,l.CITY_NAME,l.ADDRESS,l.STATE_NAME,l.ZIP_CODE,l.COUNTRY_NAME,b.BRANCH_ID,b.EVENT_NAME,b.SEARCH_DATA , oh.START_TIME,oh.END_TIME FROM branch b LEFT OUTER JOIN audit a ON b.BRANCH_ID=a.BRANCH_ID LEFT OUTER JOIN categoryalias cs  ON b.BRANCH_ID=cs.BRANCH_ID LEFT OUTER JOIN subcategoryalias scs  ON cs.CATEGORY_ALIAS_ID=scs.CATEGORY_ALIAS_ID AND DATE(a.TIME_STAMP)='"
                + searchDate
                + "' LEFT OUTER JOIN location l ON l.LOCATION_ID=b.LOCATION_ID LEFT OUTER JOIN OperatingHours oh ON b.OPERATING_HOURS_ID=oh.OPERATING_HOURS_ID where b.IS_DELETED="
                + IConstant.IS_DELETED
                + " "
                + " and (b.BRANCH_TYPE='select'"
                + businessCatagory
                + " OR cs.CATAGEORY_ID='0'"
                + catagoryId
                + " OR scs.SUB_CATAGEORY_ID='0'"
                + subCategoryId + ")GROUP BY b.BRANCH_ID ");
        searchDataList = query.list();
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
    return searchDataList;
  }

  /**
   * getEventSearch method use to get all event name based on selected date .
   * @param catagory
   * @param searchDate
   */
  public List getEventSearch(String[] catagory, String searchDate) {
    List searchDataList = null;
    String businessCatagory = " ";
    for (String s : catagory) {
      businessCatagory = businessCatagory + " OR b.branchType='" + s + "'";
    }
    /*
     * Please don't Change SQL Query index because web service depend on it, if
     * you want to add column then add on last index
     */
    searchDataList = hibernateTemplate
        .find("select b.branchId, b.eventStartDateAndTime,b.eventEndDateAndTime,b.eventName ,b.searchData from  Branch b WHERE b.isDeleted="
            + IConstant.IS_DELETED
            + "  "
            + " and (b.branchType='select'"
            + businessCatagory
            + ") and b.eventStartDateAndTime>='" + searchDate + "' ");
    return searchDataList;
  }
  
  /**
   * getCustomerComment method use to get customer comment from database.
   * All customer comment show on map pin point.
   * @param branchId
   */
  public List<CustomerComment> getCustomerComment(int branchId) {
    List<CustomerComment> customerComment = null;
    customerComment = hibernateTemplate.find("from CustomerComment cc where cc.branch.branchId=?",
        branchId);
    System.out.println(customerComment);
    return customerComment;
  }
}
