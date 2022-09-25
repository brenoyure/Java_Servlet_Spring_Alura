package br.com.alura.jdbc.testes.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();

		for (int i = 0; i < 30; i++) {
			try (Connection connection = factory.recuperaConexao()) {
				System.out.println("Conexão: " + i);
			}

		}

	}

}
