package br.com.alura.jdbc.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.ConnectionFactory;
import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.modelo.Categoria;

public class TestaListagemCategoriaComProduto {

    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().recuperaConexao()) {

            List<Categoria> listaDeCategoria = new CategoriaDAO(connection).listaComProdutos();

            listaDeCategoria.forEach(c -> c.getProdutos().forEach(p -> System.out.println(c + " " + p)));

        }

    }

}
