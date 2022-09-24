package br.com.alura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

	public Connection recuperaConexao() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual", "root", "Bl@ck0511");

	}

	public void cadastraProduto(String nome, String descricao) throws SQLException {

		Connection connection = this.recuperaConexao();

		PreparedStatement stm = connection.prepareStatement("INSERT INTO produto (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();

		while (rst.next()) {
			System.out.println("Produto ID: " + rst.getInt(1) + " adicionado.");
		}

		System.out.println(stm.getUpdateCount() + " linhas afetadas.");

		connection.close();

	}

	public void listaProdutos() throws SQLException {

		Connection connection = this.recuperaConexao();

		PreparedStatement stm = connection.prepareStatement("SELECT * FROM produto");
		
		stm.execute();

		ResultSet resultado = stm.getResultSet();

		while (resultado.next()) {

			Integer id = resultado.getInt("id");
			String nome = resultado.getString("nome");
			String descricao = resultado.getString("descricao");

			System.out.println("Produto: " + id + ", Nome: " + nome + ", Descrição: " + descricao);
		}

		connection.close();

	}

	public void removeProduto(Integer id) throws SQLException {
		
		if (id < 1 || id == null)
			throw new IllegalArgumentException("ID do produto inválido");
		
		Connection connection = this.recuperaConexao();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM produto WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
		stm.setInt(1, id);		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while (rst.next()) {
			Integer colunaID = rst.getInt(1);
			System.out.println("Produto ID: " + colunaID + " removido com sucesso.");
		}
		
		
		System.out.println(stm.getUpdateCount() + " linhas afetadas.");
		
		connection.close();
	}

	public void removeProdutoComIDMaiorQue(Integer id) throws SQLException {
		
		if (id < 1 || id == null)
			throw new IllegalArgumentException("ID do produto inválido");
		
		Connection connection = this.recuperaConexao();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM produto WHERE id > ?");
		stm.setInt(1, id);
		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();
		
		while (rst.next()) {
			Integer colunaID = rst.getInt(1);
			System.out.println("Produto ID: " + colunaID + " removido com sucesso.");
		}
		
		
		System.out.println(stm.getUpdateCount() + " linhas afetadas.");
		
		connection.close();
		
		
	}
	
}
