package com.biblioteca.test;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.biblioteca.util.ConnectionFactory;

public class ConexaoTeste {
	
	
	@Before
	public void iniciar(){
		System.out.println("Construiu");
	}
	
	@Test
	public void testarConexao(){
		Connection con = ConnectionFactory.getInstance().getConnection();
		Assert.assertNotNull(con);
	}

}
