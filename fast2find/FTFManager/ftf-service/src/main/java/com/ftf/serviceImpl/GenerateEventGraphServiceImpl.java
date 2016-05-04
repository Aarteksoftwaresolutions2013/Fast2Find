package com.ftf.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.model.Audit;
import com.ftf.model.Branch;
import com.ftf.repository.GenerateEventGraphRepository;
import com.ftf.service.GenerateEventGraphService;

@Service
public class GenerateEventGraphServiceImpl implements GenerateEventGraphService {

  @Autowired
  private GenerateEventGraphRepository generateEventGraphRepository;

  /**
   * getEventWeeklyDetails use to get weekly data from database
   * 
   * @param loginId
   */

  public List<Audit> getEventWeeklyDetails(Integer loginId) {
    return generateEventGraphRepository.getEventWeeklyDetails(loginId);
  }

  /**
   * getEventMonthlyDetails use to get monthly data from database
   * 
   * @param loginId
   */
  public List<Audit> getEventMonthlyDetails(Integer loginId) {
    return generateEventGraphRepository.getEventMonthlyDetails(loginId);
  }

  /**
   * getEventThreeMonthlyInformation use to get three monthly data from database
   * 
   * @param loginId
   */
  public List<Audit> getEventThreeMonthlyDetails(Integer loginId) {
    return generateEventGraphRepository.getEventThreeMonthlyDetails(loginId);
  }

  /**
   * getEventYearlyDetails use to get yearly data from database
   * 
   * @param loginId
   */
  public List<Audit> getEventYearlyDetails(Integer loginId) {
    return generateEventGraphRepository.getEventYearlyDetails(loginId);
  }

  /**
   * getBranchEventId use to get branch name form data base.
   * 
   * @param businessAndEventId
   */
  public List<Branch> getBranchEventId(Integer businessAndEventId) {
    return generateEventGraphRepository.getBranchEventId(businessAndEventId);
  }

}
