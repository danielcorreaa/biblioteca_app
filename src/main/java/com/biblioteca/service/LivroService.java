package com.biblioteca.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biblioteca.enums.SituacaoEnum;
import com.biblioteca.modelo.Livro;
import com.biblioteca.util.Mensagem;
import com.biblioteca.util.SqlResources;

@Repository
public class LivroService extends GenericDAO{
	
	@Autowired
	private Mensagem mensagem;
	
	public Mensagem salvar(Livro livro){		
		try {
			this.pstm = getPreparedStatemaent(SqlResources.getInstance().querieSql("inserirLivro"));			
			this.pstm.setString(1, livro.getTitulo());
			this.pstm.setString(2, livro.getEditora());	
			this.pstm.setDate(3, new Date(livro.getDataLancamento().getTime()) );
			this.pstm.execute();			
			mensagem.setMensagem("Sucesso ao salvar!");			
		} catch (SQLException e) {
			mensagem.setMensagem("Falha ao salvar ");
		} finally {
			fecharConexao(con, pstm);
		}
		return mensagem;
	}
	
	public Mensagem alterar(Livro livro){		
		try {
			this.pstm = getPreparedStatemaent(SqlResources.getInstance().querieSql("atualizarLivro"));			
			this.pstm.setString(1, livro.getTitulo());
			this.pstm.setString(2, livro.getEditora());
			this.pstm.setDate(3, new Date(livro.getDataLancamento().getTime()));
			this.pstm.setString(4, livro.getSituacao().toString());
			this.pstm.setInt(5, livro.getId());
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
			this.pstm = getPreparedStatemaent(SqlResources.getInstance().querieSql("deleteLivro"));
			this.pstm.setInt(1, id);
			this.pstm.executeUpdate();
			mensagem.setMensagem("sucesso ao excluir - codigo retorno");			
		} catch (SQLException e) {
			mensagem.setMensagem(e.getMessage());
		}finally {
			fecharConexao(con, pstm);
		}
		return mensagem;
	}

	public List<Livro> listar(int inicio, int quantidade) {
		Livro livro = null;
		List<Livro> livros = new ArrayList<Livro>();
		try {
			this.pstm = getPreparedStatemaent(SqlResources.getInstance().querieSql("buscarTodosLivros", inicio, quantidade));
			this.rs = this.pstm.executeQuery();
			while (rs.next()) {
				livro = new Livro();
				livro.setId(rs.getInt("id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setEditora(rs.getString("editora"));
				livro.setDataLancamento(rs.getDate("data_lancamento"));
				livro.setSituacao(SituacaoEnum.valueOf(rs.getString("situacao")));
				livros.add(livro);			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao(con, pstm, rs);
		}
		return livros;
	}

	public Livro buscarLivroCodigo(int codigo) {
		Livro livro = null;
		try {
			this.pstm = getPreparedStatemaent(SqlResources.getInstance().querieSql("buscarLivroPorId"));
			this.pstm.setInt(1, codigo);
			rs = this.pstm.executeQuery();
			rs.next();
			livro = new Livro();
			livro.setId(rs.getInt("id"));
			livro.setTitulo(rs.getString("titulo"));
			livro.setEditora(rs.getString("editora"));
			livro.setDataLancamento(rs.getDate("data_lancamento"));
			livro.setSituacao(SituacaoEnum.valueOf(rs.getString("situacao")));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao(con, pstm, rs);
		}
		return livro;
	}
	
	public Livro buscarLivroNome(String nome) {
		Livro livro = null;
		String novoNome = "%"+nome+"%";
		try {
			this.pstm = getPreparedStatemaent(SqlResources.getInstance().querieSql("buscarLivroPorNome"));
			this.pstm.setString(1, novoNome);
			rs = this.pstm.executeQuery();
			rs.next();
			livro = new Livro();
			livro.setId(rs.getInt("id"));
			livro.setTitulo(rs.getString("titulo"));
			livro.setEditora(rs.getString("editora"));
			livro.setDataLancamento(rs.getDate("data_lancamento"));
			livro.setSituacao(SituacaoEnum.valueOf(rs.getString("situacao")));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao(con, pstm, rs);
		}
		return livro;
	}


}
