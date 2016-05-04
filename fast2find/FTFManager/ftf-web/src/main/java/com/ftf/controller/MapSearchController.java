package com.ftf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftf.model.Branch;
import com.ftf.model.Catageory;
import com.ftf.model.CustomerComment;
import com.ftf.service.CatageoryService;
import com.ftf.service.MapSearchService;
import com.ftf.util.IConstant;

@Controller
@SuppressWarnings("rawtypes")
public class MapSearchController {
  @Autowired
  private MapSearchService mapSearchService;

  @Autowired
  private CatageoryService catageoryService;

  /**
   * Method for show front page(Welcome Page). getAllCatageoryName method use to
   * get all category name from database.
   */
  @RequestMapping("/frontPage")
  public String showFrontPage(Map<String, Object> map, Model model) {
    map.put("Branch", new Branch());
    List<Catageory> catageoryList = new ArrayList<Catageory>();
    catageoryList = catageoryService.getAllCatageoryName();
    if (catageoryList != null) {
      model.addAttribute("catageory", catageoryList);
    }
    return "frontPage";
  }

  /**
   * getEventSearchInfo method use get all event from database if user is paid
   * type. getAllCatageoryName method use to get all category name from data
   * base . getSearchDetails method use to get all business register with
   * Fast2Find and show on map
   * @param branch
   * @param result
   * @param address
   */
  @RequestMapping(value = "/searchAction", method = { RequestMethod.GET, RequestMethod.POST })
  public String seach(@ModelAttribute("Branch") Branch branch, BindingResult result,
      ModelMap model, Map<String, Object> map, HttpServletRequest request) {
    List<Catageory> catageoryList = new ArrayList<Catageory>();
    catageoryList = catageoryService.getAllCatageoryName();
    if (catageoryList != null) {
      model.addAttribute("catageory", catageoryList);
    }
    if (branch.getCatagory() != null) {
      String type = branch.getCatagory()[0];
      if (type.equals(IConstant.EVENT) && branch.getPaidUSer().equals(IConstant.PAID_USER_YES)) {
        String address = request.getParameter("address");
        List<Branch> list = new ArrayList<Branch>();
        list = mapSearchService.getEventSearchInfo(branch.getCatagory(), address,
            branch.getSearchDate());
        if (!list.isEmpty()) {
          model.addAttribute("searchList", list);
          model.addAttribute("message", " ");
        } else {
          model.addAttribute("message", IConstant.NO_RECORD);
        }
        return "eventSearchInfo";
      } else {
        String address = request.getParameter("address");
        List list = new ArrayList();
        list = mapSearchService.getSearchDetails(branch.getCatagory(), address,
            branch.getSearchDate(), branch.getSubCatagory());
        if (!list.isEmpty()) {
          model.addAttribute("searchList", list);
          model.addAttribute("message", " ");
        } else {
          model.addAttribute("message", IConstant.NO_RECORD);
        }
        return "frontPage";
      }
    } else {
      return "frontPage";
    }
  }

  /**
   * businessInfo method use to show business information page
   */
  @RequestMapping("/showBusinessInfo")
  public String businessInfo(Map<String, Object> map, Model model) {
    return "showBusinessInfo";
  }

  /**
   * getMapInformation method use get all business information corresponding to
   * branchId.
   * @param branch
   * @param branchId
   * @param date
   */
  @RequestMapping(value = "/showInformation", method = { RequestMethod.GET, RequestMethod.POST })
  public String mapInfo(@ModelAttribute("Branch") Branch branch, BindingResult result,
      ModelMap model, HttpServletRequest request, @RequestParam(required = false) Integer branchId) {
    List<Branch> list = new ArrayList<Branch>();
    list = mapSearchService.getMapInformation(branchId, branch.getSearchDate());
    if (list != null) {
      model.addAttribute("mapInfoList", list);
    }
    return "showBusinessInfo";
  }

  /**
   * searchAllMaps method use to get all address for show into auto complete
   * @param searchValue
   */
  @RequestMapping(value = "/searchMap", method = RequestMethod.GET)
  @ResponseBody
  public List<Branch> searchAddress(@RequestParam String searchValue) {
    List<Branch> searchList = new ArrayList<Branch>();
    if (!searchValue.isEmpty()) {
      searchList = mapSearchService.searchAllMaps(searchValue);
    }
    return searchList;
  }

  /**
   * showEventSearchInfo method use to show event information page
   * @param map
   * @param model
   * @return
   */
  @RequestMapping("/eventSearchInfo")
  public String showEventSearchInfo(Map<String, Object> map, Model model) {
    return "eventSearchInfo";
  }

  /**
   * getEventInformation method get event information corresponding to branch
   * id.
   * @param branch
   * @param result
   * @param model
   * @param request
   * @param branchId
   * @return
   */
  @RequestMapping(value = "/showEventInformation", method = { RequestMethod.GET, RequestMethod.POST })
  public String showEventInfo(@ModelAttribute("Branch") Branch branch, BindingResult result,
      ModelMap model, HttpServletRequest request, @RequestParam(required = false) Integer branchId) {
    List<Branch> list = new ArrayList<Branch>();
    list = mapSearchService.getEventInformation(branchId, branch.getSearchDate());
    if (list != null) {
      model.put("eventSearchList", list);
    }
    return "showEventInformation";
  }

  @RequestMapping("/showEventInformation")
  public String showEventInformationPage(Map<String, Object> map, Model model) {
    return "showEventInformation";
  }

  /**
   * getCustomerComment method use to get all comment that user have given and
   * show the comment on map.
   * @param branchId
   * @return
   */
  @RequestMapping(value = "/getCustomerComment", method = RequestMethod.GET)
  @ResponseBody
  public List<CustomerComment> getComment(@RequestParam int branchId) {
    List<CustomerComment> commentList = new ArrayList<CustomerComment>();
    if (branchId != 0) {
      commentList = mapSearchService.getCustomerComment(branchId);
    }
    return commentList;
  }
}
