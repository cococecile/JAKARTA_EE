<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Employee | Home</title>
<!-- Main css -->
<link rel="stylesheet" href="/css/style.css">
</head>
<body><br> <br> <br>
	<div>
		<h3 style="text-align: center;">Groupe 1 - Cécile / Justine / Karima / Mireille</h3>
	</div>
	<!-- Sign up form -->
	<section class="signup">
		<div class="container">
			<br>
			<div>
				<h2 style="text-align: center;">GESTION - PHARMA Articles</h2>
			</div>
			<div class="signup-image">
			<c:if test="${not empty nom}">
				<center><h1>Welcome, ${nom}</h1></center>
			</c:if>
				<br>
				<br>
				<div style="display: flex; justify-content: space-between;">
					<a href="${pageContext.request.contextPath}/user/home" class="signup-image-link">Home</a> 
<%-- 					<a href="${pageContext.request.contextPath}/user/updateUser/${user.id}" class="signup-image-link">Update Profile</a> --%>
					<a href="${pageContext.request.contextPath}/user/users" class="signup-image-link">View Employees</a>
					<a href="${pageContext.request.contextPath}/user/" class="signup-image-link">Logout</a>
				</div>
			</div>
			<br> <br> <br>
		</div>
	</section>
</body>
</html>