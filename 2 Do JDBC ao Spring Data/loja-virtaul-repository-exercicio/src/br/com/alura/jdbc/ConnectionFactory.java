package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private static final String USER_NAME = "root";
	private static final String PASSWORD = "Bl@ck0511";
	private static final String DATABASE_URL = "jdbc:mysql://localhost/loja_virtual";

	private DataSource dataSource;

	public ConnectionFactory() {

		ComboPooledDataSource pool = new ComboPooledDataSource();
		pool.setJdbcUrl(DATABASE_URL);
		pool.setUser(USER_NAME);
		pool.setPassword(PASSWORD);

		pool.setMaxPoolSize(15);

		this.dataSource = pool;

	}

	public Connection recuperaConexao() throws SQLException {

		return this.dataSource.getConnection();

	}

}
