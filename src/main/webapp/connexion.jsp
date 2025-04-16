<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Connexion</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Connexion</h2>

<form action="ConnexionServlet" method="post">
    <input type="text" name="nom" placeholder="Nom" required>
    <input type="password" name="motDePasse" placeholder="Mot de passe" required>
    <input type="submit" value="Se connecter">
</form>

<c:if test="${not empty erreur}">
    <p style="color: red; text-align: center;">${erreur}</p>
</c:if>

<a href="AccueilServlet">Retour à l’accueil</a>

</body>
</html>
