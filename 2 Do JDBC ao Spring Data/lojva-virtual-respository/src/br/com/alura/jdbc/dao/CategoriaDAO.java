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
import br.com.alura.jdbc.modelo.Produto;

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

    public List<Categoria> listarComProdutos() throws SQLException {
        
        List<Categoria> categorias = new ArrayList<>();
        Categoria ultima = null;

        String sql = "SELECT * FROM CATEGORIA C INNER JOIN" + " PRODUTO P ON C.ID = P.CATEGORIA_ID";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            try (ResultSet rst = pstm.executeQuery()) {

                while (rst.next()) {

                    if(ultima == null || !ultima.getNome().equals(rst.getString(2))) {
                        Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
                        ultima = categoria;
                        categorias.add(categoria);
                    }
                    
                    Produto produto = 
                            new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
                    ultima.adicionar(produto);
                    

                }
            }
        }

        return unmodifiableList(categorias);
    }

}
