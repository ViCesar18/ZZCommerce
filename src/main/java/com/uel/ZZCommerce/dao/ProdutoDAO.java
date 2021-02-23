package com.uel.ZZCommerce.dao;

import com.uel.ZZCommerce.jdbc.ConnectionFactory;
import com.uel.ZZCommerce.model.Contato;
import com.uel.ZZCommerce.model.Produto;

import java.sql.*;

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
            statement.setString(4, Integer.toString(produto.getIdContato()));

            statement.execute();

            statement.close();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}