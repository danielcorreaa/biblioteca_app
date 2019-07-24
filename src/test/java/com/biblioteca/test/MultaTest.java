package com.biblioteca.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.biblioteca.modelo.Multa;
import com.biblioteca.modelo.PagamentoMulta;
import com.biblioteca.modelo.Pessoa;
import com.biblioteca.service.MultaDAO;

public class MultaTest {
	
	MultaDAO dao;
	
	@Before
	public void init(){
		dao = new MultaDAO();
	}
	
	//@Test
	public void deveTrazerMultaPorPessoa(){
		Pessoa pessoa = new Pessoa();
		pessoa.setId(3);		
		PagamentoMulta pagamento = dao.buscarMultaPorPessoa(pessoa);		
		Assert.assertNotNull(pagamento);
	}
	
	@Test
	public void devePagarMulta(){
		Pessoa pessoa = new Pessoa();
		pessoa.setId(3);
		List<Multa> multas = dao.pagarMulta(pessoa);
		for (Multa multa : multas) {
			System.out.println(multa.getSituacao());
		}
		Assert.assertNotNull(multas);
		
	}

}
