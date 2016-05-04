<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<script type="text/javascript" src="js/jsp-js/businessUpdate.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.datetimepicker.js"></script>
<script type="text/javascript">
var music='${music}';
$(document).ready(function(){
<c:forEach items="${Branch.categoryAliasList}" var="list" >        
$('#cat'+"${list.catageory.catageoryId}").attr('checked', true);
<c:forEach var="sub" items='${list.subCategoryAliasList}' varStatus="subcon">
$('#sbCat'+"${sub.subCatageory.subCatageoryId}").attr('checked', true);
</c:forEach>
</c:forEach>
var startTime='${Branch.operatingHours.startTime}';
var sTime=startTime.split(",");
for(var j=0; j<sTime.length; j++) {
  document.getElementById('st'+j).value=sTime[j];
}
var endTime='${Branch.operatingHours.endTime}';
var eTime=endTime.split(",");
for(var k=0; k<eTime.length; k++) {
  document.getElementById('et'+k).value=eTime[k];
}
});
</script>
<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="js/common.js"></script>
<title>Insert title here</title> 
</head>
<body>
<jsp:scriptlet>
      String[] countryName = new String[]{"Afghanistan", "Albania", "Algeria","American Samoa","Andorra","Angola","Anguilla","Antarctica","Antigua and Barbuda","Argentina","Armenia","Aruba","Australia","Azerbaijan","Bahamas","Bahrain","Bangladesh","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia and Herzegovina","Botswana","Bouvet Island","Brazil","British Indian Ocean Territory","Brunei Darussalam","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Cayman Islands","Central African Republic","Chad","Chile","China","Christmas Island","Cocos Islands","Colombia","Comoros","Congo","Congo", "Democratic Republic of the","Cook Islands","Costa Rica","Cote d'Ivoire","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Falkland Islands","Faroe Islands","Fiji","Finland","France","French Guiana","French Polynesia","Gabon","Gambia","Georgia","Germany","Gibraltar","Greece","Greenland","Grenada","Guadeloupe","Guam","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Heard Island and McDonald Islands","Honduras","Hong Kong", "Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati","Kyrgyzstan","Laos","Latvia","Lebanon","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macao","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Martinique","Mauritania","Maldives","Mauritius","Mayotte","Mexico","Micronesia"
          ,"Moldova","Monaco","Mongolia","Montenegro","Montserrat","Morocco","Mozambique","Myanmar","Namibia","Nauru","Nepal","Netherlands","Netherlands Antilles","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","Norfolk Island","North Korea","Norway","Oman","Pakistan","Palau","Palestinian Territory","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Pitcairn","Poland","Portugal","Puerto Rico","Qatar","Romania","Russian Federation","Rwanda","Saint Helena","Saint Kitts and Nevis","Saint Lucia","Saint Pierre and Miquelon","Saint Vincent and the Grenadines","Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","South Africa","South Georgia","South Korea","Spain","Sri Lanka","Sudan","Suriname","Svalbard and Jan Mayen","Swaziland","Sweden","Switzerland","Syrian Arab Republic","Taiwan","Tajikistan","Tanzania","Thailand","The Former Yugoslav Republic of Macedonia","Timor-Leste","Togo","Tokelau","Trinidad and Tobago","Tunisia","Turkey","Turkmenistan" ,"Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States","United States Minor Outlying Islands","Uruguay","Uzbekistan","Vatican City","Venezuela","Venezuela","Vietnam","Virgin Islands, British","Virgin Islands, U.S.","Wallis and Futuna","Western Sahara","Yemen","Zambia","Zimbabwe"};
              pageContext.setAttribute("countryName", countryName);
</jsp:scriptlet>
<div id="busn-page" class="busn-page">
          <h1>Event or Business Details<span class="headin-busi"> Pick Your Category</span></h1>
          <h3>${message}</h3>
          <div id="business-page-update" class="business-page-update">
          <form:form modelAttribute="Branch" action="updateBusinessInfo.do" method="post" name="business-update" class="business-update" target="_top" autocomplete="off">
          <ul class="first-busi-left">
          <li>
          <label for="business-name"><span>Business Name</span></label>
          <form:input path="branchName" id="business-name" name="business-name"  placeholder="Business Name" required ="autofocus" maxlength="50" />
          <form:errors path="branchName" cssClass="error"></form:errors>
          <form:hidden path="branchId" />
          <form:hidden path="location.locationId" />
          <form:hidden path="login.loginId" />
          </li>
          
          <li>
          <label for="max-capacity"><span>Max Capacity</span></label>
          <form:input path="maxCapacity" id="max-capacity" name="max-capacity"  placeholder="Max Capacity" required ="autofocus" maxlength="5" onkeyup="hourrVal(event,this)" />
          </li>
          <li>
          <label for="phone-number"><span>Phone Number</span></label>
          <form:input path="contactNo" id="phone-number" name="phone-number"  placeholder="Phone Number" required ="autofocus" maxlength="15" onkeyup="num(event,this)" />
          </li>
          <li><form:errors path="contactNo" cssClass="error"></form:errors></li>
          <li><form:errors path="maxCapacity" cssClass="error"></form:errors></li>
          <li>
          <label for="location-addres"><span>Location Address</span></label>
          <form:input path="location.address" id="location-addres" name="location-addres"  placeholder="Location Address" maxlength="150" required ="autofocus"/>
          <form:errors path="location.address" cssClass="error"></form:errors>
          </li>
          
          <li>
          <label for="city-name"><span>City</span></label>
          <form:input path="location.cityName" id="city-name" name="city-name" placeholder="City" required ="autofocus" maxlength="20" onkeyup="onlyAlph(event,this)" />
          </li>
          <li>
          <label for="state-province"><span>State/Province</span></label>
          <form:input path="location.stateName" id="state-province" name="state-province"  placeholder="State/Province" required ="autofocus" maxlength="20" onkeyup="onlyAlph(event,this)"/>
          </li>
          <li><form:errors path="location.cityName" cssClass="error"></form:errors></li>
          <li><form:errors path="location.stateName" cssClass="error"></form:errors></li>
          <li>
          <label for="zip-code"><span>Zip Code</span></label>
          <form:input path="location.zipCode" id="zip-code" name="zip-code" placeholder="Zip Code" required ="autofocus" maxlength="10" onkeyup="Validate(event,this)" />
          </li>
          <li>
              <label for="Country"><span>Select Country</span></label>
                <form:select path="location.countryName" id="selectint" >
            <form:option value="selected" selected="selected" label="Select Country" />
          <c:forEach items="${pageScope.countryName}" var="country">
          <form:option value="${country}" label="${country}"  />
          </c:forEach>
          </form:select>
          </li>
          <li><form:errors path="location.zipCode" cssClass="error"></form:errors></li>
          <li>
          <label for="q-b-f-p-p"><span>Quick Booking Fee Per Person</span></label>
          <form:input path="chargePerPerson" id="hr-opr" name="quickBookingFeePerPerson" placeholder="Quick Booking Fee Per Person" required ="autofocus" maxlength="15" />
          </li>
          <li><form:errors path="chargePerPerson" cssClass="error"></form:errors></li>
          <li>
          <label for="q-b-f-pr-table"><span>Quick Booking Fee Per Table</span></label>
          <form:input path="quickBookingFeePerTable" id="hr-opr" name="q-b-f-pr-table"  placeholder="Quick Booking Fee Per Table" required ="autofocus" maxlength="5" onkeyup="hourrVal(event,this)"/>
          </li>
          <li><form:errors path="quickBookingFeePerTable" cssClass="error"></form:errors></li>
          <h3>Tally App Access to</h3>
          <li>
           <label for="eId"><span>Email Id</span></label>
          <form:input path="login.emailId"  placeholder="name@email.com" id="eId" required ="autofocus" maxlength="50" onblur="tallyEmailVal()"/>
          </li>
          <li><form:errors path="login.emailId" cssClass="error"></form:errors></li>
          <li>
           <label for="hr-opr"><span>Password</span></label>
          <form:input path="login.password"  placeholder="Password" id="hr-opr"  maxlength="15" required ="autofocus"/>
          </li>
          <li><form:errors path="login.password" cssClass="error"></form:errors></li>
          
          </ul>
           <hr class="busin-page-lin">
  
  <div class="glossymenu">

<div class="checkall"><input type="checkbox" id="selecctall"/><label for="selecctall"> Select All </div>
            <c:forEach items="${catageory}" var="catageoryList"  varStatus="con">            
            <div class="club-sec">
            <div class="toch-togle"><a class="menuitem submenuheader" href="#" headerindex="0h"><span class="accordprefix"></span><span class="accordsuffix"></span><span class="statusicon" id="hmmm"></span></a></div>
            <div class="club-sect">
            <form:checkbox path="catagoryList" id="cat${catageoryList.catageoryId}"  value="${catageoryList.catageoryId}"  class="checkbox1"/> 
            <label for="cat${catageoryList.catageoryId}"><span></span>${catageoryList.catageoryName}</label>
            </div> <!-----club-sect----->
            </div>
            
            <div class="sub-cate-sec">

<div class="submenu" contentindex="0c" style="display: none;">
  <ul>
<c:forEach var="sub" items='${catageoryList.subCatageoryList}' varStatus="subcon">
  <li>
   <form:checkbox path="subCatagoryList" id="sbCat${sub.subCatageoryId}"  value="${sub.subCatageoryId}"  class="checkbox1"/>
 <label for="sbCat${sub.subCatageoryId}"><span></span>${sub.subCatageoryName}</label>
  </li>
</c:forEach>  
 </ul>
</div>
</div><!----------.sub-cate-sec------->
</c:forEach>
  <ul><li><form:errors path="catagoryList" cssClass="error"></form:errors></li></ul>
<ul>
<li>
          <h2>Music or Genre typically played select all that apply:</h2>
          </li>
          
          <li>
          <form:checkbox path="music" id="msCountry"  value="Country" />
          <label for="msCountry">Country</label>
          </li>
          </br>
          <li>
          <form:checkbox path="music" id="mship-hop"  value="hip-hop" />
          <label for="mship-hop"><span></span>Hip-Hop/Rap</label>
          </li>
           </br>
          <li>
          <form:checkbox path="music" id="msJazz"  value="Jazz" />
          <label for="msJazz"><span></span>Jazz</label>
          </li>
           </br>
          <li>
          <form:checkbox path="music" id="mshous-electr-dnce"  value="hous-electr-dnce" />
          <label for="mshous-electr-dnce"><span></span>House/ Electronic/ Dance</label>
          </li>
           </br>
          <li>
          <form:checkbox path="music" id="msdance-top"  value="dance-top" />
          <label for="msdance-top"><span></span>Dance/ Top 40</label>
          </li>
         </br>
          <li>
          <form:checkbox path="music" id="msMetal"  value="Metal" />
          <label for="msMetal"><span></span>Metal</label>
          </li>
           </br>
          <li>
          <form:checkbox path="music" id="msRock"  value="Rock" />
          <label for="msRock"><span></span>Rock</label>
          </li>
           </br>
          <li>
          <form:checkbox path="music" id="msClassical"  value="Classical" />
          <label for="msClassical"><span></span>Classical</label>
          </li>
           </br>
           <li>
          <form:checkbox path="music" id="Italian"  value="Italian" />
          <label for="Italian"><span></span>Italian</label>
          </li>
           </br>
             <li>
          <form:checkbox path="music" id="Indian"  value="Indian" />
          <label for="Indian"><span></span>Indian</label>
          </li>
           </br>
          <li>
          <form:checkbox path="music" id="Canadian" value="Canadian" />
          <label for="Canadian"><span></span>Canadian</label>
          <form:errors path="music" cssClass="error"></form:errors>
          </li>
   </ul>
</div>
</div><!-----..right-checkbox-sct--------->
  <div class="weakly-table" id="weak-table">
<h3>Operating Hours:</h3>
<table border="0px" cellspacing="0" cellpadding="0" width="100%" class="mid-table">
<thead>
<tr>
<th class="weakdays"> Weakday </th>
<th class="opening-time">Open Time</th>
<th class="closeing-time">Close Time</th>
</tr>
</thead>
<tbody>
<tr>
<td class="weakz">Monday</td>
<td><form:input path="operatingHours.startTime"  id="st0" maxlength="12" /></td>
<td><form:input path="operatingHours.endTime" id="et0" maxlength="12" /></td>
</tr>
<tr>
<td class="weakz">Tuesday</td>
<td><form:input path="operatingHours.startTime" id="st1" maxlength="12" /></td>
<td><form:input path="operatingHours.endTime" id="et1" maxlength="12" /></td>
</tr>
<tr>
<td class="weakz">Wedesday</td>
<td><form:input path="operatingHours.startTime"  id="st2"  maxlength="12" /></td>
<td><form:input path="operatingHours.endTime" id="et2" maxlength="12" /></td>
</tr>
<tr>
<td class="weakz">Thursday</td>
<td><form:input path="operatingHours.startTime" id="st3"  maxlength="12" /></td>
<td><form:input path="operatingHours.endTime" id="et3" maxlength="12" /></td>
</tr>
<tr>
<td class="weakz">Friday</td>
<td><form:input path="operatingHours.startTime" id="st4" maxlength="12" /></td>
<td><form:input path="operatingHours.endTime" id="et4" maxlength="12" /></td>
</tr>
<tr>
<td class="weakz">Saturday</td>
<td><form:input path="operatingHours.startTime" id="st5"  maxlength="12" /></td>
<td><form:input path="operatingHours.endTime" id="et5" maxlength="12" /></td>
</tr>
<tr>
<td class="weakz">Sunday</td>
<td><form:input path="operatingHours.startTime"  id="st6" maxlength="12" /></td>
<td><form:input path="operatingHours.endTime" id="et6" maxlength="12" /></td>
</tr>
</tbody>
</table>
</div>        
          <h4 class="detils">Please enter details of business via quick box or use calendar to input details</h4>
          <h4>Business or Event Details Repeating:</h4>
          
          <ul class="center-layou-table">
          <li>
          <label for="months"><span></span></label>
                     <form:input path="eventRepeatDate" id="datetimepicker" class="time ui-timepicker-input" placeholder="Select Date and Time" />
          </li>
         
          <li id="text-area">
          <label for="tex-area"><span></span></label>
           <form:textarea path="description" rows="7" cols="30" id="tex-area"   placeholder="Internal notice for Business Owner"  maxlength="100"  />
          </li>
          
          <li id="time-start">
          <label for="time-strt" style="display:block; color:#d1d1d1"><span></span>Start Time</label>
          <form:input path="eventStartDateAndTime" id="datetimepicker1"  class="time ui-timepicker-input" placeholder="Select Date and Time" />
          </li>
          
          <li id="time-endz">
          <label for="End-Time" style="display:block; color:#D1d1d1"><span></span>End Time</label>
          <form:input path="eventEndDateAndTime" id="datetimepicker2" class="time" placeholder="Select Date and Time" />
          
          </li>
          <li id="list-select">
          <select name="list" id="list">
             <option value="daily">Daily</option>
          <option value="weekly">Weekly</option>
          <option value="fornightly">Fortnightly</option>
          <option value="monthly">Monthly</option>
          </select>
          </li>
          
          <li class="check-all-tag">
          <input type="checkbox" id="all" />
          <label for="all" class="uip"><span></span></label>
          
          
          </li>
          
          <li>
          <span class="para">
          <p>Check here to allow Quick Booking , fee is 5% of booking.<p>
          <p>This allows customers to book table instaneously through website.</p>
          </span></li>
          </ul>
          
          <ul id="read-only-inp">
          <li>
          <label for="name-a"><span></span></label>
          <form:input path="additionalInfo" id="name-a" placeholder="Use this for additional information" />
          </li>
          
          <li>
          <label for="name-b"><span></span></label>
          <form:input path="additionalInfo" id="name-b" placeholder="Use this for additional information" />
          </li>
          
          <li>
           <label for="name-b"><span></span></label>
          <form:input path="additionalInfo" id="name-c" placeholder="Use this for additional information" />
          </li>
          
          <li>
          <label for="name-b"><span></span></label>
          <form:input path="additionalInfo" id="name-d" placeholder="Use this for additional information" />
          </li>
          
          <li>
          <label for="submit-detils"><span></span></label>
          
          <input type="submit" id="submit-detils" value="Update Details "/>
          </li>
          
          </ul>
          </form:form>
          </div><!----------end business-page-update---------->
        </div><!----========================end page-content==========================----------> 

<script type="text/javascript">
/*-------------------------------------------------------------------- 
 * jQuery plugin: customaaInput()
 * by Maggie Wachs and Scott Jehl, http://www.filamentgroup.com
 * Copyright (c) 2009 Filament Group
 * Dual licensed under the MIT (filamentgroup.com/examples/mit-license.txt) and GPL (filamentgroup.com/examples/gpl-license.txt) licenses.
 * Article: http://www.filamentgroup.com/lab/accessible_customaa_designed_checkbox_radio_button_inputs_styled_css_jquery/  
 * Usage example below (see comment "Run the script...").
--------------------------------------------------------------------*/
jQuery.fn.customaaInput = function(){
  $(this).each(function(i){ 
    if($(this).is('[type=checkbox],[type=radio]')){
      var input = $(this);
      var label = $('label[for='+input.attr('id')+']');
      var inputType = (input.is('[type=checkbox]')) ? 'checkbox' : 'radio';
      $('<div class="customaa-'+ inputType +'"></div>').insertBefore(input).append(input, label);
      var allInputs = $('input[name='+input.attr('name')+']');
      label.hover(
        function(){ 
          $(this).addClass('hover'); 
          if(inputType == 'checkbox' && input.is(':checked')){ 
            $(this).addClass('checkedHover'); 
          } 
        },
        function(){ $(this).removeClass('hover checkedHover'); }
      );
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
</script>
<script type="text/javascript">
ddaccordion.init({
  headerclass: "submenuheader", //Shared CSS class name of headers group
  contentclass: "submenu", //Shared CSS class name of contents group
  revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
  mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
  collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
  defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
  onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
  animatedefault: false, //Should contents open by default be animated into view?
  persiststate: true, //persist state of opened contents within browser session?
  toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
  togglehtml: ["suffix", "<span class='statusicon'>&nbsp;</span>", "<span class='statusicon' id='hmm'>&nbsp;</span>"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
  animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
  oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
    //do nothing
  },
  onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
    //do nothing
  }
})
</script>
<!---------------select all checkbox javascript------------------------>
</html>