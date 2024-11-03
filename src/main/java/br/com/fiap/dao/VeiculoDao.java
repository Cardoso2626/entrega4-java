package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.model.Usuario;
import br.com.fiap.model.Veiculo;
import br.com.fiap.util.Conexao;

public class VeiculoDao {
	public void insert(Veiculo v) throws SQLException{
		Conexao c = new Conexao();
		String sql = "insert into t_porto_veiculo(placa_veiculo, montadora_veiculo, modelo_veiculo, ano_fabricacao_veiculo, tipo_veiculo, id_usuario)" +
				     "values(?, ?, ?, ?, ?, ?)";

		try(Connection con = c.getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"id_veiculo"});){
			pstmt.setString(1, v.getPlaca());
			pstmt.setString(2, v.getMontadora());
			pstmt.setString(3, v.getModelo());
			pstmt.setInt(4, v.getAnoFabricacao());
			pstmt.setString(5, v.getTipo());
			pstmt.setLong(6, v.getUsuario().getId());
			pstmt.executeUpdate();


			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				v.setId(rs.getBigDecimal(1).longValue());
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;

		}
	}
	
	
	public void altera(Veiculo v) throws Exception {
        String sql = "update t_porto_veiculo set placa_veiculo=?, montadora_veiculo=?, modelo_veiculo=?, ano_fabricacao_veiculo=?, tipo_veiculo=?, id_usuario=?" +
                " where id_veiculo=?";
        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);)
        {
        	pstmt.setString(1, v.getPlaca());
			pstmt.setString(2, v.getMontadora());
			pstmt.setString(3, v.getModelo());
			pstmt.setInt(4, v.getAnoFabricacao());
			pstmt.setString(5, v.getTipo());
			pstmt.setLong(6, v.getUsuario().getId());
			pstmt.setLong(7, v.getId());
			pstmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
	public Veiculo recuperaVeiculoPorId(Long id) throws Exception {
        String sql = "select id_veiculo, placa_veiculo, montadora_veiculo, modelo_veiculo, ano_fabricacao_veiculo, tipo_veiculo, id_usuario " +
                "from t_porto_veiculo where id_veiculo=?";

        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);){

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Veiculo v = new Veiculo();
                v.setId(rs.getLong("id_veiculo"));
                v.setPlaca(rs.getString("placa_veiculo"));
                v.setMontadora(rs.getString("montadora_veiculo"));
                v.setModelo(rs.getString("modelo_veiculo"));
                v.setAnoFabricacao(rs.getInt("ano_fabricacao_veiculo"));
                v.setTipo(rs.getString("tipo_veiculo"));
                
                UsuarioDao usuarioDao = new UsuarioDao();
                
                long idUsuario = rs.getLong("id_usuario");
                Usuario usuario = usuarioDao.recuperaUsuarioPorId(idUsuario);
                v.setUsuario(usuario);
                return v;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }
	
	 public void deleta(Long id) throws Exception {
			String del = "delete from t_porto_veiculo where id_veiculo=?";
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
