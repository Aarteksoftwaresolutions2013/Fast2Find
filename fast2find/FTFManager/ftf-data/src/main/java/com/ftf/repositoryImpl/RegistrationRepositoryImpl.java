package com.ftf.repositoryImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ftf.model.BusinessAndEventInformation;
import com.ftf.model.CustomerInformation;
import com.ftf.repository.RegistrationRepository;
import com.ftf.util.IConstant;

@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public boolean custInfoAdd(CustomerInformation customerInformation) {
		@SuppressWarnings("rawtypes")
		List content = null;
		content = hibernateTemplate
				.find("from CustomerInformation where login.emailId='"
						+ customerInformation.getLogin().getEmailId()
						+ "' AND IS_DELETED=" + IConstant.IS_DELETED);
		if (content.isEmpty()) {
			try {
				hibernateTemplate.save(customerInformation);
				return true;
			} catch (Exception e) {
				System.out
						.println("Inside Registration Repository Exception Block"
								+ e);
			}
		}
		return false;
	}

	/**
	 * addBusinessAndEvent() method for save user information into database.
	 * If use already register with Fast2Find than return false.
	 * @param businessAndEventInformation
	 */
	public boolean addBusinessAndEvent(
			BusinessAndEventInformation businessAndEventInformation) {
		@SuppressWarnings("rawtypes")
		List content = null;
		content = hibernateTemplate
				.find("from BusinessAndEventInformation where login.emailId='"
						+ businessAndEventInformation.getLogin().getEmailId()
						+ "' AND IS_DELETED=" + IConstant.IS_DELETED);
		if (content.isEmpty()) {
			try {
				hibernateTemplate.save(businessAndEventInformation);
				return true;
			} catch (Exception e) {
				System.out
						.println("Inside Registration Repository Exception Block"
								+ e);
			}
		}
		return false;
	}
  public void updatePaidStatus() {
    SessionFactory sessionFactory = null;
    Session session = null;
    try {
      sessionFactory = hibernateTemplate.getSessionFactory();
      session = sessionFactory.openSession();
      Query query = session.createSQLQuery("UPDATE login SET PAID_STATUS='yes' ORDER BY LOGIN_ID DESC LIMIT 1");
       query.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  public boolean editBusinessCustomerInfo(BusinessAndEventInformation businessAndEventInformation) {
    hibernateTemplate.saveOrUpdate(businessAndEventInformation);
    return true;
  }
}
