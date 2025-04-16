<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sujets des messages</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Sujets des messages publics</h2>

<c:choose>
    <c:when test="${not empty sujets}">
        <ul>
            <c:forEach var="sujet" items="${sujets}">
                <li>${sujet}</li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <p style="text-align:center;">Aucun sujet trouvé.</p>
    </c:otherwise>
</c:choose>

<a href="AccueilServlet">Retour à l’accueil</a>

</body>
</html>
