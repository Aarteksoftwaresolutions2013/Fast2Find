package com.ftf.repositoryImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.ftf.model.Audit;
import com.ftf.repository.TallyAppRepository;
import com.ftf.util.IConstant;

@Repository
@SuppressWarnings({ "unchecked", "rawtypes" })
public class TallyAppRepositoryImpl implements TallyAppRepository {
  @Autowired
  private HibernateTemplate hibernateTemplate;

  /**
   * Increase male or female counter into database.
   * 
   * @param audit
   */
  public boolean increaseCounter(Audit audit) {
    int branchId = audit.getBranch().getBranchId();
    int mfCount = audit.getCount();

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String createdDate = dateFormat.format(date);
    String str = createdDate.toString();
    List<Audit> auditList2 = null;
    auditList2 = hibernateTemplate.find("from Audit audit where audit.branch.branchId=" + branchId
        + " and Date(audit.timeStamp)='" + str + "'");
    if (auditList2.isEmpty()) {
      if (mfCount == 1) {
        audit.setNoOfMaleIn(IConstant.mfCount);
        audit.getBranch().setBranchId(branchId);
        audit.setNoOfFeMaleIn(IConstant.mfCountZero);
        audit.setNoOfMaleOut(IConstant.mfCountZero);
        audit.setNoOfFeMaleOut(IConstant.mfCountZero);
        hibernateTemplate.save(audit);
      } else {
        audit.setNoOfFeMaleIn(IConstant.mfCount);
        audit.getBranch().setBranchId(branchId);
        audit.setNoOfMaleIn(IConstant.mfCountZero);
        audit.setNoOfMaleOut(IConstant.mfCountZero);
        audit.setNoOfFeMaleOut(IConstant.mfCountZero);
        hibernateTemplate.save(audit);
      }
    } else {
      Audit audit2 = null;
      Iterator itr = auditList2.iterator();
      while (itr.hasNext()) {
        audit2 = (Audit) itr.next();
      }
      int noMaleIn = audit2.getNoOfMaleIn();
      int noFemaleIn = audit2.getNoOfFeMaleIn();
      int noMaleOut = audit2.getNoOfMaleOut();
      int noFeMAleOut = audit2.getNoOfFeMaleOut();
      if (mfCount == 1) {
        audit.setNoOfMaleIn(noMaleIn + IConstant.mfCount);
        audit.setNoOfFeMaleIn(noFemaleIn);
        audit.setNoOfMaleOut(noMaleOut);
        audit.setNoOfFeMaleOut(noFeMAleOut);
        hibernateTemplate.save(audit);
      } else {
        audit.setNoOfMaleIn(noMaleIn);
        audit.setNoOfFeMaleIn(noFemaleIn + IConstant.mfCount);
        audit.setNoOfMaleOut(noMaleOut);
        audit.setNoOfFeMaleOut(noFeMAleOut);
        hibernateTemplate.save(audit);
      }
    }
    return true;

  }

  /**
   * Decrease male or female counter from data base.
   * 
   * @param audit
   *          .
   */
  public boolean decreaseCounter(Audit audit) {
    int branchId = audit.getBranch().getBranchId();
    int mfCount = audit.getCount();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String createdDate = dateFormat.format(date);
    String str = createdDate.toString();
    List<Audit> auditList2 = null;
    auditList2 = hibernateTemplate.find("from Audit audit where audit.branch.branchId=" + branchId
        + " and Date(audit.timeStamp)='" + str + "'");
    if (!auditList2.isEmpty()) {
      Audit audit2 = null;
      Iterator itr = auditList2.iterator();
      while (itr.hasNext()) {
        audit2 = (Audit) itr.next();
      }
      int MaleOut = audit2.getNoOfMaleOut();
      int femaleOut = audit2.getNoOfFeMaleOut();
      int maleIn = audit2.getNoOfMaleIn();
      int feMaleIn = audit2.getNoOfFeMaleIn();
      if (mfCount == 1) {
        audit.setNoOfMaleOut(MaleOut + IConstant.mfCount);
        audit.setNoOfFeMaleOut(femaleOut);
        audit.setNoOfMaleIn(maleIn);
        audit.setNoOfFeMaleIn(feMaleIn);
        hibernateTemplate.save(audit);
      } else {
        audit.setNoOfMaleOut(MaleOut);
        audit.setNoOfFeMaleOut(femaleOut + IConstant.mfCount);
        audit.setNoOfMaleIn(maleIn);
        audit.setNoOfFeMaleIn(feMaleIn);
        hibernateTemplate.save(audit);
      }
      return true;
    } else {
      return false;
    }
  }
}