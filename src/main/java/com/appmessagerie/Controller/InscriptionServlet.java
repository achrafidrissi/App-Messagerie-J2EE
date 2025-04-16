package com.appmessagerie.Controller;

import com.appmessagerie.DAO.DAOServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String motDePasse = request.getParameter("motDePasse");

        boolean inscrit = DAOServices.registerUser(nom, prenom, motDePasse);

        if (inscrit) {
            request.setAttribute("message", "Inscription réussie !");
        } else {
            request.setAttribute("message", "Erreur lors de l'inscription.");
        }

        request.getRequestDispatcher("inscription.jsp").forward(request, response);
    }
}
