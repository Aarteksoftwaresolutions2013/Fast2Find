<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
<script type="text/javascript">
var b = document.documentElement;
b.setAttribute('data-useragent',  navigator.userAgent);
</script>
<title>Insert title here</title>
</head>
<body>
		<div id="result-pages-content" class="result-pages-content">
			<h2>Results of Search</h2>
			<div id="pages-search" class="pages-search">
			<form action="" name="result-page" id="result-page" method="">
			<c:choose>
			<c:when test="${!empty searchList}">
			<c:forEach items="${searchList}" var="searchData">
			<fmt:parseDate value="${searchData[1]}" var="date" pattern="yyyy/MM/dd HH:mm"/>
			<fmt:formatDate type="date" value="${date}"  var="startDate"/>
			<fmt:parseDate value="${searchData[2]}" var="date" pattern="yyyy/MM/dd HH:mm"/>
			<fmt:formatDate type="date" value="${date}"  var="endDate"/>
			<input type="radio" name="radio-title" id="radio-a" checked />
			<label for="radio-a"><span></span>
			<a href="showEventInformation.do?branchId=${searchData[0]}"> ${searchData[3]}: ${startDate} - ${endDate}</a></label>
			</c:forEach>
			</c:when>
			<c:otherwise>
			<label for="radio-a"><span></span><c:out value="NO Record Found"></c:out></label>
			</c:otherwise>
			</c:choose>
			<!-- <input type="submit" id="showdetailes" name="title" value="Show Details" /> -->
			</form>			
			
			
			
			</div><!--------end pages-search------->
			
			</div>	
	<script type="text/javascript">
	// Run the script on DOM ready:
	$(function(){
		$('input').resultsrsearchInput();
	});
	</script>
<script type="text/javascript">
/*-------------------------------------------------------------------- 
 * jQuery plugin: resultsrsearchInput()
 * by Maggie Wachs and Scott Jehl, http://www.filamentgroup.com
 * Copyright (c) 2009 Filament Group
 * Dual licensed under the MIT (filamentgroup.com/examples/mit-license.txt) and GPL (filamentgroup.com/examples/gpl-license.txt) licenses.
 * Article: http://www.filamentgroup.com/lab/accessible_resultsrsearch_designed_checkbox_radio_button_inputs_styled_css_jquery/  
 * Usage example below (see comment "Run the script...").
--------------------------------------------------------------------*/


jQuery.fn.resultsrsearchInput = function(){
	$(this).each(function(i){	
		if($(this).is('[type=checkbox],[type=radio]')){
			var input = $(this);
			
			// get the associated label using the input's id
			var label = $('label[for='+input.attr('id')+']');
			
			//get type, for classname suffix 
			var inputType = (input.is('[type=checkbox]')) ? 'checkbox' : 'radio';
			
			// wrap the input + label in a div 
			$('<div class="resultsrsearch-'+ inputType +'"></div>').insertBefore(input).append(input, label);
			
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
			
			//bind resultsrsearch event, trigger it, bind click,focus,blur events					
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