package com.ftf.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.model.CustomerComment;
import com.ftf.repository.CustomerCommentRepository;
import com.ftf.service.CustomerCommentService;
import com.ftf.util.IConstant;

@Service
public class CustomerCommentServiceImpl implements CustomerCommentService {
  @Autowired
  private CustomerCommentRepository customerCommentRepository;

  /**
   * addCustomer comment method use to save customer comment.
   */
  public boolean addCustomerComment(CustomerComment customerComment) {
    boolean status=false;
    if (customerComment != null) {
      customerComment.setIsDeleted(IConstant.IS_DELETED);
      status = customerCommentRepository.addCustomerComment(customerComment);
      return status;
    }
    return status;
  }
}
