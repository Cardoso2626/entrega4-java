package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.model.ItemVenda;
import br.com.fiap.util.Conexao;

public class ItemVendaDao {
	public void insert(ItemVenda iV) throws SQLException{
		Conexao c = new Conexao();
		String sql = "insert into t_porto_item_venda(qnt_item_venda, valor_item_venda)" +
				     "values(?, ?)";
		try(Connection con = c.getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"id_item_venda"});){

			pstmt.setInt(1, iV.getQuantidade());
			pstmt.setDouble(2, iV.getValor());
			pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                iV.setId(rs.getBigDecimal(1).longValue());
            }


        }
		catch(Exception e) {
			e.printStackTrace();
            throw e;
		}
	}
	
	public void altera(ItemVenda iv) throws Exception {
        String sql = "update t_porto_item_venda set qnt_item_venda=?, valor_item_venda=?" +
                " where id_item_venda=?";
        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);)
        {
            pstmt.setInt(1, iv.getQuantidade());
            pstmt.setDouble(2, iv.getValor());
            pstmt.setLong(3, iv.getId());
            pstmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
	public ItemVenda recuperaItemVendaPorId(Long id) throws Exception {
        String sql = "select id_item_venda, qnt_item_venda, valor_item_venda " +
                "from t_porto_item_venda where id_item_venda=?";

        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);){

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                ItemVenda i = new ItemVenda();
                i.setId(rs.getLong("id_item_venda"));
                i.setQuantidade(rs.getInt("qnt_item_venda"));
                i.setValor(rs.getDouble("valor_item_venda"));       
                return i;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }
	
	 public void deleta(long id) throws Exception {
			String del = "delete from t_porto_item_venda where id_item_venda=?";
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
