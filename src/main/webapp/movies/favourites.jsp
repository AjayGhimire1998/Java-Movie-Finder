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
	<p>${fav }</p>
</body>
</html>