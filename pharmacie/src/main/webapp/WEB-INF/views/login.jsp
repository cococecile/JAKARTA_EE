<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<br>
<!-- Navbar -->
<jsp:include page="header1.jsp"></jsp:include>
<!-- Navbar -->
<div class="container">
	<div>
		<h2 style="text-align: center;">GESTION - PHARMACIE Articles</h2>
	</div>
</div>
<!-- Heading -->
<h2 class="my-5 h2 text-center">Se Connecter</h2>

<!--Card-->
<div class="card">
	<div>
		<!--Card content-->
		<form:form method="POST" action="/login" modelAttribute="loginForm">

			<!--Grid row-->
			<div class="row"></div>
			<!--Grid row-->

			<!--login-->
			<div class="md-form mb-5">
				<label for="login" class="">Email</label>
				<form:input path="email" />
			</div>
			<!--password-->
			<div class="md-form mb-5">
				<label for="password" class="">Mot de passe</label>
				<form:password path="password" />
			</div>

			<hr class="mb-4">
			<input value="SE CONNECTER" type="submit"
				styleClass="btn btn-primary btn-lg btn-block" />
		</form:form>
		<!--/ .Card content-->
	</div>
</div>
<!--/.Card-->

<!--Footer-->
<jsp:include page="footer.jsp"></jsp:include>
<!--/.Footer-->
