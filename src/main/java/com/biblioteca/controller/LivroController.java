package com.biblioteca.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.facade.dto.livro.LivroDto;
import com.biblioteca.facade.internal.LivroFacade;
import com.biblioteca.modelo.Livro;
import com.biblioteca.repository.LivroRepository;
import com.biblioteca.util.Mensagem;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LivroController {	
	
	@Autowired
	private LivroFacade facade;
	
	@Autowired
	private LivroRepository livroRep;
	
	@RequestMapping(value="/livro", method=RequestMethod.POST)
	public ResponseEntity<Mensagem> salvar(@RequestBody Livro livro){
		if(livro == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Mensagem resposta = null;		
		resposta = livroRep.salvar(livro);
		return new ResponseEntity<Mensagem>(resposta, HttpStatus.CREATED);
		
	}
	
	/*@RequestMapping(value="livro", method=RequestMethod.PUT)
	public ResponseEntity<Mensagem> editar(@RequestBody Livro livro){
		if(livro == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Mensagem resposta = facade.alterar(livro);
		if(resposta == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Mensagem>(resposta, HttpStatus.OK);
	}*/
	
	/*@RequestMapping(value="livro/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Mensagem> excluir(@PathVariable("id") Integer id){
		if(id == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Mensagem resposta = facade.excluir(id);
		if(resposta == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Mensagem>(resposta, HttpStatus.OK);
	}*/
	
	@RequestMapping( value="livros/{page}/{size}", method = RequestMethod.GET)
	public ResponseEntity<Resources<LivroDto>> list(@PathVariable int page, @PathVariable int size){
		List<LivroDto> all = facade.listar(page,size);	
		return ResponseEntity.ok(new Resources<>(all, linkTo(methodOn(getClass()).list(page, size)).withSelfRel()));
	}
	
	/*@RequestMapping( value="livros/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Livro> buscarLivroCodigo(@PathVariable("id")Integer id){
		Livro response = facade.buscarLivroCodigo(id);
		if(response == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
		return new ResponseEntity<Livro>( response, HttpStatus.OK) ;
	}*/
	
	/*@RequestMapping( value="livros/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Livro> buscarLivroNome(@PathVariable("nome")String nome){
		Livro response = facade.buscarLivroNome(nome);
		if(response == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
		return new ResponseEntity<Livro>( response, HttpStatus.OK) ;
	}*/

}
