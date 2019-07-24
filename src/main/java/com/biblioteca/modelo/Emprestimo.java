package com.biblioteca.modelo;

import java.util.Date;

import com.biblioteca.enums.SituacaoEnum;
import com.biblioteca.util.Mensagem;

import lombok.Data;

@Data
public class Emprestimo {

	private Integer Id;
	private Livro livro;
	private Pessoa pessoa;
	private SituacaoEnum situacao;
	private Date dataSaida;
	private Date dataEntrega;
	private Date dataPrevDevolucao;
	private Mensagem mensagem;

	

	public String setNomePessoa(String nome) {
		this.pessoa = new Pessoa();
		this.pessoa.setNome(nome);
		return this.pessoa.getNome();
	}

	public String setTituloLivro(String titulo) {
		this.livro = new Livro();
		this.livro.setTitulo(titulo);
		return this.livro.getTitulo();
	}

}
