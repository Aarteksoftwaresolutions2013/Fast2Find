function numeric(e) {
	e.value = e.value.replace(/[^0-9]+/g, '-');
}
function Validate(evt, txt) {
	var keyCode = evt.keyCode;
	if (keyCode < 37 || keyCode > 40) {
		txt.value = txt.value.replace(/[^a-zA-Z 0-9\n\r]+/g, '');
	}
	return false;
}
function onlyAlph(evt, alph) {
	var keyCode = evt.keyCode;
	if (keyCode < 37 || keyCode > 40) {
		alph.value = alph.value.replace(/[^a-zA-Z\-\']+/g, ' ');
	}
	return false;
}
function hourrVal(evt, hr) {
	var keyCode = evt.keyCode;
	if (keyCode < 37 || keyCode > 40) {
		hr.value = hr.value.replace(/[^0-9]+/g, '');
	}
	return false;
}
function num(evt, e) {
	var keyCode = evt.keyCode;
	if (keyCode < 37 || keyCode > 40) {
		e.value = e.value.replace(/[^0-9+-]+/g, '');
	}
	return false;
}
function emailVali(alph,evt) {
	var keyCode = evt.keyCode;
	if (keyCode < 37 || keyCode > 40) {
	alph.value = alph.value.replace(/[^a-zA-Z 0-9\n\r\-\_\.\@]+/g, '');
	}
	return false;
}
function checkspecialcharacter(txt) {
	 var invalidChars = /[^a-zA-Z 0-9\n\r\-\_\.\@]+/g 
	    if(invalidChars.test(txt.value)) {
	     txt.value = txt.value.replace(invalidChars,"");
	        }
	}
function uncheckCatagory() {
	var status = document.getElementById('special_event').checked;
	if (status) {
		$('.checkbox1').attr('checked', false);
	}
}
/*function special() {
	var status = document.getElementById('special_event').checked;
	if (status) {
		$('#special_event').attr('checked', false);
	}
}*/
var isValid = false;
function saveData() {
	vaildateform();
	if (isValid) {
		var type = $("#the_list").val();
		if (type == "Customer") {
			var data = {
				firstName : $("#fld-a").val(),
				lastName : $("#fld-b").val(),
				location : {
					address : $("#fld-c").val(),
					cityName : $("#fld-d").val(),
					stateName : $("#fld-e").val(),
					zipCode : $("#fld-f").val(),
					countryName : $("#sign-gbal").val(),
					billingAddress : $("#fld-rc").val(),
					billingCityName : $("#fld-rd").val(),
					billingStateName : $("#fld-re").val(),
					billingZipCode : $("#fld-rf").val(),
					billingCountryName : $("#sign-gbal-right").val()
				},
				login : {
					emailId : $("#fld-g").val(),
					password : $("#fld-pss").val(),
					userType : $("#the_list").val()
				},
				customerCatagory : $('input[name="customer"]:checked').val()
			};
			$.ajax({
				type : "POST",
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				url : "addCustomerInformation.do",
				data : JSON.stringify(data),
				success : function(data, status, request) {
					$('#statusInfo').html(data.responseText);
				},
				error : function(data, status, request) {
					$('#statusInfo').html(data.responseText);
					clearData();
					removeMessage();
				}
			});
		}
		if (type == "business" || type == "event") {
			var data = {
				firstName : $("#fld-a").val(),
				lastName : $("#fld-b").val(),
				location : {
					address : $("#fld-c").val(),
					cityName : $("#fld-d").val(),
					stateName : $("#fld-e").val(),
					zipCode : $("#fld-f").val(),
					countryName : $("#sign-gbal").val(),
					billingAddress : $("#fld-rc").val(),
					billingCityName : $("#fld-rd").val(),
					billingStateName : $("#fld-re").val(),
					billingZipCode : $("#fld-rf").val(),
					billingCountryName : $("#sign-gbal-right").val()
				},
				login : {
					emailId : $("#fld-g").val(),
					password : $("#fld-pss").val(),
					userType : $("#the_list").val()
				},
				businessCatagory : $('input[name="business"]:checked').val(),
				eventCatagory : $('input[name="event"]:checked').val()
			};
			$.ajax({
				type : "POST",
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				url : "addBusinessAndEventInfo.do",
				data : JSON.stringify(data),
				success : function(data, status, request) {
					$('#statusInfo').html(data.responseText);
				},
				error : function(data, status, request) {
					$('#statusInfo').html(data.responseText);
					clearData();
					removeMessage();
				}
			});
		}
	}
}
function removeMessage() {
	$('#userType').attr('style', 'display:none');
	$('#firstName').attr('style', 'display:none;');
	$('#lastName').attr('style', 'display:none;');
	$('#address').attr('style', 'display:none;');
	$('#city').attr('style', 'display:none;');
	$('#state').attr('style', 'display:none;');
	$('#zipCode').attr('style', 'display:none;');
	$('#email').attr('style', 'display:none;');
	$('#pasword').attr('style', 'display:none;');
	$('#busID').attr('style', 'display:none;');
	$('#custID').attr('style', 'display:none;');
	$('#eventID').attr('style', 'display:none;');
	$('#emailVal').attr('style', 'display:none;');
	$('#confirmEmail').attr('style', 'display:none;');
	$('#country').attr('style', 'display:none;');
}
function vaildateform() {
	$('input[type="text"]')
			.each(
					function() {
						var emailText = document.getElementById('fld-g').value;
						var confirmEmail = document.getElementById("fld-h").value;
						var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
						if (($.trim($('#the_list').val()) == 'global')
								&& ($.trim($('#fld-a').val()) == '')
								&& ($.trim($('#fld-b').val()) == '')
								&& ($.trim($('#fld-c').val()) == '')
								&& ($.trim($('#fld-d').val()) == '')
								&& ($.trim($('#fld-e').val()) == '')
								&& ($.trim($('#fld-f').val()) == '')
								&& ($.trim($('#fld-g').val()) == '')
								&& ($.trim($('#fld-pss').val()) == '')
								&& ($.trim($('#sign-gbal').val()) == 'selected')) {
							$('#userType').attr('style',
									'display:block;color:red;');
							$('#firstName').attr('style',
									'display:block;color:red;');
							$('#lastName').attr('style',
									'display:block;color:red;');
							$('#address').attr('style',
									'display:block;color:red;');
							$('#city')
									.attr('style', 'display:block;color:red;');
							$('#state').attr('style',
									'display:block;color:red;');
							$('#zipCode').attr('style',
									'display:block;color:red;');
							$('#email').attr('style',
									'display:block;color:red;');
							$('#pasword').attr('style',
									'display:block;color:red;');
							$('#country').attr('style',
									'display:block;color:red;');
						} else if ($.trim($('#the_list').val()) == 'global') {
							$('#userType').attr('style',
									'display:block;color:red;');
							$('#firstName').attr('style', 'display:none;');
							$('#lastName').attr('style', 'display:none;');
							$('#address').attr('style', 'display:none;');
							$('#city').attr('style', 'display:none;');
							$('#state').attr('style', 'display:none;');
							$('#zipCode').attr('style', 'display:none;');
							$('#email').attr('style', 'display:none;');
							$('#pasword').attr('style', 'display:none;');
						} else if ($.trim($('#fld-a').val()) == '') {
							$('#userType').attr('style', 'display:none;');
							$('#firstName').attr('style',
									'display:block;color:red;');
							$('#lastName').attr('style', 'display:none;');
							$('#address').attr('style', 'display:none;');
							$('#city').attr('style', 'display:none;');
							$('#state').attr('style', 'display:none;');
							$('#zipCode').attr('style', 'display:none;');
							$('#email').attr('style', 'display:none;');
							$('#pasword').attr('style', 'display:none;');
						} else if ($.trim($('#fld-b').val()) == '') {
							$('#userType').attr('style', 'display:none;');
							$('#firstName').attr('style', 'display:none;');
							$('#lastName').attr('style',
									'display:block;color:red;');
							$('#address').attr('style', 'display:none;');
							$('#city').attr('style', 'display:none;');
							$('#state').attr('style', 'display:none;');
							$('#zipCode').attr('style', 'display:none;');
							$('#email').attr('style', 'display:none;');
							$('#pasword').attr('style', 'display:none;');
						} else if ($.trim($('#fld-c').val()) == '') {
							$('#userType').attr('style', 'display:none;');
							$('#firstName').attr('style', 'display:none;');
							$('#lastName').attr('style', 'display:none;');
							$('#address').attr('style',
									'display:block;color:red;');
							$('#city').attr('style', 'display:none;');
							$('#state').attr('style', 'display:none;');
							$('#zipCode').attr('style', 'display:none;');
							$('#email').attr('style', 'display:none;');
							$('#pasword').attr('style', 'display:none;');
						} else if ($.trim($('#fld-d').val()) == '') {
							$('#userType').attr('style', 'display:none;');
							$('#firstName').attr('style', 'display:none;');
							$('#lastName').attr('style', 'display:none;');
							$('#address').attr('style', 'display:none;');
							$('#city')
									.attr('style', 'display:block;color:red;');
							$('#state').attr('style', 'display:none;');
							$('#zipCode').attr('style', 'display:none;');
							$('#email').attr('style', 'display:none;');
							$('#pasword').attr('style', 'display:none;');
						} else if ($.trim($('#fld-e').val()) == '') {
							$('#userType').attr('style', 'display:none;');
							$('#firstName').attr('style', 'display:none;');
							$('#lastName').attr('style', 'display:none;');
							$('#address').attr('style', 'display:none;');
							$('#city').attr('style', 'display:none;');
							$('#state').attr('style',
									'display:block;color:red;');
							$('#zipCode').attr('style', 'display:none;');
							$('#email').attr('style', 'display:none;');
							$('#pasword').attr('style', 'display:none;');
						} else if ($.trim($('#sign-gbal').val()) == 'selected') {
							$('#userType').attr('style', 'display:none;');
							$('#firstName').attr('style', 'display:none;');
							$('#lastName').attr('style', 'display:none;');
							$('#address').attr('style', 'display:none;');
							$('#city').attr('style', 'display:none;');
							$('#state').attr('style', 'display:none;');
							$('#zipCode').attr('style', 'display:none;');
							$('#email').attr('style', 'display:none;');
							$('#pasword').attr('style', 'display:none;');
							$('#country').attr('style',
									'display:block;color:red;');
						} else if ($.trim($('#fld-f').val()) == '') {
							$('#userType').attr('style', 'display:none;');
							$('#firstName').attr('style', 'display:none;');
							$('#lastName').attr('style', 'display:none;');
							$('#address').attr('style', 'display:none;');
							$('#city').attr('style', 'display:none;');
							$('#state').attr('style', 'display:none;');
							$('#zipCode').attr('style',
									'display:block;color:red;');
							$('#email').attr('style', 'display:none;');
							$('#pasword').attr('style', 'display:none;');
						} else if ($.trim($('#fld-g').val()) == '') {
							$('#userType').attr('style', 'display:none;');
							$('#firstName').attr('style', 'display:none;');
							$('#lastName').attr('style', 'display:none;');
							$('#address').attr('style', 'display:none;');
							$('#city').attr('style', 'display:none;');
							$('#state').attr('style', 'display:none;');
							$('#zipCode').attr('style', 'display:none;');
							$('#email').attr('style',
									'display:block;color:red;');
							$('#pasword').attr('style', 'display:none;');
						} else if ($.trim($('#fld-pss').val()) == '') {
							$('#userType').attr('style', 'display:none;');
							$('#firstName').attr('style', 'display:none;');
							$('#lastName').attr('style', 'display:none;');
							$('#address').attr('style', 'display:none;');
							$('#city').attr('style', 'display:none;');
							$('#state').attr('style', 'display:none;');
							$('#zipCode').attr('style', 'display:none;');
							$('#email').attr('style', 'display:none;');
							$('#pasword').attr('style',
									'display:block;color:red;');
						} else if (($.trim($('#the_list').val()) == 'Customer')
								&& ($('#global3').find(
										'input[type=radio]:checked').length == 0)) {
							$('#userType').attr('style', 'display:none;');
							$('#firstName').attr('style', 'display:none;');
							$('#lastName').attr('style', 'display:none;');
							$('#address').attr('style', 'display:none;');
							$('#city').attr('style', 'display:none;');
							$('#state').attr('style', 'display:none;');
							$('#zipCode').attr('style', 'display:none;');
							$('#email').attr('style', 'display:none;');
							$('#pasword').attr('style', 'display:none;');
							$('#busID').attr('style', 'display:none;');
							$('#eventID').attr('style', 'display:none;');
							$('#custID').attr('style',
									'display:block;color:red;');
						} else if (($.trim($('#the_list').val()) == 'business')
								&& ($('#global1').find(
										'input[type=radio]:checked').length == 0)) {
							$('#userType').attr('style', 'display:none;');
							$('#firstName').attr('style', 'display:none;');
							$('#lastName').attr('style', 'display:none;');
							$('#address').attr('style', 'display:none;');
							$('#city').attr('style', 'display:none;');
							$('#state').attr('style', 'display:none;');
							$('#zipCode').attr('style', 'display:none;');
							$('#email').attr('style', 'display:none;');
							$('#pasword').attr('style', 'display:none;');
							$('#eventID').attr('style', 'display:none;');
							$('#custID').attr('style', 'display:none;');
							$('#busID').attr('style',
									'display:block;color:red;');
						} else if (($.trim($('#the_list').val()) == 'event')
								&& ($('#global2').find(
										'input[type=radio]:checked').length == 0)) {
							$('#userType').attr('style', 'display:none;');
							$('#firstName').attr('style', 'display:none;');
							$('#lastName').attr('style', 'display:none;');
							$('#address').attr('style', 'display:none;');
							$('#city').attr('style', 'display:none;');
							$('#state').attr('style', 'display:none;');
							$('#zipCode').attr('style', 'display:none;');
							$('#email').attr('style', 'display:none;');
							$('#pasword').attr('style', 'display:none;');
							$('#custID').attr('style', 'display:none;');
							$('#busID').attr('style', 'display:none;');
							$('#eventID').attr('style',
									'display:block;color:red;');
						} else if (!pattern.test(emailText)) {
							$('#emailVal').attr('style',
									'display:block;color:red;');
						} else if (emailText != confirmEmail) {
							$('#confirmEmail').attr('style',
									'display:block;color:red;');
						} else {
							isValid = true;
						}
					});
}
function clearData() {
	document.getElementById("fld-a").value = "";
	document.getElementById("fld-b").value = "";
	document.getElementById("fld-c").value = "";
	document.getElementById("fld-d").value = "";
	document.getElementById("fld-e").value = "";
	document.getElementById("fld-f").value = "";
	document.getElementById("fld-g").value = "";
	document.getElementById("fld-h").value = "";
	document.getElementById("fld-pss").value = "";
	document.getElementById("fld-ps").value = "";
	document.getElementById("fld-rc").value = "";
	document.getElementById("fld-rd").value = "";
	document.getElementById("fld-re").value = "";
	document.getElementById("fld-rf").value = "";
}
function confirmEmailValidation() {
	var emial = document.getElementById("fld-g").value;
	var confirmEmail = document.getElementById("fld-h").value;
	$('input[type="text"]').each(function() {
		if (emial != '' && confirmEmail != '') {
			if (emial != confirmEmail) {
				$('#confirmEmail').attr('style', 'display:block;color:red;');
			} else {
				$('#confirmEmail').attr('style', 'display:none;');
			}
		}
	});
}
function confirmPasswordValidation() {
	var password = document.getElementById("fld-pss").value;
	var confirmPassword = document.getElementById("fld-ps").value;
	$('input[type="text"]').each(function() {
		if (password != '' && confirmPassword != '') {
			if (password != confirmPassword) {
				$('#confirmPass').attr('style', 'display:block;color:red;');
			} else {
				$('#confirmPass').attr('style', 'display:none;');
			}
		}
	});
}
function searchValidation() {
	$('#msg').hide();
	var isValid = true;
	document.getElementById('paidUser').value = userType;
	if (($('#left-side-checkbox').find('input[type=checkbox]:checked').length == 0)
			&& ($('#search').val() == '')
			&& ($('#datepick').val() == 'Select Date')) {
		$('#checkId').attr('style', 'display:block;color:red;');
		$('#searchId').attr('style', 'display:block;color:red;');
		$('#dateMsgId').attr('style', 'display:block;color:red;');
		isValid = false;
	} else if ($('#left-side-checkbox').find('input[type=checkbox]:checked').length == 0) {
		$('#checkId').attr('style', 'display:block;color:red;');
		$('#searchId').attr('style', 'display:none;');
		$('#dateMsgId').attr('style', 'display:none;');
		isValid = false;
	} else if ($('#search').val() == '') {
		$('#searchId').attr('style', 'display:block;color:red;');
		$('#checkId').attr('style', 'display:none;');
		$('#dateMsgId').attr('style', 'display:none;');
		isValid = false;
	} else if ($('#datepick').val() == 'Select Date') {
		$('#searchId').attr('style', 'display:none;');
		$('#checkId').attr('style', 'display:none;');
		$('#dateMsgId').attr('style', 'display:block;color:red;');
		isValid = false;
	}
	if (isValid) {
		document.searchForm.action = "searchAction.do";
		document.searchForm.submit();
	}
}
function validateEmail() {
	var emailText = document.getElementById('fld-g').value;
	var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	$('input[type="text"]').each(function() {
		if (emailText != '') {
			if (!pattern.test(emailText)) {
				$('#emailVal').attr('style', 'display:block;color:red;');
			} else {
				$('#emailVal').attr('style', 'display:none;');
			}
		}
	});
}
function eventValidation() {
	var mobile = document.getElementById('field-e').value;
	$('input[type="text"]').each(function() {
		if (mobile.length < 10) {
			$('#mob').attr('style', 'display:block;color:red;');
		} else {
			$('#mob').attr('style', 'display:none;');
		}

	});
}
function eventValidateEmail() {
	var emailText = document.getElementById('field-j').value;
	var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	$('input[type="text"]').each(function() {
		if (emailText != '') {
			if (!pattern.test(emailText)) {
				$('#emailVal').attr('style', 'display:block;color:red;');
			} else {
				$('#emailVal').attr('style', 'display:none;');
			}
		}
	});
}
function tallyEmail() {
	var emailText2 = document.getElementById('field-ab').value;
	var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	$('input[type="text"]').each(function() {
		if (emailText2 != '') {
			if (!pattern.test(emailText2)) {
				$('#tallyEmailID').attr('style', 'display:block;color:red;');
			} else {
				$('#tallyEmailID').attr('style', 'display:none;');
			}
		}
	});
}
function tallyEmailVal() {
	var emailText2 = document.getElementById('eId').value;
	var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	$('input[type="text"]').each(function() {
		if (emailText2 != '') {
			if (!pattern.test(emailText2)) {
				$('#tallyId').attr('style', 'display:block;color:red;');
			} else {
				$('#tallyId').attr('style', 'display:none;');
			}
		}
	});
}
function doAjaxPost() {
	emptyValidation();
	// get the form values
	if (isValid) {
		var name = $('#name').val();
		var email = $('#email1').val();
		var message = $('#message').val();
		$.ajax({
			type : "POST",
			url : "visitorMessage.do",
			data : "name=" + name + "&email=" + email + "&message=" + message,
			success : function(response) {
				// we have the response
				$('#info').html(response);
				$('#info').show();
				$('#name').val('');
				$('#email1').val('');
				$('#message').val('');
				clearVisitorMessage();
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
}
function clearVisitorMessage() {
	$('#nameId').attr('style', 'display:none;');
	$('#emailID').attr('style', 'display:none;');
	$('#msgId').attr('style', 'display:none;');
}
function emptyValidation() {
	$('input[type="text"]')
			.each(
					function() {
						if (($.trim($('#name').val()) == '')
								&& ($.trim($('#email1').val()) == '')
								&& ($.trim($('#message').val()) == '')) {
							$('#nameId').attr('style',
									'display:block;color:red;');
							$('#emailID').attr('style',
									'display:block;color:red;');
							$('#info').hide();
							/*
							 * $('#msgId').attr('style',
							 * 'display:block;color:red;');
							 */
							isValid = false;
						} else if ($.trim($('#name').val()) == '') {
							$('#nameId').attr('style',
									'display:block;color:red;');
							$('#emailID').attr('style', 'display:none;');
							$('#msgId').attr('style', 'display:none;');
							isValid = false;
						} else if ($.trim($('#email1').val()) == '') {
							$('#nameId').attr('style', 'display:none;');
							$('#emailID').attr('style',
									'display:block;color:red;');
							$('#msgId').attr('style', 'display:none;');
							isValid = false;
						} else if ($.trim($('#message').val()) == '') {
							$('#nameId').attr('style', 'display:none;');
							$('#emailID').attr('style', 'display:none;');
							$('#msgId').attr('style',
									'display:block;color:red;');
							isValid = false;
						} else {
							var emailText2 = document.getElementById('email1').value;
							var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
							if (!pattern.test(emailText2)) {
								$('#emailMsgId').attr('style',
										'display:block;color:red;');
								$('#nameId').attr('style', 'display:none;');
								$('#msgId').attr('style', 'display:none;');
								$('#emailID').attr('style', 'display:none;');
								isValid = false;
							} else {
								$('#emailMsgId').attr('style', 'display:none;');
								isValid = true;
							}
						}
					});
}
function visitorEmail() {
	var emailText2 = document.getElementById('email1').value;
	var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	$('input[type="text"]').each(function() {
		if (emailText2 != '') {
			if (!pattern.test(emailText2)) {
				$('#emailMsgId').attr('style', 'display:block;color:red;');
				$('#emailID').attr('style', 'display:none;');
			} else {
				$('#emailMsgId').attr('style', 'display:none;');
			}
		}
	});
}
function nameEmpty() {
	var name = document.getElementById('name').value;
	$('input[type="text"]').each(function() {
		if (name == '') {
			$('#nameId').attr('style', 'display:block;color:red;');
		} else {
			$('#nameId').attr('style', 'display:none;');
		}
	});
}
function businessQuick() {
	var isValid = true;
	if (($('#quickService').find('input[type=checkbox]:checked').length == 0)
			&& ($('#amop').val() == '') && ($('#table-bok-time').val() == '')) {
		$('#quickBusServiceId').attr('style', 'display:block;color:red;');
		$('#numberOfPerson').attr('style', 'display:block;color:red;');
		$('#tableBookingTime').attr('style', 'display:block;color:red;');
		isValid = false;
	} else if ($('#quickService').find('input[type=checkbox]:checked').length == 0) {
		$('#quickBusServiceId').attr('style', 'display:block;color:red;');
		$('#numberOfPerson').attr('style', 'display:none;');
		$('#tableBookingTime').attr('style', 'display:none;');
		isValid = false;
	} else if ($('#amop').val() == '') {
		$('#numberOfPerson').attr('style', 'display:block;color:red;');
		$('#quickBusServiceId').attr('style', 'display:none;');
		$('#tableBookingTime').attr('style', 'display:none;');
		isValid = false;
	} else if ($('#table-bok-time').val() == '') {
		$('#numberOfPerson').attr('style', 'display:none;');
		$('#quickBusServiceId').attr('style', 'display:none;');
		$('#tableBookingTime').attr('style', 'display:block;color:red;');
		isValid = false;
	}
	if (isValid) {
		document.businessQuickBooking.action = "quickBookingAction.do";
		document.businessQuickBooking.submit();
	}
}
function eventQuick() {
	var isValid = true;
	if (($('#quickService').find('input[type=checkbox]:checked').length == 0)
			&& ($('#amop').val() == '')) {
		$('#quickBusServiceId').attr('style', 'display:block;color:red;');
		$('#numberOfPerson').attr('style', 'display:block;color:red;');
		isValid = false;
	} else if ($('#quickService').find('input[type=checkbox]:checked').length == 0) {
		$('#quickBusServiceId').attr('style', 'display:block;color:red;');
		$('#numberOfPerson').attr('style', 'display:none;');
		isValid = false;
	} else if ($('#amop').val() == '') {
		$('#numberOfPerson').attr('style', 'display:block;color:red;');
		$('#quickBusServiceId').attr('style', 'display:none;');
		isValid = false;
	}
	if (isValid) {
		document.eventQuickBooking.action = "eventQuickBookingAction.do";
		document.eventQuickBooking.submit();
	}
}
function uncheckAddress() {
	var status = document.getElementById('same_as_bil').checked;
	if (status) {
		document.getElementById("fld-rc").disabled = true;
		document.getElementById("fld-rd").disabled = true;
		document.getElementById("fld-re").disabled = true;
		document.getElementById("fld-rf").disabled = true;
		document.getElementById("sign-gbal-right").disabled = true;
	} else {
		document.getElementById("fld-rc").disabled = false;
		document.getElementById("fld-rd").disabled = false;
		document.getElementById("fld-re").disabled = false;
		document.getElementById("fld-rf").disabled = false;
		document.getElementById("sign-gbal-right").disabled = false;
	}
}
function moblen() {
	var contactNo = document.getElementById("phone-number").value;
	if (contactNo.length<10) {
		$('#contactNo').attr('style', 'display:block;color:red;');
	}
	else
		{
		$('#contactNo').attr('style', 'display:none;');
		}
}