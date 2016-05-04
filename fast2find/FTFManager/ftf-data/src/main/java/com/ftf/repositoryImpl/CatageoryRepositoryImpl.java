package com.ftf.repositoryImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ftf.model.Catageory;
import com.ftf.model.SubCatageory;
import com.ftf.repository.CatageoryRepository;
import com.ftf.util.IConstant;

@Repository
@SuppressWarnings("unchecked")
public class CatageoryRepositoryImpl implements CatageoryRepository {
  @Autowired
  private HibernateTemplate hibernateTemplate;

  public boolean addCatageory(Catageory catageory) {
    if (catageory != null) {
      @SuppressWarnings("rawtypes")
      List categoryList = null;
      if (catageory.getCatageoryId() == null) {
        categoryList = hibernateTemplate.find("from Catageory c where c.catageoryName='"
            + catageory.getCatageoryName() + "' AND IS_DELETED=" + IConstant.IS_DELETED);
        if (categoryList.isEmpty()) {
          hibernateTemplate.saveOrUpdate(catageory);
          return true;
        } else {
          return false;
        }
      } else {
        hibernateTemplate.saveOrUpdate(catageory);
        return true;
      }
    } else {
      return false;
    }
  }

  /**
   * getAllcatageory method use to get all category name from database.
   * condition:isDeleted active
   */
  public List<Object> getAllCatageoryName() {
    List<Object> catageoryList = null;
    catageoryList = hibernateTemplate.find("from Catageory where IS_DELETED="
        + IConstant.IS_DELETED);
    return catageoryList;
  }

  public List<Object> getInfoForEdit(Integer catageoryId) {
    List<Object> list = null;
    list = hibernateTemplate.find("from Catageory c where c.catageoryId=" + catageoryId);
    return list;
  }

  public void deleteCatageory(Integer catageoryId) {
    Catageory catageory = (Catageory) hibernateTemplate.get(Catageory.class, catageoryId);
    catageory.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
    List<SubCatageory> subCatageoryList = catageory.getSubCatageoryList();
    for (SubCatageory subCatageory : subCatageoryList) {
      subCatageory.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
    }
    if (null != catageory) {
      hibernateTemplate.update(catageory);
    }
  }

  @SuppressWarnings("rawtypes")
  public List getCategoryAndSubCategory() {
    SessionFactory sessionFactory = null;
    Session session = null;
    List nameList = null;
    try {
      sessionFactory = hibernateTemplate.getSessionFactory();
      session = sessionFactory.openSession();
      Query query = session
          .createSQLQuery("SELECT b.CATAGEORY_NAME,a.SUB_CATAGEORY_NAME FROM  catageory b LEFT OUTER JOIN subcatageory a ON b.CATAGEORY_ID=a.CATAGEORY_ID WHERE b.IS_DELETED="
              + IConstant.IS_DELETED);
      nameList = query.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
    return nameList;
  }
}