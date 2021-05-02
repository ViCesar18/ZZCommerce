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
        String sql = "SELECT id, nome, precovenda, quantidade, id_contato, imagem FROM commerce.produto WHERE LOWER(nome) LIKE LOWER(?);";
        List<Produto> produtos = new ArrayList<Produto>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + pesquisa.getPesquisa() + "%");

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
