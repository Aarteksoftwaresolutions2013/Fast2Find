var b = document.documentElement;
b.setAttribute('data-useragent',  navigator.userAgent);

$(document).ready(function(){
    var additionInfo = document.getElementById('name-a').value;
    var values=additionInfo.split(",");
    if(values[0]!=undefined)
      document.getElementById('name-a').value=values[0];
    else
    document.getElementById('name-a').value="";
    if(values[1]!=undefined)
      document.getElementById('name-b').value=values[1];
    else
      document.getElementById('name-b').value="";
    if(values[2]!=undefined)
    document.getElementById('name-c').value=values[2];
    else
      document.getElementById('name-c').value="";
    if(values[3]!=undefined)
    document.getElementById('name-d').value=values[3];
    else
      document.getElementById('name-d').value="";
    
    var ids=music.split(",");
    for(var i=0; i<ids.length; i++) {
      $('#ms'+ids[i]).attr('checked', true);
    }
  });
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
  $('#datetimepicker').datetimepicker()
  /* .datetimepicker({value:'2014/04/15 1:00 AM',step:30}); */ 
$('#datetimepicker1').datetimepicker()
  /* .datetimepicker({value:'2014/04/15 1:00 AM',step:30}); */
$('#datetimepicker2').datetimepicker()
  /* .datetimepicker({value:'2014/04/15 1:00 AM',step:30}); */

$('#selecctall').click(function(event) {  // on click
  if(this.checked) { // check select status
      $('.checkbox1').each(function() { // loop through each checkbox
          this.checked = true;  // select all checkboxes with class "checkbox1"
      });
  }else{
      $('.checkbox1').each(function() { // loop through each checkbox
          this.checked = false; // deselect all checkboxes with class
                                // "checkbox1"
      });         
  }
});
  });
// Run the script on DOM ready:
$(function(){
  $('input').customaaInput();
});