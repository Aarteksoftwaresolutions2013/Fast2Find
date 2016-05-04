<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" type="text/css" href="css/pages.min.css" />
<link rel="stylesheet" type="text/css" href="css/css" />
<link href="css/bootstrap.min.css" media="all" rel="stylesheet" type="text/css" id="bootstrap-css">
<link href="css/adminflare.min.css" media="all" rel="stylesheet" type="text/css" id="adminflare-css">
<script src="js/modernizr-jquery.min.js" type="text/javascript"></script>
<script src="js/adminflare-demo.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/adminflare-demo-init.min.js"></script>
<title>Log in</title> 
<script type="text/javascript">
    $(document).ready(function() {
    /*  $('#signin-container').submit(function() {
        document.location = 'Dashboard/dashboard.htm';
        return false;
      }); */
      var updateBoxPosition = function() {
        $('#signin-container').css({
          'margin-top': ($(window).height() - $('#signin-container').height()) / 2
        });
      };
      $(window).resize(updateBoxPosition);
      setTimeout(updateBoxPosition, 50);
    });
  </script>
</head>
<body class="signin-page" >
  <section id="signin-container" style="margin-top: 80px;">
    <a href="#" title="AdminFlare" class="header">
      <img src="images/af-logo-signin.png" alt="Fist2find">
      <span>
        Login<br>
        <strong>Admin</strong>
      </span>
    </a>
    <h3>${message}</h3>
    <form:form method="POST" action="userSignIn.do" modelAttribute="Login"  autocomplete="off"  >
      <fieldset>
          <form:errors path="emailId" cssClass="error"></form:errors>
        <form:errors path="password" cssClass="error"></form:errors>
        <div class="fields">
          <form:input path="emailId" name="username" placeholder="Username" id="id_username" tabindex="1" required="autofocus" maxlength="50" />
          <form:password path="password"  name="password" placeholder="Password" id="id_password" tabindex="2" required="autofocus" maxlength="15" />
        </div>
        <a href="http://fast2find.com/ftf-web/signIn.do" title="" tabindex="3" class="forgot-password"><!-- Forgot? -->Back To Fast2Find</a>
        <button type="submit" class="btn btn-primary btn-block" tabindex="4">Log in</button>
      </fieldset>
  </form:form>
    <div class="social">
      <p>manage your pages</p>
<div class="soci">
      <a href="https://twitter.com/fast2find" title="" tabindex="5" class="twitter">
        <i class="icon-twitter"></i>
      </a>
      <a href="https://facebook.com/fast2find" title="" tabindex="6" class="facebook">
        <i class="icon-facebook"></i>
      </a>
      <a href="https://plus.google.com/115711491255478144290"  title="" tabindex="7" class="google">
        <i class="icon-google-plus"></i>
      </a>
    </div></div>
  </section>
</body>
</html>