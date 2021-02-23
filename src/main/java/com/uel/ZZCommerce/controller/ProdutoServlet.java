package com.uel.ZZCommerce.controller;

import com.uel.ZZCommerce.dao.ProdutoDAO;
import com.uel.ZZCommerce.model.Contato;
import com.uel.ZZCommerce.model.Produto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registerProduto")
public class ProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProdutoServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Produto produto = new Produto(
                request.getParameter("nome"),
                Double.parseDouble(request.getParameter("preco")),
                Integer.parseInt(request.getParameter("quantidade"))
        );

        HttpSession session = request.getSession();
        Contato contato = (Contato) session.getAttribute("loggedInUser");
        System.out.print(contato.getId());
        produto.setIdContato(contato.getId());

        ProdutoDAO produtoDAO = new ProdutoDAO();

        if (produtoDAO.registerProduto(produto)){
            String destPage = "view/main_page.jsp";

            String message = "Produto adicionado com sucesso";

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

            try {
                Thread.sleep (3000);
            }
            catch (InterruptedException e) {
                throw new ServletException(e);
            }

        }else{
            String destPage = "register.jsp";

            String message = "An error has happened, please try again";

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
        }
    }
}
