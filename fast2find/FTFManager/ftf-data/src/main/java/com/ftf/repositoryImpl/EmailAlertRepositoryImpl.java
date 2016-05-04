package com.ftf.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ftf.model.EmailAlert;
import com.ftf.repository.EmailAlertRepository;
import com.ftf.util.IConstant;

@Repository
@SuppressWarnings("unchecked")
public class EmailAlertRepositoryImpl implements EmailAlertRepository {

  @Autowired
  private HibernateTemplate hibernateTemplate;

  public List<EmailAlert> getAlertEmail(String monthly) {
    List<EmailAlert> emailList = null;
    emailList = hibernateTemplate.find("from EmailAlert where EMAIL_ALERT_TIME='" + monthly
        + "' AND IS_DELETED=" + IConstant.IS_DELETED);
    return emailList;
  }

  public List<EmailAlert> getWeeklyEmail(String weekly) {
    List<EmailAlert> emailList = null;
    emailList = hibernateTemplate.find("from EmailAlert where EMAIL_ALERT_TIME='" + weekly
        + "' AND IS_DELETED=" + IConstant.IS_DELETED);
    return emailList;
  }

  /**
   * addEmailRequest method use to save email alert information into database.
   * @param emailAlert
   */
  public boolean custInfoAdd(EmailAlert emailAlert) {
    if (emailAlert != null) {
      hibernateTemplate.save(emailAlert);
      return true;
    } else {
      return false;
    }
  }
}
