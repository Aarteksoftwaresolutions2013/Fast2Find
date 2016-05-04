package com.ftf.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.model.Audit;
import com.ftf.model.Branch;
import com.ftf.repository.GenerateGraphRepository;
import com.ftf.service.GenerateGraphService;

@Service
public class GenerateGraphServiceImpl implements GenerateGraphService {
  @Autowired
  GenerateGraphRepository generateGraphRepository;

  /**
   * getWeeklyDetails() use for fetch weekly data form database and show on bar
   * graph.
   * 
   * @param loginId
   */
  public List<Audit> getWeeklyDetails(Integer loginId) {
    return generateGraphRepository.getWeeklyDetails(loginId);
  }

  /**
   * getMonthlyDetails() use for fetch monthly data form database and show on bar
   * graph.
   * 
   * @param loginId
   */
  public List<Audit> getMonthlyDetails(Integer loginId) {
    return generateGraphRepository.getMonthlyDetails(loginId);
  }

  /**
   * getThreeMonthlyDetails() use for fetch 3 monthly data form database and show on bar
   * graph.
   * 
   * @param loginId
   */
  public List<Audit> getThreeMonthlyDetails(Integer loginId) {
    return generateGraphRepository.getThreeMonthlyDetails(loginId);
  }

  /**
   * getYearlyDetails() use for fetch yearly data form database and show on bar
   * graph.
   * 
   * @param loginId
   */
  public List<Audit> getYearlyDetails(Integer loginId) {
    return generateGraphRepository.getYearlyDetails(loginId);
  }

  /**
   * getBranchId() use for fectch branch id from database.
   * @param businessAndEventId
   */
  public List<Branch> getBranchId(Integer businessAndEventId) {
    return generateGraphRepository.getBranchId(businessAndEventId);
  }

}
