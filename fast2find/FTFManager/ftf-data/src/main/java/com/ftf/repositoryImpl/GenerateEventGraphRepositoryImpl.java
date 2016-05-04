package com.ftf.repositoryImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ftf.model.Audit;
import com.ftf.model.Branch;
import com.ftf.repository.GenerateEventGraphRepository;

@Repository
@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
public class GenerateEventGraphRepositoryImpl implements GenerateEventGraphRepository {

  @Autowired
  private HibernateTemplate hibernateTemplate;

  /**
   * getEventWeeklyDetails use to get weekly data from database
   * 
   * @param loginId
   */
  public List<Audit> getEventWeeklyDetails(Integer loginId) {
    List hourlyList = null;
    List weeklyList = null;
    List graphData = new ArrayList();
    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");// dd/MM/yyyy
    Date now = new Date();
    String strDate = sdfDate.format(now);
    DateUtils d = new DateUtils();
    Date D = d.addDays(now, -7);
    String endDate = sdfDate.format(D);
    SessionFactory sessionFactory = null;
    Session session = null;
    try {
      sessionFactory = hibernateTemplate.getSessionFactory();
      session = sessionFactory.openSession();
      Query query = session
          .createSQLQuery("SELECT TIME(t),MAX(temp.currentVolume) FROM (SELECT TIME_STAMP t, ((NO_OF_MALE_IN+NO_OF_FEMALE_IN)-(NO_OF_MALE_OUT+NO_OF_FEMALE_OUT)) currentVolume,BRANCH_ID FROM audit WHERE   ((NO_OF_MALE_IN+NO_OF_FEMALE_IN)-(NO_OF_MALE_OUT+NO_OF_FEMALE_OUT)) IN(SELECT MAX(((NO_OF_MALE_IN+NO_OF_FEMALE_IN)-(NO_OF_MALE_OUT+NO_OF_FEMALE_OUT))) FROM  audit    GROUP BY DATE(TIME_STAMP)) ORDER BY ((NO_OF_MALE_IN+NO_OF_FEMALE_IN)-(NO_OF_MALE_OUT+NO_OF_FEMALE_OUT))) temp  WHERE  (DATE(t) BETWEEN '"
              + endDate
              + "' AND  '"
              + strDate
              + "') and BRANCH_ID='"
              + loginId
              + "' GROUP BY DATE(t) ;");
      hourlyList = query.list();
      weeklyList = hibernateTemplate
          .find("SELECT  date(a.timeStamp),Max(a.noOfMaleIn),Max(a.noOfFeMaleIn), a.branch.eventName,a.branch.branchType,a.branch.maxCapacity,a.branch.music FROM Audit a  WHERE (a.timeStamp BETWEEN '"
              + endDate
              + "' and '"
              + strDate
              + "') and a.branch.branchId='"
              + loginId
              + "' GROUP BY date(a.timeStamp) ");
      graphData.add(weeklyList);
      graphData.add(hourlyList);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
    return graphData;

  }

  /**
   * getEventMonthlyDetails use to get monthly data from database
   * 
   * @param loginId
   */
  public List<Audit> getEventMonthlyDetails(Integer loginId) {
    List hourlydDataList = null;
    List monthlyList = null;
    List graphDataList = new ArrayList();
    Integer branchId = null;
    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");// dd/MM/yyyy
    Date now = new Date();
    String strDate = sdfDate.format(now);
    DateUtils d = new DateUtils();
    Date D = d.addDays(now, -30);
    String endDate = sdfDate.format(D);
    SessionFactory sessionFactory = null;
    Session session = null;
    try {
      sessionFactory = hibernateTemplate.getSessionFactory();
      session = sessionFactory.openSession();
      Query query = session
          .createSQLQuery("SELECT TIME(t),MAX(temp.currentVolume) FROM (SELECT TIME_STAMP t, ((NO_OF_MALE_IN+NO_OF_FEMALE_IN)-(NO_OF_MALE_OUT+NO_OF_FEMALE_OUT)) currentVolume,BRANCH_ID FROM audit WHERE   ((NO_OF_MALE_IN+NO_OF_FEMALE_IN)-(NO_OF_MALE_OUT+NO_OF_FEMALE_OUT)) IN(SELECT MAX(((NO_OF_MALE_IN+NO_OF_FEMALE_IN)-(NO_OF_MALE_OUT+NO_OF_FEMALE_OUT))) FROM  audit    GROUP BY DATE(TIME_STAMP)) ORDER BY ((NO_OF_MALE_IN+NO_OF_FEMALE_IN)-(NO_OF_MALE_OUT+NO_OF_FEMALE_OUT))) temp  WHERE  (DATE(t) BETWEEN '"
              + endDate
              + "' AND  '"
              + strDate
              + "') and BRANCH_ID='"
              + loginId
              + "'  GROUP BY DATE(t) ;");
      hourlydDataList = query.list();
      monthlyList = hibernateTemplate
          .find("SELECT  date(a.timeStamp),Max(a.noOfMaleIn),Max(a.noOfFeMaleIn), a.branch.eventName,a.branch.branchType,a.branch.maxCapacity,a.branch.music FROM Audit a  WHERE (a.timeStamp BETWEEN '"
              + endDate
              + "' and '"
              + strDate
              + "') and a.branch.branchId='"
              + loginId
              + "' GROUP BY date(a.timeStamp) ");
      graphDataList.add(monthlyList);
      graphDataList.add(hourlydDataList);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
    return graphDataList;

  }

  /**
   * getEventThreeMonthlyInformation use to get three monthly data from database
   * 
   * @param loginId
   */
  public List<Audit> getEventThreeMonthlyDetails(Integer loginId) {
    List monthlyList = null;
    List threeMonthlyDataList = new ArrayList();
    Integer branchId = null;
    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
    Date now = new Date();
    // String strDate = sdfDate.format(now);
    DateUtils d = new DateUtils();
    Date[] D = new Date[10];
    String[] endDate = new String[10];
    D[0] = now;
    for (int i = 0; i < 10; i++) {
      if (i < 9) {
        D[i + 1] = d.addDays(D[i], -10);
      }
      endDate[i] = sdfDate.format(D[i]);
    }

    for (int i = 0; i < endDate.length - 1; i++) {

      String fromToDate = endDate[i + 1] + " To " + endDate[i];
      SessionFactory sessionFactory = null;
      Session session = null;
      try {
        sessionFactory = hibernateTemplate.getSessionFactory();
        session = sessionFactory.openSession();
        Query query = session
            .createSQLQuery("SELECT DATE(dt),SUM(max_count),SUM(maxf_count),bn FROM(SELECT DATE(TIME_STAMP) dt ,MAX(NO_OF_MALE_IN) max_count , MAX(NO_OF_FEMALE_IN) maxf_count ,b.EVENT_NAME bn  FROM audit a INNER JOIN branch b ON b.BRANCH_ID=a.BRANCH_ID AND (DATE(TIME_STAMP) BETWEEN '"
                + endDate[i + 1]
                + "' and '"
                + endDate[i]
                + "' ) AND a.BRANCH_ID='"
                + loginId
                + "'  GROUP BY DATE(TIME_STAMP)) tmp");
        monthlyList = query.list();
        monthlyList.add(fromToDate);
        threeMonthlyDataList.add(monthlyList);
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        session.close();
      }
    }

    return threeMonthlyDataList;
  }

  /**
   * getEventYearlyDetails use to get yearly data from database
   * 
   * @param loginId
   */
  public List<Audit> getEventYearlyDetails(Integer loginId) {
    List<Audit> yearlyList = null;
    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");// dd/MM/yyyy
    Date now = new Date();
    String strDate = sdfDate.format(now);
    DateUtils d = new DateUtils();
    Date D = d.addYears(now, -1);
    String endDate = sdfDate.format(D);
    SessionFactory sessionFactory = null;
    Session session = null;
    try {
      sessionFactory = hibernateTemplate.getSessionFactory();
      session = sessionFactory.openSession();
      Query query = session
          .createSQLQuery("SELECT dt,SUM(max_count),SUM(maxf_count),bn,bt,mc,bn FROM(SELECT DATE(TIME_STAMP) dt ,MAX(NO_OF_MALE_IN) max_count , MAX(NO_OF_FEMALE_IN) maxf_count ,b.EVENT_NAME bn ,b.BRANCH_TYPE bt,b.MAXCAPACITY mc,b.MUSIC bm  FROM audit a INNER JOIN branch b ON b.BRANCH_ID=a.BRANCH_ID AND (DATE(TIME_STAMP) BETWEEN '"
              + endDate
              + "' and '"
              + strDate
              + "' ) AND  a.BRANCH_ID='"
              + loginId
              + "' GROUP BY DATE(TIME_STAMP))tmp GROUP BY MONTH(dt)");
      yearlyList = query.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return yearlyList;
  }

  /**
   * getBranchEventId use to get branch name form data base.
   * 
   * @param businessAndEventId
   */
  public List<Branch> getBranchEventId(Integer businessAndEventId) {
    List list = null;
    list = hibernateTemplate
        .find("select branchId,eventName from Branch where businessAndEventInformation.businessEventID='"
            + businessAndEventId + "' ");
    return list;
  }

}
