package com.uel.ZZCommerce.controller;
 
import com.uel.ZZCommerce.dao.ContatoDAO;
import com.uel.ZZCommerce.model.Contato;

import java.io.*;
import java.sql.SQLException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
        name = "LoginServlet",
        urlPatterns = {
                "/login",
                "/logout"
        }
)
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        super();
    }
 
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch(request.getServletPath()){
            case "/login":{
                Contato contato = new Contato(request.getParameter("username"), request.getParameter("password"));

                ContatoDAO contatoDao = new ContatoDAO();

                try {
                    contato = contatoDao.checkLogin(contato);

                    if (contato.getId() != 0) {
                        if(request.getParameter("Test") == null) {
                            HttpSession session = request.getSession();
                            session.setAttribute("loggedInUser", contato);
                            session.setAttribute("username", contato.getUsername());
                        }
                        request.setAttribute("messagemSucesso", "Usuário logado com sucesso!");
                    } else {
                        request.setAttribute("messagemFalha", "Usuário ou Senha inválidos!");
                    }

                    response.sendRedirect(request.getContextPath() + "/allProduto");
                } catch (SQLException | ClassNotFoundException ex) {
                    throw new ServletException(ex);
                }
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        switch (request.getServletPath()){
            case "/logout":{
                if(session != null) {
                    session.invalidate();
                }

                response.sendRedirect(request.getContextPath() + "/");
            }
        }
    }
}