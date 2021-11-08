<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br>
<!-- Navbar -->
<jsp:include page="header.jsp"></jsp:include>
<!-- Navbar -->
<br />
<h1 style="text-align: center;">Informations Article</h1>
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

		<td><br /> <br /> <br /> <br /> Pour plus d'information Merci
			de consulter le dictionnaire medical : <a
			href="https://www.vidal.fr/medicaments.html" target="_blank">
				Dictionnaire VIDAL </a></td>
	</tr>
</table>
<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- Footer -->