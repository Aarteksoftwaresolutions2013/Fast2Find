<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
 <script type="text/javascript" src="../ftf-web/js/jquery.js"></script>  
 <script type="text/javascript" src="../ftf-web/js/jquery-ui.js"></script>     
 <script type="text/javascript" src="../ftf-web/js/highcharts.js"></script> 
 <script type="text/javascript" src="../ftf-web/js/exporting.js"></script>  
 <script  type="text/javascript" src="../ftf-web/js/data.js"></script>
<script type="text/javascript" src="../ftf-web/js/highslide-full.min.js"></script>
<script type="text/javascript" src="../ftf-web/js/highslide.config.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="http://www.highcharts.com/media/com_demo/highslide.css" />                                      
 <script type="text/javascript" src="../ftf-web/js/report.js"></script>                                     
<script type="text/javascript" src="js/jsp-js/generateReport.js"></script>
</head>
<body>
<form:form method="POST"  modelAttribute="Branch" autocomplete="off">
 <br>
<span id=branchId style="display:none;  class="error" >Business name must be selected!</span>  
 <h4>&nbsp;&nbsp;&nbsp;&nbsp;Business Name&nbsp;&nbsp;&nbsp;
 <form:select path="branchId" id="sign-gbal" onchange="clear_div()" >
            <form:option value="0" label="Select" />
            <c:forEach items="${branchIdList}" var="branchList">
              <form:option value="${branchList[0]}" label="${branchList[1]}" />
            </c:forEach>
          </form:select></h4>
<p></p>
&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"  value="7 Days" onclick="getWeeklyData()" id="event-pagesubmit"/>
<input type="button"  value="30 Days" onclick="getMonthlyData()" id="event-pagesubmit" />
<input type="button"  value="90 Days"  onclick="getThreeMonthlyData()"id="event-pagesubmit" />
<input type="button"  value="1 Year"  onclick="getYearlyData()" id="event-pagesubmit" />
<!-- <div id="container" style="min-width: 210px; height: 400px; margin: 0 ; float: left"></div> -->
<center>
<div id="container" style=" width:80%; height:120%; float:center">
</div>
</center>
<center> 
<div id="container1" style="width:80%; height:120%;  float:center">
</div>
</center>

<center><div id="container2" style="   width:80%; height:120%; float:center">   
</div>
</center>
<center><div id="container3" style=" width:80%; height:120%;   float:center">
</div>  
</center>
 <center><b> <div id="statusInfo"></div> </b></center>  
 <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p> 
 <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p> 
 <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
  </form:form> 
</body>       
</html>