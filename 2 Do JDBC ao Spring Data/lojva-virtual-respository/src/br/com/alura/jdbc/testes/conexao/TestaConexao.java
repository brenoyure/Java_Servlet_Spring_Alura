package br.com.alura.jdbc.testes.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
					
		Connection connection = factory.recuperarConexao();
		
		System.out.println("Fechando conexão");
		
		connection.close();

	}

}
