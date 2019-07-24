package com.biblioteca.util;

import org.springframework.stereotype.Service;

@Service
public class Mensagem {
	
	private String mensagem;
	
	public Mensagem() {
		super();
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
