<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Users | Sign in</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="/fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="/css/style.css">
</head>
<body style="background-color:#4BA74D;">
	<div>
		<h3 style="text-align: center;">Groupe 1 - C�cile / Justine / Karima / Mireille</h3>
	</div>
	
	<!-- Sing in  Form -->
	<section class="sign-in">
		<div class="container">
			<div class="signin-content">
				<div class="signin-image">
					    <img src="	https://img.myloview.fr/papiers-peints/user-icon-lock-securite-mot-de-passe-connexion-user-icon-in-glyph-vector-illustration-400-72163148.jpg"height="200px" width=200px"/>
				
					<figure>
						<img src="/images/signin-image.jpg" alt="sing up image">
					</figure>
					<div style="display: flex; justify-content: space-between;">
						<a href="create-user"
							class="signup-image-link">Create an account</a> <a
							href="welcome"
							class="signup-image-link">Go Home</a>
					</div>
					<spring:url value="/create-user" var="sign-in-URL" />
				</div>

				<div class="signin-form">
					<h3 class="form-title">User Sign-In Form</h3>
					<form:form modelAttribute="user-sign-in"
						action="/user/validateUser" method="POST"
						cssClass="register-form" id="login-form">
						<div class="form-group">
							<label for="email"><i class="zmdi zmdi-email"></i></label>
							<form:input type="email" path="email" name="email" id="email"
								placeholder="Email" required="required" />
							<form:errors path="email" cssStyle="color:red;" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="mot_de_passe"><i class="zmdi zmdi-lock"></i></label>
							<form:password path="mot_de_passe" name="pass" id="pass"
								placeholder="mot_de_passe" required="required" />
							<form:errors path="mot_de_passe" cssStyle="color:red;"
								cssClass="error" />
						</div>
						<div class="form-group">
							<input type="checkbox" name="remember-me" id="remember-me"
								class="agree-term" /> <label for="remember-me"
								class="label-agree-term"><span><span></span></span>Remember
								me</label>
						</div>
						<div class="form-group form-button">
							<input type="submit" name="signin" id="signin"
								class="form-submit" value="Log in" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</section>


	<!-- JS -->
		<%@include file="footer.jsp"%>
</body>
</html>