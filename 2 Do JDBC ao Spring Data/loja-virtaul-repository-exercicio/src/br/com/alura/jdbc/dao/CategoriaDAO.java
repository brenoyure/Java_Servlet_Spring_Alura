package br.com.alura.jdbc.dao;

import static java.util.Collections.unmodifiableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {

		this.connection = connection;

	}

	public List<Categoria> listaCategorias() throws SQLException {
		
		List<Categoria> categorias = new ArrayList<>();
		
		final String sql = "SELECT * FROM CATEGORIA";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)) {
			
			try(ResultSet rst = pstm.executeQuery()) {
				
				while(rst.next()) {
					
					categorias.add(new Categoria(rst.getInt(1), rst.getString(2)));
					
				}
				
			}
			
		}
		
		return unmodifiableList(categorias);
		
	}
	
	/**
	 * Método getProdutos() devolve uma lista de produtos com suas respectivas
	 * categorias
	 * 
	 * @return Lista de Produtos
	 * @throws SQLException
	 */
	public List<Categoria> listaComProdutos() throws SQLException {

		List<Categoria> categorias = new ArrayList<>();

		final String sql = "SELECT * FROM categoria c INNER JOIN produto p ON c.ID = p.CATEGORIA_ID";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {

			try (ResultSet rst = pstm.executeQuery()) {

				while (rst.next()) {

					Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
					Produto produto = new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));

					categoria.adiciona(produto);
					categorias.add(categoria);

				}

			}

		}

		return unmodifiableList(categorias);

	}

}
