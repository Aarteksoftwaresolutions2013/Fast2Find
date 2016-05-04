package com.ftf.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.model.Catageory;
import com.ftf.repository.CatageoryRepository;
import com.ftf.service.CatageoryService;
import com.ftf.util.IConstant;

@Service
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CatageoryServiceImpl implements CatageoryService {
  @Autowired
  private CatageoryRepository catageoryRepository;

  public boolean addCatageory(Catageory catageory) {
    boolean status = false;
    catageory.setIsDeleted(IConstant.IS_DELETED);
    status = catageoryRepository.addCatageory(catageory);
    if (status) {
      return status;
    } else {
      return status;
    }
  }
  /**
   * getAllcatageory method use to get all category name from database.
   */
  public List<Catageory> getAllCatageoryName() {
    List<Catageory> catageoryList = new ArrayList<Catageory>();
    catageoryList = (List) catageoryRepository.getAllCatageoryName();
    return catageoryList;
  }

  public Catageory getInfoForEdit(Integer catageoryId) {
    List<Object> list = new ArrayList<Object>();
    Catageory catageory = new Catageory();
    list = catageoryRepository.getInfoForEdit(catageoryId);
    for (Object object : list) {
      catageory = (Catageory) object;
    }
    return catageory;
  }

  public void deleteCatageory(Integer catageoryId) {
    catageoryRepository.deleteCatageory(catageoryId);
  }

  public List getCategoryAndSubCategory() {
    List list = new ArrayList();
    List NameList=new ArrayList();
    list=catageoryRepository.getCategoryAndSubCategory();
    if(!list.isEmpty())
    {
    for(Object obj:list){
      Map nameMap = new HashMap();
      Object[] objs=(Object[])obj;
      nameMap.put("CATEGORY", objs[0]==null?"-----":objs[0]);
      nameMap.put("SUB_CATEGORY", objs[1]==null?"-----":objs[1]);
      NameList.add(nameMap);
    }
    }
    return NameList;
  }
}