<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.mid_tbl{
	border: 1px solid #CCC;
}
.mid_tbl th{
	text-align: left;
	background-color: #d4d4d4;
	padding-top: 8px;
	padding-right: 3px;
	padding-bottom: 8px;
	padding-left: 3px;
	font-size: 13px;
}
.mid_tbl td{
	padding-top: 8px;
	padding-right: 3px;
	padding-bottom: 8px;
	padding-left: 3px;
	background-color: #f5f4f4;
}
</style>
</head>
<body>
<h3 align="center">Your Registered Business Category List</h3>
<c:set var="count" value="0" scope="page" />
<display:table name="catageoryList" pagesize="10" class="mid_tbl"  uid="cat" requestURI="viewCatageory.do" style="width:1000px"  >
		 <display:column  title="S.NO"  sortable="true" style="width:200px">
		<c:set var="count" value="${count+1}" scope="page" />${count}
		</display:column>
		 <display:column property="catageoryName" title="CATEGORY NAME" style="width:500px"  />
		  <display:column  title="Edit" ><a  href="editCatageory.do?catageoryId=${cat.catageoryId}"  style="width:200px">Edit</a></display:column>
		 <display:column  title="Delete" ><a  href="deleteCatageory.do?catageoryId=${cat.catageoryId}" onclick="return confirm('Are you sure !!! you want to delete?');" style="width:200px" >Delete</a></display:column>
	</display:table>
</body>
</html>