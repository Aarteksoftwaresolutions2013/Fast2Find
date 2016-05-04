<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/hilitor.js"></script>
<title>Insert title here</title>
</head>
<body>
<div id="playground">
<div class="main-blog-content">
      <div class="news-pagescontent">
      <div class="postshow">
      <!-----beging post------>
      <div class="post1">
      <h2>Final post</h2>
      <div class="catogry">
      <a href="#"><span class="timie">MAY 30, 2014</span></a>
      <a href="#"><span class="wategory">UNCATEGORIZED</span></a>
      </div>
      <p>
      There are lots of reasons why technology companies like Google struggle to recruit and retain women and minorities. For example, women earn roughly 18 percent of all computer science degrees in the United States. Blacks and Hispanics make up under 10 percent of U.S. college grads and collect fewer than 5 percent of degrees in []
      </p>
      <a href="#" class="readi">Read more</a>
      </div><!-----end post1----->
      <!-----beging post------>
      <div class="post1">
      <h2>last post</h2>
      <div class="catogry">
      <a href="#"><span class="timie">MAY 30, 2014</span></a>
      <a href="#"><span class="wategory">UNCATEGORIZED</span></a>
      </div>
      <p>
      There are lots of reasons why technology companies like Google struggle to recruit and retain women and minorities. For example, women earn roughly 18 percent of all computer science degrees in the United States. Blacks and Hispanics make up under 10 percent of U.S. college grads and collect fewer than 5 percent of degrees in []
      </p>
      <a href="#" class="readi">Read more</a>
      </div><!-----end post1----->
      <!-----beging post------>
      <div class="post1">
      <h2>second last post</h2>
      <div class="catogry">
      <a href="#"><span class="timie">MAY 30, 2014</span></a>
      <a href="#"><span class="wategory">UNCATEGORIZED</span></a>
      </div>
      <p>
      There are lots of reasons why technology companies like Google struggle to recruit and retain women and minorities. For example, women earn roughly 18 percent of all computer science degrees in the United States. Blacks and Hispanics make up under 10 percent of U.S. college grads and collect fewer than 5 percent of degrees in []
      </p>
      <a href="#" class="readi">Read more</a>
      </div><!-----end post1----->
      </div><!-----end postshow----->
      <div class="leftpostcontent">
      <div class="srch-frm">
      <form role="search" method="get" class="search-form" autocomplete="off" >
        <label>
          <span class="screen-reader-text"></span>
        <input type="search" class="search-field" placeholder="Search "  name="s" title="Search for:" id="keywords" size="24" > 
        </label>
      </form></div>
      
      <aside id="categories-3" class="widget widget_categories"><h3 class="widget-title">Categories</h3>    <ul>
  <li class="cat-item cat-item-1"><a href="#" title="View all posts filed under Uncategorized">Uncategorized</a>
</li>
    </ul>
</aside>
      </div><!-----end leftpostcontent----->            
      </div><!-----end news-pagescontent----->
      </div><!-----main blog content------>
</div>
<script type="text/javascript">
var myHilitor2;
document.addEventListener("DOMContentLoaded", function() {
myHilitor2 = new Hilitor("playground");
myHilitor2.setMatchType("left");
}, false);
document.getElementById("keywords").addEventListener("keyup", function() {
myHilitor2.apply(this.value);
}, false);
</script>
</body>
</html>