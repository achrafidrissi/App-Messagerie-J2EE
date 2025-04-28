<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Sujets des messages</title>
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
            max-width: 600px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            background-color: #e9f0fc;
            margin: 10px 0;
            padding: 12px 16px;
            border-radius: 8px;
            border: 1px solid #cce0f5;
            color: #333;
            font-weight: 500;
        }

        .empty-message {
            text-align: center;
            font-style: italic;
            color: #666;
            margin-bottom: 20px;
        }

        .actions {
            text-align: center;
            margin-top: 20px;
        }

        .actions a {
            text-decoration: none;
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border-radius: 8px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .actions a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>📚 Sujets des messages publics</h2>

    <c:choose>
        <c:when test="${not empty sujets}">
            <ul>
                <c:forEach var="sujet" items="${sujets}">
                    <li>${sujet}</li>
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            <p class="empty-message">Aucun sujet trouvé.</p>
        </c:otherwise>
    </c:choose>

    <div class="actions">
        <a href="AccueilServlet">⬅ Retour à l’accueil</a>
    </div>
</div>

</body>
</html>
