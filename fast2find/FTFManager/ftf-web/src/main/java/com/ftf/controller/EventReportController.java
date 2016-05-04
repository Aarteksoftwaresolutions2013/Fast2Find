package com.ftf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftf.model.Audit;
import com.ftf.model.Branch;
import com.ftf.model.BusinessAndEventInformation;
import com.ftf.service.GenerateEventGraphService;
import com.ftf.util.IConstant;

@Controller
@SuppressWarnings("rawtypes")
public class EventReportController {

  @Autowired
  private GenerateEventGraphService generateEventGraphService;

  /**
   * showEventReportPage use to show event report page. getBranchEventId method
   * use to get branch id from data base for generate report corresponding to
   * branch id.
   * @param businessAndEventId
   */
  @RequestMapping("/showEventReport")
  public String showEventReportPage(Map<String, Object> map, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    BusinessAndEventInformation loginMember = (BusinessAndEventInformation) session
        .getAttribute("login");
    Integer businessAndEventId = loginMember.getBusinessEventID();
    map.put("Branch", new Branch());
    List<Branch> branchEventIdList = null;
    branchEventIdList = generateEventGraphService.getBranchEventId(businessAndEventId);
    if (branchEventIdList != null) {
      model.addAttribute("branchEventIdList", branchEventIdList);
    }
    return "eventReportPage";
  }

  /**
   * getEventWeeklyDetails use to get weekly data from database
   * @param loginId
   */
  @RequestMapping(value = "/getEventWeeklyInformation", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> getWeeklyData(@RequestBody Audit audit, HttpServletRequest request,
      HttpServletResponse response) {
    Integer loginId = audit.getComboId();
    List<Audit> weeklyList = null;
    weeklyList = generateEventGraphService.getEventWeeklyDetails(loginId);
    Map<Object, Object> map = new HashMap<Object, Object>();
    if (((List) weeklyList.get(0)).isEmpty()) {
      map.put("code", IConstant.FAILURE_CODE);
      map.put("weeklyData", weeklyList);
      map.put("Result", IConstant.NO_RECORD_FOUND);
    } else {
      map.put("code", IConstant.SUCCESS_CODE);
      map.put("weeklyData", weeklyList);
      map.put("Result", IConstant.RECORD_FOUND);
    }
    return map;
  }

  /**
   * getEventMonthlyDetails use to get monthly data from database
   * @param loginId
   */
  @RequestMapping(value = "/getEventMonthlyInformation", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> getMonthlyData(@RequestBody Audit audit, HttpServletRequest request,
      HttpServletResponse response) {
    Integer loginId = audit.getComboId();
    List<Audit> monthlyList = null;
    monthlyList = generateEventGraphService.getEventMonthlyDetails(loginId);
    Map<Object, Object> map = new HashMap<Object, Object>();
    if (((List) monthlyList.get(0)).isEmpty()) {
      map.put("code", IConstant.FAILURE_CODE);
      map.put("monthlyData", monthlyList);
      map.put("failure", IConstant.NO_RECORD_FOUND);
    } else {
      map.put("code", IConstant.SUCCESS_CODE);
      map.put("monthlyData", monthlyList);
      map.put("successMessage", IConstant.RECORD_FOUND);
    }
    return map;
  }

  /**
   * getEventThreeMonthlyInformation use to get three monthly data from database
   * @param loginId
   */
  @RequestMapping(value = "/getEventThreeMonthlyInformation", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> getthreeMonthlyData(@RequestBody Audit audit, HttpServletRequest request,
      HttpServletResponse response) {
    Integer loginId = audit.getComboId();
    List<Audit> threeMonthlyList = null;
    threeMonthlyList = generateEventGraphService.getEventThreeMonthlyDetails(loginId);
    Map<Object, Object> map = new HashMap<Object, Object>();
    Object[] obj = (Object[]) ((List) threeMonthlyList.get(1)).get(0);
    if (obj[0] == null) {
      map.put("code", IConstant.FAILURE_CODE);
      map.put("threeMonthlyData", threeMonthlyList);
      map.put("failure", IConstant.NO_RECORD_FOUND);
    } else {
      map.put("code", IConstant.SUCCESS_CODE);
      map.put("threeMonthlyData", threeMonthlyList);
      map.put("successMessage", IConstant.RECORD_FOUND);
    }
    return map;
  }

  /**
   * getEventYearlyDetails use to get yearly data from database
   * @param loginId
   */
  @RequestMapping(value = "/getEvent" + "YearlyInformation", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> getData(@RequestBody Audit audit, HttpServletRequest request,
      HttpServletResponse response) {
    Integer loginId = audit.getComboId();
    List<Audit> yearlyList = null;
    yearlyList = generateEventGraphService.getEventYearlyDetails(loginId);
    Map<Object, Object> map = new HashMap<Object, Object>();
    if (yearlyList.isEmpty()) {
      map.put("code", IConstant.FAILURE_CODE);
      map.put("yearlyData", yearlyList);
      map.put("failure", IConstant.NO_RECORD_FOUND);
    } else {
      map.put("code", IConstant.SUCCESS_CODE);
      map.put("yearlyData", yearlyList);
      map.put("successMessage", IConstant.RECORD_FOUND);
    }
    return map;
  }

}
