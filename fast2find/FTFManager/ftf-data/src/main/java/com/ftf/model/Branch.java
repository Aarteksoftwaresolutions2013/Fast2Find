package com.ftf.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "branch")
public class Branch implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "BRANCH_ID")
  private Integer branchId;

  @Column(name = "BRANCH_TYPE")
  private String branchType;

  @Column(name = "BRANCH_NAME")
  private String branchName;

  @Column(name = "EVENT_NAME")
  private String eventName;

  @Column(name = "EVENT_REPEAT_DATE")
  private String eventRepeatDate;

  @Column(name = "MAXCAPACITY")
  private String maxCapacity;

  @Column(name = "EVENT_START_DATEANDTIME")
  private String eventStartDateAndTime;

  @Column(name = "EVENT_END_DATEANDTIME")
  private String eventEndDateAndTime;

  @Column(name = "HOUR_OF_OPERATION")
  private String hourOfOperation;

  @Column(name = "CHARGE_PER_PERSON")
  private String chargePerPerson;

  @Column(name = "QUICK_BOOKING_FEE_PER_TABLE")
  private String quickBookingFeePerTable;

  @Column(name = "ENTRY_TICKETS")
  private String entryTickets;

  @Column(name = "BOTTLE_SERVICE_BOOKING")
  private String bottleServiceBooking;

  @Column(name = "MUSIC")
  private String music;

  @Column(name = "Event_EMAIL")
  private String eventEmail;

  @Column(name = "CONTACT_NO")
  private String contactNo;

  @Column(name = "EVENT_TITLE")
  private String eventTitle;

  @Column(name = "FULL_EVENT_TICKET")
  private String fullEventTicket;

  @Column(name = "DECRIPTION")
  private String description;

  @Column(name = "LATITUDE")
  private String latitude;

  @Column(name = "LONGITUDE")
  private String longitude;

  @Column(name = "SEARCH_DATA")
  private String searchData;

  @Column(name = "IS_DELETED")
  private Integer isDeleted;

  @Column(name = "DAILY_EVENT_TICKET")
  private String dailyEventTicket;

  @Column(name = "UPDATE_STAGE")
  private String updateStage;

  @Column(name = "EVENT_KIOSK_NAME")
  private String eventKioskName;

  @Column(name = "EVENT_OWNER_FNAME")
  private String eventOwnerFName;

  @Column(name = "EVENT_OWNER_LNAME")
  private String eventOwnerLName;

  @Column(name = "ALLOW_QUICKBOOKING")
  private String allowQuickBooking;
  /**
   * add updatable=false to restrict child update
   */
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "BRANCH_ID", updatable = false)
  private List<Audit> auditList;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "BRANCH_ID", updatable = false)
  private List<CategoryAlias> categoryAliasList;

  /**
   * add FetchType mode. add updatable=false to restrict child update
   */
  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "BRANCH_ID", updatable = false)
  private List<QuickBooking> quickBookingList;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "LOCATION_ID")
  private Location location;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "LOGIN_ID")
  private Login login;

  @ManyToOne
  @JoinColumn(name = "BUSINESS_EVENT_ID")
  private BusinessAndEventInformation businessAndEventInformation;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "OPERATING_HOURS_ID")
  private OperatingHours operatingHours;

  @Transient
  private String catagory[];

  @Transient
  private String subCatagory[];

  @Transient
  private String paidUSer;

  @Transient
  private String fullAddress;

  @Transient
  private String searchDate;

  @Transient
  private Integer noOfMale;
  
  @Transient
  private String firstName;

  @Transient
  private String lastName;

  @Transient
  private Integer noOfFemale;

  @Transient
  private List<Integer> catagoryList;

  @Transient
  private String repeatEmail;

  @Transient
  private List<Integer> subCatagoryList;

  @Column(name = "ADDITIONAL_INFO")
  private String additionalInfo;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "BRANCH_ID")
  private List<CustomerComment> customerCommentList;

  public String getPaidUSer() {
    return paidUSer;
  }

  public void setPaidUSer(String paidUSer) {
    this.paidUSer = paidUSer;
  }

  /**
   * @return the branchId
   */
  public Integer getBranchId() {
    return branchId;
  }

  /**
   * @param branchId
   *          the branchId to set
   */
  public void setBranchId(Integer branchId) {
    this.branchId = branchId;
  }

  /**
   * @return the branchType
   */
  public String getBranchType() {
    return branchType;
  }

  /**
   * @param branchType
   *          the branchType to set
   */
  public void setBranchType(String branchType) {
    this.branchType = branchType;
  }

  /**
   * @return the branchName
   */
  public String getBranchName() {
    return branchName;
  }

  /**
   * @param branchName
   *          the branchName to set
   */
  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }

  /**
   * @return the eventName
   */
  public String getEventName() {
    return eventName;
  }

  /**
   * @param eventName
   *          the eventName to set
   */
  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  /**
   * @return the eventRepeatDate
   */
  public String getEventRepeatDate() {
    return eventRepeatDate;
  }

  /**
   * @param eventRepeatDate
   *          the eventRepeatDate to set
   */
  public void setEventRepeatDate(String eventRepeatDate) {
    this.eventRepeatDate = eventRepeatDate;
  }

  /**
   * @return the maxCapacity
   */
  public String getMaxCapacity() {
    return maxCapacity;
  }

  /**
   * @param maxCapacity
   *          the maxCapacity to set
   */
  public void setMaxCapacity(String maxCapacity) {
    this.maxCapacity = maxCapacity;
  }

  /**
   * @return the chargePerPerson
   */
  public String getChargePerPerson() {
    return chargePerPerson;
  }

  /**
   * @param chargePerPerson
   *          the chargePerPerson to set
   */
  public void setChargePerPerson(String chargePerPerson) {
    this.chargePerPerson = chargePerPerson;
  }

  /**
   * @return the music
   */
  public String getMusic() {
    return music;
  }

  /**
   * @param music
   *          the music to set
   */
  public void setMusic(String music) {
    this.music = music;
  }

  /**
   * @return the eventTitle
   */
  public String getEventTitle() {
    return eventTitle;
  }

  /**
   * @param eventTitle
   *          the eventTitle to set
   */
  public void setEventTitle(String eventTitle) {
    this.eventTitle = eventTitle;
  }

  /**
   * @return the fullEventTicket
   */
  public String getFullEventTicket() {
    return fullEventTicket;
  }

  /**
   * @param fullEventTicket
   *          the fullEventTicket to set
   */
  public void setFullEventTicket(String fullEventTicket) {
    this.fullEventTicket = fullEventTicket;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description
   *          the description to set
   */
  public void setDescription(String description) {
    this.description = description;
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

  /**
   * @return the audit
   */

  /**
   * @return the eventStartDateAndTime
   */
  public String getEventStartDateAndTime() {
    return eventStartDateAndTime;
  }

  /**
   * @param eventStartDateAndTime
   *          the eventStartDateAndTime to set
   */
  public void setEventStartDateAndTime(String eventStartDateAndTime) {
    this.eventStartDateAndTime = eventStartDateAndTime;
  }

  /**
   * @return the eventEndDateAndTime
   */
  public String getEventEndDateAndTime() {
    return eventEndDateAndTime;
  }

  /**
   * @param eventEndDateAndTime
   *          the eventEndDateAndTime to set
   */
  public void setEventEndDateAndTime(String eventEndDateAndTime) {
    this.eventEndDateAndTime = eventEndDateAndTime;
  }

  /**
   * @return the auditList
   */
  @JsonIgnore
  public List<Audit> getAuditList() {
    return auditList;
  }

  /**
   * @param auditList
   *          the auditList to set
   */
  public void setAuditList(List<Audit> auditList) {
    this.auditList = auditList;
  }

  /**
   * @return the quickBookingList
   */

  @JsonIgnore
  public List<QuickBooking> getQuickBookingList() {
    return quickBookingList;
  }

  /**
   * @param quickBookingList
   *          the quickBookingList to set
   */
  public void setQuickBookingList(List<QuickBooking> quickBookingList) {
    this.quickBookingList = quickBookingList;
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
   * @return the login
   */
  /* @JsonIgnore */
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
   * @return the latitude
   */
  public String getLatitude() {
    return latitude;
  }

  /**
   * @param latitude
   *          the latitude to set
   */
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  /**
   * @return the longitude
   */
  public String getLongitude() {
    return longitude;
  }

  /**
   * @param longitude
   *          the longitude to set
   */
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  /**
   * @return the searchData
   */
  public String getSearchData() {
    return searchData;
  }

  /**
   * @param searchData
   *          the searchData to set
   */
  public void setSearchData(String searchData) {
    this.searchData = searchData;
  }

  /**
   * @return the catagory
   */
  public String[] getCatagory() {
    return catagory;
  }

  /**
   * @param catagory
   *          the catagory to set
   */
  public void setCatagory(String[] catagory) {
    this.catagory = catagory;
  }

  /**
   * @return the quickBookingFeePerTable
   */
  public String getQuickBookingFeePerTable() {
    return quickBookingFeePerTable;
  }

  /**
   * @param quickBookingFeePerTable
   *          the quickBookingFeePerTable to set
   */
  public void setQuickBookingFeePerTable(String quickBookingFeePerTable) {
    this.quickBookingFeePerTable = quickBookingFeePerTable;
  }

  /**
   * @return the entryTickets
   */
  public String getEntryTickets() {
    return entryTickets;
  }

  /**
   * @param entryTickets
   *          the entryTickets to set
   */
  public void setEntryTickets(String entryTickets) {
    this.entryTickets = entryTickets;
  }

  /**
   * @return the bottleServiceBooking
   */
  public String getBottleServiceBooking() {
    return bottleServiceBooking;
  }

  /**
   * @param bottleServiceBooking
   *          the bottleServiceBooking to set
   */
  public void setBottleServiceBooking(String bottleServiceBooking) {
    this.bottleServiceBooking = bottleServiceBooking;
  }

  /**
   * @return the eventEmail
   */
  public String getEventEmail() {
    return eventEmail;
  }

  /**
   * @param eventEmail
   *          the eventEmail to set
   */
  public void setEventEmail(String eventEmail) {
    this.eventEmail = eventEmail;
  }

  /**
   * @return the dailyEventTicket
   */
  public String getDailyEventTicket() {
    return dailyEventTicket;
  }

  /**
   * @param dailyEventTicket
   *          the dailyEventTicket to set
   */
  public void setDailyEventTicket(String dailyEventTicket) {
    this.dailyEventTicket = dailyEventTicket;
  }

  /**
   * @return the updateStage
   */
  public String getUpdateStage() {
    return updateStage;
  }

  /**
   * @param updateStage
   *          the updateStage to set
   */
  public void setUpdateStage(String updateStage) {
    this.updateStage = updateStage;
  }

  /**
   * @return the fullAddress
   */
  public String getFullAddress() {
    return fullAddress;
  }

  /**
   * @param fullAddress
   *          the fullAddress to set
   */
  public void setFullAddress(String fullAddress) {
    this.fullAddress = fullAddress;
  }

  /**
   * @return the businessAndEventInformation
   */
/*  @JsonIgnore*/
  public BusinessAndEventInformation getBusinessAndEventInformation() {
    return businessAndEventInformation;
  }

  /**
   * @param businessAndEventInformation
   *          the businessAndEventInformation to set
   */
  public void setBusinessAndEventInformation(BusinessAndEventInformation businessAndEventInformation) {
    this.businessAndEventInformation = businessAndEventInformation;
  }

  /**
   * @return the searchDate
   */
  public String getSearchDate() {
    return searchDate;
  }

  /**
   * @param searchDate
   *          the searchDate to set
   */
  public void setSearchDate(String searchDate) {
    this.searchDate = searchDate;
  }

  /**
   * @return the eventKioskName
   */
  public String getEventKioskName() {
    return eventKioskName;
  }

  /**
   * @param eventKioskName
   *          the eventKioskName to set
   */
  public void setEventKioskName(String eventKioskName) {
    this.eventKioskName = eventKioskName;
  }

  /**
   * @return the eventOwnerFName
   */
  public String getEventOwnerFName() {
    return eventOwnerFName;
  }

  /**
   * @param eventOwnerFName
   *          the eventOwnerFName to set
   */
  public void setEventOwnerFName(String eventOwnerFName) {
    this.eventOwnerFName = eventOwnerFName;
  }

  /**
   * @return the eventOwnerLName
   */
  public String getEventOwnerLName() {
    return eventOwnerLName;
  }

  /**
   * @param eventOwnerLName
   *          the eventOwnerLName to set
   */
  public void setEventOwnerLName(String eventOwnerLName) {
    this.eventOwnerLName = eventOwnerLName;
  }

  /**
   * @return the contactNo
   */
  public String getContactNo() {
    return contactNo;
  }

  /**
   * @param contactNo
   *          the contactNo to set
   */
  public void setContactNo(String contactNo) {
    this.contactNo = contactNo;
  }

  /**
   * @return the additionalInfo
   */
  public String getAdditionalInfo() {
    return additionalInfo;
  }

  /**
   * @param additionalInfo
   *          the additionalInfo to set
   */
  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  /**
   * @return the noOfMale
   */
  public Integer getNoOfMale() {
    return noOfMale;
  }

  /**
   * @param noOfMale
   *          the noOfMale to set
   */
  public void setNoOfMale(Integer noOfMale) {
    this.noOfMale = noOfMale;
  }

  /**
   * @return the noOfFemale
   */
  public Integer getNoOfFemale() {
    return noOfFemale;
  }

  /**
   * @param noOfFemale
   *          the noOfFemale to set
   */
  public void setNoOfFemale(Integer noOfFemale) {
    this.noOfFemale = noOfFemale;
  }

  /**
   * @return the allowQuickBooking
   */
  public String getAllowQuickBooking() {
    return allowQuickBooking;
  }

  /**
   * @param allowQuickBooking
   *          the allowQuickBooking to set
   */
  public void setAllowQuickBooking(String allowQuickBooking) {
    this.allowQuickBooking = allowQuickBooking;
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

  /**
   * @return the subCatagory
   */
  public String[] getSubCatagory() {
    return subCatagory;
  }

  /**
   * @param subCatagory
   *          the subCatagory to set
   */
  public void setSubCatagory(String[] subCatagory) {
    this.subCatagory = subCatagory;
  }

  /**
   * @return the catagoryList
   */
  public List<Integer> getCatagoryList() {
    return catagoryList;
  }

  /**
   * @param catagoryList
   *          the catagoryList to set
   */
  public void setCatagoryList(List<Integer> catagoryList) {
    this.catagoryList = catagoryList;
  }

  /**
   * @return the subCatagoryList
   */
  public List<Integer> getSubCatagoryList() {
    return subCatagoryList;
  }

  /**
   * @param subCatagoryList
   *          the subCatagoryList to set
   */
  public void setSubCatagoryList(List<Integer> subCatagoryList) {
    this.subCatagoryList = subCatagoryList;
  }

  /**
   * @return the repeatEmail
   */
  public String getRepeatEmail() {
    return repeatEmail;
  }

  /**
   * @param repeatEmail
   *          the repeatEmail to set
   */
  public void setRepeatEmail(String repeatEmail) {
    this.repeatEmail = repeatEmail;
  }

  /**
   * @return the operatingHours
   */
  public OperatingHours getOperatingHours() {
    return operatingHours;
  }

  /**
   * @param operatingHours
   *          the operatingHours to set
   */
  public void setOperatingHours(OperatingHours operatingHours) {
    this.operatingHours = operatingHours;
  }

  /**
   * @return the hourOfOperation
   */
  public String getHourOfOperation() {
    return hourOfOperation;
  }

  /**
   * @param hourOfOperation
   *          the hourOfOperation to set
   */
  public void setHourOfOperation(String hourOfOperation) {
    this.hourOfOperation = hourOfOperation;
  }

  /**
   * @return the customerCommentList
   */
  public List<CustomerComment> getCustomerCommentList() {
    return customerCommentList;
  }

  /**
   * @param customerCommentList
   *          the customerCommentList to set
   */
  public void setCustomerCommentList(List<CustomerComment> customerCommentList) {
    this.customerCommentList = customerCommentList;
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

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

}
