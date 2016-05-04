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

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "customercomment")
public class CustomerComment implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "CUSTOMER_COMMENT_ID")
  private Integer customerCommentId;

  @Column(name = "NO_OF_MALEANDFEMALE_LINE_UP")
  private String noOfMaleAndFemaleLineUp;

  @Column(name = "NO_OF_MALEANDFEMALE_INSIDE")
  private String noOfMaleAndFemaleInside;

  @Column(name = "CUSTOMER_COMMENT")
  private String customerComment;

  @Column(name = "IS_DELETED")
  private Integer isDeleted;

  @ManyToOne
  @JoinColumn(name = "BRANCH_ID")
  private Branch branch;

  /**
   * @return the customerCommentId
   */
  public Integer getCustomerCommentId() {
    return customerCommentId;
  }

  /**
   * @param customerCommentId
   *          the customerCommentId to set
   */
  public void setCustomerCommentId(Integer customerCommentId) {
    this.customerCommentId = customerCommentId;
  }

  /**
   * @return the noOfMaleAndFemaleLineUp
   */
  public String getNoOfMaleAndFemaleLineUp() {
    return noOfMaleAndFemaleLineUp;
  }

  /**
   * @param noOfMaleAndFemaleLineUp
   *          the noOfMaleAndFemaleLineUp to set
   */
  public void setNoOfMaleAndFemaleLineUp(String noOfMaleAndFemaleLineUp) {
    this.noOfMaleAndFemaleLineUp = noOfMaleAndFemaleLineUp;
  }

  /**
   * @return the noOfMaleAndFemaleInside
   */
  public String getNoOfMaleAndFemaleInside() {
    return noOfMaleAndFemaleInside;
  }

  /**
   * @param noOfMaleAndFemaleInside
   *          the noOfMaleAndFemaleInside to set
   */
  public void setNoOfMaleAndFemaleInside(String noOfMaleAndFemaleInside) {
    this.noOfMaleAndFemaleInside = noOfMaleAndFemaleInside;
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
   * @return the customerComment
   */
  public String getCustomerComment() {
    return customerComment;
  }

  /**
   * @param customerComment
   *          the customerComment to set
   */
  public void setCustomerComment(String customerComment) {
    this.customerComment = customerComment;
  }

  /**
   * @return the branch
   */
  @JsonIgnore
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

}
