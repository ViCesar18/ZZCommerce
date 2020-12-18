package com.uel.ZZCommerce.controller;
 
import com.uel.ZZCommerce.dao.ContatoDAO;
import com.uel.ZZCommerce.model.Contato;

import java.io.*;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public RegisterServlet() {
        super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contato contato = new Contato(
                request.getParameter("username"),
                request.getParameter("senha"),
                request.getParameter("nome"),
                request.getParameter("apelido"),
                request.getParameter("empresa"),
                request.getParameter("endereco"),
                request.getParameter("bairro"),
                request.getParameter("cidade"),
                request.getParameter("telefone1"),
                request.getParameter("telefone2"),
                request.getParameter("observacao")
        );
         
        ContatoDAO contatoDao = new ContatoDAO();
        if(contatoDao.register(contato)) {
        	String destPage = "index.jsp";
            
            String message = "Registered successfully, now login";
            request.setAttribute("message2", message);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
            
            try {
            	Thread.sleep (3000); 
            }
            catch (InterruptedException e) {
            	throw new ServletException(e);
            }
         
        }
        else {
        	String destPage = "register.jsp";
        	
        	String message = "An error has happened, please try again";
            request.setAttribute("message2", message);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
        }
    }
}