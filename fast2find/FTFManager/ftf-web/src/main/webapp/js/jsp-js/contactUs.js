$(document).ready(function() {
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

var b = document.documentElement;
b.setAttribute('data-useragent', navigator.userAgent);
// Run the script on DOM ready:
$(function() {
  $('input').customaaInput();
});

/*-------------------------------------------------------------------- 
 * jQuery plugin: customaaInput()
 * by Maggie Wachs and Scott Jehl, http://www.filamentgroup.com
 * Copyright (c) 2009 Filament Group
 * Dual licensed under the MIT (filamentgroup.com/examples/mit-license.txt) and GPL (filamentgroup.com/examples/gpl-license.txt) licenses.
 * Article: http://www.filamentgroup.com/lab/accessible_customaa_designed_checkbox_radio_button_inputs_styled_css_jquery/  
 * Usage example below (see comment "Run the script...").
 --------------------------------------------------------------------*/
jQuery.fn.customaaInput = function() {
  $(this).each(function(i) {
    if ($(this).is('[type=checkbox],[type=radio]')) {
      var input = $(this);
      // get the associated label using the input's id
      var label = $('label[for=' + input.attr('id') + ']');
      // get type, for classname suffix
      var inputType = (input.is('[type=checkbox]')) ? 'checkbox' : 'radio';
      // wrap the input + label in a div
      $('<div class="customaa-' + inputType + '"></div>').insertBefore(input).append(input, label);
      // find all inputs in this set using the shared name attribute
      var allInputs = $('input[name=' + input.attr('name') + ']');
      // necessary for browsers that don't support the :hover pseudo class on
      // labels
      label.hover(function() {
        $(this).addClass('hover');
        if (inputType == 'checkbox' && input.is(':checked')) {
          $(this).addClass('checkedHover');
        }
      }, function() {
        $(this).removeClass('hover checkedHover');
      });
      // bind customaa event, trigger it, bind click,focus,blur events
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