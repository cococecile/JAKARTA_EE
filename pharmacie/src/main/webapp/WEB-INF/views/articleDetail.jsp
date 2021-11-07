<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Utilisateur</title>
</head>
<body>
	<h1>Informations Article</h1>
	<table>

		<tr>
			<td>Designation :</td>
			<td>${article.designation}</td>
		</tr>
		<tr>
			<td>Description :</td>
			<td>${article.description}</td>
		</tr>
		<tr>
			<td>Quantité :</td>
			<td>${article.quantite}</td>
		</tr>

		<tr>

			<td><br /> <br /> <br /> <br /> Pour plus d'information
				Merci de consulter le dictionnaire medical : <a
				href="https://www.vidal.fr/medicaments.html" target="_blank">
					Dictionnaire VIDAL </a></td>
		</tr>
	</table>
	<br />
	<br />
	<br />
	<br />
	<br />
	<a href="/articlesList">Retour liste des Articles</a>
</body>
</html>