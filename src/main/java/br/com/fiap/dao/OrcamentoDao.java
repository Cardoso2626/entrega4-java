package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.model.Oficina;
import br.com.fiap.model.Orcamento;
import br.com.fiap.model.Usuario;
import br.com.fiap.util.Conexao;

public class OrcamentoDao {
	
	
	public void insert(Orcamento o) throws SQLException{
		Conexao c = new Conexao();
		String sql = "insert into t_porto_orcamento(dt_compra, valor_total, id_oficina, id_usuario)" +
				     "values(?, ?, ?, ?)";
		try(Connection con = c.getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"id_orcamento"});){

			pstmt.setDate(1, Date.valueOf(o.getData()));
			pstmt.setDouble(2, o.getValorTotal());
			pstmt.setLong(3, o.getOficina().getId());
			pstmt.setLong(4, o.getUsuario().getId());
			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				o.setId(rs.getBigDecimal(1).longValue());
			}



		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void altera(Orcamento o) throws Exception {
        String sql = "update t_porto_orcamento set dt_compra=?, valor_total=?, id_oficina=?, id_usuario=?" +
                " where id_orcamento=?";
        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);)
        {
            pstmt.setDate(1, Date.valueOf(o.getData()));
            pstmt.setDouble(2, o.getValorTotal());
            pstmt.setLong(3, o.getOficina().getId());
            pstmt.setLong(4, o.getUsuario().getId());
            pstmt.setLong(5, o.getId());
            pstmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
	
	public Orcamento recuperaOrcamentoPorId(Long id) throws Exception {
	    String sql = "select id_orcamento, dt_compra, valor_total, id_oficina, id_usuario " +
	            "from t_porto_orcamento where id_orcamento=?";

	    try (Connection con = new Conexao().getConexao();
	         PreparedStatement pstmt = con.prepareStatement(sql)) {

	        pstmt.setLong(1, id);
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            Orcamento o = new Orcamento();
	            o.setId(rs.getLong("id_orcamento"));
	            o.setData(rs.getDate("dt_compra").toLocalDate());
	            o.setValorTotal(rs.getDouble("valor_total"));

	            
	            OficinaDao oficinaDao = new OficinaDao();
	            UsuarioDao usuarioDao = new UsuarioDao();

	           
	            long idOficina = rs.getLong("id_oficina");
	            Oficina oficina = oficinaDao.recuperaOficinaPorId(idOficina);
	            o.setOficina(oficina);

	        
	            long idUsuario = rs.getLong("id_usuario");
	            Usuario usuario = usuarioDao.recuperaUsuarioPorId(idUsuario); 
	            o.setUsuario(usuario);
	            return o;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    }
	    return null;
	}


	 public void deleta(long id) throws Exception {
			String del = "delete from t_porto_orcamento where id_orcamento=?";
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
