<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br>
<!-- Navbar -->
<jsp:include page="header.jsp"></jsp:include>
<!-- Navbar -->
<br>
<h1>Update User</h1>
<form:form method="post" action="/create-user" modelAttribute="user">
	<table>
		<tr>
			<td>Name:</td>
			<td><form:input path="nom" /></td>
		</tr>
		<tr>
			<td>Name:</td>
			<td><form:input path="prenom" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>Mot de passe:</td>
			<td><form:input type="password" path="mot_de_passe" /></td>
		</tr>
		<tr>
			<td>adresse:</td>
			<td><form:input path="adresse" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Update" /></td>
		</tr>
	</table>
</form:form>
<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- Footer -->