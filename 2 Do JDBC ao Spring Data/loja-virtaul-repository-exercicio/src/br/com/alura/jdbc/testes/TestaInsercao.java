package br.com.alura.jdbc.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.ConnectionFactory;
import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperaConexao()) {

			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			
			Produto produto = new Produto("Computador HP", "HP Prodesk 600G1 SFF");
			
			produtoDAO.cadastrar(produto);
			
			
		}

	}

}
