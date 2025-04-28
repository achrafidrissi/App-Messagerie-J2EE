package com.appmessagerie.DAO;

import com.appmessagerie.Model.Message;
import com.appmessagerie.Model.Personne;
import com.appmessagerie.Util.HashUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOServices {

    // 1. Récupérer les messages publics (idPersonne = 1)
    public static List<Message> getPublicMessages() {
        List<Message> messages = new ArrayList<>();

        String sql = "SELECT * FROM Message WHERE idPersonne = 1";
        try (Connection con = DAOUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Message msg = new Message(
                        rs.getInt("idMessage"),
                        rs.getInt("idPersonne"),
                        rs.getString("sujet"),
                        rs.getString("contenu")
                );
                messages.add(msg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    // 2. Récupérer les sujets des messages publics
    public static List<String> getPublicSubjects() {
        List<String> sujets = new ArrayList<>();

        String sql = "SELECT sujet FROM Message WHERE idPersonne = 1";
        try (Connection con = DAOUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                sujets.add(rs.getString("sujet"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sujets;
    }

    // 3. Inscription d’un utilisateur
    public static boolean registerUser(String nom, String prenom, String motDePasse) {
        String sql = "INSERT INTO Personne (nom, prenom, motDePasse) VALUES (?, ?, ?)";
        try (Connection con = DAOUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String motDePasseHache = HashUtil.hashPassword(motDePasse);

            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, motDePasseHache);

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 4. Récupérer les messages personnels d’un utilisateur
    public static List<Message> getUserMessages(int idPersonne) {
        List<Message> messages = new ArrayList<>();

        String sql = "SELECT * FROM Message WHERE idPersonne = ?";
        try (Connection con = DAOUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, idPersonne);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    messages.add(new Message(
                            rs.getInt("idMessage"),
                            rs.getInt("idPersonne"),
                            rs.getString("sujet"),
                            rs.getString("contenu")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }

    // 5. Récupérer tous les utilisateurs
//    public static List<Personne> getAllPersonnes() {
//        List<Personne> personnes = new ArrayList<>();
//
//        String sql = "SELECT * FROM Personne";
//        try (Connection con = DAOUtil.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql);
//             ResultSet rs = ps.executeQuery()) {
//
//            while (rs.next()) {
//                personnes.add(new Personne(
//                        rs.getInt("idPersonne"),
//                        rs.getString("nom"),
//                        rs.getString("prenom"),
//                        rs.getString("motDePasse")
//                ));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return personnes;
//    }

    public static Personne authenticate(String nom, String motDePasseHache) {
        String sql = "SELECT * FROM Personne WHERE nom = ? AND motDePasse = ?";

        try (Connection con = DAOUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nom);
            ps.setString(2, motDePasseHache);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Personne(
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("motDePasse")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Aucun utilisateur trouvé
    }

    public static void insertMessage(int idPersonne, String sujet, String contenu) {
        String sql = "INSERT INTO Message (idPersonne, sujet, contenu) VALUES (?, ?, ?)";

        try (Connection con = DAOUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPersonne);
            ps.setString(2, sujet);
            ps.setString(3, contenu);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
