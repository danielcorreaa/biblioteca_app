package com.biblioteca.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.biblioteca.enums.SituacaoEnum;
import com.biblioteca.modelo.Emprestimo;
import com.biblioteca.modelo.Livro;
import com.biblioteca.modelo.Multa;
import com.biblioteca.modelo.Pessoa;
import com.biblioteca.service.EmprestimoDAO;
import com.biblioteca.service.LivroService;
import com.biblioteca.service.PessoaDAO;
import com.biblioteca.util.DataUtil;

public class MovimentacaoTest {
	
	/*EmprestimoDAO dao = null;
	LivroService daoL = null;
	PessoaDAO daoP = null;
	
	@Before
	public void init(){
		dao = new EmprestimoDAO();
		daoL = new LivroService();
		daoP = new PessoaDAO();
	}
	
	//@Test
	public void deveEmprestarLivro(){		
		Livro livro = daoL.buscarLivroCodigo(3);
		Pessoa pessoa = daoP.buscarPessoaCodigo(1);		
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setPessoa(pessoa);
		emprestimo.setLivro(livro);
		emprestimo.setDataSaida(new Date());
		List<Emprestimo> retorno = dao.processarEmprestimo(emprestimo);
		System.out.println(retorno);		
		
	}
	
	@Test
	public void deveTrazerEmprestimoPorLivroPessoaESituacao(){
		@SuppressWarnings("unused")
		Livro livro = daoL.buscarLivroCodigo(1);
		Pessoa pessoa = daoP.buscarPessoaCodigo(1);		
		List<Emprestimo> result = dao.buscarEmprestimoPorLivroPessoaESituacao(pessoa, SituacaoEnum.A.toString());
		for (Emprestimo emprestimo : result) {			
			System.out.println(emprestimo.getPessoa().getNome());
			System.out.println(emprestimo.getLivro().getTitulo());
			System.out.println(emprestimo.getDataSaida());
			System.out.println(emprestimo.getDataPrevDevolucao());
		}
		Assert.assertNotNull(result);
	}
	
	//@Test
	public void deveDevolverLivro(){
		@SuppressWarnings("unused")
		Livro livro = daoL.buscarLivroCodigo(3);
		Pessoa pessoa = daoP.buscarPessoaCodigo(1);		
		List<Emprestimo> emprestimo = dao.buscarEmprestimoPorLivroPessoaESituacao(pessoa, SituacaoEnum.A.toString());		
		Boolean multa = DataUtil.verificarSeLivroEstaAtrazado(emprestimo.get(0).getDataPrevDevolucao());
		if(multa){
			Multa mult = (Multa) dao.processarDevolucao(emprestimo.get(0), multa );
			System.out.println(mult.getEmprestimo().getId());
			System.out.println(mult.getId());		
			System.out.println(mult.getValor());
			System.out.println(mult.getDataMulta());
		}else{
			String retorno = (String) dao.processarDevolucao(emprestimo.get(0), multa );
			System.out.println(retorno);
		}
	
		
	}*/

}
