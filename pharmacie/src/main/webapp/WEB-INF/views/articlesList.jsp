<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des Articles</title>
</head>
<body>

	<h1 style="align-content: center;">Liste des Articles</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Designation</th>
			<th>Description</th>
			<th>Quantité</th>
		</tr>
		<c:forEach var="article" items="${articles}">
			<tr>
				<td>${article.designation}</td>
				<td>${article.description}</td>
				<td>${article.quantite}</td>
				<td><a href="/articleDetail/${article.id}">Plus
						d'informations</a></td>
				<td><a href="/articleUpdate/${article.id}">Update</a></td>
				<td><a href="/articleDelete/${article.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="/articleCreate">Create Article</a>
	<br>
	<a href="/welcome">Welcome</a>



</body>
</html>