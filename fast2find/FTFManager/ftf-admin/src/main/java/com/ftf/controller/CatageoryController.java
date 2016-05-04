package com.ftf.controller;

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
import com.ftf.service.CatageoryService;

@Controller
public class CatageoryController {

  @Autowired
  private CatageoryService catageoryService;

  @RequestMapping("/landingPage")
  public String showFirstPage(Map<String, Object> map, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    Login loginMember = (Login) session.getAttribute("loginType");
    if (loginMember != null) {
      return "landingPage";
    } else {
      return "redirect:/signIn.do";
    }
  }

  @RequestMapping("/catageory")
  public String showCatageoryPage(Map<String, Object> map, Model model, HttpServletRequest request,
      @RequestParam(required = false) String message,@RequestParam(required = false) String message2) {
    HttpSession session = request.getSession();
    Login loginMember = (Login) session.getAttribute("loginType");
    if (loginMember != null) {
      List<Catageory> catageoryList = null;
      catageoryList = catageoryService.getAllCatageoryName();
      if (catageoryList != null) {
        model.addAttribute("catageoryList", catageoryList);
      }
      model.addAttribute("message", message);
      model.addAttribute("message2", message2);
      map.put("Catageory", new Catageory());
      return "catageory";
    } else {
      return "redirect:/signIn.do";
    }
  }

  @RequestMapping(value = "/addCatageoryAction", method = RequestMethod.POST)
  public String feedbackInfo(@ModelAttribute("Catageory") Catageory catageory,
      BindingResult result, ModelMap model, Map<String, Object> map) {
    boolean status = false;
    model.put("Catageory", new Catageory());
    if (catageory.getCatageoryId() != null) {
      status = catageoryService.addCatageory(catageory);
      if (status) {
        model.addAttribute("message", "Category has been updated successfully!");
      } else {
        model.addAttribute("message", "Error In Catageory Updated");
      }
      return "redirect:/catageory.do";
    } else {
      status = catageoryService.addCatageory(catageory);
      if (status) {
        model.addAttribute("message", "Category added successfully!");
      } else {
        model.addAttribute("message", "Category name already exists,please enter other category name");
      }
      return "redirect:/catageory.do";
    }
  }

  @RequestMapping("/viewCatageory")
  public String viewCatageory(Map<String, Object> map, Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    Login loginMember = (Login) session.getAttribute("loginType");
    if (loginMember != null) {
      List<Catageory> catageoryList = null;
      catageoryList = catageoryService.getAllCatageoryName();
      if (catageoryList != null) {
        model.addAttribute("catageoryList", catageoryList);
      }
      return "viewCatageory";
    } else {
      return "redirect:/signIn.do";
    }
  }

  @RequestMapping(value = "/editCatageory", method = { RequestMethod.GET, RequestMethod.POST })
  public String editCatageory(@ModelAttribute("Catageory") Catageory catageory,
      BindingResult result, ModelMap model, HttpServletRequest request,
      @RequestParam(required = false) Integer catageoryId) {
    catageory = catageoryService.getInfoForEdit(catageoryId);
    List<Catageory> catageoryList = null;
    catageoryList = catageoryService.getAllCatageoryName();
    if (catageoryList != null) {
      model.addAttribute("catageoryList", catageoryList);
    }
    model.put("Catageory", catageory);
    return "catageory";
  }

  @RequestMapping(value = "/deleteCatageory", method = { RequestMethod.GET, RequestMethod.POST })
  public String deleteCatageory(@ModelAttribute("Catageory") Catageory catageory,
      BindingResult result, ModelMap model, HttpServletRequest request,
      @RequestParam(required = false) Integer catageoryId) {
    catageoryService.deleteCatageory(catageoryId);
    model.addAttribute("message", "Category deleted successfully!");
    return "redirect:/catageory.do";
  }
}
