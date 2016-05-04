<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
var b = document.documentElement;
b.setAttribute('data-useragent',  navigator.userAgent);
</script>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=629898567079730&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<script type="text/javascript">
!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
</head>
<body>
<div class="social-content" id="social-content">
      <div class="feedback-widget">
      <div class="facebookfeed">
    <div id="fb-root"></div>
    <div class="fb-activity" data-site="fast2find.com/ftf-web" data-action="likes, recommends" data-max-age="180" data-colorscheme="light" data-header="true"></div>
      </div>
      <div class="twitterfeed">
      <!-- <img src="images/634440920318363583_twitterFeedScreenShot.jpg" width="320px" /> -->
           <a class="twitter-timeline"  href="https://twitter.com/fast2find/lists/hero"  data-widget-id="481766417428013056">Tweets from https://twitter.com/fast2find/lists/hero</a>
      </div>
      </div>
      </div><!-----end social-content--->
</body>
</html>