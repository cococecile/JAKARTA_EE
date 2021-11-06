<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Creation D'acticle</title>
<link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body style="background-color: #4BA74D;">

	<form:form action="articleCreate" method="POST"
		modelAttribute="articleDto">
		<form:hidden path="id" />
		<table>
			<tr>
				<td>Désignation</td>
				<td><form:input path="designation" />    </td>
			</tr>
			<tr>
				<td>Description</td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td>Quantité</td>
				<td><form:input path="quantité" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Submit" /> <a
					href="articleList">Cancel</a></td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form:form>


	<!--         <form method="post" @ModelAttribute=article action="articleCreate"> -->
	<!--         <fieldset> -->
	<!--                 <legend>Creation d'acticle</legend> -->
	<!--                 <p>Vous pouvez vous créer un nouvel article via ce formulaire.</p> -->

	<!--                 <label for="designation">Désignation article <span class="requis">*</span></label> -->
	<!--                 <input type="text" id="int" name="text" value="" size="200" maxlength="200" /> -->

	<!--                 <br /> -->

	<!--                 <label for="description">Description article <span class="requis">*</span></label> -->
	<!--                 <input type="text" id="int" name="text" value="" size="200" maxlength="200" /> -->

	<!--                 <br /> -->

	<!--                 <label for="quantite">Quantité article <span class="requis">*</span></label> -->
	<!--                 <input type="text" id="confirmation" name="confirmation" value="" size="200" maxlength="200" /> -->

	<!--                 <br /> -->


	<!--                 <br /> -->

	<!--                 <input type="submit" value="Valider" class="sansLabel" /> -->

	<!--                 <br /> -->

	<!--                 <a href="login" class="signup-image-link">Login</a>  -->
	<%--                 <a href="${pageContext.request.contextPath}/user/" class="signup-image-link">Logout</a> --%>
	<!--             </fieldset> -->
	<!--         </form> -->
	<section></section>

</body>
</html>