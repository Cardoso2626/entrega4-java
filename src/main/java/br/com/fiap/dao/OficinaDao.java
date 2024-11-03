package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.model.Oficina;
import br.com.fiap.util.Conexao;

public class OficinaDao {
	public void insert(Oficina o) throws SQLException{
		Conexao c = new Conexao();
		String sql = "insert into t_porto_oficina(cnpj_oficina, nm_oficina, tel_oficina, especialidade_oficina, email_oficina)" +
				     "values(?, ?, ?, ?, ?)";
		try(Connection con = c.getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"id_oficina"});){

			pstmt.setString(1, o.getCnpj());
			pstmt.setString(2, o.getNome());
			pstmt.setString(3, o.getTelefone());
			pstmt.setString(4, o.getEspecialidade());
			pstmt.setString(5, o.getEmail());
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
	
	public void altera(Oficina o) throws Exception {
        String sql = "update t_porto_oficina set cnpj_oficina=?, nm_oficina=?, tel_oficina=?, especialidade_oficina=?, email_oficina=?" +
                " where id_oficina=?";
        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);)
        {
            pstmt.setString(1, o.getCnpj());
            pstmt.setString(2, o.getNome());
            pstmt.setString(3, o.getTelefone());
            pstmt.setString(4, o.getEspecialidade());
            pstmt.setString(5, o.getEmail());
            pstmt.setLong(6, o.getId());
            pstmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
	public Oficina recuperaOficinaPorId(Long id) throws Exception {
        String sql = "select id_oficina, cnpj_oficina, nm_oficina, tel_oficina, especialidade_oficina, email_oficina " +
                "from t_porto_oficina where id_oficina=?";

        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);){

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Oficina o = new Oficina();
                o.setId(rs.getLong("id_oficina"));
                o.setCnpj(rs.getString("cnpj_oficina"));
                o.setNome(rs.getString("nm_oficina"));
                o.setTelefone(rs.getString("tel_oficina"));
                o.setEspecialidade(rs.getString("especialidade_oficina"));
                o.setEmail(rs.getString("email_oficina"));
                return o;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }
	
	 public void deleta(Long id) throws Exception {
			String del = "delete from t_porto_oficina where id_oficina=?";
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
