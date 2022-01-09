package com.aad.ejercicio4;

import java.util.List;

public interface EquipoDAO {
	public void insert(Equipo equipo, Entrenador entrenador, List<Competicion> competiciones);
	public boolean update(Equipo equipo);
	public boolean deleteById(Integer id);
	public Equipo readEquipo(Integer id_equipo);
	public Entrenador readEntrenador(Integer id_equipo);
	public List<Jugador> readJugadores(Integer id_equipo);
	public List<Competicion> readCompeticiones(Integer id_equipo);
	public List<Equipo> findAll();
	public void Batch (List<Jugador>jugadores, int id_Equipo);
}
