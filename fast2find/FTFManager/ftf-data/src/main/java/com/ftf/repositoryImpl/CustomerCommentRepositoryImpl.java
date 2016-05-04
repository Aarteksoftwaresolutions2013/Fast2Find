package com.ftf.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ftf.model.CustomerComment;
import com.ftf.repository.CustomerCommentRepository;

/**
 * @author PravinSir
 * 
 */
@Repository
public class CustomerCommentRepositoryImpl implements CustomerCommentRepository {
  @Autowired
  private HibernateTemplate hibernateTemplate;

  /**
   * addCustomerComment method use to save customer comment.
   * @param customerComment
   */
  public boolean addCustomerComment(CustomerComment customerComment) {
    if (customerComment != null) {
      hibernateTemplate.save(customerComment);
      return true;
    }
    return false;
  }
}
