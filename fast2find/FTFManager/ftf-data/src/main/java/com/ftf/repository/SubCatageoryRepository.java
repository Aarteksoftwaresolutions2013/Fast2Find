package com.ftf.repository;

import java.util.List;

import com.ftf.model.SubCatageory;

public interface SubCatageoryRepository {
  public boolean addSubCatageory(SubCatageory subCatageory);
  public List<Object> getAllSubCatageoryName();
  public List<Object> getInfoForEdit(Integer subCatageoryId);
  public void deleteSubCatageory(Integer subCatageoryId);


}
