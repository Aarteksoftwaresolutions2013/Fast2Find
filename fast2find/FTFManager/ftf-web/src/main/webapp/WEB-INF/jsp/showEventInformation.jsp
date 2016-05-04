<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jsp-js/showEventInformation.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
  $(document).ready(function() {
    <c:forEach items="${eventSearchList}" var="info">
    var stage = '${info[22]}';
    var ids = stage.split(",");
    </c:forEach>
    for ( var i = 0; i < ids.length; i++) {
      $('#stage' + ids[i]).attr('checked', true);
    }
  });
  function QuickBooking() {
    var com = document.getElementById("textre").value;
    <c:forEach items="${eventSearchList}" var="info">
    window.location.href = "eventQuickBooking.do?branchId=" + '${info[17]}' + "&businessName=" + '${info[4]}'
        + "&fullEventPrice=" + '${info[18]}' + "&dayPrice=" + '${info[21]}' + "&comment=" + com
    </c:forEach>
  }
</script>
</head>
<body>
<form action="#" method="#" name="special event page">
<div class="page-date-pinpnt" id="page-date-pinpoint">
      <div class="inner-page-date">
      <h2 class="page-heading">Special Event page selected by date or pinpoint</h2>
      <ul class="left-page-ul">
      <c:forEach items="${eventSearchList}" var="info">
      <div class="prograss-bar-wrap">
      <div class="progress_bar" id="progress_bari">
      <span class="for-bg">
      <span class="title-nd-value"><p>${(info[0]-info[2])+(info[1]-info[3])}</p></span> / <span class="outoff"><p>${info[6]}</p></span>
      </span><!---end span for bg---->
      <div id="prograss-cont" class="prograss-cont">
      <div class="progress-inc" style="width:${(((info[0]-info[2])+(info[1]-info[3])*100)/info[6])}%"></div>
      </div><!----close progress-cont div----->
      </div><!------closer here progress_bar--->
      <div class="progress_bar" id="progress_bari">
      <span class="for-bgh">
      <span class="title-nd-value"><p>Hourly Trends</p></span><span class="outoff"><p></p></span>
      </span><!---end span for bg---->
      <div id="prograss-cont" class="prograss-cont">
      <div class="progress-hourly" style="width:${(info[0]+info[1])-(info[2]+info[3])}"></div>
      </div><!----close progress-cont div----->
      </div><!------closer here progress_bar--->
      <div class="progress_bar" id="progress_bari">
      <span class="for-bggg">
      <span class="title-nd-value"><p>Gents</p>  </span><span class="outoff"><p>${info[0]-info[2]}</p></span>
      </span><!---end span for bg---->
      <div id="prograss-cont" class="prograss-cont">
      <div class="progress-gents" style="width:${((info[0]-info[2])*100)/info[6]}%"></div>
      </div><!----close progress-cont div----->
      </div><!------closer here progress_bar--->
      <div class="progress_bar" id="progress_bari">
      <span class="for-bglll">
      <span class="title-nd-value"><p>Lady </p>  </span><span class="outoff"><p>${info[1]-info[3]}</p></span>
      </span><!---end span for bg---->
      <div id="prograss-cont" class="prograss-cont">
      <div class="progress-lady" style="width:${((info[1]-info[3])*100)/info[6]}%"></div>
      </div><!----close progress-cont div----->
      </div><!------closer here progress_bar--->
      </div>
      </c:forEach>
      <div class="text-arearplace" id="textareaplace">
      <textarea rows="4" cols="50" placeholder="Your Blurb..." id="textre"  name="textre" ></textarea>
      </div>
      <div class="data-show" id="dateshow" >
      <c:forEach items="${eventSearchList}" var="info">
      <ul>
      <li>Event  or Pavillion Name: &nbsp;&nbsp;<b>${info[4]}</b> </li>
      <li>Special Event kiosk name: &nbsp;&nbsp;<b>${info[20]}</b> </li>
      <li>Event specific location Address: &nbsp;&nbsp;<b>${info[13]}</b></li>
      <li>City: &nbsp;&nbsp;<b>${info[12]}</b></li>
      <li>State/Province: &nbsp;&nbsp;<b>${info[14]}</b></li>
      <li>Zip/Post code: &nbsp;&nbsp;<b>${info[15]}</b></li>
      <li>Country: &nbsp;&nbsp;<b>${info[16]}</b></li>
      <li>Max Capacity of Event: &nbsp;&nbsp;<b>${info[6]}</b></li>
      <li>Full Event: &nbsp;&nbsp;<b>$${info[18]}</b></li>
      <li>Day price: &nbsp;&nbsp;<b>$${info[21]}</b></li>
      </ul>
      </c:forEach>
      </div>
      </ul><!------left side ul close here-------->
      </div><!-----end progress-bar-wrap close------->
      
      <div class="right-side-prt">
    <!--   <ul class="chk-container">
<li><input type="checkbox" id="selecctall" class="checkall"/> <label for="selecctall"><span></span>Select All or specific pavillion </label></li>
</ul> -->
<div class="small-ui1">
<ul>
<li>
<input class="checkbox1" type="checkbox" name="mails[]" value="item1" id="stage1" /> 
<label for="stage1"><span></span>Stage1</label>
</li>
<li><input class="checkbox1" type="checkbox" name="mails[]" value="item2" id="stage2" />
<label for="stage2"><span></span> Stage 2</label>
</li>
<li><input class="checkbox1" type="checkbox" name="mails[]" value="item3" id="stage3" /> <label for="stage3"><span></span>
Stage 3</label></li>
<li><input class="checkbox1" type="checkbox" name="mails[]" value="item4" id="stage4" /> 
<label for="stage4"><span></span>
stage 4 </label>
</li>
<li><input class="checkbox1" type="checkbox" name="mails[]" value="item5" id="stage5" /> 
<label for="stage5"><span></span> stage 5</label></li>
<li><input class="checkbox1" type="checkbox" name="mails[]" value="item6" id="stage6" /><label for="stage6"><span></span> Stage 6</label></li>
<li><input class="checkbox1" type="checkbox" name="mails[]" value="item6" id="stage7" /><label for="stage7"><span></span> Stage 7</label></li>
<li><input class="checkbox1" type="checkbox" name="mails[]" value="item6" id="stage8" /><label for="stage8"><span></span> Stage 8</label></li>
<li><input class="checkbox1" type="checkbox" name="mails[]" value="item6" id="stage9" /><label for="stage9"><span></span> Stage 9</label></li>
<li><input class="checkbox1" type="checkbox" name="mails[]" value="item6" id="stage10" /><label for="stage10"><span></span> Stage 10</label></li>
<li><input class="checkbox1" type="checkbox" name="mails[]" value="item6" id="stage11" /><label for="stage11"><span></span> Stage 11</label></li>
<li><input class="checkbox1" type="checkbox" name="mails[]" value="item6" id="stage12" /><label for="stage12"><span></span> Stage 12</label></li>
<li><input class="checkbox1" type="checkbox" name="mails[]" value="item6" id="stage13" /><label for="stage13"><span></span> Stage 13</label></li>
<li><input class="checkbox1" type="checkbox" name="mails[]" value="item6" id="stage14" /><label for="stage14"><span></span> Stage 14</label></li>
</ul>
</div>
<div class="side-widget" id="widget">
<c:forEach items="${eventSearchList}" var="info">
<ul>
<c:set var="now" value="<%=new java.util.Date()%>"/>
<li><p>Currently = <fmt:formatDate value="${now}" pattern="hh:mm aa" /></p></li>
<li><p> <fmt:formatDate  pattern="E" value="${now}" /> = Trending up for past hour </p></li>
<li><p> Current Volume = &nbsp;&nbsp;${(info[0]+info[1])-(info[2]+info[3])} </p></li>
<li><p> Max Capacity = &nbsp;&nbsp;${info[6]} </p></li>
<li><p>Day volume = &nbsp;&nbsp;${info[0]+info[1]}</p></li>
<li>
<fmt:parseDate value="${info[7]}" var="startTime" pattern="yyyy/MM/dd HH:mm"/>
<fmt:parseDate value="${info[8]}" var="endTime" pattern="yyyy/MM/dd HH:mm"/>
<p>Hours of operation =<fmt:formatDate value="${startTime}" pattern="hh:mm aa" />-<fmt:formatDate value="${endTime}" pattern="hh:mm aa" /></p></li>
</ul>
</c:forEach>
</div><!-----close here side-widget---------->  
<!-- <div class="side-widgetb" id="widgetb">
  <h2>Let us know how it was</h2>
  <div class="likeid" id="likendislik">
  <ul><li>
<input type="radio" name="like" id="likeid" /><label for="likeid"><span></span>I like this application</label>
</li>
<li>
<input type="radio" name="like" id="dislikeid" /><label for="dislikeid"><span></span>I do no like this application</label>
</li>
</ul>
  </div>--end like div---
  </div> -->
  <!------end side-widgetb div here----->
<%--   <c:forEach items="${eventSearchList}" var="info">
  <c:if test="${info[23]!=null}">
  <div class="submt-bnt">
      <a href="#" onclick="QuickBooking()"  class="clikbookinghere">Click Here for Quick Booking</a>
  </div>
  </c:if>
   </c:forEach> --%>
</div><!-------right-side-part---end here---->
      
      </div><!--------------inner-page-date---------->
      </div><!---------- end page-date-pinpoint div here---------->
      </form>
</body>
</html>