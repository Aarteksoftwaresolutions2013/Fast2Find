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

@Entity
@Table(name = "operatinghours")
public class OperatingHours implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "OPERATING_HOURS_ID")
  private Integer operatingHoursId;

  @Column(name = "START_TIME")
  private String startTime;

  @Column(name = "END_TIME")
  private String endTime;

  @OneToOne
  @JoinColumn(name = "OPERATING_HOURS_ID")
  private Branch branch;

  /**
   * @return the operatingHoursId
   */
  public Integer getOperatingHoursId() {
    return operatingHoursId;
  }

  /**
   * @param operatingHoursId
   *          the operatingHoursId to set
   */
  public void setOperatingHoursId(Integer operatingHoursId) {
    this.operatingHoursId = operatingHoursId;
  }

  /**
   * @return the startTime
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * @param startTime
   *          the startTime to set
   */
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  /**
   * @return the endTime
   */
  public String getEndTime() {
    return endTime;
  }

  /**
   * @param endTime
   *          the endTime to set
   */
  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  /**
   * @return the branch
   */
  public Branch getBranch() {
    return branch;
  }

  /**
   * @param branch the branch to set
   */
  public void setBranch(Branch branch) {
    this.branch = branch;
  }

}
