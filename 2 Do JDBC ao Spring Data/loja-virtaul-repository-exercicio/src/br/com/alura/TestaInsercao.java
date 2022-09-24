package br.com.alura;

import java.sql.SQLException;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		
		factory.cadastraProduto("Smartphone", "SAMSUNG Galaxy A52s 5G");
		
	}
	
}
