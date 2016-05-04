package com.ftf.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emailalert")
public class EmailAlert implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMAIL_ALERT_ID")
	private Integer emailAlertId;

	@Column(name = "CATAGORY")
	private String catagory;

	@Column(name = "SUB_CATAGORY")
	private String subCatagory;

	@Column(name = "MUSIC")
	private String music;

	@Column(name = "EMAIL_ALERT_TIME")
	private String emailAlertTime;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;
	
	@Column(name = "CREATED_ON")
	private String createdOn;

	@Column(name = "UPDATED_ON")
	private String updatedOn;
	
	@Column(name = "CITY")
	private String city;
	
	/**
	 * @return the emailAlertId
	 */
	public Integer getEmailAlertId() {
		return emailAlertId;
	}

	/**
	 * @param emailAlertId
	 *            the emailAlertId to set
	 */
	public void setEmailAlertId(Integer emailAlertId) {
		this.emailAlertId = emailAlertId;
	}

	/**
	 * @return the catagory
	 */
	public String getCatagory() {
		return catagory;
	}

	/**
	 * @param catagory
	 *            the catagory to set
	 */
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	/**
	 * @return the subCatagory
	 */
	public String getSubCatagory() {
		return subCatagory;
	}

	/**
	 * @param subCatagory
	 *            the subCatagory to set
	 */
	public void setSubCatagory(String subCatagory) {
		this.subCatagory = subCatagory;
	}

	/**
	 * @return the music
	 */
	public String getMusic() {
		return music;
	}

	/**
	 * @param music
	 *            the music to set
	 */
	public void setMusic(String music) {
		this.music = music;
	}

	/**
	 * @return the emailAlertTime
	 */
	public String getEmailAlertTime() {
		return emailAlertTime;
	}

	/**
	 * @param emailAlertTime
	 *            the emailAlertTime to set
	 */
	public void setEmailAlertTime(String emailAlertTime) {
		this.emailAlertTime = emailAlertTime;
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
	 * @return the createdOn
	 */
	public String getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the updatedOn
	 */
	public String getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn the updatedOn to set
	 */
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

}
