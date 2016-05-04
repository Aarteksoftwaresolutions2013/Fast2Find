<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
 <head>
 <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
 <title>Google Maps Multiple Markers</title>
 <!-- Autocomplete js start  --> 
 <link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
 <script type="text/javascript" src="js/jquery.js"></script>
 <script type="text/javascript" src="../ftf-web/js/jquery-ui.js"></script>    
 <!-- Autocomplete js End -->
 <script src= "http://maps.google.com/maps/api/js?sensor=false" type="text/javascript"> </script>
 <script type="text/javascript" src="js/common.js"></script>
 <link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/>
 <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.9.1.custom.min.css"/>
 <script type="text/javascript" src="js/jsp-js/frontPage.js"></script>
 <script type="text/javascript" src="js/infobubble.js"></script>
  <script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=629898567079730&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<script type="text/javascript">
//Google Map implemetation
 var userType='${sessionScope.login.login.paidStatus}';
 if(userType=='yes')
 {
   var today=new Date();
   var thisDay=today.getDay();
  <c:forEach items="${searchList}" var="business">
   var startTime="${business[21]}";
   var sTime=startTime.split(",");
   var endTime="${business[22]}";
   var eTime=endTime.split(",");
   var tue;
   if(thisDay==1)
   {
      tue=sTime[0]+"-"+eTime[0]; 
   }
  if(thisDay==2)
  {
     tue=sTime[1]+"-"+eTime[1];
  }
  if(thisDay==3)
  {
     tue=sTime[2]+"-"+eTime[2];
  }
  if(thisDay==4)
  {
     tue=sTime[3]+"-"+eTime[3];
  }
  if(thisDay==5)
  {
     tue=sTime[4]+"-"+eTime[4];
  }
  if(thisDay==6)
  {
     tue=sTime[5]+"-"+eTime[5];
  }
  if(thisDay==7)
  {
     tue=sTime[6]+"-"+eTime[6];
  }
  </c:forEach>
   var markers = [
 <c:forEach items="${searchList}" var="business">
 {"title":"${business[18]}","lat":'${business[11]}',"log":'${business[12]}',"cap":'${(((business[0]+business[1])-(business[2]+business[3])) * 100)/business[6]}',"description":"<table><tr><td><b>Business Name:</b></td><td>${business[4]}${business[19]}</td></tr><tr><td><b>Address:</b></td><td>${business[14]}</td></tr><tr><td><b>City:</b></td><td>${business[13]}</td></tr><tr><td><b>state:</b></td><td>${business[15]}</td></tr><tr><td><b>Postal Code:</b></td><td>${business[16]}</td></tr><tr><td><b>Operating Hour:</b></td><td>"+tue+"</td></tr><tr><td><b>Contact No:</b></td><td>${business[10]}</td></tr><tr><td><b>Music:</b></td><td>${business[9]}</td></tr><tr><td><b>Max Capacity:</b></td><td>${business[6]}</td></tr><tr><td><b>Currrent Volume:</b></td><td>${(business[0]+business[1])-(business[2]+business[3])}</td></tr><tr><td><b>No.Male:</b></td><td>${business[0]-business[2]}</td></tr><tr><td><b>No.Female:</b></td><td>${business[1]-business[3]}</td></tr><tr><td><b>More Details</b></td><td><a href=showInformation.do?branchId="+${business[18]}+"><b>Click Here</b></a></td></tr></table>"},
 </c:forEach>
          ];
 } 
else
{ 
var markers = [
  <c:forEach items="${searchList}" var="business">
  {"title":"${business[18]}","lat":'${business[11]}',"log":'${business[12]}',"cap":'${(((business[0]+business[1])-(business[2]+business[3])) * 100)/business[6]}',"description":"<table><tr><td><b>Business Name:</b></td><td>${business[4]}${business[19]}</td></tr><tr><td><b>Address:</b></td><td>${business[14]}</td></tr><tr><td><b>City:</b></td><td>${business[13]}</td></tr><tr><td><b>state:</b></td><td>${business[15]}</td></tr><tr><td><b>Postal Code:</b></td><td>${business[16]}</td></tr><tr><td><b>Contact No:</b></td><td>${business[10]}</td></tr><tr><td><b><a href=signIn.do>Sign in for more details</b></a></tr></table>"},
  </c:forEach>
           ];
  }
function special() {
var status = document.getElementById('special_event').checked;
if (status) {
     $('#special_event').attr('checked', false);
}
<c:forEach items="${catageory}" var="catageoryList"  varStatus="con">              
if($('#cat'+"${catageoryList.catageoryId}").is(":checked")){
<c:forEach var="sub" items='${catageoryList.subCatageoryList}' varStatus="subcon">
$('#sbCat'+"${sub.subCatageoryId}").attr('checked', true);
</c:forEach>
}
else
   {
   <c:forEach var="sub" items='${catageoryList.subCatageoryList}' varStatus="subcon">
   $('#sbCat'+"${sub.subCatageoryId}").attr('checked', false);
   </c:forEach>
   }
</c:forEach>
}
 function subCat() {
var status = document.getElementById('special_event').checked;
if (status) {
$('#special_event').attr('checked', false);
}
<c:forEach items="${catageory}" var="catageoryList"  varStatus="con">      
<c:forEach var="sub" items='${catageoryList.subCatageoryList}' varStatus="subcon">
if($('#sbCat'+"${sub.subCatageoryId}").is(":checked")){
$('#cat'+"${catageoryList.catageoryId}").attr('checked', true);
$('#sbCat'+"${sub.subCatageoryId}").attr('checked', true);
}
</c:forEach>
</c:forEach>
 }
</script>
<style type="text/css">
       .ui-autocomplete {
            max-height: 200px;
            overflow-y: auto;
            /* prevent horizontal scrollbar */
            overflow-x: hidden;
            /* add padding to account for vertical scrollbar */
            padding-right: 20px;
            max-width: 570px;
    }
    /* IE 6 doesn't support max-height
     * we use height instead, but this forces the menu to always be this tall
     */
    * html .ui-autocomplete {
        height: 100px;
    }
</style>
 <!-- <script type="text/javascript">
      var script = '<script type="text/javascript" src="http://google-maps-' +
          'utility-library-v3.googlecode.com/svn/trunk/infobubble/src/infobubble';
      if (document.location.search.indexOf('compiled') !== -1) {
        script += '-compiled';
      }
      script += '.js"><' + '/script>';
      document.write(script);
    </script> -->
 </head>  
  <body>
  <div id="find-location" class="find-location">
  <h2>Find Location</h2>
  <c:choose>
  <c:when test="${(sessionScope.loginType!=null) and (sessionScope.loginType.paidStatus!=no)}">
  <span class="clic_find"><a href="registration.do?param=check"><i>Refer you friends and get  
   &nbsp;&nbsp;&nbsp;rewarded!</i></a></span>
  </c:when>
<c:otherwise>
  <span class="clic_find"><a href="registration.do?param=check"><i>First Time </br>Sign 
  up OFFERS</i></a></span>
</c:otherwise>
</c:choose>
<form:form method="POST"  modelAttribute="Branch" id="searchbox" class="boxi" name="searchForm">
<div id="landingform">
<div id="left-side-checkbox" class="left-side-checkbox">
<input type="checkbox"  name="catagory" value="event" id="special_event" onClick="uncheckCatagory()"/>
<label for="special_event" class="club"><span></span>Special Events</label>
  <div class="checkall"><input type="checkbox" class="checkbox1" id="selecctall" onClick="special()" /><label for="selecctall">Select All Categories</div>
 <div class="my-glossy-tabs">
            <c:forEach items="${catageory}" var="catageoryList"  varStatus="con">            
        <div class="clear-both">
      <a class="menuitem mysubmenuheader" href="#" headerindex="0h"><span class="accordprefix"></span>&nbsp;<span class="accordsuffix"><img src="images/plus.gif" class="mystatus"></span></a>
            <div class="club-sect1">
            <input type="checkbox"  id="cat${catageoryList.catageoryId}"  value="${catageoryList.catageoryId}" class="checkbox1" name="catagory" onClick="special()" /> 
            <label for="cat${catageoryList.catageoryId}"><span></span>${catageoryList.catageoryName}</label>
            </div> <!-----club-sect----->
<div class="mysubmenu" contentindex="0c" style="display: none;">
  <ul>
<c:forEach var="sub" items='${catageoryList.subCatageoryList}' varStatus="subcon">
  <li>
   <input type="checkbox" id="sbCat${sub.subCatageoryId}"  value="${sub.subCatageoryId}" class="checkbox1" name="subCatagory" onClick="subCat()" />
 <label for="sbCat${sub.subCatageoryId}"><span></span>${sub.subCatageoryName}</label>
  </li>
</c:forEach>  
 </ul>
</div>
</div>
</c:forEach>
  </div>
   <br><br>
  <span id="checkId" style="display:none;" class="error" >Please select one of categories to find your places of interest!</span>
</div><!----end -side-checkbox---->
</div>
<!------right-side---->
<div id="right_side" class="right_side">
<h3 class="help">
Please select categories on your left and enter your location below! 
This will enable us to provide you with accurate
information of what you are looking for..
 </h3>
<div class="black_logo">
<img src="images/gray.png" />
</div>

<div id="serch-locate" class="serch-locate">
<div style="color: #FF0000;" id="msg">${message}</div></br>
<input id="search" type="search" name="address" placeholder="City, address, zip code or postal code." required ="autofocus" />
<span id="searchId" style="display:none;"class="error" >Please Enter Address</span>
<form:hidden path="paidUSer" id="paidUser" value="" />
</div><!----serch-locate---->
<div id="dropdown" class="dropdown-btn">
<div class="datepicks" id="datepik">
<form:input path="searchDate" id="datepick" type="text" class="dates" value="Select Date" />
<span id="dateMsgId" style="display:none;" class="error" >Please select Date</span>
</div>
      </div><!-----end drop down----->
      <div id="submit_buttons" class="submit-btns">
      <input type="button" value="Submit" class="sum-btn" onclick="searchValidation()" maxlength="100" />
      </div><!-----end submit-buttons====------>
      </div><!------end right-side---->
      </form:form>
      </div>
      <div class="line"></div>
      <!-------main-contents----->
      <div id="mian-contents" class="min-contents">
      <div id="contens-colums" class="contents-colums">
      <div class="colums-pic">
      </div>
      <h2>Search Restaurant</h2>
      <p> Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
      </div><!-----contents-colums------>
      <div id="contens-colums-02" class="contents-colums-02">
      <div class="colums-pic-02">
      </div>
      <h2>Search Clubs</h2>
      <p> Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
      </div><!-----contents-colums-02------>
      <div id="contens-colums-03" class="contents-colums-03">
      <div class="colums-pic-03">
      </div>
      <h2>Search Pubs</h2>
      <p> Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
      </div><!-----contents-colums-03------>
      <div id="contens-colums-04" class="contents-colums-04">
      <div class="colums-pic-04">
      </div>
      <h2>Special Events</h2>
      <p> Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
      </div><!-----contents-colums------>
      <div id="contens-colums-05" class="contents-colums-05">
      <div class="colums-pic-05">
      </div>
      <h2>Search Comedy</h2>
      <p> Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
      </div><!-----contents-colums-02------>
      <div id="contens-colums-06" class="contents-colums-06">
      <div class="colums-pic-06">
      </div>
      <h2>Search Bands</h2>
      <p> Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
      </div><!-----contents-colums-03------>
      <div class="provid-banner">
      <h2>We Provide Wide Range Of Search...</h2>
      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>
      <div id="search-all" class="search-all">
      <a href="#"><h3>Search All<div class="map-ff">Map Facility</div></h3></a>
      </div>
      </div><!------edn porvid---banner--->
      <!------most-search----->
      <div id="most-search" class="most-search">
      <h2>Most Searched ...</h2>
      <div id="most-search-colums" class="most-search-colums">
      <a href="#"><img src="images/restr-01.png" /></a>
      <h3>Restaurants</h3>
      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </p>
      </div>
      <div id="most-search-colums" class="most-search-colums">
      <a href="#"><img src="images/club-03.png" /></a>
      <h3>Clubs</h3>
      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </p>
      </div>
      <div id="most-search-colums" class="most-search-colums">
      <a href="#"> <img src="images/restr-01.png"/></a>
      <h3>Special Events</h3>
      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </p>
      </div>
      </div><!------end most-search----->
      </div><!-------end main-contents----->
      <center>
      <div  id="map" style="width: 900px; height: 600px;"></div></center>
            <table align="center">
    <tr>
       <td valign="top">
        <u>Legend:</u><br />
         <img src="images/black 19 x32.png" />0% to 25% (of % capacity)&nbsp;
         <img src="images/green19 x32.png" />25% to 50%  (of % Capacity)&nbsp;
         <img src="images/yellow19 x32.png" />50% to 75% (% Getting full)&nbsp;
         <img src="images/orange19 x32.png" />75% to 95% (% Filling up)&nbsp;
         <img src="images/red19 x32.png" />95% to 100% (Almost full)&nbsp;
         <img src="images/flashing-01.gif" />100% (Maximum Full)&nbsp;
    </td>
</tr>
</table>

<div id="fb-root"></div>
<div class="fb-like"  style="margin-left: 50px;" data-href="https://www.facebook.com/fast2find123" data-layout="standard" data-action="recommend" data-show-faces="true" data-share="false"  align="center">
</div>
<p></p>
<!-- below line for share -->
<div class="fb-share-button"  style="margin-left: 50px;" data-href="https://www.facebook.com/fast2find123" data-type="button_count"  align="center">
</div>
<!-- below line for like button only -->
<div class="fb-like" data-href="https://fast2find.com/ftf-web" data-layout="standard" data-action="like" data-show-faces="true" data-share="false"  align="center">
</div>
<script type="text/javascript" src="js/jquery-1.8.2.js" charset="utf-8"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.1.custom.min.js" charset="utf-8"></script>
<script type="text/javascript">
/*-------------------------------------------------------------------- 
 * jQuery plugin: customInput()
 * by Maggie Wachs and Scott Jehl, http://www.filamentgroup.com
 * Copyright (c) 2009 Filament Group
 * Dual licensed under the MIT (filamentgroup.com/examples/mit-license.txt) and GPL (filamentgroup.com/examples/gpl-license.txt) licenses.
 * Article: http://www.filamentgroup.com/lab/accessible_custom_designed_checkbox_radio_button_inputs_styled_css_jquery/  
 * Usage example below (see comment "Run the script...").
--------------------------------------------------------------------*/
jQuery.fn.customInput = function(){
  $(this).each(function(i){ 
    if($(this).is('[type=checkbox],[type=radio]')){
      var input = $(this);
      // get the associated label using the input's id
      var label = $('label[for='+input.attr('id')+']');
      //get type, for classname suffix 
      var inputType = (input.is('[type=checkbox]')) ? 'checkbox' : 'radio';
      // wrap the input + label in a div 
      $('<div class="custom-'+ inputType +'"></div>').insertBefore(input).append(input, label);
      // find all inputs in this set using the shared name attribute
      var allInputs = $('input[name='+input.attr('name')+']');
      // necessary for browsers that don't support the :hover pseudo class on labels
      label.hover(
        function(){ 
          $(this).addClass('hover'); 
          if(inputType == 'checkbox' && input.is(':checked')){ 
            $(this).addClass('checkedHover'); 
          } 
        },
        function(){ $(this).removeClass('hover checkedHover'); }
      );
      //bind custom event, trigger it, bind click,focus,blur events         
      input.bind('updateState', function(){ 
        if (input.is(':checked')) {
          if (input.is(':radio')) {       
            allInputs.each(function(){
              $('label[for='+$(this).attr('id')+']').removeClass('checked');
            });   
          };
          label.addClass('checked');
        }
        else { label.removeClass('checked checkedHover checkedFocus'); }
      })
      .trigger('updateState')
      .click(function(){ 
        $(this).trigger('updateState'); 
      })
      .focus(function(){ 
        label.addClass('focus'); 
        if(inputType == 'checkbox' && input.is(':checked')){ 
          $(this).addClass('checkedFocus'); 
        } 
      })
      .blur(function(){ label.removeClass('focus checkedFocus'); });
    }
  });
};

</script>
<script type="text/javascript" src="js/ddaccordion.js">

/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>
<script type="text/javascript">
ddaccordion.init({
  headerclass: "mysubmenuheader", //Shared CSS class name of headers group
  contentclass: "mysubmenu", //Shared CSS class name of contents group
  revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
  mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
  collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
  defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
  onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
  animatedefault: false, //Should contents open by default be animated into view?
  persiststate: true, //persist state of opened contents within browser session?
  toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
  togglehtml: ["suffix", "<img src='images/plus.gif' class='mystatus' />", "<img src='images/minus.gif' class='mystatus' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
  animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
  oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
    //do nothing
  },
  onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
    //do nothing
  }
})
</script>
</body>
</html>
