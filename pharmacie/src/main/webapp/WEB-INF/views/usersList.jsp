<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br>

<!-- Navbar -->
<jsp:include page="header.jsp"></jsp:include>
<!-- Navbar -->
<br>
<h1 style="text-align: center;">Liste des Users</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Nom</th>
		<th>PreNom</th>
		<th>Info User</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="user" items="${users}">
		<tr>
			<td>${user.nom}</td>
			<td>${user.prenom}</td>
			<td><a href="/user/${user.id}">Infos ....</a></td>
			<td><a href="/update-user/${user.id}">Update</a></td>
			<td><a href="/delete-user/${user.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- Footer -->
