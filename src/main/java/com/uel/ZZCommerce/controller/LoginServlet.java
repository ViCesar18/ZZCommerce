package com.uel.ZZCommerce.controller;
 
import com.uel.ZZCommerce.dao.ContatoDAO;
import com.uel.ZZCommerce.model.Contato;

import java.io.*;
import java.sql.SQLException;
 
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
         
        try {
            contato = contatoDao.checkLogin(contato);
            String destPage;
             
            if (contato.getId() != 0) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser", contato);
                session.setAttribute("username", contato.getUsername());
                session.removeAttribute("message2");
                session.removeAttribute("message1");
                destPage = "view/main_page.jsp";
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
                destPage = "index.jsp";
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
             
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}