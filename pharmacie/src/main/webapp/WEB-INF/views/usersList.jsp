<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Read Users</h1>
    <table border="2" width="70%" cellpadding="2">
        <tr>
            <th>Nom</th>
            <th>Email</th>
            <th>Adresse</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="utilisateur" items="${utilisateur}">
            <tr>
                <td>${utilisateur.id}</td>
                <td>${utilisateur.nom}</td>
                <td>${utilisateur.email}</td>
                <td>${utilisateur.adresse}</td>
                <td>${utilisateur.prenom}</td>
                <td><a href="/update-user/${utilisateur.id}">Update</a></td>
                <td><a href="/delete-user/${utilisateur.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
<br/>
<a href="/create-user">Create User</a>