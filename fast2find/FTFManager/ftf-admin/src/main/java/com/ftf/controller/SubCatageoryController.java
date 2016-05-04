package com.ftf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ftf.model.Catageory;
import com.ftf.model.Login;
import com.ftf.model.SubCatageory;
import com.ftf.service.CatageoryService;
import com.ftf.service.SubCatageoryService;
import com.ftf.validator.SubCategoryValidator;

@Controller
public class SubCatageoryController {

  @Autowired
  private CatageoryService catageoryService;

  @Autowired
  private SubCatageoryService subCatageoryService;

  @Autowired
  private SubCategoryValidator subCategoryValidator;

  @RequestMapping("/subCatageory")
  public String showSubCatageoryPage(Map<String, Object> map, Model model,
      HttpServletRequest request, @RequestParam(required = false) String message,@RequestParam(required = false) String message2) {
    HttpSession session = request.getSession();
    Login loginMember = (Login) session.getAttribute("loginType");
    if (loginMember != null) {
      model.addAttribute("message", message);
      model.addAttribute("message2", message2);
      map.put("SubCatageory", new SubCatageory());
      List<Catageory> catageoryList = new ArrayList<Catageory>();
      catageoryList = catageoryService.getAllCatageoryName();
      if (catageoryList != null) {
        model.addAttribute("catageory", catageoryList);
      }
      List<SubCatageory> subCatageoryList = null;
      subCatageoryList = subCatageoryService.getAllSubCatageoryName();
      if (subCatageoryList != null) {
        model.addAttribute("subCatageoryList", subCatageoryList);
      }
      return "subCatageory";
    } else {
      return "redirect:/signIn.do";
    }
  }

  @RequestMapping(value = "/addSubCatageoryAction", method = RequestMethod.POST)
  public String feedbackInfo(@ModelAttribute("SubCatageory") SubCatageory subCatageory,
      BindingResult result, ModelMap model, Map<String, Object> map) {
    boolean status = false;
    List<Catageory> catageoryList = new ArrayList<Catageory>();
    List<SubCatageory> subCatageoryList = null;
    model.put("SubCatageory", new SubCatageory());
    subCategoryValidator.validate(subCatageory, result);
    if (result.hasErrors()) {
      catageoryList = catageoryService.getAllCatageoryName();
      subCatageoryList = subCatageoryService.getAllSubCatageoryName();
      if (catageoryList != null) {
        model.addAttribute("catageory", catageoryList);
      }
      if (subCatageoryList != null) {
        model.addAttribute("subCatageoryList", subCatageoryList);
      }
      return "subCatageory";
    }
    if (subCatageory.getSubCatageoryId() != null) {
      status = subCatageoryService.addSubCatageory(subCatageory);
      if (status) {
        model.addAttribute("message", "Sub Category has been updated successfully!");
      } else {
        model.addAttribute("message", "Error In SubCatageory Updated");
      }
      return "redirect:/subCatageory.do";
    } else {
      status = subCatageoryService.addSubCatageory(subCatageory);
      if (status) {
        model.addAttribute("message", "Sub Category added successfully!");
      } else {
        model.addAttribute("message", "Subcategory name already exists,please enter other Subcategory name");
      }
      return "redirect:/subCatageory.do";
    }
  }

  @RequestMapping("/viewSubCatageory")
  public String viewSubCatageory(Map<String, Object> map, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    Login loginMember = (Login) session.getAttribute("loginType");
    if (loginMember != null) {
      List<SubCatageory> subCatageoryList = null;
      subCatageoryList = subCatageoryService.getAllSubCatageoryName();
      if (subCatageoryList != null) {
        model.addAttribute("subCatageoryList", subCatageoryList);
      }
      return "viewSubCatageory";
    } else {
      return "redirect:/signIn.do";
    }
  }

  @RequestMapping(value = "/editSubCatageory", method = { RequestMethod.GET, RequestMethod.POST })
  public String editsubCat(@ModelAttribute("SubCatageory") SubCatageory subCatageory,
      BindingResult result, ModelMap model, HttpServletRequest request,
      @RequestParam(required = false) Integer subCatageoryId) {
    List<Catageory> catageoryList = new ArrayList<Catageory>();
    catageoryList = catageoryService.getAllCatageoryName();
    if (catageoryList != null) {
      model.addAttribute("catageory", catageoryList);
    }
    subCatageory = subCatageoryService.getInfoForEdit(subCatageoryId);
    model.put("SubCatageory", subCatageory);
    List<SubCatageory> subCatageoryList = null;
    subCatageoryList = subCatageoryService.getAllSubCatageoryName();
    if (subCatageoryList != null) {
      model.addAttribute("subCatageoryList", subCatageoryList);
    }
    return "subCatageory";
  }

  @RequestMapping(value = "/deleteSubCatageory", method = { RequestMethod.GET, RequestMethod.POST })
  public String deleteCatageory(@ModelAttribute("SubCatageory") SubCatageory subCatageory,
      BindingResult result, ModelMap model, HttpServletRequest request,
      @RequestParam(required = false) Integer subCatageoryId) {
    subCatageoryService.deleteSubCatageory(subCatageoryId);
    model.addAttribute("message", "Subcategory deleted successfully!");
    return "redirect:/subCatageory.do";
  }
}
