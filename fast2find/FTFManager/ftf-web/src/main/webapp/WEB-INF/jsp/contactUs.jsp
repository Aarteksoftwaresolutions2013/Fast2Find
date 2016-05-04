<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jsp-js/contactUs.js"></script>
</head>
<body>
<div class="contact-main" id="contact-pag">
      <div class="contact-frm">
      <h3>${message}</h3>
      <h2 class="elec">PLEASE SEND US YOUR QUERY/MESSAGE!</h2>
      <form:form modelAttribute="ContactUs" action="contactAction.do" method="post" id="contact-form" autocomplete="off" >
      <p>
            <label for="name"></label>
            <form:input path="name" id="name"  placeholder="Your Name" required ="autofocus" maxlength="50" onkeyup="onlyAlph(event,this)" />
          </p>
          <p><form:errors path="name"  cssClass="error"></form:errors> </p>
            <p>
            <label for="company"></label>
            <form:input path="companyName" id="company"  placeholder="Company" required ="autofocus" maxlength="50"  onkeyup="onlyAlph(event,this)" />
          </p>
          <p><form:errors path="companyName"  cssClass="error"></form:errors> </p>
          <p>
            <label for="emaili"></label>
            <form:input path="emailId" id="email1"  placeholder="Email Address" required ="autofocus" maxlength="80" onblur="visitorEmail()" onkeyup="emailVali(this)"/>
            <span id="emailMsgId" style="display:none;" >Invalid Email Address</span>
          </p>
          <p><form:errors path="emailId"  cssClass="error"></form:errors> </p>
          <p>
            <label for="phone"></label>
            <form:input path="mobileNo"  id="phone"   placeholder="Phone Number" required ="autofocus" maxlength="15" onkeyup="num(event,this)"/>
          </p>
          <p><form:errors path="mobileNo"  cssClass="error"></form:errors> </p>
          <p>
            <label for="location"></label>
            <form:input path="city" id="location"  placeholder="Location (city)" required ="autofocus" maxlength="30"  onkeyup="onlyAlph(event,this)" />
          </p>
          <p><form:errors path="city"  cssClass="error"></form:errors> </p>
          <p>
            <label for="message"></label>
            <form:textarea path="message" rows="5"  id="tx" placeholder="Message"  required ="autofocus" maxlength="250" />
          </p>
          <p><form:errors path="message"  cssClass="error"></form:errors> </p>
      <p>
      <input type="submit" value="Submit" id="cnt-sbmit" />
      </p>
    </form:form>
      </div><!----end contact-frm-----> 
      <div class="frm-dsi">
      <div class="onpad">
      <h5> Phone </h5>
      <!-- <span class="det">City</span> -->
      <p> 1-701-214-4566</p>
       <!-- <h5> Fax </h5> -->
      <!--<p>780 639 1424</p> -->
      <h5> Email </h5>
      <span class="det">general inquiries</span>
      <p>Fast2Find@outlook.com</p>
      <span class="det">catering inquiries</span>
      <p>Fast2Find@outlook.com</p>
      </div><!------end onpad----->
      </div><!-------end frm-dsi----> 
      </div><!-----end contact pag div here-----> 
</body>
</html>