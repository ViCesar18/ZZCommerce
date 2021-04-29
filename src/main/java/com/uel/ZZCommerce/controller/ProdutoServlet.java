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
import java.sql.SQLException;
import java.util.List;

@WebServlet(
        name = "ProdutoServlet",
        urlPatterns = {
                "/registerProduto",
                "/allProduto"

        }
)
public class ProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProdutoServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();

        switch (servletPath){
            case "/registerProduto":{
                Produto produto = new Produto();
                produto.setNome(request.getParameter("nome"));
                produto.setPrecoVenda(Double.parseDouble(request.getParameter("preco")));
                produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

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
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        RequestDispatcher dispatcher;

        switch(servletPath){
            case "/allProduto":{
                try {
                    List<Produto> produtos = produtoDAO.allProduto();

                    request.setAttribute("produtos", produtos);

                    dispatcher = request.getRequestDispatcher("view/main_page.jsp");
                    dispatcher.forward(request, response);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
