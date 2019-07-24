package com.biblioteca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.biblioteca.util.ConnectionFactory;

public class GenericDAO {

	protected Connection con;
	protected PreparedStatement pstm;
	protected ResultSet rs;

	public Connection getCon() {
		return ConnectionFactory.getInstance().getConnection();		
	}

	public PreparedStatement getPreparedStatemaent(String sql) throws SQLException {
		this.con = ConnectionFactory.getInstance().getConnection();
		return con.prepareStatement(sql);
	}

	protected ResultSet execute(String sql) {
		ResultSet rs = null;
		try {
			pstm = getPreparedStatemaent(sql);
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	protected static void fecharConexao(Connection con, PreparedStatement pstm, ResultSet rs) {
	
		try {
			if(rs != null && !rs.isClosed()){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if( pstm != null && !pstm.isClosed()){
				pstm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(con != null &&  !con.isClosed()){				
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void fecharConexao(Connection con, PreparedStatement pstm) {
		try {
			if(!con.isClosed()){				
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(!pstm.isClosed()){
				pstm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void fecharConexao(Connection con) {
		try {
			if(!con.isClosed()){				
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	protected void fecharConexao(ResultSet rs) {
		try {
			if(!rs.isClosed()){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
