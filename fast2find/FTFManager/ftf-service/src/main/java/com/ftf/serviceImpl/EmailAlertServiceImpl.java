package com.ftf.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ftf.model.EmailAlert;
import com.ftf.repository.EmailAlertRepository;
import com.ftf.service.EmailAlertService;
import com.ftf.util.IConstant;

@Service
@SuppressWarnings({ "unchecked", "rawtypes" })
public class EmailAlertServiceImpl implements EmailAlertService {

  @Autowired
  private EmailAlertRepository emailAlertRepository;
  List<EmailAlert> emailList = new ArrayList<EmailAlert>();
  EmailAlert emailData = new EmailAlert();

  class Weekly extends TimerTask {
    @Override
    public void run() {
      emailList = (List) emailAlertRepository.getWeeklyEmail(IConstant.WEEKLY_EMAIL);
      for (EmailAlert email : emailList) {
        System.out.println("Inside Weekly Class.." + email.getEmailId());
      }
    }
  }

  class Monthly extends TimerTask {
    @Override
    public void run() {
      emailList = (List) emailAlertRepository.getAlertEmail(IConstant.MONTHLY_EMAIL);
      for (EmailAlert email : emailList) {
        System.out.println("Inside Monthly Class.." + email.getEmailId());
      }
    }
  }

  public void startTime() {
    Timer timer = new Timer();
    Calendar date = Calendar.getInstance();
    timer.schedule(new Weekly(), date.getTime(), 1000 * 60 * 60 * 24 * 7);
    Timer timer2 = new Timer();
    Calendar date2 = Calendar.getInstance();
    timer2.schedule(new Monthly(), date2.getTime(), 1000 * 60 * 60 * 24 * 7 * 30);
  }

  /**
   * addEmailRequest method use to save email alert information into database.
   * @param emailAlert
   *  set isDeleted one. 
   *  set also created date and update date in yyyy/MM/dd format
   */
  public boolean addEmailRequest(EmailAlert emailAlert) {
    boolean status = false;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    emailAlert.setIsDeleted(IConstant.IS_DELETED);
    emailAlert.setCreatedOn(dateFormat.format(date));
    emailAlert.setUpdatedOn(dateFormat.format(date));
    status = emailAlertRepository.custInfoAdd(emailAlert);
    if (status == true) {
      return true;
    } else {
      return false;
    }
  }
}
