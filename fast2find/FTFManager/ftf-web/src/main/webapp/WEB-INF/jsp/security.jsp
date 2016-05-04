<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sc" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/styleb.css" media="screen">
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jsp-js/security.js"></script>
</head>
<body>
 <!--------========================page-content==========================---------->
        <div id="page-content" class="page-content">
        <h1>Get Back into Fast2Find Account</h1>
        <span>Need to reset password and security information. Please enter your account email or username.</span>
        <font color="red">${message}</font>
        <div id="security-page-from" class="securty-pge-from">
        <form:form method="POST" action="recaptcha.do" modelAttribute="Login" name="email" id="email-id" autocomplete="off" >
        <ul>
        
        <li>
        <label for="user-mail"><span></span></label>
        <form:errors path="emailId" cssStyle="color: red;font-size: 0.7em;font-weight: bold;"></form:errors>
        <!-- <input type="email" name="user-mail" id="user-mail" required placeholder="Email Address or Username" /> -->  
          <form:input path="emailId" name="user-mail" id="user-mail" placeholder="Email Address or Username" required ="autofocus" maxlength="100" onkeyup="checkspecialcharacter(this)" />
        </li>
        
        <li>
        <label for="captch"><span></span></label>
        <sc:captcha/>
        </li>
        
        <li>
        <label for="reset-mail"><span></span></label>
        <input type="submit" value="Submit" name="Reset" id="reset-mail" />
        </li>
        </ul>
        
      </form:form>
      </div><!-----end securty-pge-from---->
      </div><!----========================end page-content==========================---------->   
</body>
</html>