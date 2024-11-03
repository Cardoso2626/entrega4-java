package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.model.Peca;
import br.com.fiap.util.Conexao;

public class PecaDao {
	public void insert(Peca p) throws SQLException{
		Conexao c = new Conexao();
		String sql = "insert into t_porto_pecas(nm_peca, categoria_peca, marca_peca)" +
				     "values(?, ?, ?)";
		try(Connection con = c.getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"id_peca"});){

			pstmt.setString(1, p.getNome());
			pstmt.setString(2, p.getCategoria());
			pstmt.setString(3, p.getMarca());
	
			pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                p.setId(rs.getBigDecimal(1).longValue());
            }



        }
		catch(Exception e) {
			e.printStackTrace();
            throw e;
		}
	}
	
	public void altera(Peca p) throws Exception {
        String sql = "update t_porto_pecas set nm_peca=?, categoria_peca=?, marca_peca=?" +
                " where id_peca=?";
        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);)
        {
            pstmt.setString(1, p.getNome());
            pstmt.setString(2, p.getCategoria());
            pstmt.setString(3, p.getMarca());
            pstmt.setLong(4, p.getId());
            pstmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
	public Peca recuperaPecaPorId(Long id) throws Exception {
        String sql = "select id_peca, nm_peca, categoria_peca, marca_peca " +
                "from t_porto_pecas where id_peca=?";

        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);){

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Peca p = new Peca();
                p.setId(rs.getLong("id_peca"));
                p.setNome(rs.getString("nm_peca"));
                p.setCategoria(rs.getString("categoria_peca"));
                p.setMarca(rs.getString("marca_peca"));
                return p;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }
	
	 public void deleta(long id) throws Exception {
			String del = "delete from t_porto_pecas where id_peca=?";
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
