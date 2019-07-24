package com.biblioteca.service;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.biblioteca.enums.SituacaoEnum;
import com.biblioteca.modelo.Multa;
import com.biblioteca.modelo.PagamentoMulta;
import com.biblioteca.modelo.Pessoa;
import com.biblioteca.util.SqlResources;

@Repository
public class MultaDAO extends GenericDAO {

	public List<Multa> pagarMulta(Pessoa pessoa) {
		Multa multa = null;
		List<Multa> response = new ArrayList<>();
		try (CallableStatement ctsmt = getCon()
				.prepareCall(SqlResources.getInstance().querieSql("procedurePagarMulta"))) {
			ctsmt.setInt(1, pessoa.getId());
			ResultSet rs = ctsmt.executeQuery();
			while (rs.next()) {
				multa = new Multa();
				multa.setDataMulta(rs.getDate("data_multa"));
				multa.setEmprestimoId(rs.getInt("id_emprestimo"));
				multa.setId(rs.getInt("id"));
				multa.setSituacao(SituacaoEnum.valueOf(rs.getString("pago")));
				multa.setValor(rs.getBigDecimal("valor"));
				response.add(multa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao(getCon());
		}
		return response;
	}

	public PagamentoMulta buscarMultaPorPessoa(Pessoa pessoa) {
		PagamentoMulta pagamento = null;
		try {
			this.pstm = getPreparedStatemaent(SqlResources.getInstance().querieSql("buscarMultaPorPessoa"));
			this.pstm.setInt(1, pessoa.getId());
			rs = this.pstm.executeQuery();
			rs.next();
			pagamento = new PagamentoMulta();
			pagamento.setNome(rs.getString("nome"));
			pagamento.setSituacao(SituacaoEnum.valueOf(rs.getString("pago")));
			pagamento.setValorTotal(rs.getBigDecimal("valor_somado"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao(con, pstm, rs);
		}
		return pagamento;
	}

}
