<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br>
<!-- Navbar -->
<jsp:include page="header.jsp"></jsp:include>
<!-- Navbar -->
<br>

<form:form action="create-user" method="POST" modelAttribute="user">
	<h1 style="text-align: center;">Creation d'un compte utilisateur</h1>
	<p>Vous pouvez vous créer un nouvel utilisateur via ce formulaire.</p>
	<form:hidden path="id" />
	<table>
		<tr>
			<td>Name:</td>
			<td><form:input path="nom" /></td>
		</tr>
		<tr>
			<td>Prenom:</td>
			<td><form:input path="prenom" /></td>
		</tr>

		<tr>
			<td>Email:</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>Adresse:</td>
			<td><form:input autocomplete="username" path="adresse" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><form:password autocomplete="current-password"
					path="mot_de_passe" /></td>
		</tr>

		<tr>
			<td></td>
			<td><input type="submit" value="Create" /> <a href="read-user">Cancel</a></td>
		</tr>
	</table>

</form:form>
<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- Footer -->
