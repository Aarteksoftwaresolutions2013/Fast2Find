package com.ftf.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "catageory")
public class Catageory implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "CATAGEORY_ID")
  private Integer catageoryId;

  @Column(name = "CATAGEORY_NAME")
  private String catageoryName;

  @Column(name = "IS_DELETED")
  private Integer isDeleted;

  /*
   * comment fetch = FetchType.EAGER because i am getting error
   * "cannot simultaneously fetch multiple bags";
   */

  @LazyCollection(LazyCollectionOption.FALSE)
  /* @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL) */
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "CATAGEORY_ID", updatable = false)
  @Fetch(FetchMode.SELECT)
  @BatchSize(size=1)
  private List<SubCatageory> subCatageoryList;

  /*
   * date:07/07/2014 i have add @LazyCollection(LazyCollectionOption.FALSE)
   * because category web service generate error.
   */
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "CATAGEORY_ID")
   @BatchSize(size=1)
  private List<CategoryAlias> categoryAliasList;

  /**
   * @return the catageoryId
   */
  public Integer getCatageoryId() {
    return catageoryId;
  }

  /**
   * @param catageoryId
   *          the catageoryId to set
   */
  public void setCatageoryId(Integer catageoryId) {
    this.catageoryId = catageoryId;
  }

  /**
   * @return the catageoryName
   */
  public String getCatageoryName() {
    return catageoryName;
  }

  /**
   * @param catageoryName
   *          the catageoryName to set
   */
  public void setCatageoryName(String catageoryName) {
    this.catageoryName = catageoryName;
  }

  /**
   * @return the isDeleted
   */
  public Integer getIsDeleted() {
    return isDeleted;
  }

  /**
   * @param isDeleted
   *          the isDeleted to set
   */
  public void setIsDeleted(Integer isDeleted) {
    this.isDeleted = isDeleted;
  }

  /**
   * @return the subCatageoryList
   */

  /**
   * Add JsonIgnore because in dynamic category web service get all data that
   * generate error so ignore sub category data.
   */
  @JsonIgnore
  public List<SubCatageory> getSubCatageoryList() {
    return subCatageoryList;
  }

  /**
   * @param subCatageoryList
   *          the subCatageoryList to set
   */
  public void setSubCatageoryList(List<SubCatageory> subCatageoryList) {
    this.subCatageoryList = subCatageoryList;
  }

  /**
   * @return the categoryAliasList
   */
  @JsonIgnore
  public List<CategoryAlias> getCategoryAliasList() {
    return categoryAliasList;
  }

  /**
   * @param categoryAliasList
   *          the categoryAliasList to set
   */
  public void setCategoryAliasList(List<CategoryAlias> categoryAliasList) {
    this.categoryAliasList = categoryAliasList;
  }

}
