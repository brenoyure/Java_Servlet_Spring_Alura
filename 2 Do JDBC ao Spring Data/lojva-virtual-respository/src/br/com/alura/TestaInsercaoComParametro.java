package br.com.alura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		String nome = "Mouse'";
		String descricao = "Mouse Sem Fio";
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		PreparedStatement stm = connection.prepareStatement("INSERT INTO produto (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		stm.setNString(1, nome);
		stm.setNString(2, descricao);
		
		stm.execute();
		

		Integer linhasAfetadas = stm.getUpdateCount();

		System.out.println("Após o statment de INSERT, " + linhasAfetadas + " linhas foram afetadas.");

		ResultSet rst = stm.getGeneratedKeys();

		while (rst.next()) {

			Integer id = rst.getInt(1);

			System.out.println("Produto ID: " + id + " criado com sucesso.");

		}

		connection.close();
	}

}
