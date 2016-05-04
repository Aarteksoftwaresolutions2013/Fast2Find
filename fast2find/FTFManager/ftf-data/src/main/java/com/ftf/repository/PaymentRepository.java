package com.ftf.repository;

import com.ftf.model.PaypalDetails;

public interface PaymentRepository {

  public void savePaymentInformation(PaypalDetails paypalDetails);

}
