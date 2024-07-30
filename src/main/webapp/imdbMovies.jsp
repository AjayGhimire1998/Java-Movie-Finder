<%@page import="java.util.Map"%>
<%@ page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap"
	rel="stylesheet">

<title>Movie Finder</title>
<style>
body {
	font-family: Roboto, sans-serif;
	display: flex;
	flex-direction: column;
	align-items: center;
	background: #1b1c1b;
	color: white;
	display: flex;
	max-height: 100vh;
}

.welcome {
	font-size: 50px;
}

.search {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	justify-content: center;
	gap: 25px;
	margin: 30px;
	width: 100%;
}

.search>.search-input {
	width: 50%;
	padding: 15px;
	font-size: 30px;
	text-align: center;
}

.search>.search-submit {
	background: #f53333;
	color: white;
	font-size: 25px;
	padding: 15px;
	width: 10%;
	border: 1px solid white;
	border-radius: 20%;
	outline: none;
}

.search>.search-submit:hover {
	background: #43cc21;
	cursor: pointer;
}

.results {
	margin-top: 20px;
}
</style>
</head>
<body>
	<h1 class="welcome">A Movie Finder App</h1>
	<br />


	<form action="/" method="get" class="search">
		<input type="text" placeholder="Type name to search.."
			class="search-input" id="title" name="title" /> <input
			type="submit" value="Search" class="search-submit" />
	</form>

	<div class="results">
		<%
		Object movieDetails = request.getAttribute("data");
		if (movieDetails != null) {
		%>
		<h1><%= movieDetails %></h1>
		
		<%
		} else {
		%>
		<p>No movie details found.</p>
		<%
		}
		%>
	</div>





</body>
</html>