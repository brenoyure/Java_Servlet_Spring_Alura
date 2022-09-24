package br.com.alura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root", "root", "Bl@ck0511");
		
		System.out.println("Fechando conexão...");
		
		connection.close();
	}

}
