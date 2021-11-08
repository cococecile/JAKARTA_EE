<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br>
<!-- Navbar -->
<jsp:include page="header.jsp"></jsp:include>
<!-- Navbar -->
<br />
<form:form action="/articleUpdate" method="POST"
	modelAttribute="article">

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
			<td><a href="${pageContext.request.contextPath}/articlesList">Cancel</a></td>

			<td>&nbsp;</td>
		</tr>
	</table>
</form:form>
<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- Footer -->