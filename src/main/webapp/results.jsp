<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>Movie Details</h1>
   <%
        Map<String, String> movieDetails = (Map<String, String>) request.getAttribute("movieDetails");
        if (movieDetails != null) {
    %>
        <p>Title: <%= movieDetails.get("Title") %></p>
        <p>Year: <%= movieDetails.get("Year") %></p>
        <p>Genre: <%= movieDetails.get("Genre") %></p>
        <p>IMDb Rating: <%= movieDetails.get("imdbRating") %></p>
        <form action="movies" method="post">
            <input type="hidden" name="title" value="<%= movieDetails.get("Title") %>">
            <input type="hidden" name="year" value="<%= movieDetails.get("Year") %>">
            <input type="hidden" name="genre" value="<%= movieDetails.get("Genre") %>">
            <input type="hidden" name="imdbRating" value="<%= movieDetails.get("imdbRating") %>">
            <input type="submit" value="Save to Database">
        </form>
    <% } else { %>
        <p>No movie details found.</p>
    <% } %> 
</body>
</html>