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
import com.ftf.model.Catageory;
import com.ftf.service.CatageoryService;
import com.ftf.util.IConstant;

@Controller
public class CategoryWebService {

  @Autowired
  private CatageoryService catageoryService;

  /**
   * getAllCatageoryName() use for fetch all category name from database.
   * condition:isDeleted active
   * @param category
   * @param response
   */
  @RequestMapping(value = "/categoryAction", method = RequestMethod.POST)
  public @ResponseBody
  Map<Object, Object> webSearchData(@RequestBody Catageory category, HttpServletResponse response) {
    List<Catageory> catageoryList = new ArrayList<Catageory>();
    catageoryList = catageoryService.getAllCatageoryName();
    Map<Object, Object> map = new HashMap<Object, Object>();
    if (catageoryList.isEmpty()) {
      map.put(IConstant.RESPONSE, IConstant.FAILURE_CODE);
      map.put(IConstant.DATA, catageoryList);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.CATEGORY_FAIL);
    } else {
      map.put(IConstant.RESPONSE, IConstant.SUCCESS_CODE);
      map.put(IConstant.DATA, catageoryList);
      map.put(IConstant.SUCCESS_MESSAGE, IConstant.CATEGORY_SUCCESS);
    }
    return map;
  }
}
