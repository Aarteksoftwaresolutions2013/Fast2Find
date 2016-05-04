$(document).ready(function () {
var d=$("#the_list").val();
if(d=='Customer')
{
  $('.the_show').hide();
  $('#global').show(); 
}
  if(d=='global')
    {
      $('.the_show').hide();
        $('#global').show(); 
    }
//Attaching the change event of dropdown list
$('#the_list').change(function () {
//Grab the value from dropdownlist
$('.the_show').hide();
$('.'+this.value).show();
});
$('#same_as_bil').change(function () {
if($('#same_as_bil').is(":checked")){
$("#fld-rc").val($("#fld-c").val());
$("#fld-rd").val($("#fld-d").val());
$("#fld-re").val($("#fld-e").val());
$("#fld-rf").val($("#fld-f").val());
$("#sign-gbal-right").val($("#sign-gbal").val());
}
});
var email=document.getElementById("fld-g").value;
var pass=document.getElementById("fld-pss").value;
document.getElementById("fld-h").value=email;
document.getElementById("fld-ps").value=pass;
var address="${BusinessAndEventInformation.sameAddress}";
if(address=="on")
  {
  $('#same_as_bil').attr('checked', true);
  }
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
  if($('#same_as_bil').is(":checked")){
    $("#fld-rc").val($("#fld-c").val());
    $("#fld-rd").val($("#fld-d").val());
    $("#fld-re").val($("#fld-e").val());
    $("#fld-rf").val($("#fld-f").val());
    $("#sign-gbal-right").val($("#sign-gbal").val());
    }
  if($('#app4').is(":checked")){
	  $('#billing').hide();
	  }
	else
	{
	$('#billing').show();
	}
  });
function hideBillingAddress()
{
  $('#billing').hide();
}
function showBillingAddress()
{
  $('#billing').show();
}