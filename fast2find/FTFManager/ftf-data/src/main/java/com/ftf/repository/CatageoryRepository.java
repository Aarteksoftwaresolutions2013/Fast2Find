package com.ftf.repository;

import java.util.List;

import com.ftf.model.Catageory;
@SuppressWarnings("rawtypes")
public interface CatageoryRepository {
  public boolean addCatageory(Catageory catageory);

  public List<Object> getAllCatageoryName();
  public List<Object> getInfoForEdit(Integer catageoryId);
  public void deleteCatageory(Integer catageoryId);
  public List getCategoryAndSubCategory();

}
