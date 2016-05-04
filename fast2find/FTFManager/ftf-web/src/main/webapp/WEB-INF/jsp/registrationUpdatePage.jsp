<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script type="text/javascript">
var b = document.documentElement;
b.setAttribute('data-useragent',  navigator.userAgent);
</script> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/common.js"></script>
 <link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
 <script type="text/javascript" src="js/jsp-js/registrationUpdatePage.js"></script>
 <link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/>
 <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.9.1.custom.min.css"/>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function () {
var dob='${BusinessAndEventInformation.dateOfBirth}';
if(dob=='' ||dob=='undefine' )
{
  document.getElementById("datepick").value = "Date of Birth";
}
else
{
  document.getElementById("datepick").value = dob;
}
});
</script>
</head>
<body>
<table align="left" border="0" cellpadding="0" cellspacing="0" width="100%">
     <tbody>
     <tr>
        <td bgcolor="#FFFFFF" valign="top">
<!---------------------singup_global ------------------------>
<!---------------------singup_global ------------------------>
      <jsp:scriptlet>
      String[] countryName = new String[]{"Afghanistan", "Albania", "Algeria","American Samoa","Andorra","Angola","Anguilla","Antarctica","Antigua and Barbuda","Argentina","Armenia","Aruba","Australia","Azerbaijan","Bahamas","Bahrain","Bangladesh","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia and Herzegovina","Botswana","Bouvet Island","Brazil","British Indian Ocean Territory","Brunei Darussalam","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Cayman Islands","Central African Republic","Chad","Chile","China","Christmas Island","Cocos Islands","Colombia","Comoros","Congo","Congo", "Democratic Republic of the","Cook Islands","Costa Rica","Cote d'Ivoire","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Falkland Islands","Faroe Islands","Fiji","Finland","France","French Guiana","French Polynesia","Gabon","Gambia","Georgia","Germany","Gibraltar","Greece","Greenland","Grenada","Guadeloupe","Guam","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Heard Island and McDonald Islands","Honduras","Hong Kong", "Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati","Kyrgyzstan","Laos","Latvia","Lebanon","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macao","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Martinique","Mauritania","Maldives","Mauritius","Mayotte","Mexico","Micronesia"
          ,"Moldova","Monaco","Mongolia","Montenegro","Montserrat","Morocco","Mozambique","Myanmar","Namibia","Nauru","Nepal","Netherlands","Netherlands Antilles","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","Norfolk Island","North Korea","Norway","Oman","Pakistan","Palau","Palestinian Territory","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Pitcairn","Poland","Portugal","Puerto Rico","Qatar","Romania","Russian Federation","Rwanda","Saint Helena","Saint Kitts and Nevis","Saint Lucia","Saint Pierre and Miquelon","Saint Vincent and the Grenadines","Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","South Africa","South Georgia","South Korea","Spain","Sri Lanka","Sudan","Suriname","Svalbard and Jan Mayen","Swaziland","Sweden","Switzerland","Syrian Arab Republic","Taiwan","Tajikistan","Tanzania","Thailand","The Former Yugoslav Republic of Macedonia","Timor-Leste","Togo","Tokelau","Trinidad and Tobago","Tunisia","Turkey","Turkmenistan" ,"Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States","United States Minor Outlying Islands","Uruguay","Uzbekistan","Vatican City","Venezuela","Venezuela","Vietnam","Virgin Islands, British","Virgin Islands, U.S.","Wallis and Futuna","Western Sahara","Yemen","Zambia","Zimbabwe"};
              pageContext.setAttribute("countryName", countryName);
          </jsp:scriptlet>
      <div id="sign-golbal" class="sign-golbal">
      <div id="statusInfo" style="color: green;"></div>
      <h3>${successMsg}</h3>
      <h2>My Account</h2>
      <form:form action="updateregistrationInfo.do" modelAttribute="BusinessAndEventInformation" method="POST" autocomplete="off" id="sign-gobal" class="sign-gobal">
      <ul class="leftsidefrm">
      <li>
      <form:select path="login.userType" id="the_list">
      <form:option value="Customer" label="Customer User" />
      </form:select>
      <form:hidden path="businessEventID" />
      <form:errors path="login.userType" cssClass="error"></form:errors>
      </li>
      
       <li>
       <div class="first"> <label>First Name</label>
       <form:input path="firstName"  name="title-here" placeholder="First Name" required ="autofocus" id="fld-a" maxlength="40" onkeyup="onlyAlph(event,this)"/>
       </div>
       <div class="last"> <label>Last Name</label>
       <form:input path="lastName" name="title-here" placeholder="Last Name" required ="autofocus" id="fld-b" maxlength="40" onkeyup="onlyAlph(event,this)" />
        </div> 
       </li>
         <li>
        <form:errors path="firstName" cssClass="error"></form:errors>
       <form:errors path="lastName" cssClass="error"></form:errors>
       </li>
       <form:hidden path="createdOn" />
       <li>
        <form:input path="dateOfBirth" id="datepick" class="dates" value="Date of Birth"  required ="autofocus"  />
       </li>
       <li>
       <form:errors path="dateOfBirth" cssClass="error"></form:errors>
       </li>
    <li>
      <label style="width: 20%; float:left;">Gender : </label>
      <span class="margin_left">
         <form:radiobutton path="gender"  name="sex" value="male" />Male
         <form:radiobutton path="gender" name="sex" value="female" />Female
      </span>
    </li>
       <li>
       <form:errors path="gender" cssClass="error"></form:errors>
       </li>
      <li class="margin_top">
      <label style="width: 24%; float:left;">Title : </label>
      <form:radiobutton path="title" name="sex" value="mr" />Mr
      <form:radiobutton path="title" name="sex" value="miss" />Miss
      <form:radiobutton path="title" name="sex" value="mrs" />Mrs
      <form:radiobutton path="title" name="sex" value="ms" />Ms
       </li>
       <li>
       </li>
       <li>
       <form:errors path="title" cssClass="error"></form:errors>
       </li>
       <li>
      <h3>Current Address</h3>
      </li>
      <li>
    <div class="first"> <label>Address</label>  
      <form:input path="location.address"  name="address" placeholder="Address" required ="autofocus" id="fld-c" maxlength="150" />
      </div>
       <form:errors path="location.address" cssClass="error"></form:errors>
      </li>
      
      <li>
      <div class="first"> <label>City</label>
      <form:input path="location.cityName"  name="title-here" placeholder="City" required ="autofocus" id="fld-d" maxlength="40" onkeyup="onlyAlph(event,this)" />
      </div>   
      <div class="last"> <label>Province/State</label>
      <form:input path="location.stateName" name="title-here" placeholder="Province/State" required ="autofocus" id="fld-e" maxlength="40" onkeyup="onlyAlph(event,this)" />
      </div>
      </li>
      <li>
      <form:errors path="location.cityName" cssClass="error" ></form:errors>
        <form:errors path="location.stateName" cssClass="error"></form:errors>
      </li>
      <li>
            <div class="first"> <label>Zip code/ Postal code</label>
      <form:input path="location.zipCode" name="title-here" placeholder="Zip code/ Postal code" required ="autofocus" id="fld-f" maxlength="12"/>
      </div>     
            <div class="first"> <label>Select Country</label> </div>
      <form:select path="location.countryName"  id="sign-gbal" >
      <form:option value="selected" selected="selected" label="Select Country" />
      <c:forEach items="${pageScope.countryName}" var="country">
      <form:option value="${country}" label="${country}"  />
      </c:forEach>
      </form:select>
            
      </li>
    <form:errors path="location.zipCode" cssClass="error" ></form:errors>
        <form:errors path="location.countryName" cssClass="error"></form:errors>
      <li>
       <li><h3>Fast2Find Credentials</h3></li>
      <li>
           <div class="first"> <label>Email Address</label>
      <form:input path="login.emailId" name="email" placeholder="Email Address" id="fld-g" required ="autofocus" maxlength="50" onblur="validateEmail()" />
      </div>
          <div class="last"> <label>Repeat Email</label>
          <form:input path="confirmEmail" placeholder="Repeat Email"  id="fld-h"  maxlength="50" onblur="confirmEmailValidation()" />
      </div>
              </li>
      <li>
      <form:errors path="login.emailId" cssClass="error" ></form:errors>
      <form:errors path="confirmEmail" cssClass="error"></form:errors>
      </li>
        <li>
        <div class="first"> <label>Password</label>
                <form:input path="login.password" name="email" placeholder="Password" id="fld-pss" required ="autofocus" maxlength="15"/>
        </div>
      <div class="last"> <label>Confirm Password</label>
      <form:input path="confirmPassword" placeholder="Confirm Password"  id="fld-ps"  maxlength="15" onblur="confirmPasswordValidation()" />
      </div>
      </li>
      <li>
      <form:errors path="login.password" cssClass="error"></form:errors>
       <form:errors path="confirmPassword" cssClass="error"></form:errors>
      </li>
      </ul>
      <p>&nbsp;</p>
      <ul class="right-bsd-side">
       <div id="billing">
      <h3>Billing Address</h3>
         <li>
      <form:checkbox path="sameAddress" id="same_as_bil"  value="on" autocomplate="off" onclick="uncheckAddress()"/>
      <span class="terms_text" style="font-family:Arial, Helvetica, sans-serif;font-size:12pt;">Current Address under Billing Address</span>
      </li>
      
      <li>
            <div class="first"> <label>Address</label>
            <form:input path="location.billingAddress" name="b_address" placeholder="Address" required="" id="fld-rc" maxlength="150"/>
        </div>
      </li>
      <li>
      <div class="first"> <label>City</label>
      <form:input path="location.billingCityName" name="title-here" placeholder="City" required="" id="fld-rd" maxlength="40" onkeyup="onlyAlph(event,this)" />     
      </div>     
      <div class="last"> <label>Province/State</label>
      <form:input path="location.billingStateName" name="title-here" placeholder="Province/State" required="" id="fld-re" maxlength="40" onkeyup="onlyAlph(event,this)" />
    </div>
      </li>
      <li>
      <div class="first"> <label>Zip code/ Postal code</label>
      <form:input path="location.billingZipCode" type="text" name="title-here" placeholder="Zip code/ Postal code" required="" id="fld-rf" maxlength="15" />      
    </div>      
      <div class="last"> <label>Select Country</label>
      <form:select path="location.billingCountryName"  id="sign-gbal-right" >
      <form:option value="selected" selected="selected" label="Select Country" />
      <c:forEach items="${pageScope.countryName}" var="country">
      <form:option value="${country}" label="${country}"  />
      </c:forEach>
      </form:select>
      </div> 
      </li>
        <li><form:errors path="location.billingZipCode" cssClass="error" ></form:errors></li>
         </div>
          <div class="the_show Customer" id="global">
      <li>
      <form:radiobutton path="customerCatagory"  value="Free" id="app4" onclick="hideBillingAddress()"/>
      <span class="terms_text" title="If you will register as free user than you will get only limit access and information" >Free User</span>
      </li>
      
         <li>
     <form:radiobutton path="customerCatagory"  value="PerYear" id="app5" onclick="showBillingAddress()"/>
        <span class="terms_text" title="If you will register as paid user than you will get more benefits like:
1. Free for one year
2. You will get email alert facilities
3. If you search any Restaurant, club etc than you will get full information like address, how many people are there, max capacity etc.
4. You can see more details related to special events.
5. You can access full application." >Free for the first year then $1.00 CAD each year</span>
      </li>
      </div>
      <li>

     <div class="the_show Customer"  id="global"><p>&nbsp;</p></div>
      <li>
      <input type="submit" id="signup-sbmt" value="Update"/>
      </li>
      
      </ul>
      </form:form>
      </div><!---------------end div of feedback------------>
      <!---------------------end singup_global ------------------------>
      <!---------------------end singup_global ------------------------>      
     </td>
    </tr></tbody></table> 
</body>
<script type="text/javascript" src="js/jquery-ui-1.9.1.custom.min.js" charset="utf-8"></script>    
<script type="text/javascript" charset="utf-8">
  jQuery( document ).ready( function() {
    jQuery.datepicker.setDefaults(jQuery.extend(jQuery.datepicker.regional['']));
   /* jQuery('#datepick').datepicker();  */
    $("#datepick").datepicker({
      dateFormat : 'mm/dd/yy',
      changeMonth : true,
      changeYear : true,
      yearRange : '-70:+10',
      constrainInput : false,
      duration : '',
      gotoCurrent : true
    }).datepicker();
  });
</script>
</html>