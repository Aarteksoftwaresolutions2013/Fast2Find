package com.ftf.repository;

import com.ftf.model.QuickBooking;

public interface QuickBookingRepository {
  public boolean addBooking(QuickBooking quickBooking);

  public boolean addeventBooking(QuickBooking quickBooking);

  public boolean saveComment(QuickBooking quickBooking);
}
