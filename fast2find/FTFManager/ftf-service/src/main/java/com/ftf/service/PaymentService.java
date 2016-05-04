package com.ftf.service;

import com.ftf.model.PaypalDetails;

public interface PaymentService {
  public void savePaymentInformation(PaypalDetails paypalDetails);
}
