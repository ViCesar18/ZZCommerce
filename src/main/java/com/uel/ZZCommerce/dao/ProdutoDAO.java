package com.uel.ZZCommerce.dao;

import com.uel.ZZCommerce.jdbc.ConnectionFactory;
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

    public boolean registerProduto (Produto produto) {
        String sql = "INSERT INTO produto (NOME, PRECOVENDA, QUANTIDADE, ID_CONTATO) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, produto.getNome());
            statement.setString(2, Double.toString(produto.getPrecoVenda()));
            statement.setString(3, Integer.toString(produto.getQuantidade()));
            statement.setString(4, Integer.toString(produto.getIdContato()  ));

            statement.execute();

            statement.close();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public List<Produto> allProduto () throws SQLException{
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT id, nome, precovenda, quantidade, id_contato FROM commerce.produto ORDER BY id";

        try (PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery()) {
                while(result.next()) {
                    Produto produto = new Produto();

                    produto.setId(result.getInt("id"));
                    produto.setNome(result.getString("nome"));
                    produto.setPrecoVenda(result.getDouble("precovenda"));
                    produto.setIdContato(result.getInt("id_contato"));


                    produtos.add(produto);
                }
        } catch(SQLException e) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, "DAO", e);

            throw new SQLException("Erro ao listar produtos.");
        }

        return produtos;
    }
}