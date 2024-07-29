<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movies</title>
</head>
<body>
	<%
	Object movies = request.getAttribute("movies");
	Object number = request.getAttribute("number");
	out.println("<h2>");
	out.println(number + " movies showign");
	out.println("</h2>");
	out.println("<h2>");
	out.println(movies);
	out.println("</h2>");
	%>


	<br />

</body>
</html>