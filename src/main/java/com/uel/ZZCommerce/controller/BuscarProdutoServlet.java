package com.uel.ZZCommerce.controller;

import com.uel.ZZCommerce.dao.ProdutoDAO;
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
    name = "BuscarProdutoServlet",
    urlPatterns = {"/allProduto"})
public class BuscarProdutoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public BuscarProdutoServlet() {
    super();
  }

  public List<Produto> getListaProdutos() {
    return null;
  }

  public List<Produto> getListaRecentes() {
    return null;
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ProdutoDAO produtoDAO = new ProdutoDAO();
    RequestDispatcher dispatcher;
    HttpSession session = request.getSession();

    if (session.getAttribute("loggedInUser") != null) {
      try {
        List<Produto> produtos = produtoDAO.buscarPorNome();

        request.setAttribute("produtos", produtos);

        dispatcher = request.getRequestDispatcher("view/main_page.jsp");
        dispatcher.forward(request, response);

      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    } else {
      dispatcher = request.getRequestDispatcher("index.jsp");
      dispatcher.forward(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
