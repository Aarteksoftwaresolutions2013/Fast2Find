package com.ftf.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "login")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LOGIN_ID")
	private Integer loginId;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "USER_TYPE")
	private String userType;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "PAID_STATUS")
	private String paidStatus;
	
	@OneToOne
	@JoinColumn(name = "LOGIN_ID")
	private CustomerInformation customerInformation;

	@OneToOne
	@JoinColumn(name = "LOGIN_ID")
	private BusinessAndEventInformation businessAndEventInformation;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "LOGIN_ID")
	private Branch branch;
	
	@Transient
	private String invalid;

	/**
	 * @return the loginId
	 */
	public Integer getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId
	 *            the loginId to set
	 */
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the customerInformation
	 */
	@JsonIgnore
	public CustomerInformation getCustomerInformation() {
		return customerInformation;
	}

	/**
	 * @param customerInformation
	 *            the customerInformation to set
	 */
	public void setCustomerInformation(CustomerInformation customerInformation) {
		this.customerInformation = customerInformation;
	}

	/**
	 * @return the businessAndEventInformation
	 */
	@JsonIgnore
	public BusinessAndEventInformation getBusinessAndEventInformation() {
		return businessAndEventInformation;
	}

	/**
	 * @param businessAndEventInformation
	 *            the businessAndEventInformation to set
	 */
	public void setBusinessAndEventInformation(
			BusinessAndEventInformation businessAndEventInformation) {
		this.businessAndEventInformation = businessAndEventInformation;
	}

	/**
	 * @return the branch
	 */
	/*@JsonIgnore*/
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
	 * @return the paidStatus
	 */
	public String getPaidStatus() {
		return paidStatus;
	}

	/**
	 * @param paidStatus the paidStatus to set
	 */
	public void setPaidStatus(String paidStatus) {
		this.paidStatus = paidStatus;
	}

  /**
   * @return the invalid
   */
  public String getInvalid() {
    return invalid;
  }

  /**
   * @param invalid the invalid to set
   */
  public void setInvalid(String invalid) {
    this.invalid = invalid;
  }

	/**
	 * @return the branch
	 */

}
