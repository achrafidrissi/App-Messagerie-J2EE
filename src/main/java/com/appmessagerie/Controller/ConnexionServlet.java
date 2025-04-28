package com.appmessagerie.Controller;

import com.appmessagerie.DAO.DAOServices;
import com.appmessagerie.DAO.HibernateService;
import com.appmessagerie.Model.Message;
import com.appmessagerie.Model.Personne;
import com.appmessagerie.Util.HashUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String motDePasse = request.getParameter("motDePasse");

        String motDePasseHache = HashUtil.hashPassword(motDePasse);

        Personne user = HibernateService.authenticate(nom, motDePasseHache);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("utilisateur", user);

            List<Message> messages = HibernateService.getUserMessages(user.getIdPersonne());
            request.setAttribute("messages", messages);

            response.sendRedirect("CompteServlet");

        } else {
            request.setAttribute("erreur", "❌ Nom ou mot de passe incorrect.");
            request.getRequestDispatcher("connexion.jsp").forward(request, response);
        }
    }
}