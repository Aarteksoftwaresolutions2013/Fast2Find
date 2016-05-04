<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jsp-js/registration.js"></script>
 <link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
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
      <div id="sign-golbal" class="sign-golbal">&nbsp;&nbsp;
       <h4>${successMsg}</h4>
      <h2>Signup</h2>
     <form:form action="addBusinessAndEventInfo.do" modelAttribute="BusinessAndEventInformation" method="POST" autocomplete="off" id="sign-gobal" class="sign-gobal" name="frm">
      <ul class="leftsidefrm">
      <li>
       <form:select path="login.userType" id="the_list">
       <form:option value="global" label="Select User Type" />
       <form:option value="business"  label="Business User" />
       <form:option value="Customer"  label="Customer User" />
       <form:option value="event" label="Event User" />
      </form:select>
        <form:errors path="login.userType" cssClass="error"></form:errors>
      </li>
      
      <li>
      <form:input path="firstName"  placeholder="First Name" id="fld-a" maxlength="40" onkeyup="onlyAlph(event,this)" required ="autofocus" />
       <form:input path="lastName" placeholder="Last Name" id="fld-b" maxlength="40" onkeyup="onlyAlph(event,this)"  required ="autofocus" />
      </li>
       <li>
       <form:errors path="firstName" cssClass="error"></form:errors>
       <form:errors path="lastName" cssClass="error"></form:errors>
       </li>
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
      <form:input path="location.address"  name="address" placeholder="Address" required ="autofocus" id="fld-c" maxlength="150" />
      <form:errors path="location.address" cssClass="error"></form:errors>
      </li>
      
      <li>
      <form:input path="location.cityName"  name="title-here" placeholder="City" required ="autofocus" id="fld-d" maxlength="40" onkeyup="onlyAlph(event,this)" />
      <form:input path="location.stateName" name="title-here" placeholder="Province/State" required ="autofocus" id="fld-e" maxlength="40" onkeyup="onlyAlph(event,this)" />
      </li>

      <li>
        <form:errors path="location.cityName" cssClass="error" ></form:errors>
        <form:errors path="location.stateName" cssClass="error"></form:errors>
      </li>
      <li>
      <form:input path="location.zipCode" name="title-here" placeholder="Zip code/ Postal code" required ="autofocus" id="fld-f" maxlength="12"/>
      <form:select path="location.countryName"  id="sign-gbal" >
      <form:option value="selected" selected="selected" label="Select Country" />
      <c:forEach items="${pageScope.countryName}" var="country">
      <form:option value="${country}" label="${country}"  />
      </c:forEach>
      </form:select>
      </li>
      <li>
      <form:errors path="location.zipCode" cssClass="error" ></form:errors>
        <form:errors path="location.countryName" cssClass="error"></form:errors>
      </li>
        <li><h3>Fast2Find Credentials</h3></li>
      <li>
      <form:input path="login.emailId"  placeholder="Email Address" id="fld-g" required ="autofocus" maxlength="50" />
      <form:input path="confirmEmail"  placeholder="Confirm Email" required="autofocus" id="fld-h" autocomplate="off" maxlength="50" />
      </li>
      <li>
      <form:errors path="login.emailId" cssClass="error" ></form:errors>
       <form:errors path="confirmEmail" cssClass="error"></form:errors>
       </li>
        <li>
       <form:password path  ="login.password"  placeholder="Password" id="fld-pss" required ="autofocus" maxlength="15"/>
       <form:password path ="confirmPassword" placeholder="Confirm Password" required="autofocus" id="fld-ps" autocomplate="off" maxlength="15" />
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
            <form:input path="location.billingAddress" name="b_address" placeholder="Address"  id="fld-rc" maxlength="150"  />
      </li>
      <li>
      <form:input path="location.billingCityName" name="title-here" placeholder="City"  id="fld-rd" maxlength="40" onkeyup="onlyAlph(event,this)" />     
      <form:input path="location.billingStateName" name="title-here" placeholder="Province/State"  id="fld-re" maxlength="40" onkeyup="onlyAlph(event,this)" />
      </li>
      <li>
      <form:input path="location.billingZipCode" type="text" name="title-here" placeholder="Zip code/ Postal code"  id="fld-rf" maxlength="15" />      
        <form:select path="location.billingCountryName"  id="sign-gbal-right" >
      <form:option value="selected" selected="selected" label="Select Country" />
      <c:forEach items="${pageScope.countryName}" var="country" >
      <form:option value="${country}" label="${country}"  />
      </c:forEach>
      </form:select>
      </li>
      <li><form:errors path="location.billingZipCode" cssClass="error" ></form:errors></li>
      <li>
      <span id="add" style="display:none;" class="error" >Please fill in the Current Address details before selecting the Billing address checkbox</span>
      </li>
      </div>
      <div class="the_show Customer" id="global3">
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
      <li><form:errors path="eventCatagory" cssClass="error"></form:errors></li>
  <!---------------added checkbox-thilak----------->
      <li>
    <form:checkbox path="termAndCondition" id="terms_condition" type="checkbox"  onClick="apply()" value="yes"/>
    <span class="terms_text">I confirm that i have read and understand and also agree to the Fast2Find <i id="terms_and_conditions">Terms and Conditions</i></span>
    </li>

 <!---------------added checkbox-thilak----------->
      <p>&nbsp;</p>
      <li>
      <input type="submit" id="signup-sbmt" value="Submit"  name="sub"/>
      </li>
      </ul>
      </form:form>
      </div><!---------------end div of feedback------------>
      <!---------------------end singup_global ------------------------>
      <!---------------------end singup_global ------------------------>     
          </td>
    </tr></tbody></table> 
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
<script type="text/javascript">
function apply()
{
  document.frm.sub.disabled=true;
  if(document.frm.termAndCondition.checked==true)
  {
    document.frm.sub.disabled=false;
  }
  if(document.frm.termAndCondition.checked==false)
  {
    document.frm.sub.enabled=false;
  }
}
</script>
<script type="text/javascript" charset="utf-8">
  jQuery( document ).ready( function() {
  $("#terms_and_conditions").click(function(){
    $("#overlay").show();
  $(".terms_and_conditions").show();
  });
    $("#close_popup, #close_popup2").click(function(){
    $(".terms_and_conditions").hide();
  $("#overlay").hide();
  });
  });
</script>
<!----Privacy Policy popup content added by thilak----->

  <div class="terms_and_conditions">
    <div class="description">
      <span id="close_popup">X</span>
<h2>Fast2Find Terms of Service</h2>
      <h2>INTRODUCTION (Acceptance of Terms)</h2>
<p>The Fast2Find (hereinafter referred to as F2F) provides its services to you subject to the following conditions. If you spend time on the web site, you must accept these conditions so please read them carefully. In addition, when you use any current or future F2F service, you also will be subject to the guidelines and conditions applicable to such service or business. F2F strictly follows the policy described below, which defines the terms and conditions when accessing this web site, and assumes your adherence to these provisions. Visiting the F2F web site, or using any of our services, constitutes your acceptance of this policy.
</p>
<p>F2F provides its services to you subject to these conditions. Carefully review the items posted here. By using this site, you agree to access this web site only as permitted by applicable law and these Terms and Conditions, and additional policies or procedures published on the site from time to time. Customers agree to review these Terms and Conditions from time to time for changes and updates. </p>
<p>In addition, when using particular features on or through the F2F web site, you shall be subject to any posted policies and guidelines applicable to such features, including any terms or conditions applicable to features provided in conjunction with any of our content and service partners. All such rules and guidelines are hereby incorporated by reference into the following terms and conditions.</p>
<h2 id="toc-services">PRIVACY POLICY</h2>
<p>You should review the other F2F policies to better comprehend our practices and how we govern your visit to the web site. Registration data and certain other information about you are subject to our privacy policy. For more information, see our entire privacy policy at: <a href="privacyPolicy.do">http://fast2find.com/ftf-web/privacyPolicy.do</a>. We reserve the right to make any changes to our web site, pricing, or policies at any time in our sole and absolute discretion. Shall any of these conditions be deemed invalid or for any reason unenforceable, the respective condition shall be removed and will not affect the validity and enforceability of any remaining conditions.
</p>
<h2 id="toc-account">ELIGIBILITY</h2>
<p>Use of the website is void where prohibited. By using this website, you represent and warrant that you have the right, authority, and capacity to enter into this terms of service agreement and to abide by all its terms and conditions. Also, you must be an individual of 13 years of age or older to register or use the website.</p>
<h2 id="toc-protection">REGISTRATION</h2>
<p>In order to register with F2F you may be required to supply a valid email address, which will be used as a unique identifier for your account, and your first name, last name, birthday, gender, country of residence and ZIP/POSTAL code. You will also be asked to set a password. You may also be asked to provide certain other information, including an image, interests and/or other requested information.
You are solely responsible for maintaining the confidentiality of your password and account. You agree not to transfer your email address or password, or lend or otherwise transfer your use of or access to the website, to anyone else. You are also solely responsible for any and all activities that occur under your account. You may change your password, or any other account information, at any time by following instructions available on your Profile Page.
You agree to immediately notify us at [support email address] of any unauthorized use of your account or any other breach of security related to your account or the website.
Those who have not registered will not have to pay a fee. Those who do register, the fees charged by F2F, which has been outlined on <a href="pricing.do">http://fast2find.com/ftf-web/pricing.do</a>, will be automatically deducted from your PayPal or credit card account annually if applicable.
</p>
<h2 id="toc-content">LICENSE TO USE THE SERVICE</h2>
<p>F2F grants you a limited license to access and make personal use of this website and not to download (other than page caching) or modify it, or any portion of it, except with F2F's express written consent. The foregoing license does not include any resale or commercial use of this website, the website or its contents; any derivative use of this website, the website or its contents; or any use of data mining, robots, or similar data gathering and extraction tools. This website, or any portion thereof, may not be reproduced, duplicated, copied, sold, resold, visited, or otherwise exploited for any commercial purposes without F2F's express written consent. Use of the website that constitutes abuse shall be determined by F2F, in its sole discretion. F2F reserves the right to terminate your account if F2F determines you have not complied with these terms.
</p>
<h2 id="toc-modification">RESTRICTION ON USE OF CONTENT</h2>
<p>You acknowledge that the website may contain information, software, photos, video, text, graphics, music, sounds or other material (collectively, "Content") that are protected by copyrights, patents, trademarks, trade secrets or other proprietary rights, and that these rights are valid and protected in all forms, media and technologies existing now or hereafter developed. The Content, taken together in its entirety, is protected under Canadian and US copyright laws as a collective work, and we own a copyright in the selection, coordination, arrangement and enhancement of such Content.
</p>
<p>Modification of the Content or use of the Content for any other purpose, including use of any such Content on any other web site or networked computer environment is strictly prohibited. Except as otherwise expressly authorized in writing in advance by us, you agree not to reproduce, redistribute, sell, modify, rent, lease, loan, adapt, translate, create derivative works based (whether in whole or in part) on, decompile, reverse engineer, disassemble, or otherwise reduce all or any part of the website, including the Content.
</p>
<h2 id="toc-warranties-disclaimers">MATERIALS SUBMITTED THROUGH THE SERVICE</h2>
<p>You are solely responsible for any data, text, software, sound files, images, photographs, graphics, video, messages, files, links or any other materials ("Materials") that are transmitted, posted, or distributed by you through the website, including, but not limited to, the contents of your email communications, information, reviews, user ratings, photos or images posted or sent by you to or through the website.
</p>
<h2 id="toc-liability">RESTRICTIONS ON USE OF THE F2F SERVICE</h2>
<p>You agree not to do the following on or through the F2F website:
</p>
<ul>
<li><strong><p>Post, transmit, or otherwise make available, through or in connection with the website anything that is or may be:</p></strong></li>
</ul>
<ul class="cir-disc">
<li><p>unlawful, threatening, harassing, degrading, abusive, hateful or intimidating;</p></li>
<li><p>defamatory; libelous or invasive of another's privacy;</p></li>
<li><p>fraudulent or tortious;</p></li>
<li><p>vulgar, obscene, indecent, sexually explicit, pornographic or otherwise objectionable;</p></li>
<li><p>protected by copyright, trademark, trade secret, right of publicity or other proprietary right without the express prior consent of the owner of such right; or </p></li>
<li><p>a virus, worm, Trojan Horse, easter egg, time bomb, spyware, cancelbot, or other computer code, file, or program that is harmful or invasive or that may or is intended to damage or hijack the operation of, or to monitor the use of, any hardware, software or equipment
</p>
</li>

<li><p>
an unsolicited or unauthorized advertising, promotional material, "junk mail," "spam," "chain letter," "pyramid scheme", survey, contest, or investment opportunity</p></li>
<li><p>
any other form of solicitation, or use any distribution lists including any person who has not given specific permission to be included in such a process (commercial or otherwise);</p>
</li>
<li>
<p>Material that you do not have a right to transmit under any law or under contractual or fiduciary relationships (such as inside information, proprietary and confidential information learned or disclosed as part of employment relationships or under nondisclosure agreements).</p></li>
</ul>
<ul>
<li><p>Use the website to defame, abuse, harass, stalk, threaten or otherwise violate the legal rights of others, including without limitation others' privacy rights or rights of publicity, or harvest or collect personally identifiable information, including email addresses, about users of the website.</p></li>

<li><p>Harm minors in any way.</p></li>

<li> <p>Impersonate any person or entity, including without limitation any of our officials, forum leaders, guides or hosts; falsely state or otherwise misrepresent your affiliation with any person or entity; or express or imply that we endorse any statement you make.</p></li>

<li><p>Interfere with or disrupt the operation of the website or the servers or networks used to make the website available; or violate any requirements, procedures, policies or regulations of such networks.</p></li>

<li><p>Restrict or inhibit any other person from using the website, including without limitation by hacking or defacing any portion of the website; or disrupt the normal flow of dialogue, or otherwise act in a manner that negatively affects other users' ability to engage in real time exchanges.
</p></li>
<li><p>
Use the website to distribute or otherwise publish or post any material containing any solicitation of funds, promotion, advertising, or solicitation for goods or services without our express prior written consent; or use the website in a commercial manner, unless otherwise expressly allowed by F2F.
</p></li>

<li>
<p>Use the website to distribute or otherwise publish or post any material that is pornographic, obscene, contains hate speech, is racist, promotes or encourages violence, is illegal or promotes illegal behavior, violates anyone's intellectual property rights, or is otherwise offensive or inappropriate as determined in F2F's sole discretion.</p>
</li>

<li><p>
Reproduce, duplicate, copy, sell, resell or otherwise exploit for any commercial purposes, any portion of, use of or access to the website.
</p>
</li>
<li><p>
Use, download, or otherwise copy, or provide (whether or not for a fee) to a person or entity that is not a user of the website any directory of F2F's users or usage information or any portion thereof other than in the context of your use of the website as permitted under these terms.
</p></li>
<li><p>Attempt to gain unauthorized access to the website, other accounts, computer systems or networks connected to the website, through password mining or any other means.</p></li>
<li><p>
Remove any copyright, trademark or other proprietary rights notice from the website or Content or Materials originating from the website.
</p></li>
<li><p>Frame or mirror any part of the website or software without our express prior written consent; or forge headers or otherwise manipulate identifiers in order to disguise the origin of any Materials transmitted through the website.</p></li>
<li><p>Create a database by systematically downloading and storing content from the website.</p></li>
<li><p>Intentionally or unintentionally violate any applicable local, state, national or international law, including, but not limited to any regulations having the force of law.</p></li>
<li><p>Use any robot, spider, site search/retrieval application or other manual or automatic device to retrieve, index, "scrape," "data mine" or in any way gather Content or Materials from the website or reproduce or circumvent the navigational structure or presentation of the website.
</p></li>
<li><p>Engage in any other conduct which, in F2F's sole discretion, is considered inappropriate, unauthorized or objectionable.
</p></li>
<li><p>In addition, you agree to comply with all applicable laws, regulations, and ordinances as a condition of use of the website.
</p></li>
</ul>
<p>In order to permit us to protect the quality of our products and services, you hereby consent to our employees and representatives being able to access your account and records for any reason, in our sole discretion. We also reserve the right, but do not assume the responsibility, to monitor or review your conduct while using the website. </p>
<h2 id="toc-business-uses">Special Admonitions for International Use</h2>
<p>Recognizing the global nature of the Internet, you agree to comply with all local rules regarding online conduct and acceptable content. Specifically, you agree to comply with all applicable laws regarding the transmission of technical data exported from the state or the country in which you reside.</p>
<h2 id="toc-business-uses">LINKS TO THIRD PARTY SITES</h2>
<p>The website may provide, or third parties may provide, links to other Internet websites or resources. Because we have no control over such sites and resources, you acknowledge and agree that we are not responsible for the availability of such external sites or resources, and do not endorse and are not responsible or liable for any content, advertising, products, services or other materials (collectively, "Third Party Materials") on or available from such sites or resources.
You acknowledge that such external sites usually have their own terms and conditions, including privacy policies, over which F2F has no control and which will govern your rights and obligations with respect to the use of those such third party's product, services or websites.
</p>
<h2 id="toc-business-uses">INDEMNIFICATION</h2>
<p>
You agree to indemnify, defend and hold harmless F2F, its parent company, subsidiaries, affiliates, officers, directors, employees, consultants, agents, successors and assigns from any and all third party claims, liability, damages, costs or demands, including, but not limited to, attorneys' fees, arising from (i) your use of the website, including, but not limited to, all content therein and any products or services obtained by you through the website, (ii) the violation of these terms by you, (iii) the infringement by you (or other user of the website using your account) of any intellectual property or other right of any person or entity; or (iv) your violation of any applicable law or regulation.
</p>
<h2 id="toc-business-uses">DISCLAIMER OF WARRANTIES</h2>
<div>
<p><i>
You expressly agree that your use of the service is at your sole risk. the service is provided on an "as is" and "as available" basis. f2f expressly disclaims all warranties of any kind, whether express or implied, including, but not limited to, the implied warranties of merchantability, fitness for a particular purpose and non-infringement as to the operation of the service, or the information, content, materials, or products included in the service. f2f makes no warranty that the service will meet your requirements, or that the service will be uninterrupted, timely, secure, or error free. f2f makes no warranty as to the results that may be obtained from the use of the service or as to the accuracy or reliability of any information obtained through the service or that defects in the service will be corrected. you acknowledge that f2f does not control content, information, products or services offered by advertisers, third parties or other users on or through the service, including, but not limited to, information, products, or services provided by license to f2f from third parties or materials provided by other users. f2f assumes no responsibility for and makes no warranty or representation as to the accuracy, currency, completeness, reliability, usefulness or decency of the service, or content or products distributed or made available by third parties (including but not limited to advertisers and users) through the service. you will be solely responsible for any damage to your computer system or loss of data that results from your attempt to download any material from the service.
</i></p>
</div>
<h2 id="toc-business-uses">LIMITATION OF LIABILITY</h2>
<div>
<p>
<i>You expressly agree that f2f shall not be liable for any indirect, incidental, special or consequential damages, including, but not limited to, damages for loss of profits, use, data or other intangibles, even if f2f has been advised of the possibility of such damages, resulting from the (i) use or the inability to use the service; (ii) cost of procurement of substitute goods and services; (iii) any goods or services purchased or obtained or content received or transactions entered into with f2f or a third party through the use of the service; (iv) inaccuracy of any information obtained from use of the service or reliance on such information; or (v) unauthorized access to your account or alteration of your account or data. you specifically agree that f2f is not responsible or liable to you or anyone else for any unlawful, harassing, defamatory, abusive, threatening, harmful, vulgar, obscene, sexually explicit or otherwise objectionable conduct or speech of any other party on or through the service, or for any infringement or violation of your rights by any other party, including, but not limited to, intellectual property rights, rights of publicity, or rights of privacy. some jurisdictions do not allow the limitation or exclusion of liability for incidental or consequential damages, therefore some of the above limitations may not apply to you.
</i></p>
</div>
<h2 id="toc-business-uses">TERMINATION AND MODIFICATION OF THE SERVICE</h2>
<p>
You agree that we, in our sole discretion, may terminate your password, account (or any part thereof) or use of the website, and remove and discard any Materials within the website, for any reason, at any time, without notice to you. We will also terminate your account upon receiving reliable information involving your violation of any law, and will cooperate with law enforcement agencies on such matters. We may also, in our sole discretion and at any time, discontinue providing the website, or any part thereof, with or without notice. You agree that we shall not be liable to you or any third party for any termination of your access to the website.
We reserve the right, at any time and from time to time, temporarily or permanently, in whole or in part, to: (a) modify or discontinue the website, including, but not limited to (i) restricting the time the website are available, (ii) restricting the amount of use of the website permitted, and (iii) restricting or terminating any user's right to use the website, with or without notice; (b) charge fees in connection with the use of the website; (c) modify and/or waive any fees charged in connection with the website; and/or (d) offer opportunities to some or all users of the website. You agree that neither we nor any of our affiliates, shall be liable to you or to any third party for any modification, suspension or discontinuance of the website, in whole or in part, or of any service, content or feature offered through the website.
</p>
<p>
Your account may be terminated if these conditions are breached, but we are not limited to these reasons. We also have the right to suspend your account for a limited period or indefinitely if the conditions warrant such an action.
</p>
<h2 id="toc-business-uses">NOTICES</h2>
<p>
F2F may give notice to you by email, a posting on the website, or other reasonable means. You must give notice to F2F in writing via email or as otherwise expressly provided by F2F. F2F may broadcast, distribute or display notices or messages through the website to inform you of changes to these Terms, the website, the Privacy Policy or other matters of importance. Such broadcast, distributions or displays of information shall constitute notice to you.
</p>
<h2 id="toc-business-uses">ENTIRE AGREEMENT </h2>
<p>
These Terms and Conditions represent the complete and entire agreement between F2F and you and supersede all prior and contemporaneous agreements of the parties relating to the subject mater hereof.<em> YOU ACKNOWLEDGE THAT YOU HAVE READ THESE TERMS AND CONDITIONS AND UNDERSTAND AND AGREE TO ALL OF THEM IN THEIR ENTIRETY. YOU HAVE INDEPENDENTLY EVALUATED THE DESIRABILITY OF USING THIS INTERNET SITE, AND ARE NOT RELYING ON ANY REPRESENTATION, GUARANTEE, OR STATEMENT OTHER THAN AS SET FORTH IN THESE TERMS AND CONDITIONS.</em>
</p>
<h2 id="toc-business-uses">SPECIAL TERMS FOR PAGES.</h2>
<p>If you have a "Page" on the website, you also agree to the following:</p>
<ul>
<li><p>
Pages are special profiles that may only be used to promote a business or other commercial, political, or charitable organization or endeavor (including non-profit organizations, political campaigns, bands, and celebrities).
</p></li>
<li><p>
You may only administer a Page if you are an authorized representative of the subject of the Page.
</p></li>
<li><p>
All Content posted on the Pages will be made available to all users of the websites.
</p></li>
<li><p>
You may not display any Content on your Page that is an ad or could be construed as an ad.
</p></li>
<li><p>
You may not establish terms beyond those set forth in these Terms of Use to govern the use of the Page you administer.
</p></li>
<li><p>
Your Page will not be used primarily or substantially to promote or advertise alcohol or tobacco products, firearms, or other products or services that may not be lawfully purchased or used by minors.
</p></li>
<li><p>
You will not direct your Page, or any Content on your Page, to children under the age of 13.
</p></li>
<li><p>
If you collect information about users, you will only use such information for your internal business purposes in connection with your use of the website and in accordance with F2F's Privacy Policy.
</p></li>
<li><p>
You will not use deceptive practices to get users to "like" your Page.
</p></li>
<li><p>
You are responsible for ensuring that your Page, including any Content you post on your Page, shall comply with all applicable laws, rules and regulations and these Terms of Use, and any advertising, marketing, privacy, or other self-regulatory code(s) applicable to your industry.
</p></li>
</ul>

<h2 id="toc-about">LANGUAGE</h2>

<p>Where F2F has provided you with a translation of the English language version of these Terms and Conditions, then you agree that the translation is provided for your convenience only and that the English language versions of the Terms will govern your relationship with F2F.</p>

<p>If there is any contradiction between what the English language version of these Terms and Conditions and what a translation says, then the English language version shall take precedence.</p>

<h2 id="toc-about">FEES, PAYMENTS, DISPUTES, TAXES, AND CHARGEBACKS</h2>
<p><strong>Fees :</strong> Once you have completed registration you will be subject to fees in accordance with any applicable Fee Schedule <a href="pricing.do">http://fast2find.com/ftf-web/pricing.do</a>. Applicable fees will be billed for using the website, even if you are not actively using the services as a registered user. The applicable Fee Schedule is subject to change at any time in our sole discretion, and if you do not agree to any such changes, you should contact us to cancel your account. We will use good faith efforts to notify you prior to the effectiveness of any significant change to the applicable Fee Schedule, but you are responsible for reviewing the applicable Fee Schedule from time to time and remaining aware of the fees charged by us and any applicable discounts. You acknowledge and agree that our measurements are the definitive measurements for payment due and owed hereunder.
</p>
<p><strong>Disputes :</strong> Notwithstanding anything set forth herein to the contrary, any disputes about any charges to you under this Agreement must be submitted to us in writing within 60 days of the date such charges are incurred. You agree to waive all disputes not brought within the 60 day period, and all such charges will be final and not subject to challenge.
</p>
<p><strong>Payment :</strong>
If you have previously provided us with your credit card for payment, you hereby authorize us to charge your credit card for such amounts on a one-time, monthly, or annual basis beginning upon registration and continuing until such time as your account is terminated. If we are for any reason unable to effect automatic payment by credit card, we will attempt to notify you by email and your account may be disabled until payment is received.
</p>
<p><strong>Taxes :</strong>
We collect and remit sales tax from our customers located in certain state and local jurisdictions, including those jurisdictions where software delivered as a service is taxable and where we maintain a physical presence. We determine your local taxing jurisdiction based on the billing address that you list in the "My Account" section of your account. Fees set forth in the applicable Fee Schedule do not take into account any taxes.
</p>
<p>You agree to be responsible for and to pay any sales, personal property, use, VAT, excise, withholding, or any other taxes that may be imposed, based on these terms (except for taxes based on net income payable by us).</p>
<p><strong>Chargebacks :</strong>
Any credit card chargebacks initiated by the Ticket Buyer for any reason, with the exception of fraudulent use of the credit card, shall be charged back to you. F2F shall either (i) deduct these costs from your outstanding balance, whether for that particular Event or for any other Event that you list with F2F; or (ii) send an invoice to you for said costs if no balance exists. If payment for said invoice is not received by F2F within thirty (30) days, F2F reserves the right, at our sole discretion, to terminate this Agreement and to cancel all other Events listed by you and / or to pursue other legal avenues to recover the monies owed by you.
</p>
      <button id="close_popup2">ok</button>
    </div>
  </div>
<div id="overlay"></div>
</body>
</html>