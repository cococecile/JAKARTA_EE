<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html:html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge,chrome=1">
<title>Connexion</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="css/mdb.min.css" rel="stylesheet">
<!-- Your custom styles (optional) -->
<link href="css/style.min.css" rel="stylesheet">
<style type="text/css">
html, body, header, .carousel {
	height: 60vh;
}

@media ( max-width : 740px) {
	html, body, header, .carousel {
		height: 100vh;
	}
}

@media ( min-width : 800px) and (max-width: 850px) {
	html, body, header, .carousel {
		height: 100vh;
	}
}
</style>
</head>
<body>

	<!-- Navbar -->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
		<div class="container">
			<!-- Brand -->
			<a class="navbar-brand waves-effect" href="lister.do"> <strong
				class="blue-text"></strong>
			</a>

			<!-- Collapse -->
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<!-- Links -->
			<div class="collapse navbar-collapse" id="navbarSupportedContent">

				<!-- Left -->
				<ul class="navbar-nav mr-auto">
					
				</ul>

				<!-- Right -->
				<ul class="navbar-nav nav-flex-icons">

				</ul>
			</div>

		</div>
	</nav>
	<!-- Navbar -->

	<!--Carousel Wrapper-->
	<jsp:include page="header.jsp"></jsp:include>
	<!--Carousel Wrapper-->

	<!--Main layout-->
	<main class="mt-5 pt-4">
		<div class="container wow fadeIn">

			<!-- Heading -->
			<h2 class="my-5 h2 text-center">Se Connecter</h2>

			<!--Grid row-->
			<div class="row" style="width: 1650px; margin: 0 auto;">

				<!--Grid column-->
				<div class="col-md-8 mb-4">

					<!--Card-->
					<div class="card">

						<!--Card content-->
						<html:form method="POST" action="/connecter.do" focus="num_puce" styleClass="card-body">
							<%-- permet d'afficher les erreurs "globales" --%>
							<html:errors header="errors.global.header" property="connexionKO" />

							<!--Grid row-->
							<div class="row"></div>
							<!--Grid row-->

							<!--login-->
							<div class="md-form mb-5">
								<html:text property="login" styleClass="form-control" />
								<html:errors property="email" header="errors.field.header"
									footer="errors.field.footer" />
								<label for="login" class="">Email</label>
							</div>
							<!--password-->
							<div class="md-form mb-5">
								<html:password property="password" styleClass="form-control" />
								<html:errors property="password" header="errors.field.header"
									footer="errors.field.footer" />
								<label for="password" class="">Mot de passe</label>
							</div>

							<hr class="mb-4">
							<html:submit value="SE CONNECTER" styleClass="btn btn-primary btn-lg btn-block" />
							<html:link href="accueil.do" >
								<html:button property="articlesList" value="RETOUR ACCUEIL" styleClass="btn btn-primary btn-lg btn-block"></html:button>
							</html:link>
						</html:form>
						<!--/ .Card content-->
						<br>
					</div>
					<!--/.Card-->

				</div>
				<!--Grid column-->

			</div>
			<!--Grid row-->

		</div>
	</main>
	<!--Main layout-->

	<!--Footer-->
	<jsp:include page="footer.jsp"></jsp:include>
	<!--/.Footer-->

	<!-- SCRIPTS -->
	<!-- JQuery -->
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="js/mdb.min.js"></script>
	<!-- Initializations -->
	<script type="text/javascript">
		// Animations initialization
		new WOW().init();
	</script>

</body>
</html:html>