<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
</head>
<body>
<!-- Hello World -->

<%
Date today = new Date();

String text = "today : " + today.toString();

out.println(text);
%>
<br>

<%="Hello From Java"%>
<br>

<%=
new Date()
%>
<br>
</body>
</html>