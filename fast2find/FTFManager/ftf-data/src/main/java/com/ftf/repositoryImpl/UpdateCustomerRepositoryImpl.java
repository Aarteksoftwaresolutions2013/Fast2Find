package com.ftf.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ftf.model.BusinessAndEventInformation;
import com.ftf.repository.UpdateCustomerRepository;

@Repository
@SuppressWarnings({ "unchecked", "rawtypes" })
public class UpdateCustomerRepositoryImpl implements UpdateCustomerRepository {

  @Autowired
  private HibernateTemplate hibernateTemplate;

  /**
   * getCustomerInfoAdd() use to fetch customer information from database.
   * 
   * @param loginId
   */
  public List<Object> getCustomerInfoAdd(Integer loginId) {
    List list = null;
    list = hibernateTemplate.find("from BusinessAndEventInformation be where be.login.loginId='"
        + loginId + "'");
    return list;
  }

  /**
   * updateCustomerInfoAdd() method use to save updated information into
   * database.
   * 
   * @param businessAndEventInformation
   */
  public boolean updateCustomerInfoAdd(BusinessAndEventInformation businessAndEventInformation) {
    Integer id = businessAndEventInformation.getBusinessEventID();
    List<BusinessAndEventInformation> list = null;
    Integer loginId = null;
    Integer locationId = null;
    list = hibernateTemplate.find("from BusinessAndEventInformation be where be.businessEventID='"
        + id + "'");
    for (BusinessAndEventInformation c : list) {
      loginId = c.getLogin().getLoginId();
      locationId = c.getLocation().getLocationId();
    }
    businessAndEventInformation.getLogin().setLoginId(loginId);
    businessAndEventInformation.getLocation().setLocationId(locationId);
    hibernateTemplate.saveOrUpdate(businessAndEventInformation);
    return true;
  }

  public List<Object> getInformation(Integer loginId) {
    List list = null;
    list = hibernateTemplate.find("from BusinessAndEventInformation be where be.login.loginId='"
        + loginId + "'");
    return list;
  }

}
