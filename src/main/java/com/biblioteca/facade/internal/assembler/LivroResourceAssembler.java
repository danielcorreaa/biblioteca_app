package com.biblioteca.facade.internal.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.biblioteca.controller.LivroController;
import com.biblioteca.facade.dto.livro.LivroDto;
import com.biblioteca.modelo.Livro;

@Component
public class LivroResourceAssembler extends ResourceAssemblerSupport<Livro, LivroDto> {
	
	@Autowired
	private ModelMapper modelMapper;
	

	public LivroResourceAssembler() {
		super(LivroController.class, LivroDto.class);
	}

	@Override
	public LivroDto toResource(Livro entity) {
		LivroDto resource = createResourceWithId(entity.getId(), entity);
		
		modelMapper.map(entity, resource);
		
		resource.add(linkTo(methodOn(LivroController.class).list(0, 10)).withRel("all"));
		
		return resource;
	}
	
	

}
