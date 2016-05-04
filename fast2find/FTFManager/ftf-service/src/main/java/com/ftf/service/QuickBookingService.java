package com.ftf.service;

import com.ftf.model.QuickBooking;

public interface QuickBookingService {
  public boolean addBooking(QuickBooking quickBooking, final String emailId);

  public boolean addBooking(QuickBooking quickBooking);

  public boolean addeventBooking(QuickBooking quickBooking, final String emailId);

  public boolean saveComment(QuickBooking quickBooking);
}
