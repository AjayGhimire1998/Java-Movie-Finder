<%@page import="java.util.List"%>
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
}

.welcome {
	font-size: 50px;
	margin-top: 20px;
}

.search {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	gap: 25px;
	margin: 30px;
	width: 100%;
}

.search>.search-input {
	width: 50%;
	padding: 15px;
	font-size: 30px;
	text-align: center;
	border: 1px solid white;
	border-radius: 5px;
	background: #2c2c2c;
	color: white;
}

.search>.search-submit {
	background: #f53333;
	color: white;
	font-size: 25px;
	padding: 15px 30px;
	border: none;
	border-radius: 25px;
	outline: none;
}

.search>.search-submit:hover {
	background: #43cc21;
	cursor: pointer;
}

.results {
	margin-top: 20px;
	width: 70%;
}

.movie {
	border-bottom: 1px solid white;
	padding: 20px;
	display: flex;
	align-items: center;
	gap: 40px;
	clear: both;
	transition: box-shadow 0.3s ease-in-out;
}

.movie:nth-child(odd) {
	float: left;
}

.movie:nth-child(even) {
	float: right;
}

.movie img {
	width: 100px;
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
	width: 200px;
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
	background: #43cc21;
}
</style>
</head>
<body>

	<h1 class="welcome">A Movie Finder App</h1>
	<br />
	<form action="/movies" method="get" class="search">
		<input type="text" placeholder="Type name to search.."
			class="search-input" id="title" name="title"
			value="${param.title}" /> <input type="submit"
			value="Search" class="search-submit" />
	</form>
	<div class="results">
		<%
		List<Map<String, String>> movieList = (List<Map<String, String>>) request.getAttribute("movieList");
		String searchTitle = request.getParameter("title");
		if (searchTitle != null && !searchTitle.isEmpty()) {
		  if (movieList != null && !movieList.isEmpty()) {
		    for (Map<String, String> movie : movieList) {
		%>
		<div class="movie">
			<img src="<%=movie.get("Poster")%>" alt="Poster" />
			<div class="movie-details">
				<p>
					<label class="title">Title:</label> <span
						class="title-span"><%=movie.get("Title")%></span>
				</p>
				<p>
					<span class="plot"><%=movie.get("Plot")%></span>
				</p>
				<p>
					<label>Year:</label> <span><%=movie.get("Year")%></span>
				</p>
				<p>
					<label>Genre:</label> <span><%=movie.get("Genre")%></span>
				</p>
				<p>
					<label>IMDb Rating:</label> <span><%=movie.get("imdbRating")%></span>
				</p>
				<form action="/" method="post">
					<input type="hidden" name="title"
						value="<%=movie.get("Title")%>"> <input
						type="hidden" name="year"
						value="<%=movie.get("Year")%>"> <input
						type="hidden" name="genre"
						value="<%=movie.get("Genre")%>"> <input
						type="hidden" name="imdbRating"
						value="<%=movie.get("imdbRating")%>"> <input
						type="hidden" name="poster"
						value="<%=movie.get("Poster")%>"> <input
						type="submit" value="Save to Favourites">
				</form>
			</div>
		</div>
		<%
		}
		} else {
		%>
		<p>No movies found.</p>
		<%
		}
		}
		%>
	</div>
</body>
</html>
