package br.com.alura.jdbc.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.jdbc.ConnectionFactory;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		try (Connection con = connectionFactory.recuperarConexao()) {
			con.setAutoCommit(false);

			
			try (PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE id > ?")) {
				stm.setInt(1, 2);
				stm.execute();

				con.commit();
				
				Integer linhasAfetadas = stm.getUpdateCount();
				System.out.println("Após o statment de DELETE, " + linhasAfetadas + " linhas foram afetadas.");
			} catch(Exception e) {
				con.rollback();
				e.printStackTrace();
			}
		}

	}

}
