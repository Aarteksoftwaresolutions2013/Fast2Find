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
function subCatValidate()
{
  var category=document.getElementById("category").value;
  if(category==0)
    {
    alert("Please select atleast one Category");
    return false;
    }
}
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
    top:325px;
  }
}
</style>
</head>
<body>
<div class="main-contentpagesub" id="main-contentpagesub">
<div class="formsub">
<form:form method="POST" action="addSubCatageoryAction.do" modelAttribute="SubCatageory"  name="subcategory"  id="subcat" autocomplete="off"  >
<p style="color: red;font-size: 0.9em;font-weight: bold;">${message}</p>
<p style="color: red;font-size: 0.9em;font-weight: bold;">${message2}</p>
<label> <span>Add SubCategory</span> </label>
<form:select path="catageory.catageoryId" class="catselect" name="category" id="category">
<form:option value="0" label="Select Category"/>
<c:forEach items="${catageory}" var="refCatageory">
<form:option value="${refCatageory.catageoryId}" label="${refCatageory.catageoryName}" />
</c:forEach>
</form:select>
<form:errors path="catageory.catageoryId" cssClass="error"></form:errors>
<form:hidden path="subCatageoryId"/>
<form:input path="subCatageoryName"  id="addsub-cat" placeholder="Sub Category" required="autofocus" maxlength="40" onkeyup="Validate(this)" />
<form:errors path="subCatageoryName" cssClass="error"></form:errors>
<c:choose>
    <c:when test="${SubCatageory.subCatageoryId!=null}">
    <button name="addsub" value="subcategory" class="subad"> Update </button>
    </c:when>
    <c:otherwise>
    <button name="addsub" value="subcategory" class="subad" onclick="return subCatValidate()"> Add </button>
    </c:otherwise>
  </c:choose>
</form:form>  
</div>
</div>
<c:set var="count" value="0" scope="page" />
<display:table name="subCatageoryList" pagesize="8" class="table"  uid="subCat" requestURI="subCatageory.do" style="width:1000px"  >
     <c:set var="count" value="${count+1}" scope="page" />
     <display:column  title="S.NO"  style="width:150px">
     ${count}
    </display:column>
     <display:column property="catageory.catageoryName" title="CATEGORY NAME" style="width:280px"  />
     <display:column property="subCatageoryName" title="SUBCATEGORY NAME" style="width:280px"  />
      <display:column  title="Edit" ><a  href="editSubCatageory.do?subCatageoryId=${subCat.subCatageoryId}"  style="width:150px">Edit</a></display:column>
     <display:column  title="Delete" ><a  href="deleteSubCatageory.do?subCatageoryId=${subCat.subCatageoryId}" onclick="return confirm('Please confirm if you want to delete this sub category');" style="width:150px" >Delete</a></display:column>
      <display:setProperty name="paging.banner.item_name" value="sub category" />
       <display:setProperty name="paging.banner.items_name" value="sub categories" />
  </display:table>
</body>
</html>