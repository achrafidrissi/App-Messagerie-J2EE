package com.appmessagerie.DAO;

import com.appmessagerie.Model.Personne;
import com.appmessagerie.Util.HashUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PersonneDAO {

    private Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/Messagerie";
        String user = "root";
        String password = ""; // ou ton mot de passe
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    public void insert(Personne personne) {
        try (Connection connection = getConnection()) {
            String motDePasseHache = HashUtil.hashPassword(personne.getMotDePasse());

            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO Personne (nom, prenom, motDePasse) VALUES (?, ?, ?)");
            ps.setString(1, personne.getNom());
            ps.setString(2, personne.getPrenom());
            ps.setString(3, motDePasseHache);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}