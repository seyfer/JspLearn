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
<jsp:useBean id="user" class="beans.User" scope="session"></jsp:useBean>
<!-- //one page -->
<%-- <jsp:useBean id="user" class="beans.User" scope="page"></jsp:useBean> --%>
<!-- //forward -->
<%-- <jsp:useBean id="user" class="beans.User" scope="request"></jsp:useBean> --%>
<!-- //while not restarted -->
<%-- <jsp:useBean id="user" class="beans.User" scope="application"></jsp:useBean> --%>

<jsp:setProperty property="email" name="user" value="seyferseed@gmail.com" />
<jsp:setProperty property="password" name="user" value="lol" />

</body>
</html>