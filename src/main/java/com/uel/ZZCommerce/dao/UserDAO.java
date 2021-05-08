package com.uel.ZZCommerce.dao;
 
import com.uel.ZZCommerce.jdbc.ConnectionFactory;
import com.uel.ZZCommerce.model.Contato;

import java.sql.*;
 
public class UserDAO {
	
	private Connection connection;
	
	public UserDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
 
    public Contato checkLogin(Contato contato) throws SQLException, ClassNotFoundException {
        
    	String sql = "SELECT ID FROM contato WHERE USERNAME = ? and PASSWORD = MD5(?)";
    	
    	try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, contato.getUsername());
	        statement.setString(2, contato.getPassword());

			try(ResultSet result = statement.executeQuery()) {
				if(result.next()) {
					contato.setId(result.getInt("id"));
				}
				else {
					throw new SecurityException("Usuário ou senha incorretos.");
				}
			}
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
 
        return contato;
    }

	public boolean register(Contato contato) {
		
		String sql = "INSERT INTO contato (USERNAME, PASSWORD, NOME, APELIDO, EMPRESA, ENDERECO, BAIRRO, CIDADE, TELEFONE1, TELEFONE2, OBSERVACAO, COMPRADOR) VALUES (?, MD5(?), ?, ?, ?, ?, ?, ?, ?, ?, ?, 1)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, contato.getUsername());
			statement.setString(2, contato.getPassword());
			statement.setString(3, contato.getNome());
			statement.setString(4, contato.getApelido());
			statement.setString(5, contato.getEmpresa());
			statement.setString(6, contato.getEndereco());
			statement.setString(7, contato.getBairro());
			statement.setString(8, contato.getCidade());
			statement.setString(9, contato.getTelefone1());
			statement.setString(10, contato.getTelefone2());
			statement.setString(11, contato.getObservacao());
			
			statement.execute();
			
			statement.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return true;
	}
}