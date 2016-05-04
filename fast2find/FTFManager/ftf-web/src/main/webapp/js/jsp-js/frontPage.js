//AutoComplete implemetation 
var xyz='Hello';
$(document).ready(function() {
  $("#search").autocomplete({
    source : function(request, response) {
      var searchName = $("#search")[0];
      var searchValue = searchName.value;
      $.ajax({
        url : "searchMap.do?searchValue=" + searchValue,
        dataType : "json",
        data : {
          maxRows : 6,
          startsWith : request.term
        },
        success : function(data) {
          response(data);
        }
      });
    }
  });
  
  jQuery.datepicker.setDefaults(jQuery.extend(jQuery.datepicker.regional['']));
  jQuery('#datepick').datepicker();

  $("#datepick").datepicker({
    dateFormat : 'mm/dd/yy',
    changeMonth : true,
    changeYear : true,
    yearRange : '-70:+10',
    constrainInput : false,
    duration : '',
    gotoCurrent : true
  }).datepicker('setDate', "0");
  // Run the script on DOM ready:
  $('input').customInput();
  if (!Modernizr.input.placeholder) {
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

  $('#selecctall').click(function(event) { //on click 
    if (this.checked) { // check select status
      $('.checkbox1').each(function() { //loop through each checkbox
        this.checked = true; //select all checkboxes with class "checkbox1"               
      });
    } else {
      $('.checkbox1').each(function() { //loop through each checkbox
        this.checked = false; //deselect all checkboxes with class "checkbox1"                       
      });
    }
  });

  window.onload = function () {
	  if(markers.length==0)
	  {
	   var mapOptions = {
	   center: new google.maps.LatLng(43.6525,-79.381667),
	   zoom: 10,
	   mapTypeId: google.maps.MapTypeId.ROADMAP
	  };
	  }
	else
	{
	  for (i = 0; i <markers.length; i++){
	  var mapOptions = {
	  center: new google.maps.LatLng(markers[i].lat, markers[i].log),
	  zoom: 10,
	  mapTypeId: google.maps.MapTypeId.ROADMAP
	 };
	}
	}
	   /* var infoWindow = new google.maps.InfoWindow();*/
	  var  infoBubble;
	    var latlngbounds = new google.maps.LatLngBounds();
	    var map = new google.maps.Map(document.getElementById("map"), mapOptions);
	    var i = 0;
	    var interval = setInterval(function () {
	        var data = markers[i]
	        if(data)
	        {
	          scrollWin();
	        var myLatlng = new google.maps.LatLng(data.lat, data.log);
	        var icon = "";
	        if (data.cap>=0.0 && data.cap<25.0)
	        {
	           icon = "images/black 19 x32.png";
	        }
	      else if (data.cap>=25.0 && data.cap<50.0)
	          {
	        icon = "images/green19 x32.png";
	          }
	        else if (data.cap>=50.0 && data.cap<75.0)
	          {
	           icon = "images/yellow19 x32.png";
	          }
	        else if (data.cap>=75.0 && data.cap<95.0)
	        {
	          icon = "images/orange19 x32.png";
	          }
	        else if (data.cap>=95.0 && data.cap<100.0)
	          {
	           icon = "images/red19 x32.png";
	          }
	        else if (data.cap==100.0)
	         {
	          icon = "images/flashing-01.gif";
	         }
	        /* icon = "http://maps.google.com/mapfiles/ms/icons/" + icon + ".png"; */
	        
	        var marker = new google.maps.Marker({
	            position: myLatlng,
	            map: map,
	            optimized:false,
	            animation: google.maps.Animation.DROP,
	            icon: new google.maps.MarkerImage(icon)
	        });
	        (function (marker, data) {
	            google.maps.event.addListener(marker, "click", function (e) {
	            	infoBubble = new InfoBubble({
	      	          maxWidth: 300
	      	        });
	      	        infoBubble2 = new InfoBubble({
	      	          map: map,
	      	        content: '<div class="phoneytext">Some label</div>',
	                position: new google.maps.LatLng(-35, 151),
	                shadowStyle: 1,
	                padding: 0,
	                backgroundColor: 'rgb(57,57,57)',
	                borderRadius: 4,
	                arrowSize: 10,
	                borderWidth: 1,
	                borderColor: '#2c2c2c',
	                disableAutoPan: true,
	                hideCloseButton: true,
	                arrowPosition: 30,
	                backgroundClassName: 'phoney',
	                arrowStyle: 2
	      	        });
	      	        infoBubble.open(map, marker);
	      	        infoBubble2.open();
	      	        var div = document.createElement('DIV');
	      	        div.id = 'commentId'+data.title;
	      	        infoBubble.addTab('Business Details', data.description);
	      	        infoBubble.addTab("<a onclick=comment("+data.title+")>User Comment</a>",div);
	            	if (!infoBubble.isOpen()) {
	                    infoBubble.open(map, marker);
	                  }
	            });
	        })(marker, data);
	        latlngbounds.extend(marker.position);
	        i++;
	        if (i == markers.length) {
	            clearInterval(interval);
	            var bounds = new google.maps.LatLngBounds();
	            map.setCenter(latlngbounds.getCenter());
	            map.fitBounds(latlngbounds);
	            map.setZoom(13);
	        }
	        }
	        else
	          {
	          }
	    }, 80);
	}
});
function scrollWin() {
  window.scrollTo(1980, 1780);
}
function comment(bId)
{
   var com=" ";
   $.ajax({
     url : 'getCustomerComment.do?branchId='+bId,
     type : 'GET',
     contentType: "application/json; charset=utf-8", 
     success : function(response) {
    	 var j=1;
    	 for (i=0;i<response.length;i++)
			{
    			com +=+j+':'+response[i].customerComment+ '<br/>';
				$('#commentId'+bId).html(com);
				j++;
			}
     },
     error : function(error) {
     }
   });
 }