<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths">
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Insert title here</title>
</head>
<body class=" fluid-layout wysihtml5-supported">
<script type="text/javascript">demoSetBodyLayout();</script>
<!-- Left navigation panel
		================================================== -->
	<nav id="left-panel" style="height: 100%; position: fixed; top: 0px; left: 0px;">
		<div id="left-panel-content" style="overflow: hidden;">
			<ul style="-webkit-transition: -webkit-transform 0ms; transition: -webkit-transform 0ms; -webkit-transform-origin: 0px 0px; -webkit-transform: translate3d(0px, 0px, 0px);">
				<li>
					<a href="dashboard.do"><span class="icon-dashboard"></span>Dashboard</a>
				</li>
				<li class="lp-dropdown">
					<a href="#" class="lp-dropdown-toggle" id="extras-dropdown"><span class="icon-reorderb"></span>category</a>
				</li>
				<!-- <li class="lp-dropdown">
					<a href="#" class="lp-dropdown-toggle" id="pages-dropdown"><span class="icon-file-alt"></span>Pages</a>
				</li> -->
			</ul>
		</div>
		<div class="icon-caret-down"></div>
		<div class="icon-caret-up"></div>
	</nav>
	<!-- / Left navigation panel -->
	<!-- Page content
		================================================== -->
	<section class="container">
		<!-- Modals
			================================================== -->
		<section class="row-fluid">
		</section>
		<div class="lp-dropdown-wrapper simple" data-dropdown-owner="pages-dropdown" style="left: 92px; width: 200px; top: 333px;"><ul class="lp-dropdown-menu simple" data-dropdown-owner="pages-dropdown" style="width: 200px;">
						<li style="display: block; width: 100%;">
							<a tabindex="-1" href="viewCatageory.do" style="display: block; width: 100%;">&nbsp;&nbsp;Edit Catageory</a>
						</li>
						<li style="display: block; width: 100%;">
							<a tabindex="-1" href="viewSubCatageory.do" style="display: block; width: 100%;">&nbsp;&nbsp;Edit SubCatageory</a>
						</li>
				<!-- 		<li style="display: block; width: 100%;">
							<a tabindex="-1" href="pages-messages.html" style="display: block; width: 100%;">&nbsp;&nbsp;page 3</a>
						</li>
						<li style="display: block; width: 100%;">
							<a tabindex="-1" href="pages-stream.html" style="display: block; width: 100%;">&nbsp;&nbsp;page 4</a>
						</li>
						<li style="display: block; width: 100%;">
							<a tabindex="-1" href="pages-pricing.html" style="display: block; width: 100%;">&nbsp;&nbsp;page 5</a>
						</li>
						<li style="display: block; width: 100%;">
							<a tabindex="-1" href="pages-invoice.html" style="display: block; width: 100%;">&nbsp;&nbsp;page 6</a>
						</li>
						<li style="display: block; width: 100%;">
							<a tabindex="-1" href="pages-map.html" style="display: block; width: 100%;">&nbsp;&nbsp;page 7</a>
						</li>
						<li style="display: block; width: 100%;">
							<a tabindex="-1" href="pages-error-404.html" style="display: block; width: 100%;">&nbsp;&nbsp;page 8</a>
						</li>
						<li style="display: block; width: 100%;">
							<a tabindex="-1" href="pages-error-500.html" style="display: block; width: 100%;">&nbsp;&nbsp;page 10</a>
						</li>
						<li style="display: block; width: 100%;">
							<a tabindex="-1" href="pages-blank.html" style="display: block; width: 100%;">&nbsp;&nbsp;Blank page</a>
						</li> -->
					</ul></div>
					<div class="lp-dropdown-wrapper" data-dropdown-owner="extras-dropdown" style="left: 92px; width: 246px; top: 531px;"><ul class="lp-dropdown-menu" data-dropdown-owner="extras-dropdown" style="width: 246px;">
						<li>
							<a tabindex="-1" href="catageory.do"><span class="icon-coffee"></span>Add New</a>
						</li>
						<li>
							<a tabindex="-1" href="subCatageory.do"><span class="icon-bar-chart"></span>Sub Category</a>
						</li>
						<!----
						<li>
							<a tabindex="-1" href="#"><span class="icon-star"></span>Widgets</a>
						</li>---->
					</ul></div>
</section>
</body>
</html>