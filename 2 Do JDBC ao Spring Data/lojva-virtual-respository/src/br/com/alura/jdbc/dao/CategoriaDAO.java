package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.unmodifiableList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;

	}

	public List<Categoria> listar() throws SQLException {

		List<Categoria> categorias = new ArrayList<>();

		String sql = "SELECT * FROM CATEGORIA";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			try (ResultSet rst = pstm.executeQuery()) {

				while (rst.next()) {

					Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));

					categorias.add(categoria);

				}
			}
		}

		return unmodifiableList(categorias);
	}

}
