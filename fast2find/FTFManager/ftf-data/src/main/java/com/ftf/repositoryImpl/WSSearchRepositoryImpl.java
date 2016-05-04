package com.ftf.repositoryImpl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.ftf.repository.WSSearchRepository;
import com.ftf.util.IConstant;

@Repository
@SuppressWarnings("rawtypes")
public class WSSearchRepositoryImpl implements WSSearchRepository {
  @Autowired
  private HibernateTemplate hibernateTemplate;

  /**
   * Fetch all business information based on full address and category
   * @param category
   * @param city
   * @param address2
   * @param zipCode
   * @param searchDate
   */
  public List getSearchDetails(String[] catagory, String city, String address2, String zipCode,
      String searchDate) {
    List searchDataList = null;
    String businessCatagory = " ";
    String catagoryId = " ";
    for (String s : catagory) {
      businessCatagory = businessCatagory + " OR b.BRANCH_TYPE='" + s + "'";
      catagoryId = catagoryId + " OR cs.CATAGEORY_ID='" + s + "'";
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
      Query query = session
          .createSQLQuery("SELECT MAX(a.NO_OF_MALE_IN),MAX(a.NO_OF_FEMALE_IN),MAX(a.NO_OF_MALE_OUT),MAX(a.NO_OF_FEMALE_OUT),b.BRANCH_NAME,b.BRANCH_TYPE,b.MAXCAPACITY,b.EVENT_START_DATEANDTIME,b.EVENT_END_DATEANDTIME,b.MUSIC,b.CONTACT_NO,b.LATITUDE,b.LONGITUDE,l.CITY_NAME,l.ADDRESS,l.STATE_NAME,l.ZIP_CODE,l.COUNTRY_NAME,b.BRANCH_ID,b.EVENT_NAME,b.SEARCH_DATA ,b.UPDATE_STAGE,b.EVENT_KIOSK_NAME,b.DAILY_EVENT_TICKET,b.FULL_EVENT_TICKET  FROM branch b LEFT OUTER JOIN audit a ON b.BRANCH_ID=a.BRANCH_ID LEFT OUTER JOIN categoryalias cs ON b.BRANCH_ID=cs.BRANCH_ID LEFT OUTER JOIN subcategoryalias scs  ON cs.CATEGORY_ALIAS_ID=scs.CATEGORY_ALIAS_ID AND DATE(a.TIME_STAMP)='"
              + searchDate
              + "' LEFT OUTER JOIN location l ON l.LOCATION_ID=b.LOCATION_ID where b.IS_DELETED="
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
              + ")GROUP BY b.BRANCH_ID ");
      searchDataList = query.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
    return searchDataList;
  }

  /**
   * Fetch business information based on category
   * @param category
   * @param searchDate
   */
  public List getSearchDataImpl(String[] catagory, String searchDate) {
    List searchDataList = null;
    String businessCatagory = " ";
    String catagoryId = " ";
    for (String s : catagory) {
      businessCatagory = businessCatagory + " OR b.BRANCH_TYPE='" + s + "'";
      catagoryId = catagoryId + " OR cs.CATAGEORY_ID='" + s + "'";
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
      Query query = session
          .createSQLQuery("SELECT MAX(a.NO_OF_MALE_IN),MAX(a.NO_OF_FEMALE_IN),MAX(a.NO_OF_MALE_OUT),MAX(a.NO_OF_FEMALE_OUT),b.BRANCH_NAME,b.BRANCH_TYPE,b.MAXCAPACITY,b.EVENT_START_DATEANDTIME,b.EVENT_END_DATEANDTIME,b.MUSIC,b.CONTACT_NO,b.LATITUDE,b.LONGITUDE,l.CITY_NAME,l.ADDRESS,l.STATE_NAME,l.ZIP_CODE,l.COUNTRY_NAME,b.BRANCH_ID,b.EVENT_NAME,b.SEARCH_DATA,b.UPDATE_STAGE ,b.EVENT_KIOSK_NAME,b.DAILY_EVENT_TICKET,b.FULL_EVENT_TICKET FROM branch b LEFT OUTER JOIN audit a ON b.BRANCH_ID=a.BRANCH_ID LEFT OUTER JOIN categoryalias cs  ON b.BRANCH_ID=cs.BRANCH_ID LEFT OUTER JOIN subcategoryalias scs  ON cs.CATEGORY_ALIAS_ID=scs.CATEGORY_ALIAS_ID AND DATE(a.TIME_STAMP)='"
              + searchDate
              + "' LEFT OUTER JOIN location l ON l.LOCATION_ID=b.LOCATION_ID where b.IS_DELETED="
              + IConstant.IS_DELETED
              + " "
              + "and (b.BRANCH_TYPE='select'"
              + businessCatagory
              + " OR cs.CATAGEORY_ID='0'" + catagoryId + ")GROUP BY b.BRANCH_ID ");
      searchDataList = query.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
    return searchDataList;
  }

  /**
   * Find 5km range locations.
   * @param category
   * @param searchDate
   * @param latitude
   * @param longitude 
   */
  public List getDataNearBy(String[] catagory, String searchDate, String latitude, String longitude) {
    List searchDataList = null;
    String businessCatagory = " ";
    String catagoryId = " ";
    for (String s : catagory) {
      businessCatagory = businessCatagory + " OR b.BRANCH_TYPE='" + s + "'";
      catagoryId = catagoryId + " OR cs.CATAGEORY_ID='" + s + "'";
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
      Query query = session
          .createSQLQuery("SELECT MAX(a.NO_OF_MALE_IN),MAX(a.NO_OF_FEMALE_IN),MAX(a.NO_OF_MALE_OUT),MAX(a.NO_OF_FEMALE_OUT),b.BRANCH_NAME,b.BRANCH_TYPE,b.MAXCAPACITY,b.EVENT_START_DATEANDTIME,b.EVENT_END_DATEANDTIME,b.MUSIC,b.CONTACT_NO,b.LATITUDE,b.LONGITUDE,l.CITY_NAME,l.ADDRESS,l.STATE_NAME,l.ZIP_CODE,l.COUNTRY_NAME,b.BRANCH_ID,b.EVENT_NAME,b.SEARCH_DATA , (6371 * ACOS( COS( RADIANS('"
              + latitude
              + "') ) * COS( RADIANS( b.latitude ) ) * COS( RADIANS( b.longitude ) -RADIANS('"
              + longitude
              + "') ) + SIN( RADIANS('"
              + latitude
              + "') ) * SIN( RADIANS( b.latitude ) ) ) ) AS distance FROM branch b LEFT OUTER JOIN audit a ON b.BRANCH_ID=a.BRANCH_ID LEFT OUTER JOIN categoryalias cs  ON b.BRANCH_ID=cs.BRANCH_ID LEFT OUTER JOIN subcategoryalias scs  ON cs.CATEGORY_ALIAS_ID=scs.CATEGORY_ALIAS_ID AND DATE(a.TIME_STAMP)='"
              + searchDate
              + "' LEFT OUTER JOIN location l ON l.LOCATION_ID=b.LOCATION_ID where b.IS_DELETED="
              + IConstant.IS_DELETED
              + " "
              + " and (b.BRANCH_TYPE='select'"
              + businessCatagory
              + " OR cs.CATAGEORY_ID='0'"
              + catagoryId
              + ")GROUP BY b.BRANCH_ID HAVING distance < 5");
      searchDataList = query.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
    return searchDataList;
  }

}
