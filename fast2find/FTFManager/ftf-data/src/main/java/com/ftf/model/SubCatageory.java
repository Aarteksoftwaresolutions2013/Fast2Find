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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "subcatageory")
public class SubCatageory implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "SUB_CATAGEORY_ID")
  private Integer subCatageoryId;

  @Column(name = "SUB_CATAGEORY_NAME")
  private String subCatageoryName;

  @ManyToOne
  @JoinColumn(name = "CATAGEORY_ID")
  private Catageory catageory;

  @Column(name = "IS_DELETED")
  private Integer isDeleted;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "SUB_CATAGEORY_ID")
  private List<SubCategoryAlias> subCategoryAliasList;

  /**
   * @return the subCatageoryId
   */
  public Integer getSubCatageoryId() {
    return subCatageoryId;
  }

  /**
   * @param subCatageoryId
   *          the subCatageoryId to set
   */
  public void setSubCatageoryId(Integer subCatageoryId) {
    this.subCatageoryId = subCatageoryId;
  }

  /**
   * @return the subCatageoryName
   */
  public String getSubCatageoryName() {
    return subCatageoryName;
  }

  /**
   * @param subCatageoryName
   *          the subCatageoryName to set
   */
  public void setSubCatageoryName(String subCatageoryName) {
    this.subCatageoryName = subCatageoryName;
  }

  /**
   * @return the catageory
   */
  public Catageory getCatageory() {
    return catageory;
  }

  /**
   * @param catageory
   *          the catageory to set
   */
  public void setCatageory(Catageory catageory) {
    this.catageory = catageory;
  }

  /**
   * @return the isDeleted
   */
  @JsonIgnore
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
   * @return the subCategoryAliasList
   */
  public List<SubCategoryAlias> getSubCategoryAliasList() {
    return subCategoryAliasList;
  }

  /**
   * @param subCategoryAliasList
   *          the subCategoryAliasList to set
   */
  public void setSubCategoryAliasList(List<SubCategoryAlias> subCategoryAliasList) {
    this.subCategoryAliasList = subCategoryAliasList;
  }

}
