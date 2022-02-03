package com.aad.ejercicio4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class EquipoDAO_ implements EquipoDAO {
	
	public void insert(Equipo equipo, Entrenador entrenador, List<Competicion> competiciones) {
		try {			
			Connection conn=Conexion.conectar();
			PreparedStatement stm1 = conn.prepareStatement ("INSERT INTO equipo (nombre, fecha_fundacion, ciudad) VALUES (?,?,?)");
			stm1.setString(1, equipo.getNombre());
			stm1.setObject(2, equipo.getFecha_fundacion());
			stm1.setString(3, equipo.getCiudad());
			stm1.executeUpdate();
			stm1.close();
			
			entrenador.setEquipo(equipo);
			PreparedStatement stm2 = conn.prepareStatement ("INSERT INTO entrenador (nombre, apellidos, edad, id_equipo) VALUES (?,?,?,?)");
			stm2.setString(1, entrenador.getNombre());
			stm2.setString(2, entrenador.getApellidos());
			stm2.setInt(3, entrenador.getEdad());
			stm2.setInt(4, entrenador.getEquipo().getId_Equipo());
			stm2.executeUpdate();
			stm2.close();
			
			PreparedStatement stm3 = conn.prepareStatement ("INSERT INTO competicion (nombre, fechaInicio, cantidadPremio, id_equipo) VALUES (?,?,?,?)");
			for (Competicion competicion : competiciones) {
				competicion.setEquipo(equipo);
				stm3.setString(1, competicion.getNombre());
				stm3.setObject(2, competicion.getFechaInicio());
				stm3.setInt(3, competicion.getCantidadPremio());
				stm3.setInt(4, competicion.getEquipo().getId_Equipo());
				stm3.executeUpdate();
			}	
			stm3.close();	
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean update(Equipo equipo) {
		boolean update=false;		
		try {
			Connection conn=Conexion.conectar();
			PreparedStatement stm = conn.prepareStatement("UPDATE equipo SET nombre =? WHERE id_Equipo = ?");
			stm.setString(1, equipo.getNombre());
			stm.setInt(2, equipo.getId_Equipo());
			
			stm.executeUpdate();
			update=true;
			stm.close();
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return update;
	}

	@Override
	public boolean deleteById(Integer id) {
		boolean eliminar=false;	
		try {
			Connection conn=Conexion.conectar();
			
			PreparedStatement stm = conn.prepareStatement("DELETE FROM equipo WHERE id_Equipo= ?");
			stm.setInt(1, id);
			stm.executeUpdate();
			
			PreparedStatement stm2 = conn.prepareStatement("DELETE FROM entrenador WHERE id_Equipo= ?");
			stm2.setInt(1, id);
			stm2.executeUpdate();
			
			PreparedStatement stm3 = conn.prepareStatement("DELETE FROM jugador WHERE id_Equipo= ?");
			stm3.setInt(1, id);
			stm3.executeUpdate();
			
			PreparedStatement stm4 = conn.prepareStatement("DELETE FROM competicion WHERE id_Equipo= ?");
			stm4.setInt(1, id);
			stm4.executeUpdate();
	
			eliminar=true;
			stm.close();
			stm2.close();
			stm3.close();
			stm4.close();
			
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return eliminar;
	}
	
	public Equipo readEquipo(Integer id) {
		Equipo equipo = new Equipo();
		try {
			Connection conn=Conexion.conectar();
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM equipo WHERE id_Equipo =?");
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				equipo.setId_Equipo(id);
				equipo.setNombre(rs.getString("nombre"));
				equipo.setFecha_fundacion(rs.getDate("fecha_fundacion").toLocalDate());
				equipo.setCiudad(rs.getString("ciudad"));
			}
			rs.close();
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}
		return equipo;
	}

	@Override
	public Entrenador readEntrenador(Integer id_equipo) {
		Entrenador entrenador = new Entrenador();
		try {
			Connection conn=Conexion.conectar();
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM entrenador WHERE id_Equipo =?");
			stm.setInt(1, id_equipo);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				entrenador.setId_Entrenador(rs.getInt("id_entrenador"));
				entrenador.setNombre(rs.getString("nombre"));
				entrenador.setApellidos(rs.getString("apellidos"));
				entrenador.setEdad(rs.getInt("edad"));
			}
			rs.close();
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}
		return entrenador;
	}

	@Override
	public List<Jugador> readJugadores(Integer id_equipo) {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		try {
			Connection conn=Conexion.conectar();
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM jugador WHERE id_Equipo =?");
			stm.setInt(1, id_equipo);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Jugador jugador = new Jugador();
				jugador.setId_Jugador(rs.getInt("id_jugador"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setApellidos(rs.getString("apellidos"));
				jugador.setEdad(rs.getInt("edad"));
				jugador.setPosicion(rs.getString("posicion"));
				jugadores.add(jugador);
			}	
			rs.close();
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}
		return jugadores;
	}

	@Override
	public List<Competicion> readCompeticiones(Integer id_equipo) {
		List<Competicion> competiciones = new ArrayList<Competicion>();
		try {
			Connection conn=Conexion.conectar();
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM competicion WHERE id_Equipo =?");
			stm.setInt(1, id_equipo);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Competicion competicion = new Competicion();
				competicion.setId_Competicion(rs.getInt("id_competicion"));
				competicion.setNombre(rs.getString("nombre"));
				competicion.setFechaInicio((LocalDate) rs.getDate("fechaInicio").toLocalDate());
				competicion.setCantidadPremio(rs.getInt("cantidadPremio"));
				competiciones.add(competicion);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return competiciones;	
	}
	
	@Override
	public List<Equipo> findAll() {
		List<Equipo> listaEquipos= new ArrayList<Equipo>();
		try {
			Connection conn=Conexion.conectar();
			Statement stm=conn.createStatement();
			ResultSet rs= stm.executeQuery("SELECT * FROM equipo");
			while (rs.next()) {
				Equipo equipo=new Equipo();
				equipo.setId_Equipo(rs.getInt("id_Equipo"));
				equipo.setNombre(rs.getString("nombre"));
				equipo.setFecha_fundacion(rs.getDate("fecha_fundacion").toLocalDate());
				equipo.setCiudad(rs.getString("ciudad"));
				listaEquipos.add(equipo);
			}
			stm.close();
			rs.close();
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return listaEquipos;
	}

	@Override
	public void Batch(List<Jugador> jugadores, int id_Equipo) {
		try {
			Connection conn=Conexion.conectar();
			PreparedStatement stm3 = conn.prepareStatement ("INSERT INTO jugador (nombre, apellidos, edad, posicion, id_equipo) VALUES (?,?,?,?,?)");
			for (Jugador jugador : jugadores) {
				stm3.setString(1, jugador.getNombre());
				stm3.setString(2, jugador.getApellidos());
				stm3.setInt(3, jugador.getEdad());
				stm3.setString(4, jugador.getPosicion());
				stm3.setInt(5, id_Equipo);
				stm3.addBatch();
				stm3.executeBatch();
			}	
			stm3.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
