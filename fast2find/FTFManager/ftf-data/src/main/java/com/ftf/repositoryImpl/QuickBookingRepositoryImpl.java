package com.ftf.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ftf.model.QuickBooking;
import com.ftf.repository.QuickBookingRepository;

@Repository
public class QuickBookingRepositoryImpl implements QuickBookingRepository {
  @Autowired
  private HibernateTemplate hibernateTemplate;

  /**
   * addBooking method use to save business booking information into database.
   * @param quickBooking
   */
  public boolean addBooking(QuickBooking quickBooking) {
    if (quickBooking != null) {
      hibernateTemplate.save(quickBooking);
      return true;
    } else {
      return false;
    }
  }

  /**
   * addeventBooking method use to save event booking information into database.
   * @param quickBooking
   */
  public boolean addeventBooking(QuickBooking quickBooking) {
    if (quickBooking != null) {
      hibernateTemplate.save(quickBooking);
      return true;
    } else {
      return false;
    }
  }

  /**
   * saveComment method use to save user comment into database.
   * @param quickBooking
   */
  public boolean saveComment(QuickBooking quickBooking) {
    if (quickBooking != null) {
      hibernateTemplate.save(quickBooking);
      return true;
    } else {
      return false;
    }
  }
}
