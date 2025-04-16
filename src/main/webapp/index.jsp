<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Accueil - Messagerie</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Messages Publics</h2>

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
        <p style="text-align:center;">Aucun message public pour le moment.</p>
    </c:otherwise>
</c:choose>

<a href="SujetsServlet">Voir uniquement les sujets</a>
<a href="connexion.jsp">Se connecter</a>
<a href="inscription.jsp">Créer un compte</a>

</body>
</html>
