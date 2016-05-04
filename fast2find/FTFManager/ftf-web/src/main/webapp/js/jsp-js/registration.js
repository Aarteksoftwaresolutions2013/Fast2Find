  $(document).ready(function () {
        $('.the_show').hide();
        $('.global').show();
            //Attaching the change event of dropdown list
        if($('#the_list').val()=='Customer')
        	{
        	  $('#global3').show();
        	}
        $('#the_list').change(function () {
                //Grab the value from dropdownlist
        $('.the_show').hide();
                $('.'+this.value).show();
            });
      $('#same_as_bil').change(function () {
      if($('#same_as_bil').is(":checked")){
    	  if($("#fld-c").val()!='' &&  $("#fld-d").val()!='' && $("#fld-e").val()!='' && $("#fld-f").val()!='' && $("#sign-gbal").val()!='selected')
		  {
								$("#fld-rc").val($("#fld-c").val());
								$("#fld-rd").val($("#fld-d").val());
								$("#fld-re").val($("#fld-e").val());
								$("#fld-rf").val($("#fld-f").val());
								$("#sign-gbal-right").val($("#sign-gbal").val());
								$('#add').attr('style', 'display:none;');
			}
     	   else {
     		   				$('#add').attr('style', 'display:block;color:red;');
							document.getElementById("fld-rc").disabled = false;
							document.getElementById("fld-rd").disabled = false;
							document.getElementById("fld-re").disabled = false;
							document.getElementById("fld-rf").disabled = false;
							document.getElementById("sign-gbal-right").disabled = false;
				   }
         }
      else
	  {
	    $("#fld-rc").val("");
		$("#fld-rd").val("");
		$("#fld-re").val("");
		$("#fld-rf").val("");
		$("#sign-gbal-right").val("selected");
	  }
      });
      if($('#app4').is(":checked")){
    	  $('#billing').hide();
    	  }
    	else
    	{
    	$('#billing').show();
    	}
      document.frm.sub.disabled=true;
      if(document.frm.termAndCondition.checked==true)
      {
        document.frm.sub.disabled=false;
      }
      if(document.frm.termAndCondition.checked==false)
      {
        document.frm.sub.enabled=false;
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
        });
  function hideBillingAddress()
	{
	  $('#billing').hide();
	}
	function showBillingAddress()
	{
	  $('#billing').show();
	}