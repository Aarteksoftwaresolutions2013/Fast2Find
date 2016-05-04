package com.ftf.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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
import com.ftf.model.BusinessAndEventInformation;
import com.ftf.model.Catageory;
import com.ftf.service.BranchService;
import com.ftf.service.CatageoryService;
import com.ftf.util.IConstant;
import com.ftf.validator.BusinessValidator;
import com.ftf.validator.EventValidator;

@Controller
public class BranchController {
  private static final Logger logger = Logger.getLogger(BranchController.class);
  @Autowired
  private BranchService branchService;

  @Autowired
  private BusinessValidator businessValidator;

  @Autowired
  private EventValidator eventValidator;

  @Autowired
  private CatageoryService catageoryService;

  /**
   * showBusinessPage Method for show Business Register page.
   * getAllCatageoryName() use to get all category name from database
   */
  @RequestMapping("/businessUpdate")
  public String showBusinessPage(Map<String, Object> map, Model model,
      @RequestParam(required = false) String message, HttpServletRequest request) {
    HttpSession session = request.getSession();
    BusinessAndEventInformation loginMember = (BusinessAndEventInformation) session
        .getAttribute("login");
    if (loginMember != null) {
      model.addAttribute("message", message);
      map.put("Branch", new Branch());
      List<Catageory> catageoryList = new ArrayList<Catageory>();
      catageoryList = catageoryService.getAllCatageoryName();
      if (catageoryList != null) {
        model.addAttribute("catageory", catageoryList);
      }
      return "businessUpdate";
    } else {
      return "redirect:/signIn.do";
    }
  }
  /**
   * businessUpdateInfo Method for business registration action.
   * And this method also use for update business. If status is true then business register and update successfully.
   * getAllCatageoryName() use to get all category name from database.
   */
  @RequestMapping(value = "/updateBusinessInfo", method = RequestMethod.POST)
  public String businessUpdateInfo(@ModelAttribute("Branch") Branch branch, BindingResult result,
      ModelMap model, Map<String, Object> map, HttpServletRequest request) {
    logger.error("Inside a businessUpdateInfo() of Branch Controller");
    List<Catageory> catageoryList = new ArrayList<Catageory>();
    boolean status = false;
    businessValidator.validate(branch, result);
    if (result.hasErrors()) {
      catageoryList = catageoryService.getAllCatageoryName();
      if (catageoryList != null) {
        model.addAttribute("catageory", catageoryList);
      }
      return "businessUpdate";
    }
    HttpSession session = request.getSession();
    BusinessAndEventInformation loginMember = (BusinessAndEventInformation) session
        .getAttribute("login");
    BusinessAndEventInformation businessAndEventInformation = new BusinessAndEventInformation();
    businessAndEventInformation.setBusinessEventID(loginMember.getBusinessEventID());
    branch.setBusinessAndEventInformation(businessAndEventInformation);
    model.put("Branch", new Branch());
    if (branch.getBranchId() != null) {
      status = branchService.businessEventInfoAdd(branch);
      if (status) {
        model.addAttribute("message", IConstant.SUCCESS_BUSINESS);
        return "redirect:/showBusiness.do";
      } else {
        model.addAttribute("message", IConstant.FAILURE_BUSINESS);
        return "redirect:/showBusiness.do";
      }
    } else {
      status = branchService.businessEventInfoAdd(branch);
      if (status) {
        model.addAttribute("message", IConstant.BUSIESS_SUCCESS);
        return "redirect:/businessUpdate.do";
      } else {
        model.addAttribute("message", IConstant.BUSINESS_FAILURE);
        return "redirect:/showBusiness.do";
      }
    }
  }

  /**
   * Method for show Event Register page.
   */
  @RequestMapping("/eventUpdate")
  public String showEventPage(Map<String, Object> map, Model model,
      @RequestParam(required = false) String message, HttpServletRequest request) {
    HttpSession session = request.getSession();
    BusinessAndEventInformation loginMember = (BusinessAndEventInformation) session
        .getAttribute("login");
    if (loginMember != null) {
      model.addAttribute("message", message);
      map.put("Branch", new Branch());
      return "eventUpdate";
    } else {
      return "redirect:/signIn.do";
    }
  }

  /**
   * eventUpdateAction Method is use to save event information.
   * If branchId not equal to null then use for edit event information.
   */
  @RequestMapping(value = "/addEventInformation", method = RequestMethod.POST)
  public String eventUpdateAction(@ModelAttribute("Branch") Branch branch, BindingResult result,
      ModelMap model, Map<String, Object> map, HttpServletRequest request) {
    boolean status = false;
    eventValidator.validate(branch, result);
    if (result.hasErrors()) {
      return "eventUpdate";
    }
    HttpSession session = request.getSession();
    BusinessAndEventInformation loginMember = (BusinessAndEventInformation) session
        .getAttribute("login");
    BusinessAndEventInformation businessAndEventInformation = new BusinessAndEventInformation();
    businessAndEventInformation.setBusinessEventID(loginMember.getBusinessEventID());
    branch.setBusinessAndEventInformation(businessAndEventInformation);
    model.put("Branch", new Branch());
    if (branch.getBranchId() != null) {
      status = branchService.addEventInformation(branch);
      if (status) {
        model.addAttribute("message", IConstant.SUCCESS_EVENT_UPDATE);
        return "redirect:/showEvent.do";
      } else {
        model.addAttribute("message", IConstant.FAILURE_EVENT_UPDATE);
        return "redirect:/showEvent.do";
      }
    } else {
      status = branchService.addEventInformation(branch);
      if (status) {
        model.addAttribute("message", IConstant.EVENT_SUCCESS);
        return "redirect:/eventUpdate.do";
      } else {
        model.addAttribute("message", IConstant.EVENT_FAILURE);
        return "redirect:/eventUpdate.do";
      }
    }

  }

  /**
   * Method showBusinessPage for show Register Business
   */
  @RequestMapping("/showBusiness")
  public String showBusinessPage(Map<String, Object> map, Model model,HttpServletRequest request,@RequestParam(required = false) String message) {
    HttpSession session = request.getSession();
    BusinessAndEventInformation loginMember = (BusinessAndEventInformation) session
        .getAttribute("login");
    if (loginMember != null) {
      Integer businessAndEventId = loginMember.getBusinessEventID();
      map.put("Branch", new Branch());
      List<Branch> businessList = null;
      businessList = branchService.getbusiness(businessAndEventId);
      if (businessList != null) {
        model.addAttribute("businessList", businessList);
        model.addAttribute("message", message);
      }
      return "showBusiness";
    } else {
      return "business";
    }
  }
  /**
   * updateBusinessEvent() for get business information from database for edit business information.
   * @param branchId
   */
  @RequestMapping(value = "/updateBusiness", method = { RequestMethod.GET, RequestMethod.POST })
  public String updateBusinessEvent(@ModelAttribute("Branch") Branch branch, BindingResult result,
      ModelMap model, HttpServletRequest request, @RequestParam(required = false) Integer branchId) {
    branch = branchService.getBusinessInfoById(branchId);
    String music = branch.getMusic();
    String catagory = branch.getBranchType();
    model.put("Branch", branch);
    model.addAttribute("catagory", catagory);
    model.addAttribute("music", music);
    List<Catageory> catageoryList = new ArrayList<Catageory>();
    catageoryList = catageoryService.getAllCatageoryName();
    if (catageoryList != null) {
      model.addAttribute("catageory", catageoryList);
    }
    return "editBusiness";
  }

  /**
   * Method showEventPage for show Register Event
   */
  @RequestMapping("/showEvent")
  public String showEventPage(Map<String, Object> map, Model model, HttpServletRequest request,@RequestParam(required = false) String message) {
    HttpSession session = request.getSession();
    BusinessAndEventInformation loginMember = (BusinessAndEventInformation) session
        .getAttribute("login");
    if (loginMember != null) {
      Integer businessAndEventId = loginMember.getBusinessEventID();
      map.put("Branch", new Branch());
      List<Branch> eventList = null;
      eventList = branchService.getEventName(businessAndEventId);
      if (eventList != null) {
        model.addAttribute("eventList", eventList);
        model.addAttribute("message", message);
      }
      return "showEvent";
    } else {
      return "business";
    }
  }
  /**
   * updateEventInfo() is use to  get event information for edit event information.
   * @param branchId 
   */
  @RequestMapping(value = "/updateEvent", method = { RequestMethod.GET, RequestMethod.POST })
  public String updateEventInfo(@ModelAttribute("Branch") Branch branch, BindingResult result,
      ModelMap model, HttpServletRequest request, @RequestParam(required = false) Integer branchId) {
    branch = branchService.getBusinessInfoById(branchId);
    model.put("Branch", branch);
    return "editEvent";
  }
  
  /**
   * getStateByCountryID() is use to get sub category corresponding to category from database.
   * @param categoryId
   */
  @RequestMapping(value = "/subCategoryByCategory", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, List<Object>> getStateByCountryID(@RequestParam Integer categoryId) {
    System.out.println("categoryId" + categoryId);
    List<Object> subCategoryList = new ArrayList<Object>();
    Map<String, List<Object>> stateMap = new HashMap<String, List<Object>>();
    if (categoryId != null) {
      subCategoryList = branchService.getSubCategoryName(categoryId);
      stateMap.put("subCategoryList", subCategoryList);
    }
    return stateMap;
  }
  /**
   * showEditBusinessPage() for show edit business page.
   */
  @RequestMapping("/editBusiness")
  public String showEditBusinessPage(Map<String, Object> map, Model model,
      @RequestParam(required = false) String message, HttpServletRequest request) {
    HttpSession session = request.getSession();
    BusinessAndEventInformation loginMember = (BusinessAndEventInformation) session
        .getAttribute("login");
    if (loginMember != null) {
      model.addAttribute("message", message);
      map.put("Branch", new Branch());
      List<Catageory> catageoryList = new ArrayList<Catageory>();
      catageoryList = catageoryService.getAllCatageoryName();
      if (catageoryList != null) {
        model.addAttribute("catageory", catageoryList);
      }
      return "editBusiness";
    } else {
      return "redirect:/signIn.do";
    }
  }
  /**
   * showEditEventPage() for show edit event page.
   */
  @RequestMapping("/editEvent")
  public String showEditEventPage(Map<String, Object> map, Model model,
      @RequestParam(required = false) String message, HttpServletRequest request) {
    HttpSession session = request.getSession();
    BusinessAndEventInformation loginMember = (BusinessAndEventInformation) session
        .getAttribute("login");
    if (loginMember != null) {
      model.addAttribute("message", message);
      map.put("Branch", new Branch());
      return "editEvent";
    } else {
      return "redirect:/signIn.do";
    }
  }
}
