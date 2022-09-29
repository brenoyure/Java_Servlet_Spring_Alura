package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("Bl@ck0511");
		
		comboPooledDataSource.setMinPoolSize(1);
		comboPooledDataSource.setMaxPoolSize(15);
		
		
		this.dataSource = comboPooledDataSource;
	}
	
	
	public Connection recuperarConexao() throws SQLException {
		
		return this.dataSource.getConnection();
		
	}
	
}
