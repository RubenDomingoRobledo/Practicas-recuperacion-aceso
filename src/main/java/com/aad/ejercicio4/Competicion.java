package com.aad.ejercicio4;

import java.time.LocalDate;

public class Competicion {
	private int id_Competicion;
	private String nombre;
	private LocalDate fechaInicio;
	private int cantidadPremio;
	private Equipo equipo;
	
	public Competicion() {
	}

	public Competicion(String nombre, LocalDate fechaInicio, int cantidadPremio) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.cantidadPremio = cantidadPremio;
	}
	
	public int getId_Competicion() {
		return id_Competicion;
	}

	public void setId_Competicion(int id_Competicion) {
		this.id_Competicion = id_Competicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getCantidadPremio() {
		return cantidadPremio;
	}

	public void setCantidadPremio(int cantidadPremio) {
		this.cantidadPremio = cantidadPremio;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Competicion --> ID: " + id_Competicion + ", Nombre: " + nombre + ", Fecha de Inicio: " + fechaInicio
				+ ", Cantidad de Premio: " + cantidadPremio + "\n";
	}
}
