<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2><%=request.getAttribute("message") == null ? "" : request.getAttribute("message") %></h2>

	<label>post form</label>
	<form action="/jsp/mvc/FormController" method="post">

		<input type="hidden" name="action" value="login">

		<label>email</label> <input type="text" name="email"
			value="<%=request.getAttribute("email") == null ? "" : request.getAttribute("email")%>" />

		<label>password</label> <input type="text" name="password"
			value="<%=request.getAttribute("password") == null ? "" : request.getAttribute("password")%>" />

		<input type="submit" value="ok" />
	</form>

</body>
</html>