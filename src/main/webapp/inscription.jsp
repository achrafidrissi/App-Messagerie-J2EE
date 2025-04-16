<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inscription</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Inscription</h2>

<form action="InscriptionServlet" method="post">
    <input type="text" name="nom" placeholder="Nom" required>
    <input type="text" name="prenom" placeholder="Prénom" required>
    <input type="password" name="motDePasse" placeholder="Mot de passe" required>
    <input type="submit" value="S'inscrire">
</form>

<c:if test="${not empty message}">
    <p style="color: green; text-align: center;">${message}</p>
</c:if>

<a href="AccueilServlet">Retour à l’accueil</a>

</body>
</html>
