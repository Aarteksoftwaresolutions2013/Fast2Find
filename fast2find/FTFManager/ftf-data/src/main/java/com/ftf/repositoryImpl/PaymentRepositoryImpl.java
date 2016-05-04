package com.ftf.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ftf.model.PaypalDetails;
import com.ftf.repository.PaymentRepository;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

  @Autowired
  private HibernateTemplate hibernateTemplate;

  /**
   * savePayment() use to save transaction information into database.
   * @param paypalDetails
   */
  public void savePaymentInformation(PaypalDetails paypalDetails) {
    hibernateTemplate.save(paypalDetails);
  }
}
