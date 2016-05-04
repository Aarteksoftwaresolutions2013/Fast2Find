<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery.timeentry.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
var b = document.documentElement;
b.setAttribute('data-useragent',  navigator.userAgent);
</script>
<script type="text/javascript" >
$(document).ready(function(){
  $('#fullEvent').hide();     
  $('#dayEvent').hide();     
  var comment="${comment}";
  var type="${type}";
  var id='${branchId}';
  var descr="${descreption}";
  var fullEventPrice="${fullEventPrice}";
  var dayPrice="${dayPrice}";
  document.getElementById('bId').value=id 
  document.getElementById('orderPlace').value=descr
  document.getElementById('comment').value=comment
  });
function showValue()
{
var descr="${descreption}";
var noOFPeople=document.getElementById("amop").value;
var show="Your Order:"+descr+','+noOFPeople+'People ';
document.getElementById("time-concert").innerHTML =show;
if($("input:radio[name='fullEvent']").is(":checked")) {
  var value = $("input[name='fullEvent']:checked").val();
  var noOfPerson=document.getElementById("amop").value
  if(value=='full')
     {
  document.getElementById("total-including").value="Total Including Taxt: $"+noOfPerson*${fullEventPrice};
     }
  else
    {
    document.getElementById("total-including").value="Total Including Taxt: $"+noOfPerson*${dayPrice};
    }
}
else
  {
  alert("Please select Full OR One Event Type");
  }
}
$(function () {
$("input:radio[name=fullEvent]").click(function() {
  /* var value = $(this).val();
  var noOfPerson=document.getElementById("amop").value
   if(value=='full')
     {
        $('#fullEvent').show();
        $('#dayEvent').hide();
        if(noOfPerson=="")
          {
          alert("Please Enter No Of Person");
          }
        else
          {
          document.getElementById("total-including").value="Total Including Taxt: $"+noOfPerson*${fullEventPrice};
          }
     }
   else
     {
        $('#fullEvent').hide();
        $('#dayEvent').show();
        if(noOfPerson=="")
        {
        alert("Please Enter No Of Person");
        }
      else
        {
        document.getElementById("total-including").value="Total Including Taxt: $"+noOfPerson*${dayPrice};
        }
        } */
});
});
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
      <h3>${message}</h3>
      <h2>Quick Booking</h2>
      <h1 class="serv">Services</h1>
      <div class="form-content">
      <div class="left-sect">
      <form:form method="POST" modelAttribute="QuickBooking"  id="quick-bk-frm" name="eventQuickBooking">
      <ul>
      <div id="quickService">
      <li>
      <input type="checkbox" name="service" id="tfc" class="tfc" value="Tickets for Concert" />
      <label for="tfc" class="tfc"><span></span>Tickets for Concert</label>
      </li>
      
      <li>
      <input type="checkbox" name="service" id="tfcomdy" class="tfcomdy" value="Tickets for Comedy" />
      <label for="tfcomdy" class="tfcomdy"><span></span>Tickets for Comedy</label>
      </li>
      
      </div>
      <li><span id="quickBusServiceId" style="display:none;" class="error" >Please select atleast one checkbox</span></li>
      <%-- <div id="fullEvent">
        <li><h3 class="per-per">$<c:out value='${fullEventPrice}' />/ Person</h3></li>
      </div>
     <div id="dayEvent">
      <li><h3 class="per-per">$<c:out value='${dayPrice}' />/ Person</h3></li>
      </div> --%>
        <li><h3 class="per-per">$0/ Person</h3></li>
      <li>
      <form:input path="numberOfPerson"  name="Amount-of-People" id="amop" placeholder="Amount of People" required="autofocus" maxlength="4" onkeyup="hourrVal(this)" onchange="showValue()" />
      <form:hidden path="bId"  id="bId" />
            <form:hidden path="comment"  id="comment" />
      </li>
      <li><form:errors path="numberOfPerson" cssClass="error"></form:errors>
      </li>
      <li><span id="numberOfPerson" style="display:none;" class="error" >Please Enter No Of Person</span></li>
      <li>
      <p id="time-concert" ></p>
      </li>
      
      <li>
      <input type="text" value="Total Including Taxt: $0" id="total-including" />
      </li>
      <form:hidden path="orderPlace"  id="orderPlace" />
      <li>
      <input type="button" name="sumbit-payment" id="sum-pay" value="Submit Payment" onclick="eventQuick()" />
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
<div class="widget-topright">
<ul>
<li>
      <input type="radio" id="Buy"  name="fullEvent" value="full"/>
      <label for="Buy" class="Buy"><span></span>Buy tickets or full event</label>
      </li>
      <li>
      <input type="radio" id="Buy1" name="fullEvent" value="day"/>
      <label for="Buy1" class="Buy1"><span></span>Buy tickets or one event</label>
      </li> 
</ul>
</div>
<div class="side-widgetb" id="widgetb">
  <h2>Let us know how it was</h2>
  <div class="likeid" id="likendislik">
  <ul><li>
<div class="custompin-radio"><input type="radio" name="likedStatus" id="likeid"><label for="likeid" class=""><span></span>I like this application</label></div>
</li>
<li>
<div class="custompin-radio"><input type="radio" name="likedStatus" id="dislikeid"><label for="dislikeid" class=""><span></span>I do no like this application</label></div>
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
