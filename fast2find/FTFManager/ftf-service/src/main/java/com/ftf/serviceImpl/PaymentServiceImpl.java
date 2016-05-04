package com.ftf.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.model.PaypalDetails;
import com.ftf.repository.PaymentRepository;
import com.ftf.service.PaymentService;
import com.ftf.util.IConstant;

@Service
public class PaymentServiceImpl implements PaymentService {

  @Autowired
  private PaymentRepository paymentRepository;

  /**
   * savePaymentInformation() use to save transaction information into database.
   * @param paypalDetails
   */
  public void savePaymentInformation(PaypalDetails paypalDetails) {
    paypalDetails.setIsDeleted(IConstant.IS_DELETED);
    paymentRepository.savePaymentInformation(paypalDetails);
  }

}
