package com.biblioteca.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biblioteca.enums.SituacaoEnum;
import com.biblioteca.modelo.Pessoa;
import com.biblioteca.util.Mensagem;
import com.biblioteca.util.SqlResources;

@Repository
public class PessoaDAO extends GenericDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(PessoaDAO.class);
	
	@Autowired
	private Mensagem mensagem;
	
	public Mensagem salvar(Pessoa pessoa){		
		try {
			this.pstm = getPreparedStatemaent(SqlResources.getInstance().querieSql("inserirPessoa"));			
			this.pstm.setString(1, pessoa.getNome());
			this.pstm.setString(2, pessoa.getEndereco());			
			this.pstm.execute();			
			mensagem.setMensagem("Sucesso ao salvar!");			
		} catch (SQLException e) {
			mensagem.setMensagem("Falha ao salvar ");
		} finally {
			fecharConexao(con, pstm);
		}
		return mensagem;
	}
	
	public Mensagem alterar(Pessoa pessoa){		
		try {
			this.pstm = getPreparedStatemaent(SqlResources.getInstance().querieSql("atualizarPessoa"));			
			this.pstm.setString(1, pessoa.getNome());
			this.pstm.setString(2, pessoa.getEndereco());
			this.pstm.setString(3, pessoa.getSituacao().toString());
			this.pstm.setInt(4, pessoa.getId());
			this.pstm.execute();			
			mensagem.setMensagem("Sucesso ao alterar!");			
		} catch (SQLException e) {
			mensagem.setMensagem("Falha ao alterar ");
		} finally {
			fecharConexao(con, pstm);
		}
		return mensagem;
	}
	
	public Mensagem excluir(Integer id){		
		try {
			this.pstm = getPreparedStatemaent(SqlResources.getInstance().querieSql("deletePessoa"));
			this.pstm.setInt(1, id);
			this.pstm.executeUpdate();
			mensagem.setMensagem("sucesso ao excluir");			
		} catch (SQLException e) {
			mensagem.setMensagem(e.getMessage());
		}finally {
			fecharConexao(con, pstm);
		}
		return mensagem;
	}

	public List<Pessoa> listar(int inicio, int quantidade) {
		Pessoa pessoa = null;
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			this.pstm = getPreparedStatemaent(SqlResources.getInstance().querieSql("buscarTodasPessoas",inicio, quantidade));
			this.rs = this.pstm.executeQuery();
			
			while (rs.next()) {
				pessoa = new Pessoa();
				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setEndereco(rs.getString("endereco"));
				pessoa.setSituacao(SituacaoEnum.valueOf(rs.getString("situacao")));
				pessoas.add(pessoa);
			}
			
		} catch (SQLException e) {
			logger.error("Ocorreu erro SQL: ",e.getMessage());
			e.printStackTrace();
		} finally {
			fecharConexao(con, pstm, rs);
		}
		return pessoas;
	}

	public Pessoa buscarPessoaCodigo(int codigo) {
		Pessoa pessoa = null;
		try {
			this.pstm = getPreparedStatemaent(SqlResources.getInstance().querieSql("buscarPessoaPorId"));
			this.pstm.setInt(1, codigo);
			rs = this.pstm.executeQuery();
			rs.next();
			pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setEndereco(rs.getString("endereco"));
			pessoa.setSituacao(SituacaoEnum.valueOf(rs.getString("situacao")));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao(con, pstm, rs);
		}
		return pessoa;
	}
	
	public Pessoa buscarPessoaNome(String nome) {
		Pessoa pessoa = null;
		String novoNome = "%"+nome+"%";
		try {
			this.pstm = getPreparedStatemaent(SqlResources.getInstance().querieSql("buscarPessoaPorNome"));
			this.pstm.setString(1, novoNome);
			rs = this.pstm.executeQuery();
			rs.next();
			pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setEndereco(rs.getString("endereco"));
			pessoa.setSituacao(SituacaoEnum.valueOf(rs.getString("situacao")));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao(con, pstm, rs);
		}
		return pessoa;
	}


}
