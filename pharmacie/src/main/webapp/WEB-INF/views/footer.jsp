<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #4BA74D;">

	<br>
	<div style="display: flex; justify-content: space-between;">
		<a href="login" class="signup-image-link">Login</a> <a
			href="${pageContext.request.contextPath}/user/articlesList"
			class="signup-image-link">View Articles</a> <a
			href="${pageContext.request.contextPath}/user/"
			class="signup-image-link">Logout</a>
	</div>
	
</body>
</html>