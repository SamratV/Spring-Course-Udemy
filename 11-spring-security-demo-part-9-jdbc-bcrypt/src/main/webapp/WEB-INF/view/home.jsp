<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Spring Security Demo :: Home</title>
	</head>
	<body>
		<h1>Welcome to Spring Security!!!</h1>
		
		<hr>
		<br>
		
		<p>
			User: <security:authentication property="principal.username"/>
			<br><br>
			Role(s): <security:authentication property="principal.authorities"/>
		</p>
		
		<br>
		<hr>
		<br>
		
		<security:authorize access="hasRole('MANAGER')">
			<p>
				Only for managers: <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			</p>
			
			<br>
			<hr>
			<br>
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
			<p>
				Only for admins: <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			</p>
			
			<br>
			<hr>
			<br>
		</security:authorize>
		
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" />
		</form:form>
	</body>
</html>