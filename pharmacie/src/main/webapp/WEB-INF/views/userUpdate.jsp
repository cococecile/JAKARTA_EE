<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Update User</h1>
<form:form method="POST" action="/update-user" modelAttribute="user">
    <table>
        <tr>
            <td>nom: </td>
            <td><form:input path="nom"/></td>
        </tr>
         <tr>
            <td>prenom : </td>
            <td><form:input path="prenom"/></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><form:input path="email"/></td>
        </tr>
         <tr>
            <td>Mot de passe: </td>
            <td><form:input  type="password" path="mot_de_passe"/></td>
        </tr>
        <tr>
            <td>adresse: </td>
            <td><form:input path="adresse"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>