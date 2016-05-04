<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="viewport"
  content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" type="text/css" href="css/style.css"
  media="screen" />
<link rel="stylesheet" type="text/css" href="css/styleb.css"
  media="screen" />
<link rel="stylesheet" type="text/css" href="css/easy.css" />
<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script> -->
<script type="text/javascript" src="js/ajax.jquery.min.js"></script>
<script type="text/javascript" src="js/scrolltopcontrol.js"></script>
<script type="text/javascript" src="js/respond.min.js"></script>
<script type="text/javascript" src="js/html5shiv.js"></script>
<link rel="stylesheet" type="text/css" href="css/ie10.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" media="all">
<script type="text/javascript" src="js/jquery (2).js"></script>
<script type="text/javascript" src="js/modernizr.js"></script>
<link rel="stylesheet" type="text/css" href="css/ie-css3.htc"
  media="all" />
<!--  <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script> -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<!--  <link rel="stylesheet" type="text/css" href="css/ie-style.css" media="all" />
 <script type="text/javascript" src="js/button.js"></script>
  <script type="text/javascript" src="js/tests.js"></script> -->
<link rel="stylesheet" href="css/responsive/responsivemobilemenu.css"
  type="text/css" />
<script type="text/javascript"
  src="js/responsive/responsivemobilemenu.js"></script>
<link rel="stylesheet" type="text/css"
  href="css/responsive/smallphone.css" media="screen">
<link rel="stylesheet" type="text/css" href="css/responsive/iphone.css"
  media="screen">
<link rel="stylesheet" type="text/css" href="css/responsive/ipad.css"
  media="screen">
<link rel="stylesheet" type="text/css" href="css/responsive/ipad768.css"
  media="screen">
<link rel="stylesheet" type="text/css" href="css/responsive/tablate.css"
  media="screen">
<title>Fast2Find</title>
</head>
<body>
  <!-----------top header------->
  <div id="top-header" class="top-header">
    <div class="menu-wrap">
      <!----top-header menu---->
      <div id="top-menu" class="top-menu">
        <ul>
          <li class="menu_01"><a href="frontPage.do">Home</a></li>
          <li class="menu_02"><a href="#">Site Map</a></li>
          <li class="menu_03"><a href="support.do">Support</a></li>
        </ul>
      </div>
      <!----end top-header menu---->
      <div class="sign_top">
        <ul>
          <c:choose>
            <c:when test="${sessionScope.login!=null}">
              <li class="sign_05"><font color="white"><c:out
                    value="Welcome, ${sessionScope.login.firstName}" /></font>&nbsp;&nbsp;</li>
              <li class="register_06"><a href="logout.do">Logout</a></li>
            </c:when>
            <c:otherwise>
              <li class="sign_05"><a href="signIn.do">Sign In</a></li>
              <li class="register_06"><a
                href="registration.do?param=check">Register</a></li>
            </c:otherwise>
          </c:choose>
        </ul>
      </div>
      <!----end sign_top--->
    </div>
    <!----end menu-wrap--->
  </div>
  <!-----------end top header------->
  <!-----beginning logo_wrap----->
  <div id="logo_wrap" class="logo_wrap">
    <div class="logo">
      <a href="frontPage.do"> <img src="images/logo.png"
        alt="fast2find logo" />
      </a>
    </div>
    <!----end logo--->
    <div id="social-media" class="social-media">
      <span class="call-us">Call Us : 1-701-214-4566</span>
      <ul>
        <li class="facebook" title="Visit Fast2Find on Facebook"><a
          target="blenk" href="https://facebook.com/fast2find">facebook</a></li>
        <li class="google-plus" title="Add Fast2Find to Google+ circles"><a
          target="blenk"
          href=" https://plus.google.com/u/0/115711491255478144290/about">google</a></li>
        <li class="Twitter" title="Follow Fast2Find on Twitter"><a
          target="blenk" href="https://twitter.com/fast2find">Twitter</a></li>
        <li class="linknd" title="Read Fast2Find news on LinkedIn"><a
          target="blenk"
          href="http://in.linkedin.com/pub/fast2find-here/a2/97a/b23">linkned</a></li>
      </ul>
    </div>
    <!-----social-media---->
  </div>
  <!-----end logo_wrap----->
  <!-------page-menu------>
  <c:if test="${sessionScope.login.login.userType==null}">
    <div id="page-menu" class="page-menu">
      <div class="menu-wrp">
        <ul>
          <li class="page_home"><a href="frontPage.do">Home</a></li>
          <li class="page_about"><a href="about.do">About us</a></li>
          <li class="page_social"><a href="socialMedia.do">Social
              Media</a></li>
          <li class="page_faq"><a href="faq.do">Faq's</a></li>
          <!--  <li class="page_location"><a href="#">Location info</a></li> -->
          <li class="page_news"><a href="news.do">News</a></li>
          <li class="page_contact"><a href="contactUs.do">Contact us</a></li>
        </ul>
      </div>
    </div>
    <div class="hideshow">
      <div class='rmm' data-menu-style="minimal">
        <ul>
          <li class="page_home"><a href="frontPage.do">Home</a></li>
          <li class="page_about"><a href="about.do">About us</a></li>
          <li class="page_social"><a href="socialMedia.do">Social
              Media</a></li>
          <li class="page_faq"><a href="faq.do">Faq's</a></li>
          <!-- <li class="page_location"><a href="#">Location info</a></li> -->
          <li class="page_news"><a href="news.do">News</a></li>
          <li class="page_contact"><a href="contactUs.do">Contact us</a></li>
        </ul>
      </div>
    </div>
  </c:if>
  <c:if
    test="${sessionScope.login.login.userType=='Customer' && sessionScope.login.login.paidStatus=='yes'}">
    <div id="page-menu" class="page-menu">
      <div class="menu-wrp">
        <ul>
          <li class="page_home"><a href="frontPage.do">Home</a></li>
          <li class="page_about"><a href="about.do">About us</a></li>
          <li class="page_social"><a href="socialMedia.do">Social
              Media</a></li>
          <li class="page_social"><a href="updateInfo.do">My Account
              </a></li>
          <li class="page_contact"><a href="emailAlert.do">Email
              Alert</a></li>
          <li class="page_contact"><a href="contactUs.do">Contact us</a></li>
        </ul>
      </div>
    </div>
    <div class="hideshow">
      <div class='rmm' data-menu-style="minimal">
        <ul>
          <li class="page_home"><a href="frontPage.do">Home</a></li>
          <li class="page_about"><a href="about.do">About us</a></li>
          <li class="page_social"><a href="socialMedia.do">Social
              Media</a></li>
          <li class="page_social"><a href="updateInfo.do">My Account
              </a></li>
          <li class="page_contact"><a href="emailAlert.do">Email
              Alert</a></li>
          <li class="page_contact"><a href="contactUs.do">Contact us</a></li>
        </ul>
      </div>
    </div>
  </c:if>
  <c:if
    test="${sessionScope.login.login.userType=='Customer' && sessionScope.login.login.paidStatus=='no'}">
    <div id="page-menu" class="page-menu">
      <div class="menu-wrp">
        <ul>
          <li class="page_home"><a href="frontPage.do">Home</a></li>
          <li class="page_about"><a href="about.do">About us</a></li>
          <li class="page_social"><a href="socialMedia.do">Social
              Media</a></li>
          <li class="page_faq"><a href="faq.do">Faq's</a></li>
          <!--  <li class="page_location"><a href="#">Location info</a></li> -->
          <li class="page_news"><a href="news.do">News</a></li>
          <li class="page_contact"><a href="contactUs.do">Contact us</a></li>
        </ul>
      </div>
    </div>
    <div class="hideshow">
      <div class='rmm' data-menu-style="minimal">
        <ul>
          <li class="page_home"><a href="frontPage.do">Home</a></li>
          <li class="page_about"><a href="about.do">About us</a></li>
          <li class="page_social"><a href="socialMedia.do">Social
              Media</a></li>
          <li class="page_faq"><a href="faq.do">Faq's</a></li>
          <!-- <li class="page_location"><a href="#">Location info</a></li> -->
          <li class="page_news"><a href="news.do">News</a></li>
          <li class="page_contact"><a href="contactUs.do">Contact us</a></li>
        </ul>
      </div>
    </div>
  </c:if>
  <c:if test="${sessionScope.login.login.userType=='business'}">
    <div id="page-menu" class="page-menu">
      <div class="menu-wrp" id="colorNav">
        <ul>
          <li class="page_home"><a href="business.do">Home</a></li>
          <li class="page_about"><a href="updateBusinessAndEventCust.do">My Account</a></li>
          <li class="page_social"><a href="socialMedia.do">Social
              Media</a></li>
          <li class="page_news"><a href="#"> Business</a>
            <ul class="submenuzz">
              <li><a href="businessUpdate.do">Register Business</a></li>
              <li><a href="showBusiness.do">Update
                  Business&nbsp;&nbsp;</a></li>
            </ul></li>
          <li class="page_social"><a href="showReport.do">Past
              Trends</a></li>
          <!-- <li class="page_about"><a href="about.do">About us</a></li> -->
          <li class="page_faq"><a href="faq.do">Faq's</a></li>
          <li class="page_contact"><a href="contactUs.do">Contact us</a></li>
        </ul>
      </div>
    </div>
    <div class="hideshow">
      <div class="rmm minimal" data-menu-style="minimal"
        style="max-width: 0px;">
        <div class="rmm-toggled rmm-closed" style="">
          <div class="rmm-toggled-controls">
            <div class="rmm-toggled-title">Menu</div>
            <div class="rmm-button">
              <span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span>
            </div>
          </div>
          <ul>
            <li class="page_home"><a href="business.do">Home</a></li>
            <li class="page_about"><a href="updateBusinessAndEventCust.do">My Account</a></li>
            <li class="page_social"><a href="socialMedia.do">Social
                Media</a></li>
            <li class="page_news"><a href="#"> Business</a>
              <ul class="submenuzz">
                <li><a href="businessUpdate.do">Register Business</a></li>
                <li><a href="showBusiness.do">Update
                    Business&nbsp;&nbsp;</a></li>
              </ul></li>
            <li class="page_social"><a href="showReport.do">Past
                Trends</a></li>
            <li class="page_faq"><a href="faq.do">Faq's</a></li>
            <li class="page_contact"><a href="contactUs.do">Contact
                us</a></li>
          </ul>
        </div>
        <ul class="rmm-main-list" style="">
          <li class="page_home"><a href="business.do">Home</a></li>
          <li class="page_about"><a href="updateBusinessAndEventCust.do">My Account</a></li>
          <li class="page_social"><a href="socialMedia.do">Social
              Media</a></li>
          <li class="page_news"><a href="#"> Business</a>
            <ul class="submenuzz">
              <li><a href="businessUpdate.do">Register Business</a></li>
              <li><a href="showBusiness.do">Update
                  Business&nbsp;&nbsp;</a></li>
            </ul></li>
          <li class="page_social"><a href="showReport.do">Past
              Trends</a></li>
          <li class="page_faq"><a href="faq.do">Faq's</a></li>
          <li class="page_contact"><a href="contactUs.do">Contact us</a></li>
        </ul>
      </div>
    </div>
  </c:if>
  <c:if test="${sessionScope.login.login.userType=='event'}">
    <div id="page-menu" class="page-menu">
      <div class="menu-wrp" id="colorNav">
        <ul>
          <li class="page_home"><a href="event.do">Home</a></li>
          <li class="page_about"><a href="updateBusinessAndEventCust.do">My Account</a></li>
          <li class="page_social"><a href="socialMedia.do">Social
              Media</a></li>
          <li class="page_news"><a href="#"> &nbsp; Event&nbsp;</a>
            <ul class="submenuzz">
              <li><a href="eventUpdate.do">Register Event</a></li>
              <li><a href="showEvent.do">Update Event&nbsp;&nbsp;</a></li>
            </ul></li>
          <li class="page_social"><a href="showEventReport.do">Past
              Trends</a></li>
          <li class="page_faq"><a href="faq.do">Faq's</a></li>
          <li class="page_contact"><a href="contactUs.do">Contact us</a></li>
        </ul>
      </div>
    </div>
    <div class="hideshow">
      <div class="rmm minimal" data-menu-style="minimal"
        style="max-width: 0px;">
        <div class="rmm-toggled rmm-closed" style="">
          <div class="rmm-toggled-controls">
            <div class="rmm-toggled-title">Menu</div>
            <div class="rmm-button">
              <span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span>
            </div>
          </div>
          <ul>
            <li class="page_home"><a href="event.do">Home</a></li>
            <li class="page_about"><a href="updateBusinessAndEventCust.do">My Account</a></li>
            <li class="page_social"><a href="socialMedia.do">Social
                Media</a></li>
            <li class="page_news"><a href="#"> &nbsp; Event&nbsp;</a>
              <ul class="submenuzz">
                <li><a href="eventUpdate.do">Register Event</a></li>
                <li><a href="showEvent.do">Update Event&nbsp;&nbsp;</a></li>
              </ul></li>
            <li class="page_social"><a href="showEventReport.do">Past
                Trends</a></li>
            <li class="page_faq"><a href="faq.do">Faq's</a></li>
            <li class="page_contact"><a href="contactUs.do">Contact
                us</a></li>
          </ul>
        </div>
        <ul class="rmm-main-list" style="">
          <li class="page_home"><a href="event.do">Home</a></li>
          <li class="page_about"><a href="updateBusinessAndEventCust.do">My Account</a></li>
          <li class="page_social"><a href="socialMedia.do">Social
              Media</a></li>
          <li class="page_news"><a href="#"> &nbsp; Event&nbsp;</a>
            <ul class="submenuzz">
              <li><a href="eventUpdate.do">Register Event</a></li>
              <li><a href="showEvent.do">Update Event&nbsp;&nbsp;</a></li>
            </ul></li>
          <li class="page_social"><a href="showEventReport.do">Past
              Trends</a></li>
          <li class="page_faq"><a href="faq.do">Faq's</a></li>
          <li class="page_contact"><a href="contactUs.do">Contact us</a></li>
        </ul>
      </div>
    </div>
  </c:if>
  <!------end page---->
</body>
</html>