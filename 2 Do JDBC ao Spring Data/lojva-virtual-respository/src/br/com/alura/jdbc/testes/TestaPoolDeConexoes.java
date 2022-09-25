package br.com.alura.jdbc.testes;

import java.sql.SQLException;

import br.com.alura.jdbc.ConnectionFactory;

public class TestaPoolDeConexoes {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();

		for (int i = 0; i < 20; i++) {
			factory.recuperarConexao();
			System.out.println("Conexão de número: " + i);
		}

	}

}
