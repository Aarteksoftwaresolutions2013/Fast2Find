package com.ftf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "paypaldetails")
public class PaypalDetails implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "PAYPAL_DETAILS_ID")
  private Integer paypalDetailsId;

  @Column(name = "SUBSCRIBE_DATE")
  private String subscribeDate;
  
  @Column(name = "FIRST_NAME")
  private String firstName;
  
  @Column(name = "LAST_NAME")
  private String lastName;
  
  @Column(name = "SUBSCRIBE_ID")
  private String subscribeId;
  
  @Column(name = "PAYPER_STATUS")
  private String payerStatus;
  
  @Column(name = "PAYE_EMAIL")
  private String payeEmail;
  
  @Column(name = "TXN_TYPE")
  private String txnType;
  
  @Column(name = "TEST_IPN")
  private String testIpn;
  
  @Column(name = "AMOUNT")
  private String amount;
  
  @Column(name = "TRANSACTION_ID")
  private String transactionId;
  
  @Column(name = "IS_DELETED")
  private Integer isDeleted;

  /**
   * @return the paypalDetailsId
   */
  public Integer getPaypalDetailsId() {
    return paypalDetailsId;
  }

  /**
   * @param paypalDetailsId the paypalDetailsId to set
   */
  public void setPaypalDetailsId(Integer paypalDetailsId) {
    this.paypalDetailsId = paypalDetailsId;
  }

  /**
   * @return the subscribeDate
   */
  public String getSubscribeDate() {
    return subscribeDate;
  }

  /**
   * @param subscribeDate the subscribeDate to set
   */
  public void setSubscribeDate(String subscribeDate) {
    this.subscribeDate = subscribeDate;
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

  /**
   * @return the subscribeId
   */
  public String getSubscribeId() {
    return subscribeId;
  }

  /**
   * @param subscribeId the subscribeId to set
   */
  public void setSubscribeId(String subscribeId) {
    this.subscribeId = subscribeId;
  }

  /**
   * @return the payerStatus
   */
  public String getPayerStatus() {
    return payerStatus;
  }

  /**
   * @param payerStatus the payerStatus to set
   */
  public void setPayerStatus(String payerStatus) {
    this.payerStatus = payerStatus;
  }

  /**
   * @return the payeEmail
   */
  public String getPayeEmail() {
    return payeEmail;
  }

  /**
   * @param payeEmail the payeEmail to set
   */
  public void setPayeEmail(String payeEmail) {
    this.payeEmail = payeEmail;
  }

  /**
   * @return the txnType
   */
  public String getTxnType() {
    return txnType;
  }

  /**
   * @param txnType the txnType to set
   */
  public void setTxnType(String txnType) {
    this.txnType = txnType;
  }

  /**
   * @return the testIpn
   */
  public String getTestIpn() {
    return testIpn;
  }

  /**
   * @param testIpn the testIpn to set
   */
  public void setTestIpn(String testIpn) {
    this.testIpn = testIpn;
  }

  /**
   * @return the amount
   */
  public String getAmount() {
    return amount;
  }

  /**
   * @param amount the amount to set
   */
  public void setAmount(String amount) {
    this.amount = amount;
  }

  /**
   * @return the transactionId
   */
  public String getTransactionId() {
    return transactionId;
  }

  /**
   * @param transactionId the transactionId to set
   */
  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  /**
   * @return the isDeleted
   */
  public Integer getIsDeleted() {
    return isDeleted;
  }

  /**
   * @param isDeleted the isDeleted to set
   */
  public void setIsDeleted(Integer isDeleted) {
    this.isDeleted = isDeleted;
  }

}
