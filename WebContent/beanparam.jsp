<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- //cookie -->
<jsp:useBean id="user5" class="beans.User" scope="page"></jsp:useBean>

<%-- <jsp:setProperty property="email" name="user5" value="seyferseed@gmail.com" /> --%>
<%-- <jsp:setProperty property="password" name="user5" param="p" /> --%>

<jsp:setProperty property="password" name="user5" param="p" />
<jsp:setProperty property="*" name="user5" />

<%=user5.getEmail() %>
<%=user5.getPassword() %>

</body>
</html>