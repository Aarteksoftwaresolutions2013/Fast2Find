<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/hilitor.js"></script>
<script type="text/javascript">
var b = document.documentElement;
b.setAttribute('data-useragent',  navigator.userAgent);
</script>
</head>
<body>
<div id="playground">
<div class="sup-wrp-content">
      <div class="supp-serchfrm">
      <form action="#" method="post">
      <input id="search-ctgory" type="search" placeholder="Search" >
      </form>
      </div><!-----supp-serchfrm------>
      <div class="inn-cont-wrp">
      <h2>Browse questions by category</h2>
      <div class="cont-wrp">
      <ul>
      <li><a href="about.do">About Fast2Find</a></li>
      <li><a href="#">Account Settings & Security</a></li>
      <li><a href="#">Announcements</a></li>
      </ul>
      </div><!-----end cont-wrp----->
      </div><!-----inn-cont-wrp------->
      </div><!-----end sup-wrp-content-------->
      </div>
<script type="text/javascript">
var myHilitor2;
document.addEventListener("DOMContentLoaded", function() {
myHilitor2 = new Hilitor("playground");
myHilitor2.setMatchType("left");
}, false);
document.getElementById("search-ctgory").addEventListener("keyup", function() {
myHilitor2.apply(this.value);
}, false);
</script>
</body>
</html>