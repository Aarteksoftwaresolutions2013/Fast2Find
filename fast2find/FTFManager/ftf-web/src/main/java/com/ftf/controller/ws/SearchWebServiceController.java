package com.ftf.controller.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftf.model.Branch;
import com.ftf.service.WSSearchService;
import com.ftf.util.IConstant;

@Controller
@SuppressWarnings("rawtypes")
public class SearchWebServiceController {

  @Autowired
  private WSSearchService wsSearchService;

  /**
   * fetch all business details from database based on address and business
   * category.
   * 
   * @param branch
   * @param response
   * @return
   */
  @RequestMapping(value = "/searchDataAction", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> webSearchData(@RequestBody Branch branch, HttpServletResponse response) {
    List searchList = new ArrayList();
    searchList = wsSearchService.getSearchDetails(branch.getCatagory(), branch.getFullAddress(),
        branch.getSearchDate());
    Map<Object, Object> map = new HashMap<Object, Object>();
    if (searchList.isEmpty()) {
      map.put(IConstant.RESPONSE, IConstant.FAILURE_CODE);
      map.put(IConstant.DATA, searchList);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.SEARCH_FAIL);
    } else {
      map.put(IConstant.RESPONSE, IConstant.SUCCESS_CODE);
      map.put(IConstant.DATA, searchList);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.SEARCH_SUCCESS);
    }
    return map;
  }

  /**
   * Find data from database with in 5Km range from current
   * location.
   * 
   * @param branch
   * @param response
   * @return
   */
  @RequestMapping(value = "/nearByAction", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> nearBy(@RequestBody Branch branch, HttpServletResponse response) {
    List nearBySearchDataList = new ArrayList();
    nearBySearchDataList = wsSearchService.getDataWithInRange(branch.getCatagory(),
        branch.getFullAddress(), branch.getSearchDate(), branch.getLatitude(),
        branch.getLongitude());
    Map<Object, Object> map = new HashMap<Object, Object>();
    if (nearBySearchDataList.isEmpty()) {
      map.put(IConstant.RESPONSE, IConstant.FAILURE_CODE);
      map.put(IConstant.DATA, nearBySearchDataList);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.SEARCH_FAIL);
    } else {
      map.put(IConstant.RESPONSE, IConstant.SUCCESS_CODE);
      map.put(IConstant.DATA, nearBySearchDataList);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.SEARCH_SUCCESS);
    }
    return map;
  }
}
