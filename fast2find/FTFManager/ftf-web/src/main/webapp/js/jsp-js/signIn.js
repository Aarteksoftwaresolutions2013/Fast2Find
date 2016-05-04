$(document).ready(function() {
  $('input').customdfdInput();
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
function remeberMe()
{
	 if ($("#stying").is(":checked")) {
		 var e = $("#user-name").val(),
	            o = $("#user-password").val();
	        $.cookie("pm[email]", e, {
	            expires: 365
	        }), $.cookie("pm[pass]", o, {
	            expires: 365
	        }), $.cookie("pm[remember]", !0, {
	            expires: 365
	        })
	    } else $.cookie("pm[email]", null), $.cookie("pm[pass]", null), $.cookie("pm[remember]", !1)
}
jQuery.fn.customdfdInput = function() {
  $(this).each(function(i) {
    if ($(this).is('[type=checkbox],[type=radio]')) {
      var input = $(this);
      var label = $('label[for=' + input.attr('id') + ']');
      var inputType = (input.is('[type=checkbox]')) ? 'checkbox' : 'radio';
      $('<div class="customdfd-' + inputType + '"></div>').insertBefore(input).append(input, label);
      var allInputs = $('input[name=' + input.attr('name') + ']');
      label.hover(function() {
        $(this).addClass('hover');
        if (inputType == 'checkbox' && input.is(':checked')) {
          $(this).addClass('checkedHover');
        }
      }, function() {
        $(this).removeClass('hover checkedHover');
      });
      // bind custom event, trigger it, bind click,focus,blur events
      input.bind('updateState', function() {
        if (input.is(':checked')) {
          if (input.is(':radio')) {
            allInputs.each(function() {
              $('label[for=' + $(this).attr('id') + ']').removeClass('checked');
            });
          }
          ;
          label.addClass('checked');
        } else {
          label.removeClass('checked checkedHover checkedFocus');
        }
      }).trigger('updateState').click(function() {
        $(this).trigger('updateState');
      }).focus(function() {
        label.addClass('focus');
        if (inputType == 'checkbox' && input.is(':checked')) {
          $(this).addClass('checkedFocus');
        }
      }).blur(function() {
        label.removeClass('focus checkedFocus');
      });
    }
  });
};