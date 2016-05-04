<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jsp-js/signIn.js"></script>
  <script type="text/javascript" src="js/jquery.cookie.js"></script>
   <script type="text/javascript" src="js/jsp-js/login.js"></script> 
<link rel="stylesheet" type="text/css" href="css/styleb.css" media="screen">
</head>
<body>
 <div id="unpaid-page" class="unpaid-page">
      <!----------form----------id----------->
      <form:form method="POST" action="userSignIn.do" modelAttribute="Login" name="signup_page_frm" id="signup-page-frm" autocomplete="off" >
      <h2>Sign in</h2>
      <h4>${message}</h4>
      <ul id="signup-nam">
      <li>
      <label for="user-name"><span></span></label>
      <form:errors path="emailId" cssClass="error"></form:errors>
      <form:input path="emailId" id="user-name" placeholder="Please enter your email" required="autofocus" maxlength="50" />
      </li>
      <li>
      <label for="user-password"><span></span></label>
      <form:errors path="password" cssClass="error"></form:errors>
      <form:password path="password" id="user-password" placeholder="Password" required="autofocus" maxlength="15" />
      </li>
      <li>
      <input type="checkbox" id="stying" />
      <label for="stying"><span></span>Stay Signed in</label>
      <a href="security.do" class="unable">Unable to access account?</a>
      <li>
       <li>
      <li>
      <li class="sssgni">
      <input type="submit" id="user-sign" value="Sign in"  onclick="remeberMe();"/>
      </li>
      </ul>
      </form:form>
      <hr class="unpd">
        <div class="signhave">
        <h2>Sign up</h2>
        <span>Do not have a Fast2Find account? </span>
        <a href="registration.do" class="singnow">Sign up Now</a>
          <div class="links-pages"> 
        <ul><li>
        <a href="feedback.do">Feedback</a></li>
        <li><a href="help.do">Help Area</a></li>
        <li><a href="termAndCondition.do">Terms and conditions </a></li>
        <li><a href="privacyPolicy.do">Privacy Policy </a></li>
          </ul>
        </div>
        </div><!-----end signhave------->
      </div><!------end unpaid-page----> 
</body>
</html>