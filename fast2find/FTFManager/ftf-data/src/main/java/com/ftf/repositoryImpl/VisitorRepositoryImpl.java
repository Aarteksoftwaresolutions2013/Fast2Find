package com.ftf.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ftf.model.ContactUs;
import com.ftf.model.VisitorUser;
import com.ftf.repository.VisitorRepository;

@Repository
public class VisitorRepositoryImpl implements VisitorRepository {
  @Autowired
  private HibernateTemplate hibernateTemplate;

  /**
   * addVisitorMessage() use for save visitor information into database.
   * 
   * @param visitorUser
   */
  public void addVisitorMessage(VisitorUser visitorUser) {
    hibernateTemplate.save(visitorUser);
  }

  public boolean addContactMessage(ContactUs contactUs) {
    if (contactUs != null) {
      hibernateTemplate.save(contactUs);
      return true;
    } else {
      return false;
    }
  }
}
