package com.biblioteca.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.biblioteca.modelo.Livro;
import com.biblioteca.util.Mensagem;
import com.biblioteca.util.SqlResources;


@Repository
public class LivroRepository {

	@Autowired
	private Mensagem mensagem;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Mensagem salvar(Livro livro){
		jdbcTemplate.update(SqlResources.getInstance().querieSql("inserirLivro"), 
					livro.getTitulo(), 
					livro.getEditora(), 
					livro.getDataLancamento());
		mensagem.setMensagem("Sucesso");
		return mensagem;
	}
}
