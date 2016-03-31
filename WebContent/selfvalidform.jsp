<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="user" class="beans.User" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

<%
String action = request.getParameter("action");
if (action != null && action.equals("1") && user.validate()) {
	user.setMessage("");
	request.getRequestDispatcher("/FormsController").forward(request, response);
}

out.print(action);
%>

<h2><jsp:getProperty property="message" name="user"/></h2>

<label>post form</label>
<form action="/jsp/selfvalidform.jsp" method="post">

<input type="hidden" name="action" value="1" />

<label>email</label>
<input type="text" name="email" 
value='<jsp:getProperty property="email" name="user"/>'/>

<label>password</label>
<input type="text" name="password" 
value='<jsp:getProperty property="password" name="user"/>'/>

<input type="submit" value="ok" />
</form>

</body>
</html>