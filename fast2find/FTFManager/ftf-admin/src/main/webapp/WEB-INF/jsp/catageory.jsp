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
<script type="text/javascript" src="js/common.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function () {
  var pagelinkValue = $('.pagelinks').map(function(){
  return $(this).text();
  }).get();
  if(pagelinkValue==1)
  $(".pagelinks").hide();
  };
</script>
<style type="text/css">
td {
font-size: 0.90em;
font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;
font-size: 12px;
}
th {
font-size: 0.90em;
border-top: 2px solid #ddd;
border-right: 2px solid #ddd;
border-left: 2px solid #666;
border-bottom: 2px solid #666;
}
table {
/* border: 1px dotted #666; */
width: 80%;
margin: 20px 0 20px 0;
}
th,td {
margin: 0;
padding: 0;
text-align: left;
vertical-align: top;
background-repeat: no-repeat;
list-style-type: none;
}
thead tr {
background-color: #bbb;
}
tr.odd {
background-color: #fff;
}
tr.even {
background-color: #ddd;
}
  .pagelinks {
    position:absolute;
    left: 948px;
    top:305px;
  }
}
</style>
</head>
<body>
<div class="main-contentpage" id="main-contentpage">
  <form:form method="POST" action="addCatageoryAction.do" modelAttribute="Catageory" name="addfunctions" id="ui-nam1" class="ui-name-1" autocomplete="off" >  
    <c:choose>
    <c:when test="${Catageory.catageoryId!=null}">
      <p>&nbsp;&nbsp;&nbsp;&nbsp;</p>
    </c:when>
    <c:otherwise>
     <c:choose>
    <c:when test="${message==null}">
      <p>&nbsp;&nbsp;&nbsp;&nbsp;</p>
    </c:when>
      <c:otherwise>
      <h4 style="color: red;font-size: 0.9em;font-weight: bold;">${message2}</h4>
     <h4 style="color: red;font-size: 0.9em;font-weight: bold;">${message}</h4>
       </c:otherwise>
        </c:choose>
    </c:otherwise>
  </c:choose>
  <label> <span>Add Category</span> </label>
  <form:input path="catageoryName"  placeholder="Add Category" required="autofocus" maxlength="40" onkeyup="Validate(this)" />
  <form:hidden path="catageoryId" />
  <c:choose>
    <c:when test="${Catageory.catageoryId!=null}">
    <button name="add" id="addcate" value="Add"> Update </button>
    </c:when>
    <c:otherwise>
    <button name="add" id="addcate" value="Add"> Add </button>
    </c:otherwise>
  </c:choose>
  </form:form>
  </div>
  <c:set var="count" value="0" scope="page" />
<display:table name="catageoryList" pagesize="8" class="table"  uid="cat" requestURI="catageory.do" style="width:1000px"  >
    <c:set var="count" value="${count+1}" scope="page" />
    <display:column  title="S.NO"  style="width:200px" class="showHeading" >
     ${count}
    </display:column>
     <display:column property="catageoryName" title="CATEGORY NAME" style="width:500px"  />
      <display:column  title="Edit" ><a  href="editCatageory.do?catageoryId=${cat.catageoryId}"  style="width:200px">Edit</a></display:column>
     <display:column  title="Delete" ><a  href="deleteCatageory.do?catageoryId=${cat.catageoryId}" onclick="return confirm('Please confirm if you want to delete this category!');" style="width:200px" >Delete</a></display:column>
        <display:setProperty name="paging.banner.item_name" value="category" />
       <display:setProperty name="paging.banner.items_name" value="categories" />
  </display:table>
</body>
</html>