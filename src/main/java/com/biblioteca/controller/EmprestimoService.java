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

import com.biblioteca.enums.SituacaoEnum;
import com.biblioteca.modelo.Emprestimo;
import com.biblioteca.modelo.Multa;
import com.biblioteca.modelo.Pessoa;
import com.biblioteca.service.EmprestimoDAO;
import com.biblioteca.util.DataUtil;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmprestimoService {

	@Autowired
	private EmprestimoDAO dao;
	
	@RequestMapping(path="emprestimo/pesquisar", method=RequestMethod.POST)
	public ResponseEntity<List<Emprestimo>> buscarEmprestimos(@RequestBody Pessoa pl){
		if(pl == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		List<Emprestimo> emprestimos = dao.
				buscarEmprestimoPorLivroPessoaESituacao(pl, SituacaoEnum.A.toString());	
		
		if(emprestimos == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		return new ResponseEntity<List<Emprestimo>>(emprestimos, HttpStatus.OK);		
	}
	
	@RequestMapping(path="emprestimo/emprestar", method=RequestMethod.POST)
	public ResponseEntity<List<Emprestimo>> emprestar(@RequestBody Emprestimo emprestimo){
		if(emprestimo == null) 
			new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		List<Emprestimo> emprestimos = dao.processarEmprestimo(emprestimo);
		if(emprestimos == null)
			new ResponseEntity<>(HttpStatus.NOT_FOUND);		
		return new ResponseEntity<>(emprestimos,HttpStatus.OK);
	}
	
	@RequestMapping(path="emprestimo/devolucao", method=RequestMethod.POST)
	public ResponseEntity<Object> devolucao(@RequestBody Emprestimo emprestimo){
		if(emprestimo == null) new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		Boolean multa = DataUtil.verificarSeLivroEstaAtrazado(emprestimo.getDataPrevDevolucao());		
		Object processoDevolucao = dao.processarDevolucao(emprestimo, multa);
		if(processoDevolucao == null) new ResponseEntity<>(HttpStatus.NOT_FOUND);
		if(multa)
			return new ResponseEntity<Object>((Multa) processoDevolucao, HttpStatus.OK);
		else
			return new ResponseEntity<Object>((String) processoDevolucao, HttpStatus.OK);
	}
	
	
	
}
