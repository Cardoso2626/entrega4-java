package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.model.Endereco;
import br.com.fiap.util.Conexao;

public class EnderecoDao {
	public void insert(Endereco en) throws SQLException{
		Conexao c = new Conexao();
		String sql = "insert into t_porto_endereco(cep, rua, numero, cidade, estado) " +
				     "values(?, ?, ?, ?, ?)";
		try(Connection con = c.getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"id_endereco"});){

			pstmt.setString(1, en.getCep());
			pstmt.setString(2, en.getRua());
			pstmt.setInt(3, en.getNumero());
			pstmt.setString(4, en.getCidade());
			pstmt.setString(5, en.getEstado());
			pstmt.executeUpdate();


            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                en.setId(rs.getBigDecimal(1).longValue());
            }
			
		}
		catch(Exception e) {
			e.printStackTrace();
            throw e;
		}
	}
	
	public void altera(Endereco en) throws Exception {
        String sql = "update t_porto_endereco set cep=?, rua=?, numero=?, cidade=?, estado=?" +
                " where id_endereco=?";
        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);){
            pstmt.setString(1, en.getCep());
            pstmt.setString(2, en.getRua());
            pstmt.setInt(3, en.getNumero());
            pstmt.setString(4, en.getCidade());
            pstmt.setString(5, en.getEstado());
            pstmt.setLong(6, en.getId());
            pstmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
	public Endereco recuperaEnderecoPorId(Long id) throws SQLException {
        String sql = "select id_endereco, cep, rua, numero, cidade, estado " +
                "from t_porto_endereco where id_endereco=?";

        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);){

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Endereco en = new Endereco();
                en.setId(rs.getLong("id_endereco"));
                en.setCep(rs.getString("cep"));
                en.setRua(rs.getString("rua"));
                en.setNumero(rs.getInt("numero"));
                en.setCidade(rs.getString("cidade"));
                en.setEstado(rs.getString("estado"));
                return en;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }
	
	 public void deleta(Long id) throws Exception {
			String del = "delete from t_porto_endereco where id_endereco=?";
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
