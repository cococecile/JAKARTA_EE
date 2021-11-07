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
<c:url var="actionUrl" value="create-user" />


<form:form method="POST" action="${actionUrl}"  >

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
            <td><form:input  autocomplete="username" path="adresse"/></td>
        </tr>
		 <tr>
            <td>Password: </td>
            <td><form:input   autocomplete="current-password"   path="mot_de_passe"/></td>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="Create"/> <a
					href="read-user">Cancel</a></td>
        </tr>
    </table>
</form:form>
