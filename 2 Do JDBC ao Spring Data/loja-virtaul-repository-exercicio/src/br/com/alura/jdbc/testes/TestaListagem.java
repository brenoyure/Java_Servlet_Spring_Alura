package br.com.alura.jdbc.testes;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.ConnectionFactory;
import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperaConexao()) {

			ProdutoDAO produtoDAO = new ProdutoDAO(connection);

			List<Produto> produtos = produtoDAO.listar();

			produtos.forEach(out::println);

		}

	}

}
