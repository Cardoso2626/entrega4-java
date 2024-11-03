package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.model.Usuario;

import br.com.fiap.util.Conexao;

public class UsuarioDao {
	public void insert(Usuario u) throws SQLException{
		Conexao c = new Conexao();
		String sql = "insert into t_porto_usuario(nm_usuario, cpf_usuario, tel_usuario, email_usuario)" +
				     "values(?, ?, ?, ?)";
		try(Connection con = c.getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"id_usuario"});){
			

			pstmt.setString(1, u.getNome());
			pstmt.setString(2, u.getCpf());
			pstmt.setString(3, u.getTelefone());
			pstmt.setString(4, u.getEmail());
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                u.setId(rs.getBigDecimal(1).longValue());
            }			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void altera(Usuario u) throws Exception {
        String sql = "update t_porto_usuario set nm_usuario=?, cpf_usuario=?, tel_usuario=?, email_usuario=?" +
                " where id_usuario=?";
        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);)
        {
            pstmt.setString(1, u.getNome());
            pstmt.setString(2, u.getCpf());
            pstmt.setString(3, u.getTelefone());
            pstmt.setString(4, u.getEmail());
            pstmt.setLong(5, u.getId());
            pstmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
	public Usuario recuperaUsuarioPorId(Long id) throws Exception {
        String sql = "select id_usuario, nm_usuario, cpf_usuario, tel_usuario, email_usuario " +
                "from t_porto_usuario where id_usuario=?";

        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);){

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getLong("id_usuario"));
                u.setNome(rs.getString("nm_usuario"));
                u.setCpf(rs.getString("cpf_usuario"));
                u.setTelefone(rs.getString("tel_usuario"));
                u.setEmail(rs.getString("email_usuario"));
                return u;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }
	
	 public void deleta(Long id) throws Exception {
			String del = "delete from t_porto_usuario where id_usuario=?";
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
