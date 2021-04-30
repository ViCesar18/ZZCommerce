package com.uel.ZZCommerce.controller;

import com.uel.ZZCommerce.dao.ContatoDAO;
import com.uel.ZZCommerce.model.Contato;

import java.io.*;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contato contato = new Contato(request.getParameter("username"), request.getParameter("password"));

        ContatoDAO contatoDao = new ContatoDAO();

        HttpSession session = request.getSession();

        try {
            contato = contatoDao.checkLogin(contato);

            if (contato.getId() != 0) {
                session.setAttribute("loggedInUser", contato);
                session.setAttribute("username", contato.getUsername());
                session.removeAttribute("message2");
                session.removeAttribute("message1");
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }

            response.sendRedirect(request.getContextPath() + "/allProduto");
        } catch (Exception e) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, "Controller", e);
            session.setAttribute("error", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}