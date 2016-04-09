<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${user1.email}"></c:out>
	<c:out value="${user2.email}"></c:out>
	<c:out value="${user3.email}"></c:out>
	
	<c:out value="${sessionScope.user2.email}"></c:out>
	
	<br />
	<c:out value='${map1["fruit"]}'></c:out>
	<br />
	${link}
	
	<br />
	<c:forEach var="user" items="${sessionScope.list1}">
	${user.email} : ${user.password} <br />
	</c:forEach>
</body>
</html>