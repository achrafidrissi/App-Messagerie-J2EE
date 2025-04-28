<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Mon Compte</title>
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
            width: 90%;
            max-width: 900px;
        }

        h2, h3 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
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

        .empty-message {
            text-align: center;
            font-style: italic;
            color: #666;
            margin-bottom: 30px;
        }

        form {
            margin-bottom: 30px;
        }

        input[type="text"], textarea {
            width: 100%;
            padding: 12px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }

        input[type="submit"] {
            margin-top: 10px;
            padding: 12px 20px;
            background-color: #28a745;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }

        .logout-btn {
            background-color: #dc3545;
        }

        .logout-btn:hover {
            background-color: #c82333;
        }

    </style>
</head>
<body>

<div class="container">
    <h2>👤 Bienvenue, ${prenom}</h2>

    <h3>📥 Vos messages privés :</h3>

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
            <p class="empty-message">Aucun message privé pour l’instant.</p>
        </c:otherwise>
    </c:choose>

    <h3>✍️ Écrire un nouveau message :</h3>

    <form action="CreationMessageServlet" method="post">
        <input type="text" name="sujet" placeholder="Sujet" required>
        <br><br>
        <textarea name="contenu" placeholder="Contenu du message" rows="5" required></textarea>
        <br>
        <input type="submit" value="Envoyer le message">
    </form>

    <form action="DeconnexionServlet" method="post" style="text-align:center;">
        <input type="submit" value="Déconnexion" class="logout-btn">
    </form>
</div>

</body>
</html>
