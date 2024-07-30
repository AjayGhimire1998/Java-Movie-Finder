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

.results {
	margin-top: 30px;
	width: 70%;
}

.empty-movie {
	text-align: center;
}

.results {
	margin-top: 30px;
	width: 70%;
}

.empty-movie {
	text-align: center;
}

.movie {
	width: 50%;
	border-bottom: 1px solid white;
	padding: 20px;
	display: flex;
	align-items: center;
	gap: 40px;
	clear: both;
	border-bottom: 3px solid white;
}

.movie:nth-child(odd) {
	float: left;
}

.movie:nth-child(even) {
	float: right;
}

.movie img {
	width: auto;
	height: 250px;
	/* Adjust the height to match the movie component height */
	border-radius: 10px;
}

.movie-details {
	display: flex;
	flex-direction: column;
}

.movie-details p {
	font-size: 20px;
	margin: 5px 0;
}

.movie-details>p>.title {
	font-size: 22px;
	margin: 5px 0;
}

.movie-details p label {
	font-size: 22px;
	font-weight: bold;
	color: #f53333;
}

.movie-details p span {
	font-size: 20px;
	color: #fff;
}

.movie-details>p>.title-span {
	font-size: 35px;
	color: #fff;
	font-weight: bold;
}

.movie-details>p>.plot {
	font-size: 12px;
	white-space: normal;
	color: #fff;
	font-style: italic;
}

.movie-details form {
	margin-top: 10px;
}

.movie-details input[type="submit"] {
	background: #f53333;
	color: white;
	font-size: 18px;
	padding: 10px 20px;
	border: none;
	border-radius: 10px;
	outline: none;
	cursor: pointer;
}

.movie-details input[type="submit"]:hover {
	background: #bf8415;
}

.favourite-submit {
	background: #1f48b8;
	color: white;
	font-size: 18px;
	padding: 10px 16px;
	border: none;
	border-radius: 15px;
	outline: none;
}

.favourite-submit:hover {
	background: #bf8415;
	cursor: pointer;
}
</style>
</head>
<body>
	<h1 class="welcome">A Movie Finder App</h1>
	<br />
	<input type="submit" value="⬅ ︎Go Back"
		class="favourite-submit" onClick="history.back();" />

	<br />
	<h1>Favourite Movies</h1>
	<br />

	<div class="results">
		<%
		List<Map<String, String>> movieList = (List<Map<String, String>>) request.getAttribute("fav");

		if (movieList != null && !movieList.isEmpty()) {
		  for (Map<String, String> movie : movieList) {
		%>
		<div class="movie">
			<img src="<%=movie.get("poster")%>" alt="Poster" />
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
				<form action="/favourites" method="post">
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
		<p class="empty-movie">No favourites saved.</p>
		<%
		}
		%>
	</div>
</body>
</html>