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
@Table(name = "quickbooking")
public class QuickBooking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOKING_ID")
	private Integer bookingId;

	@Column(name = "NUMBER_OF_PERSON")
	private Integer numberOfPerson;

	@Column(name = "TABLE_BOOKING_TIME")
	private String tableBookingTime;

	/*Remove cascadeType.All*/
	@ManyToOne
	@JoinColumn(name = "BRANCH_ID")
	private Branch branch;

	@Column(name = "SERVICE")
	private String service;

	@Column(name = "LIKED_STATUS")
	private String likedStatus;
	
	@Column(name = "AMOUNT_PAID")
	private Integer amountPaid;
	
	 @Column(name = "COMMENT")
	  private String comment;
	
	@Transient
	private Integer bId;

	@Transient
	private String orderPlace;
	
	@Transient
  private String emailId;
	
	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getNumberOfPerson() {
		return numberOfPerson;
	}

	public void setNumberOfPerson(Integer numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}

	public String getTableBookingTime() {
		return tableBookingTime;
	}

	public void setTableBookingTime(String tableBookingTime) {
		this.tableBookingTime = tableBookingTime;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

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
	 * @return the service
	 */
	public String getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * @return the amountPaid
	 */
	public Integer getAmountPaid() {
		return amountPaid;
	}

	/**
	 * @param amountPaid the amountPaid to set
	 */
	public void setAmountPaid(Integer amountPaid) {
		this.amountPaid = amountPaid;
	}

	/**
	 * @return the bId
	 */
	public Integer getbId() {
		return bId;
	}

	/**
	 * @param bId the bId to set
	 */
	public void setbId(Integer bId) {
		this.bId = bId;
	}

	/**
	 * @return the orderPlace
	 */
	public String getOrderPlace() {
		return orderPlace;
	}

	/**
	 * @param orderPlace the orderPlace to set
	 */
	public void setOrderPlace(String orderPlace) {
		this.orderPlace = orderPlace;
	}

	/**
	 * @return the likedStatus
	 */
	public String getLikedStatus() {
		return likedStatus;
	}

	/**
	 * @param likedStatus the likedStatus to set
	 */
	public void setLikedStatus(String likedStatus) {
		this.likedStatus = likedStatus;
	}

  /**
   * @return the comment
   */
  public String getComment() {
    return comment;
  }

  /**
   * @param comment the comment to set
   */
  public void setComment(String comment) {
    this.comment = comment;
  }

  /**
   * @return the emailId
   */
  public String getEmailId() {
    return emailId;
  }

  /**
   * @param emailId the emailId to set
   */
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

}
