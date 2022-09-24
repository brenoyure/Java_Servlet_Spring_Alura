package br.com.alura;

import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		
		factory.removeProdutoComIDMaiorQue(2);
		
		factory.listaProdutos();
		
		
	}
}
