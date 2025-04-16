<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mon Compte</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Bienvenue ${prenom}</h2>
<h3>Vos messages privés :</h3>

<c:choose>
    <c:when test="${not empty messages}">
        <table>
            <tr>
                <th>Sujet</th>
                <th>Contenu</th>
            </tr>
            <c:forEach var="msg" items="${messages}">
                <tr>
                    <td>${msg.sujet}</td>
                    <td>${msg.contenu}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <p style="text-align:center;">Aucun message privé pour l’instant.</p>
    </c:otherwise>
</c:choose>
<h3>Écrire un nouveau message :</h3>

<form action="CreationMessageServlet" method="post" style="width: 400px; margin: 0 auto;">
    <input type="text" name="sujet" placeholder="Sujet" required>
    <br><br>
    <textarea name="contenu" placeholder="Contenu du message" rows="5" style="width: 100%;" required></textarea>
    <br><br>
    <input type="submit" value="Envoyer le message">
</form>

<form action="DeconnexionServlet" method="post" style="text-align:center;">
    <input type="submit" value="Déconnexion">
</form>

</body>
</html>
