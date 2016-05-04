package com.ftf.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ftf.model.Audit;
import com.ftf.repository.LoginRepository;
import com.ftf.util.IConstant;

/**
 * @author Pravin Raghuvanshi
 *
 */
@Repository
@SuppressWarnings({ "unchecked", "rawtypes" })
public class LoginRepositoryImpl implements LoginRepository {
  private static final Logger logger = Logger.getLogger(LoginRepositoryImpl.class);
  @Autowired
  private HibernateTemplate hibernateTemplate;
  /**
   * @param emailId
   * @param password
   * find() use for check email or password are exist or not in database
   */
  public List<Object> userSignIn(String emailId, String password) {
    List<Object> login = null;
    List<Object> emailAndPassword = null;
    login = hibernateTemplate.find(
        "from Login login where login.emailId = ? and login.password = ?", emailId, password);
    if (login.size() == 0) {
      emailAndPassword = hibernateTemplate
          .find("from Login login where login.emailId = ?", emailId);
      return emailAndPassword;
    }
    return login;
  }
  /**
   * @param bid(Branch Id)
   */
  public List<Object> getBranchData(Integer bid) {
    List<Object> login = null;
    login = hibernateTemplate.find("from Audit a where a.branch.branchId=?", bid);
    return login;
  }

  /**
   * @param loginId
   */
  public List<Object> custInfo(int loginId) {
    List<Object> customerList = null;
    customerList = hibernateTemplate.find("from CustomerInformation where LOGIN_ID='" + loginId
        + "' AND IS_DELETED=" + IConstant.IS_DELETED);
    return customerList;
  }
  /**
   * @param loginId
   */
  public List<Object> eventInfo(int loginId) {
    List<Object> businessAndEventList = null;
    businessAndEventList = hibernateTemplate
        .find("from BusinessAndEventInformation where LOGIN_ID='" + loginId + "' AND IS_DELETED="
            + IConstant.IS_DELETED);
    return businessAndEventList;
  }
  /**
   * Get branchInfo for corresponding to loginId
   * @param loginId
   */
  public List<Object> branchInfo(int loginId) {
    List<Object> branchList = null;
    branchList = hibernateTemplate.find("from Branch where LOGIN_ID='" + loginId
        + "' AND IS_DELETED=" + IConstant.IS_DELETED);
    return branchList;
  }

  public List<Object> adminSignIn(String emailId, String password) {
    List<Object> login = null;
    login = hibernateTemplate.find(
        "from Login l where l.emailId = ? and l.password = ? and l.userType=?", emailId, password,
        IConstant.ADMIN);
    return login;
  }

  /**
   * getMaleAndFemale() get no of male and female of current day.
   * @param branchId
   * @param todayDate
   */
  public List<Audit> getMaleAndFemale(int branchId, String todayDate) {
    List auditList2 = null;
    SessionFactory sessionFactory = null;
    Session session = null;
    try {
      sessionFactory = hibernateTemplate.getSessionFactory();
      session = sessionFactory.openSession();
      Query query = session
          .createSQLQuery("SELECT MAX(a.NO_OF_MALE_IN),MAX(a.NO_OF_FEMALE_IN),MAX(a.NO_OF_MALE_OUT),MAX(a.NO_OF_FEMALE_OUT) from branch b LEFT OUTER JOIN audit a ON b.BRANCH_ID=a.BRANCH_ID AND DATE(a.TIME_STAMP)='"
              + todayDate
              + "' where b.IS_DELETED="
              + IConstant.IS_DELETED
              + " "
              + "and b.BRANCH_ID=" + branchId + " GROUP BY b.BRANCH_ID ");
      auditList2 = query.list();
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("getMaleAndFemale() method inside a LoginRepositoryImpl:-", e);
    } finally {
      session.close();
    }
    return auditList2;
  }
}
