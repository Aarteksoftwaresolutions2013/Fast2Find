<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jsp-js/eventUpdate.js"></script>
  <script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.datetimepicker.js"></script>
<title>Insert title here</title>
</head>
<body>
<!---------------------Event update page------------------------>
<jsp:scriptlet>
      String[] countryName = new String[]{"Afghanistan", "Albania", "Algeria","American Samoa","Andorra","Angola","Anguilla","Antarctica","Antigua and Barbuda","Argentina","Armenia","Aruba","Australia","Azerbaijan","Bahamas","Bahrain","Bangladesh","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia and Herzegovina","Botswana","Bouvet Island","Brazil","British Indian Ocean Territory","Brunei Darussalam","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Cayman Islands","Central African Republic","Chad","Chile","China","Christmas Island","Cocos Islands","Colombia","Comoros","Congo","Congo", "Democratic Republic of the","Cook Islands","Costa Rica","Cote d'Ivoire","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Falkland Islands","Faroe Islands","Fiji","Finland","France","French Guiana","French Polynesia","Gabon","Gambia","Georgia","Germany","Gibraltar","Greece","Greenland","Grenada","Guadeloupe","Guam","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Heard Island and McDonald Islands","Honduras","Hong Kong", "Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati","Kyrgyzstan","Laos","Latvia","Lebanon","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macao","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Martinique","Mauritania","Maldives","Mauritius","Mayotte","Mexico","Micronesia"
          ,"Moldova","Monaco","Mongolia","Montenegro","Montserrat","Morocco","Mozambique","Myanmar","Namibia","Nauru","Nepal","Netherlands","Netherlands Antilles","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","Norfolk Island","North Korea","Norway","Oman","Pakistan","Palau","Palestinian Territory","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Pitcairn","Poland","Portugal","Puerto Rico","Qatar","Romania","Russian Federation","Rwanda","Saint Helena","Saint Kitts and Nevis","Saint Lucia","Saint Pierre and Miquelon","Saint Vincent and the Grenadines","Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","South Africa","South Georgia","South Korea","Spain","Sri Lanka","Sudan","Suriname","Svalbard and Jan Mayen","Swaziland","Sweden","Switzerland","Syrian Arab Republic","Taiwan","Tajikistan","Tanzania","Thailand","The Former Yugoslav Republic of Macedonia","Timor-Leste","Togo","Tokelau","Trinidad and Tobago","Tunisia","Turkey","Turkmenistan" ,"Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States","United States Minor Outlying Islands","Uruguay","Uzbekistan","Vatican City","Venezuela","Venezuela","Vietnam","Virgin Islands, British","Virgin Islands, U.S.","Wallis and Futuna","Western Sahara","Yemen","Zambia","Zimbabwe"};
              pageContext.setAttribute("countryName", countryName);
</jsp:scriptlet>      
      <div id="event-update-page" class="event-update-page">
      <h3>${message}</h3>
      <h2>Register Event<span class="right-up">Tally App Access to</span></h2>
        <div id="event-form-page" class="event-form-page">
        <form:form modelAttribute="Branch" action="addEventInformation.do" method="post" name="event-page-form" autocomplete="off">
        <ul class="form-a">
        <li>
        <form:input path="eventName" name="title-here" placeholder="Event or Pavillion Name" required ="autofocus" id="field-a" maxlength="50"  onkeyup="Validate(event,this)" />
        <form:errors path="eventName" cssClass="error" ></form:errors>
        <form:hidden path="branchId" />
        <form:hidden path="location.locationId" />
        <form:hidden path="login.loginId" />
        </li>
        
        <li>
        <form:input path="eventKioskName" name="title-here" placeholder="Special Event Kiosk Name" required ="autofocus" id="field-b" maxlength="50" onkeyup="Validate(event,this)" />
        <form:errors path="eventKioskName" cssClass="error" ></form:errors>
        </li>
        
        <li>
        <form:input path="eventOwnerFName" name="title-here" placeholder="Event Owner First Name"  required ="autofocus" id="field-c" maxlength="50" onkeyup="onlyAlph(event,this)" />
        <form:input path="eventOwnerLName" name="title-here" placeholder="Event Owner Last Name" required ="autofocus" id="field-d" maxlength="50" onkeyup="onlyAlph(event,this)" />
        </li> 
        <li><form:errors path="eventOwnerFName" cssClass="error" ></form:errors>
       <form:errors path="eventOwnerLName" cssClass="error" ></form:errors></li>
        <li>
        <form:input path="contactNo" name="title-here" placeholder="Phone Number" required ="autofocus" id="field-e" maxlength="15" onkeyup="num(event,this)" onblur="eventValidation()" />
        <form:errors path="contactNo" cssClass="error" ></form:errors>
        </li>
        <li><span id="mob" style="display:none;" class="error" >Please enter atleast 10 digit Number</span></li>  
        
        <li>
        <form:input path="location.address" name="title-here" placeholder="Event Specific Location Address" required ="autofocus" id="field-f" maxlength="150" />
        <form:errors path="location.address" cssClass="error" ></form:errors>
        </li>
        <li>
        <form:input path="location.cityName" name="title-here" placeholder="City" required ="autofocus" id="field-g" maxlength="20" onkeyup="onlyAlph(event,this)"/>
        <form:input path="location.stateName" name="title-here" placeholder="State/Province" required ="autofocus" id="field-h" maxlength="20" onkeyup="onlyAlph(event,this)" />
        </li>
        <li><form:errors path="location.cityName" cssClass="error" ></form:errors>
        <form:errors path="location.stateName" cssClass="error" ></form:errors></li>
        <li>
        <form:input path="location.zipCode" name="title-here" placeholder="Zip/Post Code" required ="autofocus" id="field-i" maxlength="10"/>
        <form:select path="location.countryName" id="select-event">
      <form:option value="selected" selected="selected" label="Select Country" />
          <c:forEach items="${pageScope.countryName}" var="country">
          <form:option value="${country}" label="${country}"  />
          </c:forEach>
      </form:select>
        </li> 
        <li><form:errors path="location.zipCode" cssClass="error" ></form:errors>
        <form:errors path="location.countryName" cssClass="error" ></form:errors>
        </li>
        <li>
        <form:input path="eventEmail" name="email" placeholder="Email Address" id="field-j" maxlength="50" required ="autofocus" />
        <form:errors path="eventEmail" cssClass="error" ></form:errors>
        </li>
        <li>
        <form:input path="repeatEmail" name="repeat-mail"  placeholder="Repeat Email Address"  id="field-k" maxlength="50" required ="autofocus"/>
        <form:errors path="repeatEmail" cssClass="error" ></form:errors>
        </li>
        
        <li>
        <form:input path="maxCapacity" name="title-here" placeholder="Max Capacity of Event" required ="autofocus" id="field-L" maxlength="5" onkeyup="hourrVal(event,this)" />
        </li>
        <li><form:errors path="maxCapacity" cssClass="error" ></form:errors></li>
        <li>
        <input type="checkbox" name="allowQuickBooking" id="allow-to" />
        <%-- <form:checkbox path="allowQuickBooking" name="title-name" id="allow-to"  /> --%>
                <label for="allow-to"><span></span>Allow Quick Booking?</label>
        </li> 
        
        <li>
        <div id="priceDiv" style="display:none">
        <p>Daily Event <span class="right-full-eve">Full Event</span> </p>
        <form:input path="dailyEventTicket" name="title-here" placeholder="$30"  id="field-m" maxlength="5" onkeyup="hourrVal(event,this)"/>
        <form:input path="fullEventTicket" name="title-here" placeholder="$99"  id="field-n" maxlength="5" onkeyup="hourrVal(event,this)" />
       </div>
        </li>
        
        <li><form:errors path="dailyEventTicket" cssClass="error" ></form:errors></li>
        <li><form:errors path="fullEventTicket" cssClass="error" ></form:errors></li>
           <li>
           <p><b>Start Time</b>&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<span class="right-full-eve"><b>End Time</b></span> </p>
          </li>
          <li id="time-start">
          <form:input path="eventStartDateAndTime" id="datetimepicker1" class="time ui-timepicker-input" placeholder="Select Date and Time" />
          </li>
          
          <li id="time-endz">
          <form:input path="eventEndDateAndTime" id="datetimepicker2" class="time" placeholder="Select Date and Time" />
          </li>
          <li><form:errors path="eventStartDateAndTime" cssClass="error" ></form:errors></li>
          <li id="text-area">
          <label for="tex-area"><span></span></label>
           <form:textarea path="description" rows="7" cols="30" id="tex-area"  placeholder="Please leave us a message with additional details if you like!" maxlength="100" />
          </li>
        <li>
        <input type="submit" id="event-pagesubmit" value="Submit Details" />
        </li>
        </ul>
        
        <hr class="event-line" />
        <ul class="right-event-form">
          
        <li>
        <form:input path="login.emailId"   placeholder="name@email.com" autocomplate="off" id="field-ab" required ="autofocus" maxlength="50" />
        </li>
        <li>
        <form:password path="login.password" autocomplate="off" placeholder="Password"  id="field-bb" required ="autofocus" maxlength="15" />
        </li>
        <li><form:errors path="login.emailId" cssClass="error" ></form:errors>
        <form:errors path="login.password" cssClass="error" ></form:errors>
        </li>
        <!-- <li>
        <input type="email" name="user-mail" placeholder="Email Address" autocomplate="off" id="field-ac" required />
        </li>
        
        <li>
        <input type="Password" name="password" autocomplate="off" placeholder="Password" required id="field-af" />
        </li>
        
        <li>
        <input type="email" name="user-mail" placeholder="Email Address" autocomplate="off" id="field-ad" required />
        </li>
        
        <li>
        <input type="Password" name="password" autocomplate="off" placeholder="Password" required id="field-ae" />
        </li>
        
        <li>
        <input type="email" name="user-mail" placeholder="Email Address" autocomplate="off" id="field-ag" required />
        </li>
        
        <li>
        <input type="Password" name="password" autocomplate="off" placeholder="Password" required id="field-an" />
        </li>
        
        <li>
        <input type="email" name="user-mail" placeholder="Email Address" autocomplate="off" id="field-ajj" required />
        </li>
        
        <li>
        <input type="Password" name="password" autocomplate="off" placeholder="Password" required id="field-ann" />
        </li> -->
        </ul>
        
        <h2 class="upd">Update Stages</h2>
        <div id="stages" class="stages">
      <form:radiobutton path="updateStage" id="stage-1" value="1"/> 
      <label for="stage-1"><span></span>Update Stage 1</label>
      <form:radiobutton path="updateStage" id="stage-2" value="2"/>
      <label for="stage-2"><span></span>Update Stage 2</label>
      <form:radiobutton path="updateStage" id="stage-3" value="3"/>
      <label for="stage-3"><span></span>Stage 3</label>
      <form:radiobutton path="updateStage" id="stage-4" value="4"/>
      <label for="stage-4"><span></span>Stage 4</label>
      <form:radiobutton path="updateStage" id="stage-5" value="5"/>
      <label for="stage-5"><span></span>Stage 5</label>
      <form:radiobutton path="updateStage" id="stage-6" value="6"/>
      <label for="stage-6"><span></span>Stage 6</label>
      <form:radiobutton path="updateStage" id="stage-7" value="7"/>
      <label for="stage-7"><span></span>Stage 7</label>
      <form:radiobutton path="updateStage" id="stage-8" value="8"/>
      <label for="stage-8"><span></span>Stage 8</label>
      <form:radiobutton path="updateStage" id="stage-9" value="9"/>
      <label for="stage-9"><span></span>Stage 9</label>
      <form:radiobutton path="updateStage" id="stage-10" value="10"/>
      <label for="stage-10"><span></span>Stage 10</label>
      <form:radiobutton path="updateStage" id="stage-11" value="11"/>
      <label for="stage-11"><span></span>Stage 11</label>
      <form:radiobutton path="updateStage" id="stage-12" value="12"/>
      <label for="stage-12"><span></span>Stage 12</label>
      <form:radiobutton path="updateStage" id="stage-13" value="13"/>
      <label for="stage-13"><span></span>Stage 13</label>
      <form:radiobutton path="updateStage" id="stage-114" value="14"/>
      <label for="stage-114"><span></span>Stage 14</label>
       <form:errors path="updateStage" cssClass="error" ></form:errors>
      </div>
      </form:form>
      <!-----end form here-------->
        </div><!-----end event-from-page----->      
      </div><!-------------end event-update-page------->  
      <script type="text/javascript">
/*-------------------------------------------------------------------- 
 * jQuery plugin: customInput()
 * by Maggie Wachs and Scott Jehl, http://www.filamentgroup.com
 * Copyright (c) 2009 Filament Group
 * Dual licensed under the MIT (filamentgroup.com/examples/mit-license.txt) and GPL (filamentgroup.com/examples/gpl-license.txt) licenses.
 * Article: http://www.filamentgroup.com/lab/accessible_custom_designed_checkbox_radio_button_inputs_styled_css_jquery/  
 * Usage example below (see comment "Run the script...").
--------------------------------------------------------------------*/
jQuery.fn.customkhaInput = function(){
  $(this).each(function(i){ 
    if($(this).is('[type=checkbox],[type=radio]')){
      var input = $(this);
      // get the associated label using the input's id
      var label = $('label[for='+input.attr('id')+']');
      //get type, for classname suffix 
      var inputType = (input.is('[type=checkbox]')) ? 'checkbox' : 'radio';
      // wrap the input + label in a div 
      $('<div class="customkha-'+ inputType +'"></div>').insertBefore(input).append(input, label);
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
</body>
</html>