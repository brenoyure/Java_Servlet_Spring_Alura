package br.com.alura.jdbc.testes.insertions;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.ConnectionFactory;
import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {

//		Produto galaxyA52s = new Produto("Smartphone", "Samsung Galaxy A52s 5G");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			ProdutoDAO produtoDao = new ProdutoDAO(connection);			
//			produtoDao.salvar(galaxyA52s);
			List<Produto> listaDeProdutos = produtoDao.listar();

			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
			
			
		}

	}

}
