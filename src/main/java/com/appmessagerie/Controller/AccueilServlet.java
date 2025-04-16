package com.appmessagerie.Controller;

import com.appmessagerie.DAO.DAOServices;
import com.appmessagerie.Model.Message;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupération des messages publics
        List<Message> messages = DAOServices.getPublicMessages();

        // Envoi à la vue
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
