package com.appmessagerie.Controller;

import com.appmessagerie.DAO.DAOServices;
import com.appmessagerie.Model.Personne;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/CreationMessageServlet")
public class CreationMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Personne user = (Personne) session.getAttribute("utilisateur");

        if (user != null) {
            String sujet = request.getParameter("sujet");
            String contenu = request.getParameter("contenu");

            DAOServices.insertMessage(user.getIdPersonne(), sujet, contenu);

            // Redirection vers CompteServlet pour afficher les messages mis à jour
            response.sendRedirect("CompteServlet");
        } else {
            response.sendRedirect("connexion.jsp");
        }
    }
}
