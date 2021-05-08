package com.uel.ZZCommerce.controller;

import com.uel.ZZCommerce.dao.ProdutoDAO;
import com.uel.ZZCommerce.model.Contato;
import com.uel.ZZCommerce.model.Produto;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(
    name = "AdicionarProdutoServlet",
    urlPatterns = {"/registerProduto"})
public class AdicionarProdutoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final int MAX_FILE_SIZE = 1024 * 1024 * 4;
  private static String SAVE_DIR = "assets/img/produtos";

  public AdicionarProdutoServlet() {
    super();
  }

  public Produto getProduto() {
    return null;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doGet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    ProdutoDAO produtoDAO = new ProdutoDAO();

    Produto produto = new Produto();

    DiskFileItemFactory factory = new DiskFileItemFactory();

    factory.setSizeThreshold(MAX_FILE_SIZE);

    factory.setRepository(new File("/temp"));

    ServletFileUpload upload = new ServletFileUpload(factory);

    upload.setSizeMax(MAX_FILE_SIZE);

    List<FileItem> items = null;
    try {
      items = upload.parseRequest(request);

    } catch (FileUploadException e) {
      e.printStackTrace();
    }

    Iterator<FileItem> iterator = items.iterator();
    while (iterator.hasNext()) {
      FileItem item = iterator.next();

      if (item.isFormField()) {
        String fieldName = item.getFieldName();
        String fieldValue = item.getString();

        switch (fieldName) {
          case "nome":
            produto.setNome(fieldValue);
            break;

          case "preco":
            produto.setPrecoVenda(Double.parseDouble(fieldValue));
            break;

          case "quantidade":
            produto.setQuantidade(Integer.parseInt(fieldValue));
            break;
        }
      } else {
        String fieldName = item.getFieldName();
        String fileName = item.getName();

        if (fieldName.equals("imagem") && !fileName.isBlank()) {
          String appPath = request.getServletContext().getRealPath("");

          String savePath = appPath + File.separator + SAVE_DIR + File.separator + fileName;
          File uploadedFile = new File(savePath);
          try {
            item.write(uploadedFile);
          } catch (Exception e) {
            e.printStackTrace();
          }

          produto.setImagem(fileName);
        }
      }
    }
    Contato contato = (Contato) session.getAttribute("loggedInUser");
    System.out.print(contato.getId());
    produto.setIdContato(contato.getId());

    if (produtoDAO.inserir(produto)) {
      response.sendRedirect(request.getContextPath() + "/allProduto");

      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        throw new ServletException(e);
      }

    } else {
      String destPage = "register.jsp";

      String message = "An error has happened, please try again";

      RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
      dispatcher.forward(request, response);
    }
  }
}
