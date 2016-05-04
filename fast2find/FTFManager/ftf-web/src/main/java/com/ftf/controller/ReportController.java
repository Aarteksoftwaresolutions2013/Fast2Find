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
import com.ftf.service.GenerateGraphService;
import com.ftf.util.IConstant;

@Controller
@SuppressWarnings("rawtypes")
public class ReportController {

  @Autowired
  private GenerateGraphService generateGraphService;

  /**
   * showLineChartPage() use to show business report page
   * @param map
   * @param model
   * @param request
   * @return
   */
  @RequestMapping("/showReport")
  public String showLineChartPage(Map<String, Object> map, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    BusinessAndEventInformation loginMember = (BusinessAndEventInformation) session
        .getAttribute("login");
    Integer businessAndEventId = loginMember.getBusinessEventID();
    map.put("Branch", new Branch());
    List<Branch> branchIdList = null;
    branchIdList = generateGraphService.getBranchId(businessAndEventId);
    if (branchIdList != null) {
      model.addAttribute("branchIdList", branchIdList);
    }
    return "reportPage";
  }

  /**
   * getWeeklyDetails() use to fetch weekly data from database and show on bar
   * graph.
   * @param audit
   * @param request
   * @param response
   * @param loginId
   * @return
   */
  @RequestMapping(value = "/getWeeklyInformation", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> getWeeklyData(@RequestBody Audit audit, HttpServletRequest request,
      HttpServletResponse response) {
    Integer loginId = audit.getComboId();
    List<Audit> weeklyList = null;
    weeklyList = generateGraphService.getWeeklyDetails(loginId);
    Map<Object, Object> map = new HashMap<Object, Object>();
    if (((List) weeklyList.get(0)).isEmpty()) {
      map.put("code", IConstant.FAILURE_CODE);
      map.put("weeklyData", weeklyList);
      map.put("failure", IConstant.NO_RECORD_FOUND);
    } else {
      map.put("code", IConstant.SUCCESS_CODE);
      map.put("weeklyData", weeklyList);
      map.put("Result", IConstant.RECORD_FOUND);
    }
    return map;
  }

  /**
   * getMonthlyData() method for fetch data from database.
   * @param audit
   * @param request
   * @param response
   * @param loginId
   */
  @RequestMapping(value = "/getMonthlyInformation", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> getMonthlyData(@RequestBody Audit audit, HttpServletRequest request,
      HttpServletResponse response) {
    Integer loginId = audit.getComboId();
    List<Audit> monthlyList = null;
    monthlyList = generateGraphService.getMonthlyDetails(loginId);
    Map<Object, Object> map = new HashMap<Object, Object>();
    if (((List) monthlyList.get(0)).isEmpty()) {
      map.put("code", IConstant.FAILURE_CODE);
      map.put("monthlyData", monthlyList);
      map.put("failure", IConstant.NO_RECORD_FOUND);
    } else {
      map.put("code", IConstant.SUCCESS_CODE);
      map.put("monthlyData", monthlyList);
      map.put("Result", IConstant.RECORD_FOUND);
    }
    return map;
  }

  /**
   * getthreeMonthlyData() use to fetch three monthly data from database and
   * show on bar graph.
   * @param audit
   * @param request
   * @param response
   * @param loginId
   * @return
   */
  @RequestMapping(value = "/getThreeMonthlyInformation", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> getthreeMonthlyData(@RequestBody Audit audit, HttpServletRequest request,
      HttpServletResponse response) {
    Integer loginId = audit.getComboId();
    List<Audit> threeMonthlyList = null;
    threeMonthlyList = generateGraphService.getThreeMonthlyDetails(loginId);
    Map<Object, Object> map = new HashMap<Object, Object>();
    Object[] obj = (Object[]) ((List) threeMonthlyList.get(1)).get(0);
    if (obj[0] == null) {
      map.put("code", IConstant.FAILURE_CODE);
      map.put("threeMonthlyData", threeMonthlyList);
      map.put("failure", IConstant.NO_RECORD_FOUND);
    } else {
      map.put("code", IConstant.SUCCESS_CODE);
      map.put("threeMonthlyData", threeMonthlyList);
      map.put("Result", IConstant.RECORD_FOUND);
    }

    return map;
  }

  /**
   * getYearlyDetails() use to fetch yearly data from database and show on bar
   * graph.
   * @param audit
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/getYearlyInformation", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> getData(@RequestBody Audit audit, HttpServletRequest request,
      HttpServletResponse response) {
    Integer loginId = audit.getComboId();
    List<Audit> yearlyList = null;
    yearlyList = generateGraphService.getYearlyDetails(loginId);
    Map<Object, Object> map = new HashMap<Object, Object>();
    if (yearlyList.isEmpty()) {
      map.put("code", IConstant.FAILURE_CODE);
      map.put("yearlyData", yearlyList);
      map.put("failure", IConstant.NO_RECORD_FOUND);
    } else {
      map.put("code", IConstant.SUCCESS_CODE);
      map.put("yearlyData", yearlyList);
      map.put("Result", IConstant.RECORD_FOUND);
    }
    return map;
  }

}
