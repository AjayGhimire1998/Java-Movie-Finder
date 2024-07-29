<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:useBean id="triangle" class="com.ajayghimire.calculators.Triangle" />
<jsp:setProperty property="*" name="triangle" />
<head>
<meta charset="UTF-8">
<title>Triangle Calc</title>
</head>
<body>
	<h1>Right Triangle Calculator</h1>
	<form action="Triangle.jsp" method="post">
		Side A: &nbsp; <input type="text" name="sideA"
			value="<jsp:getProperty name="triangle" property="sideA"/>" /> <br>
		<br> Side B: &nbsp; <input type="text" name="sideB"
			value="<jsp:getProperty name="triangle" property="sideB"/>" /> <br>
		<br> Side C: &nbsp;
		<jsp:getProperty name="triangle" property="sideC" />
		<br> <br> <input type="submit" value="Calculate" />
	</form>
</body>
</html>