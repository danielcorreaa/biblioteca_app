package com.biblioteca.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {	
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://SOFWS0284;databaseName=biblioteca;";
			String user = "SOFISANTE\\dcorreia.3mpk";
			String password = "";
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection connection = ConexaoDB.getConnection();
		if(connection != null){
			System.out.println("Conectou");
		}else{
			System.out.println("Falhou");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
