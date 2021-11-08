<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<br>
<!-- Navbar -->
<jsp:include page="header.jsp"></jsp:include>
<!-- Navbar -->
<br>

<section>
	<br />
	<h1 style="text-align: center;">Informations User</h1>
	<table>

		<tr>
			<td>Nom :</td>
			<td>${user.nom}</td>
		</tr>
		<tr>
			<td>Prenom :</td>
			<td>${user.prenom}</td>
		</tr>
		<tr>
			<td>Email :</td>
			<td>${user.email}</td>
		</tr>
		<tr>
			<td>Adresse :</td>
			<td>${user.adresse}</td>
		</tr>


	</table>
</section>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- Footer -->
