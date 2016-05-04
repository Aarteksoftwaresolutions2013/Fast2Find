package com.ftf.service;
import java.util.List;
import com.ftf.model.Catageory;
@SuppressWarnings("rawtypes")
public interface CatageoryService {
  public boolean addCatageory(Catageory catageory);
  public List<Catageory> getAllCatageoryName();
  public Catageory getInfoForEdit(Integer catageoryId);
  public void deleteCatageory(Integer catageoryId);
  public List getCategoryAndSubCategory();
}
