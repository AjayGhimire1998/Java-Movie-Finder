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
	width: 100%;
	display: flex;
	flex-direction: column;
}

.movie {
	border-bottom: 1px solid white;
	padding: 10px;
	display: flex;
	align-items: center;
	gap: 20px;
}

.movie img {
	width: 100px;
}

.movie-details {
	display: flex;
	flex-direction: column;
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
		if (movieList != null) {
		  for (Map<String, String> movie : movieList) {
		%>
		<div class="movie">
			<img src="<%=movie.get("Poster")%>" alt="Poster" />
			<div class="movie-details">
				<p>
					Title:
					<%=movie.get("Title")%></p>
				<p>
					Year:
					<%=movie.get("Year")%></p>
				<p>
					Genre:
					<%=movie.get("Genre")%></p>
				<p>
					IMDb Rating:
					<%=movie.get("imdbRating")%></p>
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
						type="submit" value="Save to Database">
				</form>
			</div>
		</div>
		<%
		}
		} else {
		%>
		<%
		if (request.getParameter("title") != "") {
		%>
		<p>No movies found.</p>
		<%
		}
		%>
		<%
		}
		%>
	</div>
</body>
</html>
