<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
<p></p>
<table align="left"><tr><td width="5%"></td>
<td>
<h5>${successMsg}</h5>
</td>
</tr>
<tr>
<td width="38%"></td><td>
<input type="hidden" name="cmd" value="_s-xclick">
<input type="hidden" name="hosted_button_id" value="58PQQW3D6ZX42">
<input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_subscribeCC_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
<input name="return" type="hidden" value="http://fast2find.com/ftf-web/signIn.do" />
<input name="cancel_return" type="hidden" value="http://fast2find.com/ftf-web/registration.do" /> 
<input name="notify_url" type="hidden" value="http://fast2find.com/ftf-web/notify.do" />
<img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
</td></tr></table>
</form>
</body>
</html>