package com.appmessagerie.Controller;

import com.appmessagerie.DAO.DAOServices;
import com.appmessagerie.DAO.HibernateService;
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

//        boolean inscrit = DAOServices.registerUser(nom, prenom, motDePasse);
        int idInscrit = HibernateService.insert(nom, prenom, motDePasse);

        if (idInscrit > 0) {
            request.setAttribute("message", "✅ Inscription réussie (ID : " + idInscrit + ")");
            request.setAttribute("messageType", "success");
        } else {
            request.setAttribute("message", "❌ Échec de l'inscription. Veuillez réessayer.");
            request.setAttribute("messageType", "error");
        }

        request.getRequestDispatcher("inscription.jsp").forward(request, response);
    }
}
