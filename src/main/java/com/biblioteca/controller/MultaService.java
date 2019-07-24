package com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.modelo.Multa;
import com.biblioteca.modelo.PagamentoMulta;
import com.biblioteca.modelo.Pessoa;
import com.biblioteca.service.MultaDAO;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MultaService {
	
	@Autowired
	private MultaDAO dao;
	
	@RequestMapping(path="/multa/pesquisa"  ,method=RequestMethod.POST)
	public ResponseEntity<PagamentoMulta> buscarMulta(@RequestBody Pessoa pessoa){
		if(pessoa == null) new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		PagamentoMulta multa = dao.buscarMultaPorPessoa(pessoa);
		if(multa == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<PagamentoMulta>(multa, HttpStatus.OK);
	}
	@RequestMapping(path="/multa/pagar"  ,method=RequestMethod.POST)
	public ResponseEntity<List<Multa>> pagarMultas(@RequestBody Pessoa pessoa){
		if(pessoa == null) new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		List<Multa> multas = dao.pagarMulta(pessoa);
		if(multas == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Multa>>(multas, HttpStatus.OK);
	}

}
