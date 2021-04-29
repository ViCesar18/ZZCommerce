package com.uel.ZZCommerce.controller;

import com.uel.ZZCommerce.dao.PesquisaDAO;
import com.uel.ZZCommerce.dao.ProdutoDAO;
import com.uel.ZZCommerce.model.Contato;
import com.uel.ZZCommerce.model.Pesquisa;
import com.uel.ZZCommerce.model.Produto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "PesquisaServlet",
        urlPatterns = {
                "/pesquisa"
        }
)

public class PesquisaServlet extends HttpServlet {
    public PesquisaServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PesquisaDAO pesquisaDAO = new PesquisaDAO();
        ProdutoDAO produtoDAO;
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();

        switch(request.getServletPath()){
            case "/pesquisa":{
                if(session.getAttribute("loggedInUser") != null) {
                    Integer idContatoLogado = ((Contato) session.getAttribute("loggedInUser")).getId();

                    String pesquisaStr = request.getParameter("pesquisa");

                    Pesquisa pesquisa = new Pesquisa();

                    pesquisa.setPesquisa(pesquisaStr);

                    List<Produto> produtos = pesquisaDAO.pesquisa(pesquisa);

                    request.setAttribute("produtos", produtos);

                    dispatcher = request.getRequestDispatcher("view/main_page.jsp");
                    dispatcher.forward(request, response);
                }

            }
        }

    }


}
