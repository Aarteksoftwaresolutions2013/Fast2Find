package com.ftf.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.model.Audit;
import com.ftf.model.Branch;
import com.ftf.model.BusinessAndEventInformation;
import com.ftf.model.CustomerInformation;
import com.ftf.model.Login;
import com.ftf.repository.LoginRepository;
import com.ftf.service.LoginService;
import com.ftf.util.DateFormatConstant;
import com.ftf.util.Encryption;
import com.ftf.util.IConstant;

/**
 * @author Praveen Raghuvanshi
 * 
 */
@Service
@SuppressWarnings("rawtypes")
public class LoginServiceImpl implements LoginService {
  private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);
  @Autowired
  private LoginRepository loginRepository;

  /**
   * userSignIn method use for login. encrypt() use for encrypt password.
   * 
   * @param emailId
   * @param password
   */
  public Login userSignIn(Object login) {
    Login loginMember = (Login) login;
    String password = Encryption.encrypt(loginMember.getPassword());
    List<Object> memberList = null;
    if (login != null) {
      if (loginMember.getEmailId() != null && loginMember.getPassword() != null) {
        memberList = loginRepository.userSignIn(loginMember.getEmailId(), password);
      }
    }
    if (memberList.size() == 0) {
      loginMember = null;
    } else {
      loginMember = (Login) memberList.get(0);
    }
    return loginMember;
  }

  /**
   * custInfo method use for get login customer information. custInfo method
   * also check customer validity is expire or not.
   * 
   * @param loginId
   */
  public CustomerInformation custInfo(int loginId) {
    CustomerInformation customerInformation = null;
    List<Object> memberList = null;
    memberList = loginRepository.custInfo(loginId);
    if (memberList.size() == 0) {
      customerInformation = null;
    } else {
      customerInformation = (CustomerInformation) memberList.get(0);
      DateFormat dateFormat = new SimpleDateFormat(DateFormatConstant.YYYYMMDD_FORMAT);
      Date date = new Date();
      String todayDate = dateFormat.format(date);
      try {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormatConstant.YYYYMMDD_FORMAT);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(
            DateFormatConstant.YYYYMMDD_FORMAT);
        Calendar c = Calendar.getInstance();
        if (customerInformation.getLogin().getUserType().equals(IConstant.CUSTOMER)) {
          Date date1 = simpleDateFormat.parse(customerInformation.getCreatedOn());
          String createdDate = dateFormat.format(date1);
          if (customerInformation.getCustomerCatagory().equals(IConstant.ONE_TIME_YEARLY)
              && customerInformation.getLogin().getUserType().equals(IConstant.CUSTOMER)) {
            c.setTime(simpleDateFormat2.parse(createdDate));
            c.add(Calendar.MONTH, IConstant.year);
            createdDate = simpleDateFormat2.format(c.getTime());

            if (todayDate.compareTo(createdDate) == 0 || todayDate.compareTo(createdDate) > 0) {
              customerInformation.getLogin().setStatus(IConstant.expired);
              return customerInformation;
            }
          }
        }

      } catch (ParseException ex) {
        ex.printStackTrace();
        logger.error("custInfo() method inside a LoginServiceImpl:-", ex);
      }
    }
    return customerInformation;
  }

  /**
   * eventInfo method use for get login business or event customer information.
   * custInfo method also check customer validity is expire or not.
   * 
   * @param loginId
   */
  public BusinessAndEventInformation eventInfo(int loginId) {
    BusinessAndEventInformation andEventInformation = new BusinessAndEventInformation();
    List<Object> memberList = null;
    memberList = loginRepository.eventInfo(loginId);
    if (memberList.size() == 0) {
      andEventInformation = null;
    } else {
      andEventInformation = (BusinessAndEventInformation) memberList.get(0);

      DateFormat dateFormat = new SimpleDateFormat(DateFormatConstant.YYYYMMDD_FORMAT);
      Date date = new Date();
      String todayDate = dateFormat.format(date);
      try {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormatConstant.YYYYMMDD_FORMAT);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(
            DateFormatConstant.YYYYMMDD_FORMAT);
        Calendar c = Calendar.getInstance();
        if (andEventInformation.getLogin().getUserType().equals(IConstant.CUSTOMER)) {
          Date date1 = simpleDateFormat.parse(andEventInformation.getCreatedOn());
          String createdDate = dateFormat.format(date1);
          if (andEventInformation.getCustomerCatagory().equals(IConstant.PER_YEAR)
              && andEventInformation.getLogin().getUserType().equals(IConstant.CUSTOMER)) {
            c.setTime(simpleDateFormat2.parse(createdDate));
            c.add(Calendar.MONTH, IConstant.year);
            createdDate = simpleDateFormat2.format(c.getTime());
            if (todayDate.compareTo(createdDate) == 0 || todayDate.compareTo(createdDate) > 0) {
              andEventInformation.getLogin().setStatus(IConstant.expired);
              return andEventInformation;
            }
          }
        }
        if (andEventInformation.getLogin().getUserType().equals(IConstant.BUSINESS)) {
          Date date1 = simpleDateFormat.parse(andEventInformation.getCreatedOn());
          String createdDate = dateFormat.format(date1);
          if (andEventInformation.getBusinessCatagory().equals(IConstant.BUSINESS_PER_MONTH)
              && andEventInformation.getLogin().getUserType().equals(IConstant.BUSINESS)) {
            c.setTime(simpleDateFormat2.parse(createdDate));
            c.add(Calendar.MONTH, IConstant.month);
            createdDate = simpleDateFormat2.format(c.getTime());
          }

          if (andEventInformation.getBusinessCatagory().equals(IConstant.PER_YEAR)
              && andEventInformation.getLogin().getUserType().equals(IConstant.BUSINESS)) {
            c.setTime(simpleDateFormat2.parse(createdDate));
            c.add(Calendar.MONTH, IConstant.year_2month);
            createdDate = simpleDateFormat2.format(c.getTime());
          }
          if (andEventInformation.getBusinessCatagory().equals(IConstant.THREE_YEARLY)
              && andEventInformation.getLogin().getUserType().equals(IConstant.BUSINESS)) {
            c.setTime(simpleDateFormat2.parse(createdDate));
            c.add(Calendar.MONTH, IConstant.year3_8month);
            createdDate = simpleDateFormat2.format(c.getTime());
          }
          if (todayDate.compareTo(createdDate) == 0 || todayDate.compareTo(createdDate) > 0) {
            andEventInformation.getLogin().setStatus(IConstant.expired);
            return andEventInformation;
          }
        }
        if (andEventInformation.getLogin().getUserType().equals(IConstant.EVENT)) {
          Date date1 = simpleDateFormat.parse(andEventInformation.getCreatedOn());
          String createdDate = dateFormat.format(date1);
          if (andEventInformation.getEventCatagory().equals(IConstant.PER_YEARLY)
              && andEventInformation.getLogin().getUserType().equals(IConstant.EVENT)) {
            c.setTime(simpleDateFormat2.parse(createdDate));
            c.add(Calendar.MONTH, IConstant.year);
            createdDate = simpleDateFormat2.format(c.getTime());
          }
          if (andEventInformation.getEventCatagory().equals(IConstant.EVENT_THREE_YEARLY)
              && andEventInformation.getLogin().getUserType().equals(IConstant.EVENT)) {
            c.setTime(simpleDateFormat2.parse(createdDate));
            c.add(Calendar.MONTH, IConstant.year3);
            createdDate = simpleDateFormat2.format(c.getTime());
          }
          if (todayDate.compareTo(createdDate) == 0 || todayDate.compareTo(createdDate) > 0) {
            andEventInformation.getLogin().setStatus(IConstant.expired);
            return andEventInformation;
          }
        }

      } catch (ParseException ex) {
        ex.printStackTrace();
        logger.error("eventInfo() method inside a LoginServiceImpl:-", ex);
      }

    }
    return andEventInformation;
  }

  /**
   * branchInfo method get branch information for showing no of male or no of
   * female.
   * 
   * @param loginId
   */
  public Branch branchInfo(int loginId) {
    Branch branch = new Branch();
    List<Object> memberList = null;
    memberList = loginRepository.branchInfo(loginId);
    if (memberList.size() == 0) {
      branch = null;
    } else {
      branch = (Branch) memberList.get(0);
      List<Audit> auditList = new ArrayList<Audit>();
      auditList = branch.getAuditList();
      if (auditList != null && !auditList.isEmpty()) {
        int branchId = auditList.get(0).getBranch().getBranchId();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatConstant.YYYYMMDD);
        Date date = new Date();
        String createdDate = dateFormat.format(date);
        String todayDate = createdDate.toString();
        List maleFemaleList = new ArrayList();
        maleFemaleList = loginRepository.getMaleAndFemale(branchId, todayDate);
        if (maleFemaleList != null && !maleFemaleList.isEmpty()) {
          for (Object obj : maleFemaleList) {
            Object[] objs = (Object[]) obj;
            if (objs[0] == null)
              objs[0] = IConstant.mfCountZero;
            if (objs[1] == null)
              objs[1] = IConstant.mfCountZero;
            if (objs[2] == null)
              objs[2] = IConstant.mfCountZero;
            if (objs[3] == null)
              objs[3] = IConstant.mfCountZero;
            branch.setNoOfMale((Integer) objs[0] - (Integer) objs[2]);
            branch.setNoOfFemale((Integer) objs[1] - (Integer) objs[3]);
          }
        } else {
          branch.setNoOfMale(IConstant.mfCountZero);
          branch.setNoOfFemale(IConstant.mfCountZero);
        }
      } else {
        branch.setNoOfMale(IConstant.mfCountZero);
        branch.setNoOfFemale(IConstant.mfCountZero);
      }
    }
    return branch;
  }

  /**
   * adminSignIn method use for admin login.
   * 
   * @param loginId
   * @param password
   */
  public Login adminSignIn(Object login) {
    Login loginMember = (Login) login;
    String password = Encryption.encrypt(loginMember.getPassword());
    List<Object> memberList = null;
    if (login != null) {
      if (loginMember.getEmailId() != null && loginMember.getPassword() != null) {
        memberList = loginRepository.adminSignIn(loginMember.getEmailId(), password);
      }
    }
    if (memberList.size() == 0) {
      loginMember = null;
    } else {
      loginMember = (Login) memberList.get(0);
    }
    return loginMember;
  }

}
