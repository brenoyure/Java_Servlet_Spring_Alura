package br.com.alura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		Connection con = connectionFactory.recuperarConexao();

		PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE id > ?");
		stm.setInt(1, 2);
		stm.execute();

		Integer linhasAfetadas = stm.getUpdateCount();

		System.out.println("Após o statment de DELETE, " + linhasAfetadas + " linhas foram afetadas.");

		con.close();

	}

}
