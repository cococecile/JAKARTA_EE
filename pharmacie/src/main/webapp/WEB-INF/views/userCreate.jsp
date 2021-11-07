<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Creation User</title>

</head>
<body style="background-color: #4BA78D;">

<form:form action="create-user" method="POST"
		modelAttribute="user" >
<fieldset>
			                <legend>Creation d'utilisateur</legend> -->
			               <p>Vous pouvez vous créer un nouvel utilisateur via ce formulaire.</p> -->
<form:hidden path="id" />
    <table>
        <tr>
            <td>Name: </td>
            <td><form:input path="nom"/></td>
        </tr>
		 <tr>
            <td>Prenom: </td>
            <td><form:input path="prenom"/></td>
        </tr>
		
        <tr>
            <td>Email: </td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Adresse: </td>
            <td><form:input   path="adresse"/></td>
        </tr>
		 <tr>
            <td>Password: </td>
            <td><form:input      path="mot_de_passe"/></td>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="Submit"/> <a
					href="read-user">Cancel</a></td>
        </tr>
    </table>
    </fieldset>
</form:form>
</body>
</html>
