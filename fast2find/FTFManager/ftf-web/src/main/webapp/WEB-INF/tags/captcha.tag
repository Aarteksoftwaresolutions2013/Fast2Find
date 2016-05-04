<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ tag import="net.tanesha.recaptcha.ReCaptchaFactory" %>
 
<script type="text/javascript">var RecaptchaOptions = {theme : 'clean'};</script>
<%
    ReCaptcha reCaptcha = ReCaptchaFactory.newReCaptcha("6Lc0r-8SAAAAABmpZBEv_XvTYAinnPZ0w-QSV_8R", "6Lc0r-8SAAAAAOMFguzICgV3SqTc6Cjuw_9F3L52", false);
    out.print(reCaptcha.createRecaptchaHtml(null, null));
%>