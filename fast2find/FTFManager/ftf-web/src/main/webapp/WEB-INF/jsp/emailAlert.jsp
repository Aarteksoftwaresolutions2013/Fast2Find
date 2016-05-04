<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jsp-js/emailAlert.js"></script>
<title>Insert title here</title> 
</head>
<body>
<!---------------------content name here ------------------------>
      <div id="customer-custmize-alert" class="customer-custmize-alert">
      <div class="customer-content">
      <h4>${message}</h4>
      <h2>Customize your email alert!</h2>
      <form:form modelAttribute="EmailAlert" action="emailAlertAction.do" method="post" id="aler-emial-001" autocomplete="off">
      <ul class="customer-side-left">
      <h3>Select Category</h3>
      <li>
      <div class="checkall"> <input type="checkbox" id="selecctall"/><label for="selecctall"> Select All </div>
      </li>
     <c:forEach items="${catageory}" var="catageoryList"  varStatus="con"> 
      <li>
      <div class="my-glossy-tabs">
      <a class="menuitem mysubmenuheader" href="#" headerindex="0h"><span class="accordprefix"></span>&nbsp;<span class="accordsuffix"><img src="images/plus.gif" class="mystatus"></span></a>
      <div class="my-style">
      <form:checkbox path="catagory" id="cat${catageoryList.catageoryId}"  value="${catageoryList.catageoryId}" class="checkbox1" />
      <label for="cat${catageoryList.catageoryId}"><span>${catageoryList.catageoryName}</span></label> 
      </div><!------my-style------>
      <div class="mysubmenu" contentindex="0c" style="display: none;">
      <ul>
      <c:forEach var="sub" items='${catageoryList.subCatageoryList}' varStatus="subcon">
      <li>
      <form:checkbox path="subCatagory" id="sbCat${sub.subCatageoryId}"  value="${sub.subCatageoryId}" class="checkbox1" />
      <label for="sbCat${sub.subCatageoryId}"><span>${sub.subCatageoryName}</span></label>
      </li>
      </c:forEach>  
      </ul> 
      </div><!-----.mysubmenu------->
      </div>
      </li>
       </c:forEach>
      <li><form:errors path="catagory" cssClass="error"></form:errors></li>
      </ul>
      <hr class="cnty" />
      <ul class="custmr-right-sid">
      <h3>Genre’s of Music</h3>
      <li> <input type="checkbox" name="music"  id="check-Pop" value="Pop" />
      <label for="check-Pop"><span>Pop</span></label> </li> 
      <li> <input type="checkbox" name="music"  id="check-folk" value="folk" />
      <label for="check-folk"><span>folk</span></label> </li> 
      <li> <input type="checkbox" name="music"  id="check-hip-hop" value="hip-hop"/>
      <label for="check-hip-hop"><span>hip hop</span></label> </li> 
      <li> <input type="checkbox" name="music"  id="check-jazz" value="Jazz" />
      <label for="check-jazz"><span>jazz</span></label> </li> 
      <li> <input type="checkbox" name="music"  id="check-rock" value="Rock"/>
      <label for="check-rock"><span>Rock</span></label> </li> 
      <li><form:errors path="music" cssClass="error"></form:errors></li>
      <p></p>
      <li>
      <form:input path="city" placeholder="ENTER CITY OF PREFERENCE" id="Ct-prefence" class="Ct-pref" maxlength="40" onkeyup="onlyAlph(event,this)" />
      </li>
     <p></p>
      <li><form:errors path="city" cssClass="error"></form:errors></li>
      <p></p>
      <h4>When to alert you</h4>
      <li> <input type="checkbox" name="emailAlertTime"  id="check-wk-alrt" value="weekly"/>
      <label for="check-wk-alrt"><span>weekly alert</span></label> </li>  
      <li> <input type="checkbox" name="emailAlertTime"  id="check-mnth-alrt" value="monthly"  />
      <label for="check-mnth-alrt"><span>Monthly alert</span></label> </li> 
        <li><form:errors path="emailAlertTime" cssClass="error"></form:errors></li>
      <p></p>
      <li>
      <input type="submit" id="sbi-btz" value="Submit"/>
      </li>
      </ul>
      </form:form>
      </div><!--------end customer-content div ----------->
      </div><!------------end customer-custmize-alert div--------->
</body>
<script type="text/javascript" src="js/ddaccordion.js"> </script>
<script type="text/javascript">
ddaccordion.init({
  headerclass: "mysubmenuheader", //Shared CSS class name of headers group
  contentclass: "mysubmenu", //Shared CSS class name of contents group
  revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
  mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
  collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
  defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
  onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
  animatedefault: false, //Should contents open by default be animated into view?
  persiststate: true, //persist state of opened contents within browser session?
  toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
  togglehtml: ["suffix", "<img src='images/plus.gif' class='mystatus' />", "<img src='images/minus.gif' class='mystatus' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
  animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
  oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
    //do nothing
  },
  onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
    //do nothing
  }
})
</script>
</html>