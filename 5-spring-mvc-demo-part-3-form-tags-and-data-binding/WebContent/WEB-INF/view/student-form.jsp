<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student Registration Form</title>
	</head>
	<body>
		<form:form action="processForm" modelAttribute="student">
			First name: <form:input path="firstName" required="true"/>
			<br><br>
			Last name: <form:input path="lastName" required="true"/>
			<br><br>
			Country:
			<form:select path="country" required="true">
				<form:option value="" disabled="true" selected="true">--- SELECT ---</form:option>
				
				<form:options items="${student.countryOptions}"/>
				<%--
					<form:option value="Brazil">Brazil</form:option>
					<form:option value="France">France</form:option>
					<form:option value="Germany">Germany</form:option>
					<form:option value="India">India</form:option>
				--%>
				
			</form:select>
			<br><br>
			Java <form:radiobutton path="favoriteLanguage" value="Java"/>
			C# <form:radiobutton path="favoriteLanguage" value="C#"/>
			PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
			Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
			<br><br>
			Operating Systems:
			Linux <form:checkbox path="operatingSystems" value="Linux"/>
			Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
			MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
			<br><br>
			<input type="submit" value="Submit">
		</form:form>
	</body>
</html>