<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>
<div id="footer" class="footer">
      <div class="footer-inner">
      <div id="footer-widget" class="footer-widget">
      <h3>about us</h3>
      <p>Fast2Find was founded in 2014 to help people find great local venues e.g. Special Events, Club Family, Bar/Pub/Tavern/Saloon, Arena, Restaurant, Stadium </p>
      </div>
      <div id="recent-catagory" class="recent-catagory">
      <h3></h3>
      </div>
        
      <div id="form" class="form">
      <div id="info" style="color: green;"></div>
      <h3>Quick Contact</h3>
      <div id="contact-form" class="contact-form">
         <form autocomplete="off" >
               <input type="hidden" name="action" value="submit" required />
                Name:<br />
                 <input type="text" name="name" id="name" size="30" maxlength="30" onblur="nameEmpty()" onkeyup="onlyAlph(event,this)" /> <br /> 
                <span id="nameId" style="display:none;" >Please Enter Name</span>
                Email:<br /> 
                  <input type="text" name="emailId" id="email1" size="30" maxlength="50" onblur="visitorEmail()"/> <br /> 
                 <span id="emailID" style="display:none;" >Please Enter Email Address</span>
                 <span id="emailMsgId" style="display:none;" >Invalid Email Address</span>
                Message:<br />
                   <textarea name="message" id="message" rows="7" cols="30" maxlength="150" ></textarea> <br />
                 <span id="msgId" style="display:none;" >Please Enter Message</span>
                <input type="button" value="Submit" id="submit" class="subm" onclick="doAjaxPost()" />
          </form>
      </div><!-----end contact-form---->
      </div><!-----end form div---->
      </div><!-----end footer-inner---->
      </div><!----end footer----->
      <div class="bottom">
      <span class="copy_right">© Domain.com 2014</span>
      </div>
</body>
</html>