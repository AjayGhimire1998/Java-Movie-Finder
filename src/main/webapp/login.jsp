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
		<input type="text" name="name" placeholder="Give name" /> &nbsp; <br />
		<input type="password" name="password" placeholder="Give password" />
	</form>
	<button>Submit</button>
	<%
	for (int i = 0; i < 10; i++) {
	%>
	<%
	int val = i;
	%>
	<h2>Hello ${val}</h2>
	<%
	}
	%>

	<%-- <c:forEach var="i" begin="1" end="10">
		<h1>
			<c:out value="${i}" />
		</h1>
	</c:forEach> --%>

</body>
</html>