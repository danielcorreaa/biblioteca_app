package com.biblioteca.enums;

public enum SituacaoEnum {

	// Pessoa
	A(1, "Ativo"), B(2, "Bloqueado"),
	// Livro
	E(3, "Emprestado"), L(4, "Liberado"),
	// Emprestimo
	F(5, "Finalizado"),
	// Multa
	P(6, "Pago"), N(7, "Não Pago");

	private int indice;
	private String descricao;

	SituacaoEnum(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getIndice() {
		return indice;
	}
	

}
