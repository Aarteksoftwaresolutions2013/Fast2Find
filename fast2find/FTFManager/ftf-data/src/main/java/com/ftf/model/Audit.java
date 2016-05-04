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
import javax.persistence.Transient;

@Entity
@Table(name = "audit")
public class Audit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AUDIT_ID")
	private Integer auditId;

	@Column(name = "NO_OF_MALE_IN")
	private Integer noOfMaleIn;

	@Column(name = "NO_OF_FEMALE_IN")
	private Integer noOfFeMaleIn;

	@Column(name = "NO_OF_MALE_OUT")
	private Integer noOfMaleOut;

	@Column(name = "NO_OF_FEMALE_OUT")
	private Integer noOfFeMaleOut;

	@Column(name = "TIME_STAMP")
	private String timeStamp;

	@ManyToOne
	@JoinColumn(name = "BRANCH_ID")
	private Branch branch;

	@Transient
	private Integer count;

	@Transient
	private Integer comboId;
	
	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@Transient
	private String catagory[];
	
	public String[] getCatagory() {
		return catagory;
	}

	public void setCatagory(String[] catagory) {
		this.catagory = catagory;
	}

	/**
	 * @return the auditId
	 */
	public Integer getAuditId() {
		return auditId;
	}

	/**
	 * @param auditId
	 *            the auditId to set
	 */
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp
	 *            the timeStamp to set
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the branch
	 */
	public Branch getBranch() {
		return branch;
	}

	/**
	 * @param branch
	 *            the branch to set
	 */
	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	/**
	 * @return the noOfMaleIn
	 */
	public Integer getNoOfMaleIn() {
		return noOfMaleIn;
	}

	/**
	 * @param noOfMaleIn
	 *            the noOfMaleIn to set
	 */
	public void setNoOfMaleIn(Integer noOfMaleIn) {
		this.noOfMaleIn = noOfMaleIn;
	}

	/**
	 * @return the noOfFeMaleIn
	 */
	public Integer getNoOfFeMaleIn() {
		return noOfFeMaleIn;
	}
   
	/**
	 * @param noOfFeMaleIn
	 *            the noOfFeMaleIn to set
	 */
	public void setNoOfFeMaleIn(Integer noOfFeMaleIn) {
		this.noOfFeMaleIn = noOfFeMaleIn;
	}

	/**
	 * @return the noOfMaleOut
	 */
	public Integer getNoOfMaleOut() {
		return noOfMaleOut;
	}

	/**
	 * @param noOfMaleOut
	 *            the noOfMaleOut to set
	 */
	public void setNoOfMaleOut(Integer noOfMaleOut) {
		this.noOfMaleOut = noOfMaleOut;
	}

	/**
	 * @return the noOfFeMaleOut
	 */
	public Integer getNoOfFeMaleOut() {
		return noOfFeMaleOut;
	}

	/**
	 * @param noOfFeMaleOut
	 *            the noOfFeMaleOut to set
	 */
	public void setNoOfFeMaleOut(Integer noOfFeMaleOut) {
		this.noOfFeMaleOut = noOfFeMaleOut;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the isDeleted
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted
	 *            the isDeleted to set
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the comboId
	 */
	public Integer getComboId() {
		return comboId;
	}

	/**
	 * @param comboId the comboId to set
	 */
	public void setComboId(Integer comboId) {
		this.comboId = comboId;
	}
}
