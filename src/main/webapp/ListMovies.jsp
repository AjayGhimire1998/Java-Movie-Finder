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
	ArrayList<Movie> movies = request.getAttribute("movies");
	out.println(moviesSize);
	%>

	<h3>moviesshowing..</h3>

	<br />

</body>
</html>