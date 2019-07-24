package com.biblioteca.service;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.biblioteca.enums.SituacaoEnum;
import com.biblioteca.modelo.Emprestimo;
import com.biblioteca.modelo.Multa;
import com.biblioteca.modelo.Pessoa;
import com.biblioteca.util.Mensagem;
import com.biblioteca.util.SqlResources;

@Repository
public class EmprestimoDAO extends GenericDAO {
	
	public List<Emprestimo> processarEmprestimo(Emprestimo emprestimo){
		List<Emprestimo> response = new ArrayList<>();		
		try(CallableStatement ctsmt = getCon().prepareCall(SqlResources.getInstance().querieSql("procedureEmprestimo"))){			
			ctsmt.setInt(1, emprestimo.getLivro().getId());
			ctsmt.setInt(2, emprestimo.getPessoa().getId());
			ctsmt.setDate(3, new Date(emprestimo.getDataSaida().getTime()));
			ctsmt.registerOutParameter(4, Types.VARCHAR);			
		    ResultSet rs = ctsmt.executeQuery();
		    while(rs.next()){
		    	Emprestimo emp = new Emprestimo();
		    	emp.setMensagem(new Mensagem());
		    	emp.getMensagem().setMensagem(ctsmt.getString(4));		    	
		    	emp.setNomePessoa(rs.getString("p.nome"));
		    	emp.setTituloLivro(rs.getString("l.titulo"));
		    	emp.setSituacao(SituacaoEnum.valueOf(rs.getString("em.situacao")));
		    	emp.setDataSaida(rs.getDate("saida"));
		    	emp.setDataPrevDevolucao(rs.getDate("volta"));
		    	response.add(emp);
		    }			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {			
			fecharConexao(getCon());
		}		
		return response;
	}
	
	public Object processarDevolucao(Emprestimo emprestimo, Boolean multa){
		String mensagem = "";
		Multa mult = null;
		Object response = null;
		try(CallableStatement ctsmt = getCon().prepareCall(SqlResources.getInstance().querieSql("procedureDevolucao"))){			
			ctsmt.setInt(1, emprestimo.getId());						
		    ResultSet rs = ctsmt.executeQuery();
		    if(multa){
		    	rs.next();
		    	mult = new Multa();
		    	mult.setId(rs.getInt("id"));
		    	mult.setEmprestimoId(rs.getInt("id_emprestimo"));
		    	mult.setValor(rs.getBigDecimal("valor"));
		    	mult.setDataMulta(rs.getDate("data_multa"));
		    	mult.setSituacao(SituacaoEnum.valueOf(rs.getString("pago")));
		    	response = mult;
		    }else{		    	
		    	rs.next();
		    	mensagem = rs.getString("situacao");
		    	response = mensagem;
		    }
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {			
			fecharConexao(getCon());
		}		
		return response;
	}
	
	public List<Emprestimo> buscarEmprestimoPorLivroPessoaESituacao(Pessoa pessoa, String situacao) {
		Emprestimo emprestimo = null;
		List<Emprestimo> response = new ArrayList<>();
		try {
			this.pstm = getPreparedStatemaent(SqlResources.getInstance().querieSql("buscarEmprestimosAtivosPorPessoaELivro"));
			this.pstm.setInt(1, pessoa.getId());			
			this.pstm.setString(2, situacao);
			rs = this.pstm.executeQuery();
			while(rs.next()){
				emprestimo = new Emprestimo();
				emprestimo.setId(rs.getInt("id"));
				emprestimo.setNomePessoa(rs.getString("nome"));
				emprestimo.setTituloLivro(rs.getString("titulo"));
				emprestimo.setDataSaida(rs.getDate("saida"));
				emprestimo.setDataPrevDevolucao(rs.getDate("data_prev_devolucao"));
				emprestimo.setDataEntrega(rs.getDate("volta"));
				emprestimo.setSituacao(SituacaoEnum.valueOf(rs.getString("situacao")));
				response.add(emprestimo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao(con, pstm, rs);
		}
		return response;
	}
	

}
