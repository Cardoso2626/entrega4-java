package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.model.Agendamento;
import br.com.fiap.model.Orcamento;
import br.com.fiap.util.Conexao;
import oracle.sql.DATE;

public class AgendamentoDao {
	public void insert(Agendamento a) throws SQLException{
		Conexao c = new Conexao();
		String sql = "insert into t_porto_agendamento(data_horario_agendamento, id_orcamento)" +
				     "values(?, ?)";
		try(Connection con = c.getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"id_agendamento"});){

			pstmt.setString(1, a.getDataHorario());
			pstmt.setLong(2, a.getOrcamento().getId());
			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				a.setId(rs.getBigDecimal(1).longValue());
			}

		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void altera(Agendamento ag) throws Exception {
        String sql = "update t_porto_agendamento set data_horario_agendamento=?, id_orcamento=?" +
                " where id_agendamento=?";
        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);)
        {
            pstmt.setString(1, ag.getDataHorario());
            pstmt.setLong(2, ag.getOrcamento().getId());
            pstmt.setLong(3, ag.getId());
            pstmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
	public Agendamento recuperaAgendamentoPorId(Long id) throws Exception {
	    String sql = "select id_agendamento, data_horario_agendamento, id_orcamento " +
	            "from t_porto_agendamento where id_agendamento=?";

	    try(Connection con = new Conexao().getConexao();
	        PreparedStatement pstmt = con.prepareStatement(sql);){

	        pstmt.setLong(1, id);
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            Agendamento ag = new Agendamento();
	            ag.setId(rs.getLong("id_agendamento"));
	            ag.setDataHorario(rs.getString("data_horario_agendamento"));

	            
	            OrcamentoDao orcamentoDao = new OrcamentoDao();
	            
	            long idOrcamento = rs.getLong("id_orcamento");
	            Orcamento orcamento = orcamentoDao.recuperaOrcamentoPorId(idOrcamento);  
	            ag.setOrcamento(orcamento);

	            return ag;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    }
	    return null;
	}

	
	
	
	 public void deleta(Long id) throws Exception {
			String del = "delete from t_porto_agendamento where id_agendamento=?";
			try(Connection con = new Conexao().getConexao();
					PreparedStatement pstmt = con.prepareStatement(del);) {

				pstmt.setLong(1, id);
				pstmt.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
		}


}
