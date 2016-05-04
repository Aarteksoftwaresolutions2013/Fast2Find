var b = document.documentElement;
b.setAttribute('data-useragent', navigator.userAgent);
$(document).ready(function() {
  var email = document.getElementById('field-j').value;
  document.getElementById('field-k').value = email;
  var id = document.getElementById('branchId').value;
  if ('${Branch.allowQuickBooking}') {
    $('#allow-to').attr('checked', true);
    $("#priceDiv").toggle(this.checked);
  } else {
  }
  $('#allow-to').click(function() {
    $("#priceDiv").toggle(this.checked);
  });

  $('#datetimepicker').datetimepicker()
  /* .datetimepicker({value:'2014/04/15 1:00 AM',step:30}); */
  $('#datetimepicker1').datetimepicker()
  /* .datetimepicker({value:'2014/04/15 1:00 AM',step:30}); */
  $('#datetimepicker2').datetimepicker()
  /* .datetimepicker({value:'2014/04/15 1:00 AM',step:30}); */

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

});

//Run the script on DOM ready:
$(function() {
  $('input').customkhaInput();
});