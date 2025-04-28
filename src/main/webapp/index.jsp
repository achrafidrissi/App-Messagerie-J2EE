<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Accueil - Messagerie</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 40px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .container {
            background: white;
            padding: 30px 40px;
            border-radius: 15px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 800px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 25px;
        }

        th, td {
            padding: 12px 16px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .actions {
            display: flex;
            justify-content: center;
            gap: 15px;
        }

        .actions a {
            display: inline-block;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 8px;
            background-color: #007bff;
            color: white;
            transition: background-color 0.3s ease;
        }

        .actions a:hover {
            background-color: #0056b3;
        }

        .empty-message {
            text-align: center;
            font-style: italic;
            color: #666;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>💬 Messages Publics</h2>

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
            <p class="empty-message">Aucun message public pour le moment.</p>
        </c:otherwise>
    </c:choose>

    <div class="actions">
        <a href="SujetsServlet">📚 Voir les sujets</a>
        <a href="connexion.jsp">🔐 Se connecter</a>
        <a href="inscription.jsp">📝 Créer un compte</a>
    </div>
</div>

</body>
</html>
