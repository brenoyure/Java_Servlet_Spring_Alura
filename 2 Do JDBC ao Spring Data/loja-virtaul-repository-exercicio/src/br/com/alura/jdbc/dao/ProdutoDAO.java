package br.com.alura.jdbc.dao;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(Produto produto) {

		try {
			if (produto == null || produto.getId() != null)
				return;

		} catch (NullPointerException e) {
			System.err.println(e.getLocalizedMessage());
			return;
		}

		try {
			if (connection.isClosed()) {
				System.err.println("ERROR: Conexão com a Datebase fechada.");
				return;
			}

			if (connection.isReadOnly()) {
				System.err.println("ERROR: ReadOnly Connection.");
				return;
			}

			if (connection.getAutoCommit() != true)
				return;

		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		String sql = "INSERT INTO produto (nome, descricao) VALUES(?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.execute();

			ResultSet rst = pstm.getGeneratedKeys();
			if (rst.next()) {
				Integer id = rst.getInt(1);
				produto.setId(id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("O " + produto + " foi cadastrado com sucesso.");

	}

	public List<Produto> listar() {

		try {
			if (connection.isClosed()) {
				return emptyList();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			return emptyList();
		}
		
		List<Produto> produtos = new ArrayList<>();

		final String sql = "SELECT * FROM produto";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {

			ResultSet rst = pstm.executeQuery();

			while (rst.next()) {
				produtos.add(new Produto(rst.getInt(1), rst.getString(2), rst.getString(3)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return emptyList();
		}

		return unmodifiableList(produtos);

	}

}
