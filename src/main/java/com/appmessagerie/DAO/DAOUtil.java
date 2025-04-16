package com.appmessagerie.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/Messagerie";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Ton mot de passe MySQL

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Erreur chargement du driver JDBC", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
