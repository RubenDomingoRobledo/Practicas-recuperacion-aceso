package com.aad.ejercicio4;

import java.time.LocalDate;
import java.util.List;

public class Equipo {
	private int id_Equipo;
	private String nombre;
	private LocalDate fecha_fundacion;
	private String ciudad;
	private Entrenador entrenador;
	private List<Jugador> jugadores;
	private List<Competicion> competicion;
	
	public Equipo() {
	}

	public Equipo(int id_Equipo, String nombre, LocalDate fecha_fundacion, String ciudad) {
		super();
		this.id_Equipo = id_Equipo;
		this.nombre = nombre;
		this.fecha_fundacion = fecha_fundacion;
		this.ciudad = ciudad;
	}

	public int getId_Equipo() {
		return id_Equipo;
	}

	public void setId_Equipo(int id_Equipo) {
		this.id_Equipo = id_Equipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha_fundacion() {
		return fecha_fundacion;
	}

	public void setFecha_fundacion(LocalDate fecha_fundacion) {
		this.fecha_fundacion = fecha_fundacion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public void addJugador(Jugador jugador) {
		this.jugadores.add(jugador);
	}
	
	public List<Competicion> getCompeticion() {
		return competicion;
	}

	public void setCompeticion(List<Competicion> competicion) {
		this.competicion = competicion;
	}
	
	public void addCompeticion(Competicion competicion) {
		this.competicion.add(competicion);
	}
	@Override
	public String toString() {
		return "Equipo --> ID: " + id_Equipo + ", Nombre: " + nombre + ", Fecha de fundacion: " + fecha_fundacion
				+ ", Ciudad: " + ciudad + "\n";
	}
}
