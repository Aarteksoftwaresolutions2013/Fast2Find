function getEventWeeklyData()
 {  
	var type=$("#sign-gbal").val();
	if(type==0)
		{
		alert("Please Select atleast One Event Name");
		return true;
		}
	else
		{
	var data = {
			comboId : $("#sign-gbal").val()};
 	 $.ajax({ 
 	        type: "POST",
 	        contentType : 'application/json; charset=utf-8',
 	        dataType : 'json',
 	        data: JSON.stringify(data), 
 	        url: "getEventWeeklyInformation.do",
 	        success : function (data,status,response) {
 	        	var Result=data.Result;
 	        	if(Result == "success") {
                 	var date=[];
             		var noOfMale=[];
             		var noOfFemale=[];
             		var totalMembers=[];
             	    var event=[];
             	    var maxTime=[];
             	    var currentVolume=[];
             	    var branchType=[];
             	    var maxCapacity=[];
             	    var music=[];
                 	      for(var i = 0;i<data.weeklyData[0].length;i++) // data is your JSON response
                 	      {
                 	    	 date.push(data.weeklyData[0][i][0]);
                 	    	 noOfMale.push(parseInt(data.weeklyData[0][i][1]));
                 	    	 noOfFemale.push(parseInt(data.weeklyData[0][i][2]));
                 	    	 totalMembers.push(parseInt(data.weeklyData[0][i][1])+parseInt(data.weeklyData[0][i][2]));
                 	    	event.push(data.weeklyData[0][i][3]);
                 	    	 branchType.push(data.weeklyData[0][i][4]);
                 	    	 maxCapacity.push(data.weeklyData[0][i][5]);
                 	    	 music.push(data.weeklyData[0][i][6]);
                 	         maxTime.push(data.weeklyData[1][i][0]);
                 	    	 currentVolume.push(data.weeklyData[1][i][1]);
                 	      }
                 	     
                 	       var newdate=[];
                 	      for(var i=0;i<date.length;i++)
                 	    	  {
                 	    	    var date1=date[i];
                 	    	    newdate[i] = date1.split("-").reverse().join("-");
                 	    	    }  
                        $('#container1').hide();
                 	   $('#container2').hide();
                 	   $('#container3').hide();
                 	   $('#container').show();
                 	   $('#container').highcharts({
                 	        chart: {
                 	            type: 'column'
                 	        },
                 	        title: {
                 	            text: 'Weekly Data'
                 	        },
                 	        subtitle: {
                 	            text: '(Past 7 days data)'
                 	        },
                 	        xAxis: {
                 	        	categories:newdate
                 	        },
                 	        yAxis: {
                 	            min: 0,
                 	            title: {
                 	                text: 'Total no. of memebers'
                 	            }
                 	        },
                 	        tooltip: {
                 	            headerFormat: '',
                 	            pointFormat: 'Click on bar for more info...',
                 	            footerFormat:'',
                 	            shared: true,
                 	            useHTML: true
                 	        },
                 	        plotOptions: {
                 	            column: {
                 	                pointPadding: 0.4,
                 	                borderWidth: 0
                 	            }
                 	        },
                 	        series: [{
                 	            name: event[0],
                 	            data:totalMembers,
                 	      point: {
                 events: {
                     click: function(e) {
                    	 hs.htmlExpand(null, {
                                    pageOrigin: {
                                    	 x: e.pageX,
                                         y: e.pageY
                                    },
                                    maincontentText: '<b>People Flow:-'+this.y +'<br>'+ '<b>Event Name:-'+this.series.name +'<br>'+
                                 '<b>Male:-'+noOfMale[e.point.x]+'<br>'+'<b>Female:-'+noOfFemale[e.point.x]+'<br>'+ '<b>capacity reached:-' + currentVolume[e.point.x] + ' at ' + maxTime[e.point.x] + '<b> Vs MaxCapacity Of ' + maxCapacity[e.point.x],
                                    width: 300,
                                    height:250
                                })
                     }
                 }
             }
                 	        }]
                 	    });
 	        	}
 	        	else {
 	        		 $('#statusInfo').html(data.Result); 
 	    		}
 	        	},
                 error: function(data,status,request){
       	          $('#statusInfo').html(data.response); 
       	          }
 	 });
 	}
 }
function getEventMonthlyData()
{
	var type=$("#sign-gbal").val();
	if(type==0)
		{
		alert("Please Select atleast One Event Name");
		return true;
		}
	else
		{
var data = {
			comboId : $("#sign-gbal").val()};
	 $.ajax({ 
	        type: "POST",
	        contentType : 'application/json; charset=utf-8',
	        dataType : 'json',
	        data: JSON.stringify(data), 
	        url: "getEventMonthlyInformation.do",
	        success :function (data,status,response) {
	        	var successMessage=data.successMessage;
	        	if(successMessage == "success") {
	        		var monthNames = [ "Jan", "Feb", "Mar", "Apr", "May", "Jun",
	            	                   "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" ];
	        	var date=[];
        		var noOfMale=[];
        		var noOfFemale=[];
        		var totalMembers=[];
        	    var event=[];
        	    var maxTime=[];
       	         var currentVolume=[];
        	     var branchType=[];
       	        var maxCapacity=[];
       	        var music=[];
            	      for(var i = 0;i<data.monthlyData[0].length;i++) // data is your JSON response
            	      {
            	    	 date.push(data.monthlyData[0][i][0]);
            	    	 noOfMale.push(parseInt(data.monthlyData[0][i][1]));
            	    	 noOfFemale.push(parseInt(data.monthlyData[0][i][2]));
            	    	 totalMembers.push(parseInt(data.monthlyData[0][i][1])+parseInt(data.monthlyData[0][i][2]));
            	    	 event.push(data.monthlyData[0][i][3]);
            	    	 branchType.push(data.monthlyData[0][i][4]);
           	    	     maxCapacity.push(data.monthlyData[0][i][5]);
           	    	     music.push(data.monthlyData[0][i][6]);
           	        	 maxTime.push(data.monthlyData[1][i][0]);
            	    	 currentVolume.push(data.monthlyData[1][i][1]);
            	      }
                             var month=[];
                  	     for(var i=0;i<date.length;i++)
                  	    	  {
                  	    	     var d=date[i]; 
                  	    	     myDate = new Date(d);
                  	    	      month[i] = myDate.getDate()+" "+monthNames[myDate.getMonth()] ;
                  	    	  }
                    $('#container').hide();
                  	$('#container2').hide();
                 	$('#container3').hide();
                 	$('#container1').show();
                    $('#container1').highcharts({
          chart: {
            type: 'column'
        },
        title: {
            text: 'Monthly Data'
        },
        subtitle: {
            text: '(Past 30 days data)'
        },
        xAxis: {
            categories: month 
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Total no. of memebers'
            }
        },
        tooltip: {
            headerFormat: '',
            pointFormat: 'Click on bar for more info...',
            footerFormat: '',
            shared: true,
            useHTML: true
        }, 
        plotOptions: {
            column: {
                pointPadding: 0.4,
                borderWidth: 0
            }
        },
        series: [{
            name: event[0],
            data: totalMembers,
            point: {
                events: {
                    click: function(e) {
                   	 hs.htmlExpand(null, {
                                   pageOrigin: {
                                   	 x: e.pageX,
                                        y: e.pageY
                                   },
                                   maincontentText: '<b>People Flow:-'+this.y +'<br>'+ '<b>Event Name:-'+this.series.name +'<br>'+
                                   '<b>Male:-'+noOfMale[e.point.x]+'<br>'+'<b>Female:-'+noOfFemale[e.point.x]+'<br>'+ '<b>capacity reached:-' + currentVolume[e.point.x] + ' at ' + maxTime[e.point.x] + '<b> Vs MaxCapacity Of ' + maxCapacity[e.point.x],
                                   width: 300,
                                   height:250
                               })
                    }
                }
            }
        }]
    });
	        	}
	        	else {
	        		 $('#statusInfo').html(data.failure); 
	    		}          
	        },
            error: function(data,status,request){
  	          $('#statusInfo').html(data.response); 
  	          }
 });
}
}
function getEventYearlyData()
{
	var type=$("#sign-gbal").val();
	if(type==0)
		{
		alert("Please Select atleast One Event Name");
		return true;
		}
	else
		{
var data = {
		comboId : $("#sign-gbal").val()};
	 $.ajax({ 
	        type: "POST",
	        contentType : 'application/json; charset=utf-8',
	        dataType : 'json',
	        data: JSON.stringify(data), 
	        url: "getEventYearlyInformation.do",
	        success : function (data,status,response) {
	        	var successMessage=data.successMessage;
	        	if(successMessage == "success") {
	        		var monthNames = [ "Jan", "Feb", "Mar", "Apr", "May", "Jun",
	            	                   "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" ];
                	var date=[];
            		var noOfMale=[];
            		var noOfFemale=[];
            	    var event=[];
            	    var totalMembers=[];
            	    var month=[];
            	    for(var i = 0;i<data.yearlyData.length;i++) // data is your JSON response
            	      {
            	    	 date.push(data.yearlyData[i][0]);
            	    	 totalMembers.push(parseInt(data.yearlyData[i][1])+parseInt(data.yearlyData[i][2]));
            	    	 noOfMale.push(parseInt(data.yearlyData[i][1]));
            	    	 noOfFemale.push(parseInt(data.yearlyData[i][2]));
            	    	 event.push(data.yearlyData[i][3]);
            	    	 
            	      }
            	      for(var i=0;i<date.length;i++)
            	    	  { var d=date[i]; 
            	    	     myDate = new Date(d);
            	    	      month[i] = monthNames[myDate.getMonth()] +" "+ myDate.getFullYear();
            	    	  }
            	       $('#container').hide();
                	   $('#container1').hide();
                	   $('#container2').hide();
                	   $('#container3').show();
                	   $('#container3').highcharts({
                	        chart: {
                	            type: 'column'
                	        },
                	        title: {
                	            text: 'Yearly Data'
                	        },
                	        subtitle: {
                	            text: '(Past One year data)'
                	        },
                	        xAxis: {
                	        	categories:month
                	        },
                	        yAxis: {
                	            min: 0,
                	            title: {
                	                text: 'Total no. of memebers'
                	            }
                	        },
                	        tooltip: {
                	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                	                '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>'+'<br>',
                	            footerFormat: '</table>',
                	            shared: true,
                	            useHTML: true
                	        },
                	        plotOptions: {
                	            column: {
                	                pointPadding: 0.4,
                	                borderWidth: 0
                	            }
                	        
                	        },
                	        series: [{
                	            name: event[0],
                	       
                	         data: totalMembers, 
                	      point: {
                events: {
                    click: function() {
                    	
                    }
                }
            }
                	        }]
                	    });
	        }
        	else {
        		 $('#statusInfo').html(data.failure); 
        		  
    		}
                },
                error: function(data,status,request){
      	          $('#statusInfo').html(data.response); 
      	          }
	 });
	    
	}
}
function getEventThreeMonthlyData()
{
	var type=$("#sign-gbal").val();
	if(type==0)
		{
		alert("Please Select atleast One Event Name");
		return true;
		}
	else
		{
var data = {
		comboId : $("#sign-gbal").val()};
	 $.ajax({ 
	        type: "POST",
	        contentType : 'application/json; charset=utf-8',
	        dataType : 'json',
	        data: JSON.stringify(data), 
	        url: "getEventThreeMonthlyInformation.do",
	        success : function (data,status,response) {
	        	var successMessage=data.successMessage;
	        	if(successMessage == "success") {
                	var date=[];
            		var noOfMale=[];
            		var noOfFemale=[];
            	    var event=[];
            	    var totalMembers=[];
            	  var fromToDate=[];
            	    for(var i = 0;i<data.threeMonthlyData.length;i++) // data is your JSON response
            	    { date.push(data.threeMonthlyData[i][0][0]);
          	    	 noOfMale.push(parseInt(data.threeMonthlyData[i][0][1]));
          	    	 noOfFemale.push(parseInt(data.threeMonthlyData[i][0][2]));
          	    	 totalMembers.push(parseInt(data.threeMonthlyData[i][0][1])+parseInt(data.threeMonthlyData[i][0][2]));
          	    	 event.push(data.threeMonthlyData[i][0][3]);
          	    	 fromToDate.push(data.threeMonthlyData[i][1]); 
          	      }
            	   /*  var newdate=[];
          	      for(var i=0;i<fromToDate.length;i++)
          	    	  {
          	    	    var date1=fromToDate[i];
          	    	    newdate[i] = date1.split("-").reverse().join("-");
          	    	    }  
          	      alert(newdate); */
                       $('#container').hide();
                	   $('#container1').hide();
                	   $('#container3').hide();
                	   $('#container2').show();
                	   $('#container2').highcharts({
                	        chart: {
                	            type: 'column'
                	        },
                	        title: {
                	            text: 'Three Monthly Data'
                	        },
                	        subtitle: {
                	            text: '(Past 90 days data)'
                	        },
                	        xAxis: {
                	             	categories:fromToDate
                	        },
                	        yAxis: {
                	            min: 0,
                	            title: {
                	                text: 'Total no. of memebers'
                	            }
                	        },
                	        tooltip: {
                	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                	                '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>'+'<br>',
                	            footerFormat: '</table>',
                	            shared: true,
                	            useHTML: true
                	        },
                	        plotOptions: {
                	            column: {
                	                pointPadding: 0.4,
                	                borderWidth: 0
                	            }
                	        
                	        },
                	        series: [{
                	            name: event[0],
                	           data: totalMembers,
                	      point: {
                events: {
                    click: function() {
                    	
                    }
                }
            }
                	        }]
                	    });
	        }
        	else {
        		
        		 $('#statusInfo').html(data.failure); 
        		  
    		}
                },
                error: function(data,status,request){
                	
      	          $('#statusInfo').html(data.response); 
      	          }
	 });
	}
}