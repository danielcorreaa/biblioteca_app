package com.biblioteca.facade.internal;

import java.util.List;

import com.biblioteca.facade.dto.livro.LivroDto;

public interface LivroFacade {
	
	
	List<LivroDto> listar(int page, int size);

}
