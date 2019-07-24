package com.biblioteca.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static ConnectionFactory connectionFactory;

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}

	private ConnectionFactory() {
		super();
	}

	public Connection getConnection() {
		Connection con = null;
		final String url = "jdbc:mysql://localhost:3306/biblioteca";
		final String user = "root";
		final String password = "";
		final String DRIVER = "com.mysql.jdbc.Driver";
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(url, user, password);			
		} catch (SQLException e) {
			System.out.println("Erro na conexao: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Drive não encontrado: " + e.getMessage());
		}
		return con;
	}
	
	
	
}
