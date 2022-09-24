package br.com.alura;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();

		Connection connection = factory.recuperarConexao();

		Statement stm = connection.createStatement();

		stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('Geladeira', 'Geladeira Azul')",	Statement.RETURN_GENERATED_KEYS);

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
