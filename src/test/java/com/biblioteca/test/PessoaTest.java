package com.biblioteca.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.biblioteca.enums.SituacaoEnum;
import com.biblioteca.modelo.Pessoa;
import com.biblioteca.service.PessoaDAO;
import com.biblioteca.util.Mensagem;

public class PessoaTest {
	
	PessoaDAO dao = null;
	
	@Before
	public void init(){
		dao = new PessoaDAO();
	}
	
	//@Test
	public void deveSalvarPessoa(){
		Pessoa pessoa = new Pessoa();	
		pessoa.setNome("Catatau");
		pessoa.setEndereco("Rua das Oliveiras - 3444, Centro");		
		Mensagem retorno = dao.salvar(pessoa);
		System.out.println(retorno);
		Assert.assertSame("Sucesso ao salvar!", retorno.getMensagem());
	}
	
	//@Test
	public void deveAlterarPessoa(){
		Pessoa pessoa = dao.buscarPessoaCodigo(4);
		pessoa.setNome("Erivaldo");
		pessoa.setEndereco("Rua das Oliveiras - 3444, Centro");	
		pessoa.setSituacao(SituacaoEnum.L);
		Mensagem retorno = dao.alterar(pessoa);
		System.out.println(retorno);
		Assert.assertSame("Sucesso ao alterar!", retorno.getMensagem());
	}
	
	//@Test
	public void deveExcluirPessoa(){
		Pessoa pessoa = dao.buscarPessoaCodigo(5);			
		Mensagem retorno = dao.excluir(pessoa.getId());
		System.out.println(retorno);
		Assert.assertSame("sucesso ao excluir - codigo retorno", retorno.getMensagem());
	}
	
	@Test
	public void deveBuscarTodos(){
		List<Pessoa> pessoas = dao.listar(0, 10);		
		Assert.assertNotNull(pessoas);
	}
	
	@Test
	public void deveBuscarPeloNome(){
		Pessoa pessoa = dao.buscarPessoaNome("z");
		Assert.assertNotNull(pessoa);
	}

}
