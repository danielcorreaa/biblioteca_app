package com.biblioteca.modelo;

import java.math.BigDecimal;

import com.biblioteca.enums.SituacaoEnum;

public class PagamentoMulta {

	private String nome;
	private SituacaoEnum situacao;
	private BigDecimal valorTotal;

	public PagamentoMulta() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SituacaoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
