package DaoTornillos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Ejercicio 3.1
 *  * 
 * @author: 
 * 
 **/

import java.util.List;

public class TornillosImpl implements Tornillos {

	@Override
	public Tornillo read(Integer referencia) {
		Tornillo t = new Tornillo();
		try {
			Connection conn=ConnectionH2.getDBConnection();
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM tornillo WHERE referencia =?");
			stm.setInt(1, referencia);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				t.setReferencia(referencia);
				t.setDiametro(rs.getInt("diametro"));
				t.setLongitud(rs.getInt("longitud"));
				t.setTipoDeRosca(rs.getString("TipoDeRosca"));
				t.setMaterial(rs.getString("material"));
				t.setTipoCabeza(rs.getString("tipoCabeza"));
				t.setEnStock(rs.getBoolean("enStock"));
				t.setStock(rs.getInt("stock"));
			}
			rs.close();
			conn.close();
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public void insert(Tornillo t) {
		try {
			Connection conn=ConnectionH2.getDBConnection();
			PreparedStatement stm1 = conn.prepareStatement ("INSERT INTO tornillo (referencia, diametro, longitud, TipoDeRosca, material, tipoCabeza, enStock, stock) VALUES (?,?,?,?,?,?,?,?)");
			stm1.setInt(1, t.getReferencia());
			stm1.setInt(2, t.getDiametro());
			stm1.setInt(3, t.getLongitud());
			stm1.setString(4, t.getTipoDeRosca());
			stm1.setString(5, t.getMaterial());
			stm1.setString(6, t.getTipoCabeza());
			stm1.setBoolean(7, t.isEnStock());
			stm1.setInt(8, t.getStock());
			stm1.executeUpdate();
			stm1.close();
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean update(Tornillo t) {
		boolean update = false;
		try {
			Connection conn=ConnectionH2.getDBConnection();
			PreparedStatement stm1 = conn.prepareStatement ("UPDATE tornillo SET diametro =? WHERE referencia = ?");
			stm1.setInt(1, t.getDiametro());
			stm1.setInt(2, t.getReferencia());
			
			stm1.executeUpdate();
			update = true;
			stm1.close();
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public boolean deleteByRef(Integer referencia) {
		boolean eliminar=false;	
		try {
			Connection conn=ConnectionH2.getDBConnection();
			PreparedStatement stm = conn.prepareStatement("DELETE FROM tornillo WHERE referencia= ?");
			stm.setInt(1, referencia);
			stm.executeUpdate();
	
			eliminar=true;
			stm.close();
			
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return eliminar;
	}

	@Override
	public List<Tornillo> findAll() {
		List<Tornillo> listaTornillos= new ArrayList<Tornillo>();
		try {
			Connection conn=ConnectionH2.getDBConnection();
			Statement stm=conn.createStatement();
			ResultSet rs= stm.executeQuery("SELECT * FROM tornillo");
			while (rs.next()) {
				Tornillo t=new Tornillo();
				t.setReferencia(rs.getInt("referencia"));
				t.setDiametro(rs.getInt("diametro"));
				t.setLongitud(rs.getInt("longitud"));
				t.setTipoDeRosca(rs.getString("TipoDeRosca"));
				t.setMaterial(rs.getString("material"));
				t.setTipoCabeza(rs.getString("tipoCabeza"));
				t.setEnStock(rs.getBoolean("enStock"));
				t.setStock(rs.getInt("stock"));
				listaTornillos.add(t);
			}
			stm.close();
			rs.close();
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return listaTornillos;
	}

	@Override
	public List<Tornillo> findByAttributes(String TipoDeRosca, String TipoCabeza) {
		List<Tornillo> listaTornillos= new ArrayList<Tornillo>();
		try {
			Connection conn=ConnectionH2.getDBConnection();
			PreparedStatement stm=conn.prepareStatement("SELECT * FROM tornillo WHERE TipoDeRosca = ? AND TipoCabeza = ?");
			stm.setString(1, TipoDeRosca);
			stm.setString(2, TipoCabeza);
			stm.executeUpdate();
			
			ResultSet rs= stm.executeQuery();
			while (rs.next()) {
				Tornillo t=new Tornillo();
				t.setReferencia(rs.getInt("referencia"));
				t.setDiametro(rs.getInt("diametro"));
				t.setLongitud(rs.getInt("longitud"));
				t.setTipoDeRosca(rs.getString("TipoDeRosca"));
				t.setMaterial(rs.getString("material"));
				t.setTipoCabeza(rs.getString("tipoCabeza"));
				t.setEnStock(rs.getBoolean("enStock"));
				t.setStock(rs.getInt("stock"));
				listaTornillos.add(t);
			}
			stm.close();
			rs.close();
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return listaTornillos;
	}

	@Override
	public boolean addStockByRef(Integer referencia, int stock) {
		Tornillo t = new Tornillo();
		try {
			Connection conn=ConnectionH2.getDBConnection();
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM tornillo WHERE referencia =?");
			stm.setInt(1, referencia);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				t.setReferencia(referencia);
				t.setDiametro(rs.getInt("diametro"));
				t.setLongitud(rs.getInt("longitud"));
				t.setTipoDeRosca(rs.getString("TipoDeRosca"));
				t.setMaterial(rs.getString("material"));
				t.setTipoCabeza(rs.getString("tipoCabeza"));
				t.setEnStock(rs.getBoolean("enStock"));
				t.setStock(rs.getInt("stock"));
			}
			rs.close();
			conn.close();
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
