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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "customer_information")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	private Integer customerID;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "CONTACT_NO")
	private String contactNo;

	@Column(name = "CUSTOMER_CATAGORY")
	private String customerCatagory;

	@Column(name = "CREATED_ON")
	private String createdOn;

	@Column(name = "UPDATED_ON")
	private String updatedOn;

	@Column(name = "VALIDATE_TILL")
	private String validateTill;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "LOGIN_ID")
	private Login login;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "LOCATION_ID")
	private Location location;

	/**
	 * @return the customerID
	 */
	public Integer getCustomerID() {
		return customerID;
	}

	/**
	 * @param customerID
	 *            the customerID to set
	 */
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}

	/**
	 * @param contactNo
	 *            the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	/**
	 * @return the customerCatagory
	 */
	public String getCustomerCatagory() {
		return customerCatagory;
	}

	/**
	 * @param customerCatagory
	 *            the customerCatagory to set
	 */
	public void setCustomerCatagory(String customerCatagory) {
		this.customerCatagory = customerCatagory;
	}

	/**
	 * @return the createdOn
	 */
	public String getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn
	 *            the createdOn to set
	 */
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the updatedOn
	 */
	public String getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn
	 *            the updatedOn to set
	 */
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the validateTill
	 */
	public String getValidateTill() {
		return validateTill;
	}

	/**
	 * @param validateTill
	 *            the validateTill to set
	 */
	public void setValidateTill(String validateTill) {
		this.validateTill = validateTill;
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
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * @return the location
	 */
	@JsonIgnore
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
