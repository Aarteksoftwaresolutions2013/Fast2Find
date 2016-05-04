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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "categoryalias")
public class CategoryAlias implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "CATEGORY_ALIAS_ID")
  private Integer categoryAliasId;

  @ManyToOne
  @JoinColumn(name = "BRANCH_ID")
  private Branch branch; 

  @ManyToOne
  @JoinColumn(name = "CATAGEORY_ID")
  private Catageory catageory;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "CATEGORY_ALIAS_ID")
  private List<SubCategoryAlias> subCategoryAliasList;

  /**
   * @return the categoryAliasId
   */
  public Integer getCategoryAliasId() {
    return categoryAliasId;
  }

  /**
   * @param categoryAliasId
   *          the categoryAliasId to set
   */
  public void setCategoryAliasId(Integer categoryAliasId) {
    this.categoryAliasId = categoryAliasId;
  }

  /**
   * @return the branch
   */
  public Branch getBranch() {
    return branch;
  }

  /**
   * @param branch
   *          the branch to set
   */
  public void setBranch(Branch branch) {
    this.branch = branch;
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
