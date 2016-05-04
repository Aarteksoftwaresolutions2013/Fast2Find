package com.ftf.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ftf.model.Branch;
import com.ftf.model.Catageory;
import com.ftf.model.CategoryAlias;
import com.ftf.model.SubCatageory;
import com.ftf.model.SubCategoryAlias;
import com.ftf.repository.BranchRepository;
import com.ftf.util.IConstant;

@Repository
@SuppressWarnings({ "unchecked", "rawtypes" })
public class BranchRepositoryImpl implements BranchRepository {
  @Autowired
  private HibernateTemplate hibernateTemplate;

  @SuppressWarnings("unused")
  public boolean businessEventInfoAdd(Branch branch) {
    if (branch.getBranchId() != null) {
      if (branch != null) {
        if (branch.getBranchId() != null) {
          List<CategoryAlias> catAList2 = hibernateTemplate
              .find("from  CategoryAlias c where c.branch.branchId=" + branch.getBranchId());
          hibernateTemplate.deleteAll(catAList2);
        }
        for (int i = 0; i < branch.getCatagoryList().size(); i++) {
          CategoryAlias cat = new CategoryAlias();
          Catageory catageory = (Catageory) hibernateTemplate.get(Catageory.class, (Integer) branch
              .getCatagoryList().get(i));
          cat.setCatageory(catageory);
          hibernateTemplate.saveOrUpdate(branch);
          cat.setBranch(branch);
          hibernateTemplate.saveOrUpdate(cat);
          if (branch.getSubCatagoryList() != null) {
            for (int j = 0; j < branch.getSubCatagoryList().size(); j++) {
              SubCatageory subCatageory = (SubCatageory) hibernateTemplate.get(SubCatageory.class,
                  (Integer) branch.getSubCatagoryList().get(j));
              int categoryId = subCatageory.getCatageory().getCatageoryId();
              if (categoryId == cat.getCatageory().getCatageoryId()) {
                SubCategoryAlias subCategoryAlias = new SubCategoryAlias();
                subCategoryAlias.setCategoryAlias(cat);
                subCategoryAlias.setSubCatageory(subCatageory);
                subCategoryAlias.getSubCatageory().getSubCatageoryId();
                hibernateTemplate.saveOrUpdate(subCategoryAlias);
              }
            }
          }
        }
        return true;
      } else {
        return false;
      }
    } else {
      List content = null;
      content = hibernateTemplate.find("from Branch b where b.branchName='"
          + branch.getBranchName() + "' AND b.contactNo='" + branch.getContactNo()
          + "' AND b.location.address='" + branch.getLocation().getAddress()
          + "' AND b.location.stateName='" + branch.getLocation().getStateName()
          + "'AND b.location.cityName='" + branch.getLocation().getCityName()
          + "'AND b.location.countryName='" + branch.getLocation().getCountryName()
          + "'AND b.isDeleted=" + IConstant.IS_DELETED);
      if (content.isEmpty()) {
        if (branch.getBranchId() != null) {
          List<CategoryAlias> catAList2 = hibernateTemplate
              .find("from  CategoryAlias c where c.branch.branchId=" + branch.getBranchId());
          hibernateTemplate.deleteAll(catAList2);
        }
        for (int i = 0; i < branch.getCatagoryList().size(); i++) {
          CategoryAlias cat = new CategoryAlias();
          Catageory catageory = (Catageory) hibernateTemplate.get(Catageory.class, (Integer) branch
              .getCatagoryList().get(i));
          cat.setCatageory(catageory);
          hibernateTemplate.saveOrUpdate(branch);
          cat.setBranch(branch);
          hibernateTemplate.saveOrUpdate(cat);
          if (branch.getSubCatagoryList() != null) {
            for (int j = 0; j < branch.getSubCatagoryList().size(); j++) {
              SubCatageory subCatageory = (SubCatageory) hibernateTemplate.get(SubCatageory.class,
                  (Integer) branch.getSubCatagoryList().get(j));
              int categoryId = subCatageory.getCatageory().getCatageoryId();
              if (categoryId == cat.getCatageory().getCatageoryId()) {
                SubCategoryAlias subCategoryAlias = new SubCategoryAlias();
                subCategoryAlias.setCategoryAlias(cat);
                subCategoryAlias.setSubCatageory(subCatageory);
                subCategoryAlias.getSubCatageory().getSubCatageoryId();
                hibernateTemplate.saveOrUpdate(subCategoryAlias);
              }
            }
          }
        }
        return true;
      } else {
        return false;
      }
    }
  }

  public List<Branch> getbusiness(Integer businessAndEventId) {
    List<Branch> list = null;
    list = hibernateTemplate
        .find("select branchId,branchName ,maxCapacity , location.cityName ,contactNo from Branch where businessAndEventInformation.businessEventID='"
            + businessAndEventId + "' ");
    return list;
  }

  public List<Object> getBusinessInfoById(Integer branchId) {
    List<Object> list = null;
    list = hibernateTemplate.find("from Branch b where b.branchId=" + branchId);
    return list;
  }

  public List<Branch> getEventName(Integer businessAndEventId) {
    List<Branch> list = null;
    list = hibernateTemplate
        .find("select branchId,eventName ,location.cityName,eventStartDateAndTime,eventEndDateAndTime from Branch where businessAndEventInformation.businessEventID='"
            + businessAndEventId + "' ");
    return list;
  }

  public List<Object> getSubCategoryName(Integer categoryId) {
    List<Object> subCategoryList = null;
    subCategoryList = hibernateTemplate.find("from  SubCatageory sc  where sc.isDeleted="
        + IConstant.IS_DELETED + " and sc.catageory.catageoryId=" + categoryId + " ");
    return subCategoryList;
  }

  public List<Object> getCategoryName(Integer categoryId) {
    List<Object> categoryList = null;
    categoryList = hibernateTemplate.find("from  Catageory c  where c.isDeleted="
        + IConstant.IS_DELETED + " and c.catageoryId=" + categoryId + " ");
    return categoryList;
  }

  public boolean addEventInformation(Branch branch) {
    if (branch != null) {
      hibernateTemplate.saveOrUpdate(branch);
      return true;
    } else {
      return false;
    }
  }

}
