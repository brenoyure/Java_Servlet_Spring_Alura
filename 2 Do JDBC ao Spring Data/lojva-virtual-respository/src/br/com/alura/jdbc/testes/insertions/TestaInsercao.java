package br.com.alura.jdbc.testes.insertions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.ConnectionFactory;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();

		try (Connection connection = factory.recuperarConexao()) {
			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

				stm.setString(1, "Geladeira");
				stm.setString(2, "Geladeira Azul");
				stm.execute();
				
				connection.commit();

				Integer nLinhas = stm.getUpdateCount();
				System.out.println("Após o statment de INSERT, " + nLinhas + " linhas foram afetadas.");

				try (ResultSet rst = stm.getGeneratedKeys()) {
					while (rst.next()) {
						Integer id = rst.getInt(1);
						System.out.println("Produto ID: " + id + " criado com sucesso.");
					}

				}
			} catch (Exception e) {
				connection.rollback();
				e.printStackTrace();
				System.err.println("ROLLBACK executado");
			}
		}

	}

}
