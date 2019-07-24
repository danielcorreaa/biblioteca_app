package com.biblioteca.modelo;

import java.util.Date;

import com.biblioteca.enums.SituacaoEnum;

import lombok.Data;

@Data
public class Livro {

	private Integer id;
	private String titulo;
	private Date dataLancamento;
	private SituacaoEnum situacao;
	private String editora;
	private String imagem;

	
	
}
