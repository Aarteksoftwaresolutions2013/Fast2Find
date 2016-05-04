<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Fast2Find</title>
<script type="text/javascript" src="js/adminflare-demo-init.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/css" />
<script type="text/javascript">
    // Include Bootstrap stylesheet 
    document.write('<link href="assets/css/' + DEMO_ADMINFLARE_VERSION + '/' + DEMO_CURRENT_THEME + '/bootstrap.min.css" media="all" rel="stylesheet" type="text/css" id="bootstrap-css">');
    // Include AdminFlare stylesheet 
    document.write('<link href="assets/css/' + DEMO_ADMINFLARE_VERSION + '/' + DEMO_CURRENT_THEME + '/adminflare.min.css" media="all" rel="stylesheet" type="text/css" id="adminflare-css">');
  </script>
  <link href="css/bootstrap.min.css" media="all" rel="stylesheet" type="text/css" id="bootstrap-css">
  <link href="css/adminflare.min.css" media="all" rel="stylesheet" type="text/css" id="adminflare-css">
  <script src="js/modernizr-jquery.min.js" type="text/javascript"></script>
  <script src="js/adminflare-demo.min.js" type="text/javascript"></script>
  <script src="js/bootstrap.min.js" type="text/javascript"></script>
  <script src="js/adminflare.min.js" type="text/javascript"></script>
  <script src="js/fuelux-datagrid-example.min.js" type="text/javascript"></script>
  <style type="text/css">
    .box { padding-bottom: 0; }
    .box > p { margin-bottom: 20px; }
    #popovers li, #tooltips li {
      display: block;
      float: left;
      list-style: none;
      margin-right: 20px;
    }
    .adminflare > div { margin-bottom: 20px; }
  </style>
  <script type="text/javascript">
    $(document).ready(function () {
      prettyPrint();
      /* Tooltips
        ================================================== */
      $('a[rel=tooltip]').tooltip();
      /* Popovers
        ================================================== */
      $('a[rel=popover]').popover().click(function () {
        return false
      });
      /* Butons
        ================================================== */
      $("#loading-state-btn").click(function () {
        $(this).button('loading');
      });
      /* Bootstrap-colorpicker
        ================================================== */
      $("#colorpicker").colorpicker();
      $("#colorpicker-rgb").colorpicker();
      $("#colorpicker-component").colorpicker();
      /* Bootstrap-datepicker
        ================================================== */
      $("#datepicker").datepicker();
      $("#datepicker-component").datepicker();
      $("#datepicker-limited").datepicker();
      /* Bootstrap-timepicker
        ================================================== */
      $('#timepicker-default').timepicker({
        defaultTime: 'value'
      });
      $('#timepicker-1').timepicker({
        minuteStep: 1,
        template: 'modal',
        showSeconds: true,
        showMeridian: false,
        defaultTime: 'value'
      });
      /* Notifications
        ================================================== */
      $('#notify').click(function () {
        $('.top-right').notify({
          message: {
            text: 'Aw yeah, It works!'
          },
          type: 'adminflare'
        }).show()
      });
      /* Input & Textarea Character Limit Counter
        ================================================== */
      $("#input-limit").limiter(20, $('#input-limit-s'));
      $("#textarea-limit").limiter(100, $('#textarea-limit-s'));
      /* Masked Inputs
        ================================================== */
      $("#date-masked").mask("99/99/9999");
      $("#phone-masked").mask("(999) 999-9999");
      $("#ssn-masked").mask("999-99-9999");
      $("#product-key-masked").mask("a*-999-a999", {
        placeholder: " ",
        completed: function(){
          alert("You typed the following: " + this.val());
        }
      });
      /* WYSIWYG-Editor
        ================================================== */
      $('#wysihtml5').wysihtml5({
        "stylesheets": []
      });
      /* Markdown Editor
        ================================================== */
      $("#markdown-editor").markdown({
        autofocus:false,
        savable:false
      })
      /* Form validations
        ================================================== */
      $("input,select,textarea", '#validate-form').not("[type=submit]").jqBootstrapValidation();
      /* Styled form elements
        ================================================== */
      // Initializing checkboxes
      $('#checkbox-toggle').on('click', function () {
        $('#myCheckbox').checkbox('toggle');
      });

      $('#checkbox-disable').on('click', function () {
        $('#myCheckbox').checkbox('disable');
      });

      $('#checkbox-enable').on('click', function () {
        $('#myCheckbox').checkbox('enable');
      });
      // Initializing comboboxes
      $('#myCombobox').on('changed', function (evt, data) {
        console.log(data);
      });
      $('#combobox-logItem').on('click', function () {
        console.log($('#myCombobox').combobox('selectedItem'));
      });
  
      $('#combobox-setByIndex').on('click', function () {
        $('#myCombobox').combobox('selectByIndex', '1');
      });
  
      $('#combobox-setByText').on('click', function () {
        $('#myCombobox').combobox('selectByText', 'Item Three');
      });
  
      $('#combobox-setBySelector').on('click', function () {
        $('#myCombobox').combobox('selectBySelector', 'li[data-fizz=buzz]');
      });
  
      $('#combobox-setByValue').on('click', function () {
        $('#myCombobox').combobox('selectByValue', '1');
      });
  
      $('#combobox-enable').on('click', function () {
        $('#myCombobox').combobox('enable');
      });
  
      $('#combobox-disable').on('click', function () {
        $('#myCombobox').combobox('disable');
      });


      // Initializing search input
      $('#MySearch').on('searched', function (e, text) {
        alert('Searched: ' + text);
      });

      $('#search-enable').click(function () {
        $('#MySearch').search('enable');
      });

      $('#search-disable').click(function () {
        $('#MySearch').search('disable');
      });

      // Initializing spinner
      $('#MySpinner').spinner();
      $('#spinner-enable').click(function () {
        $('#MySpinner').spinner('enable');
      });

      $('#spinner-disable').click(function () {
        $('#MySpinner').spinner('disable');
      });

      $('#spinner-log').click(function () {
        console.log("Spinner value: ", $('#MySpinner').spinner('value'));
      });

      // Initializing radio
      $('#radio-disable').on('click', function () {
        $('#myRadio').radio('disable');
      });

      $('#radio-enable').on('click', function () {
        $('#myRadio').radio('enable');
      });

      // Initializing select
      $('#mySelect').on('changed', function (evt, data) {
        console.log(data);
      });

      $('#select-logItem').on('click', function () {
        console.log($('#mySelect').select('selectedItem'));
      });

      $('#select-setByIndex').on('click', function () {
        $('#mySelect').select('selectByIndex', '1');
      });

      $('#select-setByText').on('click', function () {
        $('#mySelect').select('selectByText', 'Item Three');
      });

      $('#select-setBySelector').on('click', function () {
        $('#mySelect').select('selectBySelector', 'li[data-fizz=buzz]');
      });

      $('#select-setByValue').on('click', function () {
        $('#mySelect').select('selectByValue', '1');
      });

      $('#select-enable').on('click', function () {
        $('#mySelect').select('enable');
      });

      $('#select-disable').on('click', function () {
        $('#mySelect').select('disable');
      });
      /* Datagrid
        ================================================== */
      var dataSource = new StaticDataSource({
        columns: [
          {
            property: 'toponymName',
            label: 'Name',
            sortable: true
          },
          {
            property: 'countrycode',
            label: 'Country',
            sortable: true
          },
          {
            property: 'population',
            label: 'Population',
            sortable: true
          },
          {
            property: 'fcodeName',
            label: 'Type',
            sortable: true
          }
        ],
        data: sampleData.geonames,
        delay: 250
      });
  
      $('#MyGrid').datagrid({
        dataSource: dataSource,
        stretchHeight: true
      });
  
      $('#datagrid-reload').on('click', function () {
        $('#MyGrid').datagrid('reload');
      });
      /* Wizard
        ================================================== */
      $('#myWizard').on('change', function (e, data) {
        console.log('change');
        if (data.step === 3 && data.direction === 'next') {
          // return e.preventDefault();
        }
      });

      $('#myWizard').on('changed', function (e, data) {
        console.log('changed');
      });

      $('#myWizard').on('finished', function (e, data) {
        console.log('finished');
      });

      $('#wizard-prev').on('click', function () {
        $('#myWizard').wizard('previous');
      });

      $('#wizard-next').on('click', function () {
        $('#myWizard').wizard('next', 'foo');
      });

      $('#wizard-logItem').on('click', function () {
        var item = $('#myWizard').wizard('selectedItem');
        console.log(item.step);
      });
      /* Toggle buttons
        ================================================== */
      $('#normal-toggle-button').toggles({on: true});
      $('#text-toggle-button').toggles({text:{on:'YES',off:'NO'}});

      /* Auto-resizing textarea
        ================================================== */
      $("#autoresize").autosize();
      /* Inline editable
        ================================================== */
      //enable / disable
      $('#enable').click(function () {
        $('#user .editable').editable('toggleDisabled');
      });

      //editables 
      $('#username').editable({
        type: 'text',
        pk: 1,
        name: 'username',
        title: 'Enter username'
      });

      $('#firstname').editable({
        validate: function (value) {
          if ($.trim(value) == '') return 'This field is required';
        }
      });

      $('#lastname').editable();

      $('#sex').editable({
        prepend: "not selected",
        source: [{
          value: 1,
          text: 'Male'
        }, {
          value: 2,
          text: 'Female'
        }],
        display: function (value, sourceData) {
          var colors = {
            "": "gray",
            1: "green",
            2: "blue"
          },
          elem = $.grep(sourceData, function (o) {
            return o.value == value;
          });
          if (elem.length) {
            $(this).text(elem[0].text).css("color", colors[value]);
          }
          else {
            $(this).empty();
          }
        }
      });

      $('#status').editable();
      $('#dob').editable();

      $('#comments').editable({
        showbuttons: true
      });

      $('#note').editable();

      $('#pencil').click(function (e) {
        e.stopPropagation();
        e.preventDefault();
        $('#note').editable('toggle');
      });

      $('#fruits').editable({
        pk: 1,
        limit: 3,
        source: [{
          value: 1,
          text: 'banana'
        }, {
          value: 2,
          text: 'peach'
        }, {
          value: 3,
          text: 'apple'
        }, {
          value: 4,
          text: 'watermelon'
        }, {
          value: 5,
          text: 'orange'
        }]
      });

      $('#address').editable({
        value: {
          city: "Moscow",
          street: "Lenina",
          building: "12"
        },
        validate: function (value) {
          if (value.city == '') return 'city is required!';
        },
        display: function (value) {
          if (!value) {
            $(this).empty();
            return;
          }
          var html = '<b>' + $('<div>').text(value.city).html() + '</b>, ' + $('<div>').text(value.street).html       () + ' st., bld. ' + $('<div>').text(value.building).html();
          $(this).html(html);
        }
      });


      /* Dialog boxes
        ================================================== */
      $('#bootbox-alert').click(function () {
        bootbox.alert("Hello world!", function () {
          alert('Hello world callback');
        });
      });

      $('#bootbox-confirm').click(function () {
        bootbox.confirm("Are you sure?", function (result) {
          alert("Confirm result: " + result);
        });
      });

      $('#bootbox-prompt').click(function () {
        bootbox.prompt("What is your name?", function (result) {
          if (result === null) {
            alert("Prompt dismissed");
          }
          else {
            alert("Hi, " + result + "!");
          }
        });
      });

      $('#bootbox-custom').click(function () {
        bootbox.dialog("I am a custom dialog", [{
          "label": "Success!",
          "class": "btn-green",
          "callback": function () {
            alert("great success");
          }
        }, {
          "label": "Danger!",
          "class": "btn-orange",
          "callback": function () {
            alert("uh oh, look out!");
          }
        }, {
          "label": "Click ME!",
          "class": "btn-primary",
          "callback": function () {
            alert("Primary button");
          }
        }, {
          "label": "Just a button..."
        }]);
      });


      /* Clickovers
        ================================================== */
      $('[rel="clickover"]').clickover();

      $('#auto-close-co').clickover({
        auto_close: 15 * 1000
      });

      $('#no-global-co').clickover({
        global_close: false
      });

      $('#shown-co').clickover({
        onShown: function () {
          alert("Hello from clickover");
        }
      });

      $('#no-esc').clickover({
        placement: 'top',
        esc_close: 0
      });
    });
  </script>
</head>
<body class=" fluid-layout wysihtml5-supported">
<script type="text/javascript">demoSetBodyLayout();</script>
  <!-- Main navigation bar
    ================================================== -->
  <header class="navbar navbar-fixed-top" id="main-navbar">
    <div class="navbar-inner">
      <div class="container">
        <a class="logo" href="dashboard.do"><img alt="fast2find" src="images/af-logo.png"></a>

        <a class="btn nav-button collapsed" data-toggle="collapse" data-target=".nav-collapse">
          <span class="icon-reorder"></span>
        </a>

        <div class="nav-collapse collapse">
          <!-- <ul class="nav">
            <li class="active"><a href="#">Visit Site</a></li>
            <li class="divider-vertical"></li>
          </ul> -->
        <%--  <form class="navbar-search pull-left" action="" _lpchecked="1">
            <input type="text" class="search-query" placeholder="Search" style="width: 120px">
          </form> --%>
          <ul class="nav pull-right">
            
            <li class="separator"></li>
            <li class="dropdown">
              <a href="http://adminflare-130.herokuapp.com/javascript.html#" class="dropdown-toggle usermenu" data-toggle="dropdown">
                <img alt="Avatar" src="images/avatar.png">
                <span>&nbsp;&nbsp;Admin</span>
              </a>
              <ul class="dropdown-menu">
              <!--  <li>
                  <a href="#">Profile</a>
                </li>
                <li>
                  <a href="#">Settings</a>
                </li> -->
                <!-- <li class="divider"></li> -->
                <li>
                  <a href="logout.do">Log out</a>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </header>
</body>
</html>