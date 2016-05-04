package com.ftf.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ftf.model.SubCatageory;
import com.ftf.repository.SubCatageoryRepository;
import com.ftf.util.IConstant;

@Repository
@SuppressWarnings("unchecked")
public class SubCatageoryRepositoryImpl implements SubCatageoryRepository {

  @Autowired
  private HibernateTemplate hibernateTemplate;

  @SuppressWarnings("rawtypes")
  public boolean addSubCatageory(SubCatageory subCatageory) {
    List subCategoryList = null;
    if (subCatageory != null) {
      if (subCatageory.getSubCatageoryId() == null) {
        subCategoryList = hibernateTemplate.find("from SubCatageory sc where sc.subCatageoryName='"
            + subCatageory.getSubCatageoryName() + "' AND sc.catageory.catageoryId='"
            + subCatageory.getCatageory().getCatageoryId() + "' AND IS_DELETED="
            + IConstant.IS_DELETED);
        if (subCategoryList.isEmpty()) {
          hibernateTemplate.saveOrUpdate(subCatageory);
          return true;
        } else {
          return false;
        }
      } else {
        hibernateTemplate.saveOrUpdate(subCatageory);
        return true;
      }
    } else {
      return false;
    }
  }

  public List<Object> getAllSubCatageoryName() {
    List<Object> subCatageoryList = null;
    subCatageoryList = hibernateTemplate.find("from SubCatageory where IS_DELETED="
        + IConstant.IS_DELETED);
    return subCatageoryList;
  }

  public List<Object> getInfoForEdit(Integer subCatageoryId) {
    List<Object> list = null;
    list = hibernateTemplate.find("from SubCatageory sc where sc.subCatageoryId=" + subCatageoryId);
    return list;
  }

  public void deleteSubCatageory(Integer subCatageoryId) {
    SubCatageory subCatageory = (SubCatageory) hibernateTemplate.get(SubCatageory.class,
        subCatageoryId);
    subCatageory.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
    if (null != subCatageory) {
      hibernateTemplate.update(subCatageory);
    }

  }
}
