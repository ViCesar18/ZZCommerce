package com.uel.ZZCommerce.controller;
 
import com.uel.ZZCommerce.dao.UserDAO;
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
 
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
         
        UserDAO userDao = new UserDAO();
        if(userDao.register(contato)) {
        	String destPage = "index.jsp";
            
            String message = "Cadastro executado com sucesso!";
            request.setAttribute("mensagemSucesso", message);
            
            if(request.getParameter("Test") == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
                dispatcher.forward(request, response);
            }
        }
        else {
        	String destPage = "register.jsp";
        	
        	String message = "Cadastro falhou, verifique os dados!";
            request.setAttribute("mensagemFalha", message);

            if(request.getParameter("Test") == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
                dispatcher.forward(request, response);
            }
        }
    }
}