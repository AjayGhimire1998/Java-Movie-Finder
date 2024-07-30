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


</body>
</html>