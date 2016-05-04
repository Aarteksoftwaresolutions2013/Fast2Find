<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
 <script type="text/javascript" src="js/jsp-js/showBusinessInfo.js"></script>
<title>Insert title here</title>
</head>
<body>
<!--------========================page-content==========================---------->
      <div id="search-page-content" class="search-page-content">  
      <h1>Search Result</h1>
      <div id="result-table" class="result-table">
      <form action="" name="result-tab" id="result-tab" class="result-tab">
       <c:forEach items="${mapInfoList}" var="info">
      <label for="busnissname" class="busina">Business Name:&nbsp;&nbsp;<b>${info[4]}</b></label>
      <label for="busnisevnt" class="busina">Business or Event Max Capacity:&nbsp;&nbsp;<b>${info[6]}</b></label>
      <label for="busniloction" class="busina">Location Address:&nbsp;&nbsp;<b>${info[14]}</b></label>
      <label for="busnicity" class="busina">City:&nbsp;&nbsp;<b>${info[13]}</b></label>
      <label for="busisate" class="busina">State/Province:&nbsp;&nbsp;<b>${info[15]}</b></label>
      <label for="busnizip" class="busina">Zip/Post Code:&nbsp;&nbsp;<b>${info[16]}</b> </label>
      <label for="busnicontry" class="busina">Country:&nbsp;&nbsp;<b>${info[17]}</b></label>
      <label for="busntick" class="busina">Entry Tickets :<b>&nbsp;&nbsp;$${info[21]}</b> </label>
      <label for="busnicbkpr" class="busina">Quick Booking Fee Per Person: &nbsp;&nbsp;<b>$${info[19]}</b></label>
      <label for="busnibktb" class="busina">Quick Booking Fee Per table:<b>&nbsp;&nbsp;$${info[20]}</b></label>
      <label for="busniservice" class="busina">Executive Table/ Bottle Service Booking :&nbsp;&nbsp;<b>$${info[22]}</b></label>
      <label for="busnihours" class="busina">Hours of Operation:&nbsp;&nbsp;
       <c:set var="openTime" value="${fn:split(info[26], ',')}" />
      <c:set var="closeTime" value="${fn:split(info[27], ',')}" />
      <jsp:useBean id="now1" class="java.util.Date"/>
      <c:if test="${fn:startsWith(now1, 'Mon')}" >
        <b>${openTime[0]}-${closeTime[0]}</b>
      </c:if>
      <c:if test="${fn:startsWith(now1, 'Tue')}" >
       <b> ${openTime[1]}-${closeTime[1]}</b>
      </c:if>
       <c:if test="${fn:startsWith(now1, 'Wed')}" >
        <b>${openTime[2]}-${closeTime[2]}</b>
      </c:if>
       <c:if test="${fn:startsWith(now1, 'Thu')}" >
       <b> ${openTime[3]}-${closeTime[3]}</b>
      </c:if>
       <c:if test="${fn:startsWith(now1, 'Fri')}" >
       <b> ${openTime[4]}-${closeTime[4]}</b>
      </c:if>
       <c:if test="${fn:startsWith(now1, 'Sat')}" >
        <b>${openTime[5]}-${closeTime[5]}</b>
      </c:if>
       <c:if test="${fn:startsWith(now1, 'Sun')}" >
       <b> ${openTime[6]}-${closeTime[6]}</b>
      </c:if>
      </label>
      </c:forEach>
      </form>
      </div><!-----end result-table----->
      
      <h1>Venue Status</h1>
      <div id="venue-stat" class="venue-stat">
      <c:forEach items="${mapInfoList}" var="info">
      <label for="progressbar"><span class="topvalue">${(info[0]-info[2])+(info[1]-info[3])}/${info[6]}</span></label>
      <div id="progressbar" class="prograssbar">
      <!-- <div id="value-pr" class="value-pr"></div> -->
      <div id="value-pr" style="width:${(((info[0]-info[2])+(info[1]-info[3])*100)/info[6])}%" class="value-pr" ></div>
       </div><!-----end progress--->
       <label for="trend"><span class="topvalue">Trend</span></label>
      <div id="trend" class="prograssbar" >
      <div id="trend-pr" class="trend-pr" style="width:${(info[0]+info[1])-(info[2]+info[3])}" ></div>
       </div><!-----end progress--->
      
      <label for="malesvlue"><span class="males188">Males<br />${info[0]-info[2]}</span></span></label>
      <div id="malesvlue" class="prograssbar">
      <div id="malesvlue-pr" class="value-pr" style="width:${((info[0]-info[2])*100)/info[6]}%"></div>
      </div><!-----end progress--->
      
       <label for="Lady"><span class="males188">Lady<br />${info[1]-info[3]}</span></span></label>
      <div id="Lady" class="prograssbar">
      <div id="Lady-pr" class="lady-pr" style="width:${((info[1]-info[3])*100)/info[6]}%"></div>
       </div><!-----end progress--->
       </c:forEach>
  <%-- <c:forEach items="${mapInfoList}" var="info">
      <a href="showQuickBookingPage.do?branchId=${info[18]}&businessName=${info[4]}&feePerson=${info[19]}" class="clikbookinghere">Click Here for Quick Booking</a>
      </c:forEach> --%>
      </div><!-------end venu-stat---------->
      
      <div id="timeshow" class="timeshow">
      <c:set var="now" value="<%=new java.util.Date()%>"/>
      <c:forEach items="${mapInfoList}" var="info">
      <label for="timesh"><span class="tim">Currently: <fmt:formatDate value="${now}" pattern="hh:mm:ss aa"/></span></label>
      <label for="wek"><span class="tim"><fmt:formatDate  pattern="E" value="${now}" />:<span class="wekl">Trending up for past hour</span></span></label>
      <label for="capcy"><span class="tim">Capacity:&nbsp;${info[6]}</span></label>
      <label for="capcy"><span class="tim">Hours of operation: &nbsp;  
      <c:set var="openTime" value="${fn:split(info[26], ',')}" />
      <c:set var="closeTime" value="${fn:split(info[27], ',')}" />
      <jsp:useBean id="now" class="java.util.Date"/>
      <c:if test="${fn:startsWith(now, 'Mon')}" >
       ${openTime[0]}-${closeTime[0]}
      </c:if>
      <c:if test="${fn:startsWith(now, 'Tue')}" >
       ${openTime[1]}-${closeTime[1]}
      </c:if>
       <c:if test="${fn:startsWith(now, 'Wed')}" >
       ${openTime[2]}-${closeTime[2]}
      </c:if>
       <c:if test="${fn:startsWith(now, 'Thu')}" >
       ${openTime[3]}-${closeTime[3]}
      </c:if>
       <c:if test="${fn:startsWith(now, 'Fri')}" >
       ${openTime[4]}-${closeTime[4]}
      </c:if>
       <c:if test="${fn:startsWith(now, 'Sat')}" >
       ${openTime[5]}-${closeTime[5]}
      </c:if>
       <c:if test="${fn:startsWith(now, 'Sun')}" >
       ${openTime[6]}-${closeTime[6]}
      </c:if>
      </span></label>
      </c:forEach>
      </div><!------end timeshow------>
      <div id="today venu" class="todyvenu">
      <span class="tdy">Todays Activities are:</span>
      <c:forEach items="${mapInfoList}" var="info">
      <fmt:parseDate value="${info[7]}" var="startTime" pattern="yyyy/MM/dd HH:mm"/>
      <c:set var="dateParts" value="${fn:split(info[25], ',')}" />
      <label for="capcy"><span class="tim">
      <c:if test="${dateParts[0]!=null }">
        ${dateParts[0]}
      </c:if>
      <c:if test="${dateParts[1]!=null}">
        ,${dateParts[1]}
      </c:if>
      <c:if test="${dateParts[2]!=null}">
        ,${dateParts[2]}
      </c:if>
      <c:if test="${dateParts[3]!=null}">
        and ${dateParts[3]}
      </c:if>
      : Starting at <fmt:formatDate value="${startTime}" pattern="hh:mm aa" /></span></label>
      <label for="capcy"><span class="tim">Booking Per Person: $${info[19]} at the door. </span></label>
      </c:forEach>
      </div><!----end today venu----->
</div><!----========================end page-content==========================---------->       
</body>
</html>
