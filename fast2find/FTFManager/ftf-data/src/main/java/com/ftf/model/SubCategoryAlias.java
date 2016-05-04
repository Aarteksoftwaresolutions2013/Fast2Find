package com.ftf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subcategoryalias")
public class SubCategoryAlias implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "SUB_CATEGORY_ALIAS_ID")
  private Integer subCategoryAliasId;

  @ManyToOne
  @JoinColumn(name = "SUB_CATAGEORY_ID")
  private SubCatageory subCatageory;

  @ManyToOne
  @JoinColumn(name = "CATEGORY_ALIAS_ID")
  private CategoryAlias categoryAlias;

  /**
   * @return the subCategoryAliasId
   */
  public Integer getSubCategoryAliasId() {
    return subCategoryAliasId;
  }

  /**
   * @param subCategoryAliasId
   *          the subCategoryAliasId to set
   */
  public void setSubCategoryAliasId(Integer subCategoryAliasId) {
    this.subCategoryAliasId = subCategoryAliasId;
  }

  /**
   * @return the subCatageory
   */
  public SubCatageory getSubCatageory() {
    return subCatageory;
  }

  /**
   * @param subCatageory
   *          the subCatageory to set
   */
  public void setSubCatageory(SubCatageory subCatageory) {
    this.subCatageory = subCatageory;
  }

  /**
   * @return the categoryAlias
   */
  public CategoryAlias getCategoryAlias() {
    return categoryAlias;
  }

  /**
   * @param categoryAlias
   *          the categoryAlias to set
   */
  public void setCategoryAlias(CategoryAlias categoryAlias) {
    this.categoryAlias = categoryAlias;
  }
}
