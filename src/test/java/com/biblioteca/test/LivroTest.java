package com.biblioteca.test;

import org.junit.Before;

import com.biblioteca.service.LivroService;

public class LivroTest {
	
	LivroService dao = null;
	
	@Before
	public void init(){
		dao = new LivroService();
	}
	
	/*//@Test
	public void deveSalvarLivro(){
		Livro livro = new Livro();
		livro.setDataLancamento(DataUtil.converterDataTextoParaFormatoData("1940-09-29"));
		livro.setEditora("VIDA");
		livro.setTitulo("O processo");		
		Mensagem retorno = dao.salvar(livro);
		Assert.assertSame("Sucesso ao salvar!", retorno.getMensagem());
	}
	
	//@Test
	public void deveAlterarLivro(){
		Livro livro = dao.buscarLivroCodigo(10);
		livro.setDataLancamento(DataUtil.converterDataTextoParaFormatoData("1980-09-18"));
		livro.setEditora("VIDA");
		livro.setTitulo("The Stand 2");		
		Mensagem retorno  = dao.alterar(livro);		
		Assert.assertSame("Sucesso ao alterar!", retorno.getMensagem());
	}
	
	//@Test
	public void deveExcluirLivro(){
		Livro livro = dao.buscarLivroCodigo(4);			
		Mensagem  retorno = dao.excluir(livro.getId());
		Assert.assertSame("sucesso ao excluir - codigo retorno", retorno.getMensagem());
	}
	
	@Test
	public void deveBuscarTodos(){
		List<Livro> livros = dao.listar(0,10);		
		Assert.assertNotNull(livros);
	}
	
	@Test
	public void deveBuscarPeloTitulo(){
		Livro livro = dao.buscarLivroNome("Senhor");
		Assert.assertNotNull(livro);
	}*/

}
