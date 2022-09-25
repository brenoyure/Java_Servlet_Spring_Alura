package br.com.alura.jdbc.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.jdbc.ConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		try (Connection con = connectionFactory.recuperarConexao()) {

			try (PreparedStatement stm = con.prepareStatement("SELECT * FROM produto")) {
				stm.execute();

				try (ResultSet rst = stm.getResultSet()) {

					while (rst.next()) {
						Integer id = rst.getInt("id");
						String nome = rst.getString("nome");
						String descricao = rst.getString("descricao");
						System.out.println("Produto: [ID: " + id + ", Nome: " + nome + ", Descrição: " + descricao + "]");
					}
				}
			}
		}

	}

}
