package br.com.alura.jdbc.testes.insertions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recuperarConexao()) {

			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO produto (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

				adicionarVariavel("SmartTV", "45 polegadas", stm);
				adicionarVariavel("Radio", "Radio de Bateria", stm);

				connection.commit();

			} catch (Exception e) {
				connection.rollback();
				e.printStackTrace();
				System.err.println("ROLLBACK Executado.");
			}
		}

	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setNString(1, nome);
		stm.setNString(2, descricao);

//		if (nome.equalsIgnoreCase("Radio"))
//			throw new RuntimeException("Não foi possível adicionar o produto " + nome);

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("Produto ID: " + id + " criado com sucesso.");

			}
		}
	}

}
