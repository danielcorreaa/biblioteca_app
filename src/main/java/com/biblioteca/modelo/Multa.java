package com.biblioteca.modelo;

import java.math.BigDecimal;
import java.util.Date;

import com.biblioteca.enums.SituacaoEnum;

public class Multa {

	private Integer id;
	private Emprestimo emprestimo;
	private BigDecimal valor;
	private Date dataMulta;
	private SituacaoEnum situacao;

	public Multa() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	public void setEmprestimoId(Integer id){
		this.emprestimo = new Emprestimo();
		this.emprestimo.setId(id);
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataMulta() {
		return dataMulta;
	}

	public void setDataMulta(Date dataMulta) {
		this.dataMulta = dataMulta;
	}

	public SituacaoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataMulta == null) ? 0 : dataMulta.hashCode());
		result = prime * result + ((emprestimo == null) ? 0 : emprestimo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}	

}
