<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src=" js/jsp-js/feedback.js"></script>
<link rel="stylesheet" type="text/css" href="css/styleb.css" media="screen">
<title>Insert title here</title>
</head>
<body>
  <div id="feedback" class="feedback">
      <h4>${successMsg}</h4>
      <h2>Feedback</h2>
      <form:form method="post" modelAttribute="FeedbackDetails" action="feedbackInfo.do" name="feedback-form">
      <strong class="signup">Please submit feedback in the space provided.</strong>
      <form:textarea path="feedbackInfo" rows="100" cols="100" id="feed-text" required ="autofocus" placeholder="Your feedback goes here" />
      <input type="submit" id="feedba" value="Submit Feedback" />
      </form:form>
      </div><!---------------end div of feedback------------>
</body>
</html>