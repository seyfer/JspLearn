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
	<c:out value="Hello!"></c:out>

	<jsp:useBean id="test" class="beans.TestBean" scope="page"></jsp:useBean>

	<br /> Attribute
	<c:out value="${test.info}"></c:out>

	<br /> Parameter
	<c:out value="${param.name}"></c:out>

	<br /> if
	<c:if test='${param.name == "lol"}'>
	lol
</c:if>
	<c:if test='${param.name != "lol"}'>
	not lol
</c:if>

	<br />
	<!-- JSTL choose -->
	choose
	<c:choose>
		<c:when test='${param.name == "lol"}'>lol</c:when>
		<c:when test='${param.name == "lols"}'>lols</c:when>
		<c:otherwise>not lol</c:otherwise>
	</c:choose>

	<br /> foreach
	<c:forEach var="i" begin="0" end="10" varStatus="status">

		<c:out value="${i}"></c:out>

		<c:if test="${status.first}">
was first
</c:if>

	</c:forEach>


</body>
</html>