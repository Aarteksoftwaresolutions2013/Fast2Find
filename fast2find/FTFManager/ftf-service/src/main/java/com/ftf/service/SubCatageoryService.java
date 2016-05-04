package com.ftf.service;

import java.util.List;

import com.ftf.model.SubCatageory;

public interface SubCatageoryService {
  public boolean addSubCatageory(SubCatageory subCatageory);

  public List<SubCatageory> getAllSubCatageoryName();
  public SubCatageory getInfoForEdit(Integer subCatageoryId);
  public void deleteSubCatageory(Integer subCatageoryId);

}
