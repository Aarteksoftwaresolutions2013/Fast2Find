<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script> -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/tablestyle.css" />
</head>
<body>
<h3 align="center" >${message}</h3>
<h3 align="center">Your Registered Business List</h3>
<div class="table-contentmain">
<c:choose>
<c:when test="${!empty businessList}">
<table border="0px" cellpadding="0" cellspacing="0" class="mid_table">
      <thead>
<tr>
<th class="sortable">S.NO</th>
<th class="thb">BUSINESS NAME</th>
<th class="thc">MAXCAPACITY</th>
<th class="thb">CONTACT NO.</th>
<th class="thd">LOCATION</th>
<th class="the">EDIT</th></tr></thead>
  <tbody>
  <c:set var="count" value="0" scope="page" />
  <c:forEach items="${businessList}" var="business">
  <c:set var="count" value="${count+1}" scope="page" />
  <tr>
  <td>&nbsp;&nbsp;${count}</td>
  <td>${business[1]}</td>
  <td>${business[2]}</td>
    <td>${business[4]}</td>
  <td>${business[3]}</td>
  <td class="edtd"><a  href="updateBusiness.do?branchId=${business[0]}"><button class="edit" value="Edit">Edit</button></a></td>
  </tr>
  </c:forEach>
  </tbody>
  </table>
  </c:when>
<c:otherwise>
<c:out value="NO Business Register , Please Register Business "></c:out>
</c:otherwise>
</c:choose>
</div>
    <!-- <div class="pagination clearfix">
  <a href="#">First</a>
  &nbsp;<a href="#">«</a>
  
  <a href="#">1</a>
  <strong>2</strong>
  <a href="#">3</a>
  
  <a href="#">»</a>
  &nbsp;<a href="#">Last</a>
</div> -->
</body>
</html>