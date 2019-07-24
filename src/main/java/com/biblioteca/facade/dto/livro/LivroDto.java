package com.biblioteca.facade.dto.livro;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LivroDto extends ResourceSupport	 {
	
	
	private String titulo;
	private Date dataLancamento;
	private String situacao;
	private String editora;
	private String imagem;
	
	

}
