package com.appmessagerie.Controller;

import com.appmessagerie.DAO.DAOServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/SujetsServlet")
public class SujetsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> sujets = DAOServices.getPublicSubjects();
        request.setAttribute("sujets", sujets);
        request.getRequestDispatcher("sujets.jsp").forward(request, response);
    }
}
