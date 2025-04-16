package com.appmessagerie.Controller;


import com.appmessagerie.DAO.DAOServices;
import com.appmessagerie.Model.Message;
import com.appmessagerie.Model.Personne;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/CompteServlet")
public class CompteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("utilisateur") != null) {
            Personne user = (Personne) session.getAttribute("utilisateur");
            List<Message> messages = DAOServices.getUserMessages(user.getIdPersonne());

            request.setAttribute("messages", messages);
            request.setAttribute("prenom", user.getPrenom());
            request.getRequestDispatcher("compte.jsp").forward(request, response);
        } else {
            // Pas connecté, redirection vers accueil
            response.sendRedirect("AccueilServlet");
        }
    }
}
