package com.ftf.model;

import java.io.Serializable;

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
@Table(name = "location")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LOCATION_ID")
	private Integer locationId;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "STATE_NAME")
	private String stateName;

	@Column(name = "CITY_NAME")
	private String cityName;

	@Column(name = "ZIP_CODE")
	private String zipCode;

	@Column(name = "COUNTRY_NAME")
	private String countryName;

	@Column(name = "BILLING_ADDRESS")
	private String billingAddress;

	@Column(name = "BILLING_STATE_NAME")
	private String billingStateName;

	@Column(name = "BILLING_CITY_NAME")
	private String billingCityName;

	@Column(name = "BILLING_ZIP_CODE")
	private String billingZipCode;

	@Column(name = "BILLING_COUNTRY_NAME")
	private String billingCountryName;
	
	@OneToOne
	@JoinColumn(name = "LOCATION_ID")
	private CustomerInformation customerInformation;

	@OneToOne
	@JoinColumn(name = "LOCATION_ID")
	private BusinessAndEventInformation businessAndEventInformation;

	/* No need (cascade = CascadeType.ALL) this place */
	@OneToOne
	@JoinColumn(name = "LOCATION_ID")
	private Branch branch;

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public CustomerInformation getCustomerInformation() {
		return customerInformation;
	}

	public void setCustomerInformation(CustomerInformation customerInformation) {
		this.customerInformation = customerInformation;
	}

	public BusinessAndEventInformation getBusinessAndEventInformation() {
		return businessAndEventInformation;
	}

	public void setBusinessAndEventInformation(
			BusinessAndEventInformation businessAndEventInformation) {
		this.businessAndEventInformation = businessAndEventInformation;
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
	 *            the branch to set
	 */
	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName
	 *            the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the billingAddress
	 */
	public String getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * @return the billingStateName
	 */
	public String getBillingStateName() {
		return billingStateName;
	}

	/**
	 * @param billingStateName the billingStateName to set
	 */
	public void setBillingStateName(String billingStateName) {
		this.billingStateName = billingStateName;
	}

	/**
	 * @return the billingCityName
	 */
	public String getBillingCityName() {
		return billingCityName;
	}

	/**
	 * @param billingCityName the billingCityName to set
	 */
	public void setBillingCityName(String billingCityName) {
		this.billingCityName = billingCityName;
	}

	/**
	 * @return the billingZipCode
	 */
	public String getBillingZipCode() {
		return billingZipCode;
	}

	/**
	 * @param billingZipCode the billingZipCode to set
	 */
	public void setBillingZipCode(String billingZipCode) {
		this.billingZipCode = billingZipCode;
	}

	/**
	 * @return the billingCountryName
	 */
	public String getBillingCountryName() {
		return billingCountryName;
	}

	/**
	 * @param billingCountryName the billingCountryName to set
	 */
	public void setBillingCountryName(String billingCountryName) {
		this.billingCountryName = billingCountryName;
	}
}
