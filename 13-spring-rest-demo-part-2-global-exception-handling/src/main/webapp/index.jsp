<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Spring REST</title>
	</head>
	<body>
		<h2>Welcome to Spring REST.</h2>
		<br>
		<hr>
		<br>
		<a href="${pageContext.request.contextPath}/test/hello">(GET) Demo REST Endpoint</a>
		<br>
		<hr>
		<br>
		<a href="${pageContext.request.contextPath}/api/students">(GET) List of Students</a>
	</body>
</html>