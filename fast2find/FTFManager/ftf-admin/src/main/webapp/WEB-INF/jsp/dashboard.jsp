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
width: 90%;
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
    left: 917px;
    top:218px;
  }
}
</style>
</head>
<body>
 <div style="float:left;width:100%;">
<font size="5"><a href="catageory.do" ><b>ADD CATEGORY</b></a></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<font size="5"><a href="subCatageory.do" ><b>ADD SUB CATEGORY</b></a></font>
</div>
<p>&nbsp;&nbsp;</p>
<table>
<tr>
<td>
 <div style="float:left;width:100%;">
 <h4 align="left">Category And Sub Category</h4>
 <p>&nbsp;&nbsp;&nbsp;</p>
<c:set var="count" value="0" scope="page" />
<display:table name="list" pagesize="10" class="table"  uid="cat" requestURI="dashboard.do" >
 <c:set var="count" value="${count+1}" scope="page" />
     <display:column  title="S.NO" style="width:200px">
     ${count}
    </display:column>
     <display:column title="CATEGORY NAME"  style="width:400px">${cat.CATEGORY}</display:column>
     <display:column title="SUBCATEGORY NAME" style="width:400px" >${cat.SUB_CATEGORY}</display:column>
        <display:setProperty name="paging.banner.item_name" value="category and sub category" />
       <display:setProperty name="paging.banner.items_name" value="categories and sub categories" />
     </display:table></div>
</td>
</tr>
</table>
</body>
</html>