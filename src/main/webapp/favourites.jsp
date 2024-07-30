<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favourite Movies</title>
<style>
body {
	font-family: Roboto, sans-serif;
	display: flex;
	flex-direction: column;
	align-items: center;
	background: #1b1c1b;
	color: white;
}

.welcome {
	font-size: 50px;
	margin-top: 20px;
}
</style>
</head>
<body>
	<h1 class="welcome">A Movie Finder App</h1>
	<br />
	<h1>Favourite Movies</h1>
	<div class="results">
		<%
		List<Map<String, String>> movieList = (List<Map<String, String>>) request.getAttribute("fav");

		if (movieList != null && !movieList.isEmpty()) {
		  for (Map<String, String> movie : movieList) {
		%>
		<div class="movie">
			<img src="<%=movie.get("Poster")%>" alt="Poster" />
			<div class="movie-details">
				<p>
					<label class="title">Title:</label> <span
						class="title-span"><%=movie.get("title")%></span>
				</p>
				<p>
					<span class="plot"><%=movie.get("plot")%></span>
				</p>
				<p>
					<label>Year:</label> <span><%=movie.get("year")%></span>
				</p>
				<p>
					<label>Genre:</label> <span><%=movie.get("genres")%></span>
				</p>
				<p>
					<label>IMDb Rating:</label> <span><%=movie.get("rating")%></span>
				</p>
				<form action="/" method="post">
					<input type="hidden" name="title"
						value="<%=movie.get("title")%>"> <input
						type="hidden" name="year"
						value="<%=movie.get("year")%>"> <input
						type="hidden" name="genre"
						value="<%=movie.get("genres")%>"> <input
						type="hidden" name="rating"
						value="<%=movie.get("rating")%>"> <input
						type="hidden" name="poster"
						value="<%=movie.get("poster")%>"> <input
						type="submit" value="Remove from Favourites">
				</form>
			</div>
		</div>
		<%
		}
		} else {
		%>
		<p class="empty-movie">No movies found.</p>
		<%
		}
		%>
	</div>
</body>
</html>