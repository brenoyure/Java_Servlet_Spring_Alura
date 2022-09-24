package br.com.alura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection recuperarConexao() throws SQLException {
		
		return DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual", "root", "Bl@ck0511");
		
	}
	
}
