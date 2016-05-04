package com.ftf.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.model.SubCatageory;
import com.ftf.repository.SubCatageoryRepository;
import com.ftf.service.SubCatageoryService;
import com.ftf.util.IConstant;

@Service
@SuppressWarnings({ "unchecked", "rawtypes" })
public class SubCatageoryServiceImpl implements SubCatageoryService {

  @Autowired
  private SubCatageoryRepository subCatageoryRepository;

  public boolean addSubCatageory(SubCatageory subCatageory) {
    boolean status = false;
    subCatageory.setIsDeleted(IConstant.IS_DELETED);
    status = subCatageoryRepository.addSubCatageory(subCatageory);
    if (status) {
      return status;
    } else {
      return status;
    }
  }

  public List<SubCatageory> getAllSubCatageoryName() {
    List<SubCatageory> subCatageoryList = new ArrayList<SubCatageory>();
    subCatageoryList = (List) subCatageoryRepository.getAllSubCatageoryName();
    return subCatageoryList;
  }

  public SubCatageory getInfoForEdit(Integer subCatageoryId) {
    List<Object> list = new ArrayList<Object>();
    SubCatageory subCatageory = new SubCatageory();
    list = subCatageoryRepository.getInfoForEdit(subCatageoryId);
    for (Object object : list) {
      subCatageory = (SubCatageory) object;
    }
    return subCatageory;
  }

  public void deleteSubCatageory(Integer subCatageoryId) {
    subCatageoryRepository.deleteSubCatageory(subCatageoryId);
  }
}
