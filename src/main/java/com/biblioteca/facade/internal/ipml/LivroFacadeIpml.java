package com.biblioteca.facade.internal.ipml;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biblioteca.facade.dto.livro.LivroDto;
import com.biblioteca.facade.internal.LivroFacade;
import com.biblioteca.facade.internal.assembler.LivroResourceAssembler;
import com.biblioteca.service.LivroService;

@Component
public class LivroFacadeIpml implements LivroFacade{
	
	@Autowired
	private LivroService service;
	
	@Autowired
	private LivroResourceAssembler assembler;

	@Override
	public List<LivroDto> listar(int page, int size) {		
		return service.listar(page, size).
				stream()
				.map(c -> {
					return assembler.toResource(c);
				}).collect(Collectors.toList());
	}
	
	
	

}
