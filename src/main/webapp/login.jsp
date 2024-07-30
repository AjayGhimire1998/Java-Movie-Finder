<%@page import="java.util.Map"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
.form-g {
	display: flex;
	margin-top: 100px;
}

input {
	color: red;
}
</style>
</head>
<body>
	<form method=class="form-g">
		<input type="text" name="user_name" placeholder="Enter your user_name" /> &nbsp; <br />
	</form>
	<button>Submit</button>

<div class="results">
		<%
		Map<String, String> movieDetails = (Map<String, String>) request.getAttribute("movieDetails");
		if (movieDetails != null) {
		%>
		<h2>Movie Details</h2>
		<p>
			Title:
			<%=movieDetails.get("Title")%></p>
		<p>
			Year:
			<%=movieDetails.get("Year")%></p>
		<p>
			Genre:
			<%=movieDetails.get("Genre")%></p>
		<p>
			IMDb Rating:
			<%=movieDetails.get("imdbRating")%></p>
		<p>
			<img src="<%=movieDetails.get("Poster")%>" alt="Poster" />
		</p>
		<form action="/" method="post">
			<input type="hidden" name="title"
				value="<%=movieDetails.get("Title")%>"> <input
				type="hidden" name="year"
				value="<%=movieDetails.get("Year")%>"> <input
				type="hidden" name="genre"
				value="<%=movieDetails.get("Genre")%>"> <input
				type="hidden" name="imdbRating"
				value="<%=movieDetails.get("imdbRating")%>"> <input
				type="hidden" name="poster"
				value="<%=movieDetails.get("Poster")%>"> <input
				type="submit" value="Save to Database">
		</form>
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