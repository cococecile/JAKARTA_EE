<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Liste des Utilisateurs</title>
<link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>
	<h1>Read Users</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>PreNom</th>
			<th>Email</th>
			<th>Adresse</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>

		<c:forEach var="utilisateur" items="${users}">
			<tr>
				<td>${user.id}</td>
				<td>${user.nom}</td>
				<td>${user.prenom}</td>
				<td>${user.email}</td>
				<td>${user.adresse}</td>
				<td><a href="/update-user/${user.id}">Update</a></td>
				<td><a href="/delete-user/${user.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="/create-user">Create User</a>

</body>
</html>