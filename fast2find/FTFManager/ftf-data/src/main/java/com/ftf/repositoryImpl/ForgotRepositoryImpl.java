package com.ftf.repositoryImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.ftf.repository.ForgotRepository;

@Repository
@SuppressWarnings("rawtypes")
public class ForgotRepositoryImpl implements ForgotRepository {
  @Autowired
  private HibernateTemplate hibernateTemplate;
  
  /**
   * getPassword method use to get password from database.
   * @param email
   */
    public List getPassword(String email) {
    List password = null;
    password = hibernateTemplate.find("select password from Login  where emailId=?", email);
    return password;
  }

}
