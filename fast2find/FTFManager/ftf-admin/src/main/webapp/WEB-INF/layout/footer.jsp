<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
			<div id="footer" class="footer">
			<div class="footer-inner">
			<div id="footer-widget" class="footer-widget">
			<h3>about us</h3>
			<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>
			</div>
			<div id="recent-catagory" class="recent-catagory">
			<h3></h3>
			</div>
			<div id="form" class="form">
			<h3>Quick Contact</h3>
			<div id="contact-form" class="contact-form">
			<form>
    <input type="hidden" name="action" value="submit"/>Name:<br />
    <input name="name" type="text" value="" size="30"/> <br /> Email:<br /> 
    <input name="email" type="text" value="" size="30"/> <br /> Message:<br />
    <textarea name="message" rows="7" cols="30"> </textarea> <br />
    <input type="submit" value="Submit" id="submit" class="subm"/>
    </form> 
			</div><!-----end contact-form---->
			</div><!-----end form div---->
			</div><!-----end footer-inner---->
			</div><!----end footer----->
			<div class="bottom">
			<span class="copy_right">© Domain.com 2014</span>
			</div>
</body>
</html>