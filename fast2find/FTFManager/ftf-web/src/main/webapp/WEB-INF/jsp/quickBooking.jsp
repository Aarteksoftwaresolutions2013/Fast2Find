<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery.timeentry.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
var b = document.documentElement;
b.setAttribute('data-useragent',  navigator.userAgent);
</script>
<script type="text/javascript" >
$(document).ready(function(){
  var feePerPerson="${feePerPerson}";
  });
function showValue()
{
var id='${branchId}';
var descr="${descreption}";
var noOFPeople=document.getElementById("amop").value;
var time=document.getElementById("table-bok-time").value;
var show="Your Order:"+descr+','+noOFPeople+'People at '+time;
document.getElementById("time-concert").innerHTML =show;
document.getElementById('bId').value=id ;
document.getElementById('orderPlace').value=descr;
}
function totalValue()
{
/*  var feePerPerson="${feePerPerson}";
  var noOFPeople=document.getElementById("amop").value;
  var total=feePerPerson*noOFPeople;
  document.getElementById("total-including").value="Total Including Taxt: $"+total; */
}
</script>
<script type="text/javascript" >
$(function () {
  $('#table-bok-time').timeEntry();
});
</script>
</head>
<body>
      <!---------------------Quick-Booking page here ------------------------>      
      <div id="quick-booking-content" class="quick-booking-content">      
      <h2>Quick Booking</h2>
      <h1 class="serv">Services</h1>
      <div class="form-content">
          <div class="left-sect">
      <form:form method="POST" modelAttribute="QuickBooking"  id="quick-bk-frm" name="businessQuickBooking" autocomplete="off" >
      <ul>
      <div id="quickService">
      <li>
      <input type="checkbox" name="service" id="bst" class="bst" value="Bottle Service Table" />
      <label for="bst" class="bst"><span></span>Bottle Service Table</label>
      </li>
      
      <li>
      <input type="checkbox" name="service" id="tfc" class="tfc" value="Tickets for Concert" />
      <label for="tfc" class="tfc"><span></span>Tickets for Concert</label>
      </li>
      
      <li>
      <input type="checkbox" name="service" id="tfcomdy" class="tfcomdy" value="Tickets for Comedy" />
      <label for="tfcomdy" class="tfcomdy"><span></span>Tickets for Comedy</label>
      </li>
      
      <li>
      <input type="checkbox" name="service" id="tfrest" class="tfrest" value="Table at Restaurant" />
      <label for="tfrest" class="tfrest"><span></span>Table at Restaurant</label>     
      </li>
      </div>
      
      <li><form:errors path="service" cssClass="error"></form:errors></li>
      <li><span id="quickBusServiceId" style="display:none;" class="error" >Please select atleast one checkbox</span></li>
      <%-- <li><h3 class="per-per">$<c:out value='${feePerPerson}' />/ Person</h3></li> --%>
           <li><h3 class="per-per">$0/ Person</h3></li>
      <li>
      <form:input path="numberOfPerson"  name="Amount-of-People" id="amop" placeholder="Amount of People" required="autofocus" maxlength="4" onkeyup="hourrVal(this)" onchange="totalValue()" />
      <form:input path="tableBookingTime" name="table-booking-time" id="table-bok-time" placeholder="Table Booking Time" required="autofocus" onblur="showValue()" maxlength="8" />
      <form:hidden path="bId"  id="bId" />
      </li>
      <li><form:errors path="numberOfPerson" cssClass="error"></form:errors>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <form:errors path="tableBookingTime" cssClass="error"></form:errors>
      </li>
      <li><span id="numberOfPerson" style="display:none;" class="error" >Please Enter No Of Person</span><span id="tableBookingTime" style="display:none;" class="error" >Please Enter Time</span>
      </li>
      <form:hidden path="orderPlace"  id="orderPlace" />
      <li>
      <p id="time-concert" ></p>
      </li>
      
      <li>
      <input type="text" value="Total Including Taxt: $0" id="total-including" />
      <c:out value='${total}' />
      </li>
      
      <li>
      <input type="button" name="sumbit-payment" id="sum-pay" value="Submit Payment" onclick="businessQuick()" />
      <span class="rdmor"><a href="termAndCondition.do" >Read Terms and Conditions</a></span>
      </li>
      <li>
      <p class="tiks">Tickets available at the door. Payment reciept will be sent to email address on file.</p>
      </li>
      </ul>
      
      </form:form>
      <div id="place" class="palce">
      <p class="plc">Place Holder to Display Your Note</p>
    </div>  
    </div>
    
<div class="right-sect">
<div class="side-widgetb" id="widgetb">
  <h2>Let us know how it was</h2>
  <div class="likeid" id="likendislik">
  <ul>
<li>
<div class="custompin-radio"><input type="radio" name="likedStatus" id="likeid" value="like" ><label for="likeid" class=""><span></span>I like this application</label></div>
</li>
<li>
<div class="custompin-radio"><input type="radio" name="likedStatus" id="dislikeid" value="dislike" ><label for="dislikeid" class=""><span></span>I do no like this application</label></div>
</li>
</ul>
  </div><!----end like div----->
  </div>
</div><!-----end right-sect------>
      </div><!-----close quick-booking-content------->      
<script type="text/javascript">
  // Run the script on DOM ready:
  $(function(){
    $('input').quickbkInput();
  });
  </script>
<script type="text/javascript">
/*-------------------------------------------------------------------- 
 * jQuery plugin: quickbkInput()
 * by Maggie Wachs and Scott Jehl, http://www.filamentgroup.com
 * Copyright (c) 2009 Filament Group
 * Dual licensed under the MIT (filamentgroup.com/examples/mit-license.txt) and GPL (filamentgroup.com/examples/gpl-license.txt) licenses.
 * Article: http://www.filamentgroup.com/lab/accessible_quickbk_designed_checkbox_radio_button_inputs_styled_css_jquery/  
 * Usage example below (see comment "Run the script...").
--------------------------------------------------------------------*/
jQuery.fn.quickbkInput = function(){
  $(this).each(function(i){ 
    if($(this).is('[type=checkbox],[type=radio]')){
      var input = $(this);
      // get the associated label using the input's id
      var label = $('label[for='+input.attr('id')+']');
      //get type, for classname suffix 
      var inputType = (input.is('[type=checkbox]')) ? 'checkbox' : 'radio';
      // wrap the input + label in a div 
      $('<div class="quickbk-'+ inputType +'"></div>').insertBefore(input).append(input, label);
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
      
      //bind quickbk event, trigger it, bind click,focus,blur events          
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
$(document).ready(function(){
if(!Modernizr.input.placeholder){
  $('[placeholder]').focus(function() {
    var input = $(this);
    if (input.val() == input.attr('placeholder')) {
    input.val('');
    input.removeClass('placeholder');
    }
  }).blur(function() {
    var input = $(this);
    if (input.val() == '' || input.val() == input.attr('placeholder')) {
    input.addClass('placeholder');
    input.val(input.attr('placeholder'));
    }
  }).blur();
  $('[placeholder]').parents('form').submit(function() {
    $(this).find('[placeholder]').each(function() {
    var input = $(this);
    if (input.val() == input.attr('placeholder')) {
      input.val('');
    }
    })
  });
}
});
</script>
</body> 
</html>
