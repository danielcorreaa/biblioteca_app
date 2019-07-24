package com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.modelo.Pessoa;
import com.biblioteca.service.PessoaDAO;
import com.biblioteca.util.Mensagem;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PessoaClient {
	
	@Autowired
	private PessoaDAO  dao;
	
	@RequestMapping(value="/pessoa", method=RequestMethod.POST)
	public ResponseEntity<Mensagem> salvar(@RequestBody Pessoa pessoa){
		if(pessoa == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Mensagem response = dao.salvar(pessoa);		
		if(response == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Mensagem>(response,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="pessoa", method=RequestMethod.PUT)
	public ResponseEntity<Mensagem> editar(@RequestBody Pessoa pessoa){
		if(pessoa == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Mensagem response = dao.alterar(pessoa);
		if(response == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Mensagem>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="pessoa/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Mensagem> excluir(@PathVariable("id") Integer id){
		if(id == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Mensagem response = dao.excluir(id);
		if(response == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Mensagem>(response, HttpStatus.OK);
	}
	
	@RequestMapping( value="pessoas/{page}/{size}", method = RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> list(@PathVariable int page, @PathVariable int size){
		List<Pessoa> response = dao.listar(page, size);		
		if(response == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
		return new ResponseEntity<List<Pessoa>>( response, HttpStatus.OK) ;
	}
	
	@RequestMapping( value="pessoas/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pessoa> buscarPessoaCodigo(@PathVariable("id")Integer id){
		Pessoa response = dao.buscarPessoaCodigo(id);
		if(response == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
		return new ResponseEntity<Pessoa>( response, HttpStatus.OK) ;
	}
	
	@RequestMapping( value="pessoas/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Pessoa> buscarPessoaNome(@PathVariable("nome")String nome){
		Pessoa response = dao.buscarPessoaNome(nome);
		if(response == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
		return new ResponseEntity<Pessoa>( response, HttpStatus.OK) ;
	}

}
