package com.uel.ZZCommerce.dao;

import com.uel.ZZCommerce.jdbc.ConnectionFactory;
import com.uel.ZZCommerce.model.Contato;
import com.uel.ZZCommerce.model.Pesquisa;
import com.uel.ZZCommerce.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {

  private Connection connection;

  public ProdutoDAO() {
    this.connection = new ConnectionFactory().getConnection();
  }

  public boolean inserir(Produto produto) {
    String sql =
        "INSERT INTO produto (NOME, PRECOVENDA, QUANTIDADE, ID_CONTATO, IMAGEM) VALUES (?, ?, ?, ?, ?)";

    try {
      PreparedStatement statement = connection.prepareStatement(sql);

      statement.setString(1, produto.getNome());
      statement.setString(2, Double.toString(produto.getPrecoVenda()));
      statement.setString(3, Integer.toString(produto.getQuantidade()));
      statement.setString(4, Integer.toString(produto.getIdContato()));
      statement.setString(5, produto.getImagem());

      statement.execute();

      statement.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return true;
  }

  public List<Produto> mostrarPrudutos() throws SQLException {
    List<Produto> produtos = new ArrayList<>();
    String sql =
        "SELECT produto.id, produto.nome, precovenda, quantidade, id_contato, imagem, contato.nome as nome_contato "
            + "FROM commerce.produto "
            + "JOIN commerce.contato ON contato.id = produto.id_contato "
            + "ORDER BY id";

    try (PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery()) {
      while (result.next()) {
        Produto produto = new Produto();
        Contato contato = new Contato();

        contato.setNome(result.getString("nome_contato"));

        produto.setId(result.getInt("id"));
        produto.setNome(result.getString("nome"));
        produto.setPrecoVenda(result.getDouble("precovenda"));
        produto.setQuantidade(result.getInt("quantidade"));
        produto.setIdContato(result.getInt("id_contato"));
        produto.setImagem(result.getString("imagem"));
        produto.setContato(contato);

        produtos.add(produto);
      }
    } catch (SQLException e) {
      Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, "DAO", e);

      throw new SQLException("Erro ao listar produtos.");
    }

    return produtos;
  }

  public List<Produto> buscarPorNome (String termo){
    String sql = "SELECT id, nome, precovenda, quantidade, id_contato, imagem FROM commerce.produto WHERE LOWER(nome) LIKE LOWER(?);";
    List<Produto> produtos = new ArrayList<Produto>();

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, "%" + termo + "%");

      try(ResultSet result = statement.executeQuery()) {
        while(result.next()) {
          Produto pesquisaProdutos = new Produto();

          pesquisaProdutos.setId(result.getInt("id"));
          pesquisaProdutos.setNome(result.getString("nome"));
          pesquisaProdutos.setPrecoVenda(result.getDouble("precovenda"));
          pesquisaProdutos.setQuantidade(result.getInt("quantidade"));
          pesquisaProdutos.setIdContato(result.getInt("id_contato"));
          pesquisaProdutos.setImagem(result.getString("imagem"));

          produtos.add(pesquisaProdutos);
        }
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }


    return produtos;
  }
}
