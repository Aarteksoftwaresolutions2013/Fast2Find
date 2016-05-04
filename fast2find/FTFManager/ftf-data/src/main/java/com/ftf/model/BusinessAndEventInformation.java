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

@Entity
@Table(name = "business_event_information")
public class BusinessAndEventInformation implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "BUSINESS_EVENT_ID")
  private Integer businessEventID;

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "BUSINESS_CATAGORY")
  private String businessCatagory;

  @Column(name = "CREATED_ON")
  private String createdOn;

  @Column(name = "UPDATED_ON")
  private String updatedOn;

  @Column(name = "VALIDATE_TILL")
  private String validateTill;

  @Column(name = "EVENT_CATAGORY")
  private String eventCatagory;

  @Column(name = "IS_DELETED")
  private Integer isDeleted;

  @Column(name = "CUSTOMER_CATAGORY")
  private String customerCatagory;

  @Column(name = "SAME_ADDRESS")
  private String sameAddress;
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "LOGIN_ID")
  private Login login;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "LOCATION_ID")
  private Location location;

  @Transient
  private String confirmEmail;

  @Transient
  private String confirmPassword;

  @Column(name = "DATE_OF_BIRTH")
  private String dateOfBirth;
  
  @Column(name = "GENDER")
  private String gender;
  
  @Column(name = "TITLE")
  private String title;
  
  @Column(name = "TERM_AND_CONDITION")
  private String termAndCondition;
  /**
   * @return the customerID
   */

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName
   *          the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the createdOn
   */
  public String getCreatedOn() {
    return createdOn;
  }

  /**
   * @param createdOn
   *          the createdOn to set
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
   *          the updatedOn to set
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
   *          the validateTill to set
   */
  public void setValidateTill(String validateTill) {
    this.validateTill = validateTill;
  }

  /**
   * @return the eventCatagory
   */
  public String getEventCatagory() {
    return eventCatagory;
  }

  /**
   * @param eventCatagory
   *          the eventCatagory to set
   */
  public void setEventCatagory(String eventCatagory) {
    this.eventCatagory = eventCatagory;
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
   * @return the login
   */
  public Login getLogin() {
    return login;
  }

  /**
   * @param login
   *          the login to set
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
   *          the location to set
   */
  public void setLocation(Location location) {
    this.location = location;
  }

  /**
   * @return the businessEventID
   */

  public Integer getBusinessEventID() {
    return businessEventID;
  }

  /**
   * @param businessEventID
   *          the businessEventID to set
   */
  public void setBusinessEventID(Integer businessEventID) {
    this.businessEventID = businessEventID;
  }

  /**
   * @return the businessCatagory
   */
  public String getBusinessCatagory() {
    return businessCatagory;
  }

  /**
   * @param businessCatagory
   *          the businessCatagory to set
   */
  public void setBusinessCatagory(String businessCatagory) {
    this.businessCatagory = businessCatagory;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName
   *          the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the customerCatagory
   */
  public String getCustomerCatagory() {
    return customerCatagory;
  }

  /**
   * @param customerCatagory
   *          the customerCatagory to set
   */
  public void setCustomerCatagory(String customerCatagory) {
    this.customerCatagory = customerCatagory;
  }

  /**
   * @return the confirmEmail
   */
  public String getConfirmEmail() {
    return confirmEmail;
  }

  /**
   * @param confirmEmail
   *          the confirmEmail to set
   */
  public void setConfirmEmail(String confirmEmail) {
    this.confirmEmail = confirmEmail;
  }

  /**
   * @return the confirmPassword
   */
  public String getConfirmPassword() {
    return confirmPassword;
  }

  /**
   * @param confirmPassword
   *          the confirmPassword to set
   */
  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  /**
   * @return the sameAddress
   */
  public String getSameAddress() {
    return sameAddress;
  }

  /**
   * @param sameAddress the sameAddress to set
   */
  public void setSameAddress(String sameAddress) {
    this.sameAddress = sameAddress;
  }

  /**
   * @return the dateOfBirth
   */
  public String getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * @param dateOfBirth the dateOfBirth to set
   */
  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  /**
   * @return the gender
   */
  public String getGender() {
    return gender;
  }

  /**
   * @param gender the gender to set
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the termAndCondition
   */
  public String getTermAndCondition() {
    return termAndCondition;
  }

  /**
   * @param termAndCondition the termAndCondition to set
   */
  public void setTermAndCondition(String termAndCondition) {
    this.termAndCondition = termAndCondition;
  }
}
