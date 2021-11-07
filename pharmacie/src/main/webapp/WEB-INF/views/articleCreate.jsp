<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body style="background-color: #4BA74D;">

	<form:form action="articleCreate" method="POST"
		modelAttribute="article">

		<fieldset>
			<legend>Creation d'acticle</legend>
			-->
			<p>Vous pouvez vous créer un nouvel article via ce formulaire.</p>
			-->
			<form:hidden path="id" />
			<table>
				<tr>
					<td>Désignation :</td>
					<td><form:input path="designation" /></td>
				</tr>
				<tr>
					<td>Description :</td>
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<td>Quantité :</td>
					<td><form:input path="quantite" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Submit" /></td>
					<td><a href="articlesList">Cancel</a></td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</fieldset>
	</form:form>

	<section></section>


</body>
</html>