package com.uel.ZZCommerce.dao;

import com.uel.ZZCommerce.jdbc.ConnectionFactory;
import com.uel.ZZCommerce.model.Pesquisa;
import com.uel.ZZCommerce.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PesquisaDAO {

    private Connection connection;

    public PesquisaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public List<Produto> pesquisa (Pesquisa pesquisa){
        String sql = "SELECT id, nome, precovenda, quantidade, id_contato FROM commerce.produto WHERE LOWER(nome) LIKE LOWER(?);";
        List<Produto> produtos = new ArrayList<Produto>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + pesquisa.getPesquisa() + "%");

            try(ResultSet result = statement.executeQuery()) {
                while(result.next()) {
                    Produto pesquisaUsuario = new Produto();

                    pesquisaUsuario.setId(result.getInt("id"));
                    pesquisaUsuario.setNome(result.getString("nome"));
                    pesquisaUsuario.setPrecoVenda(result.getDouble("precovenda"));
                    pesquisaUsuario.setQuantidade(result.getInt("quantidade"));
                    pesquisaUsuario.setIdContato(result.getInt("id_contato"));

                    produtos.add(pesquisaUsuario);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return produtos;
    }

}
