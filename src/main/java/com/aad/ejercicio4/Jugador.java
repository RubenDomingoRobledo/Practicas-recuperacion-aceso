package com.aad.ejercicio4;

public class Jugador {
	private int id_Jugador;
	private String nombre;
	private String apellidos;
	private int edad;
	private String posicion;
	private Equipo equipo;
	
	public Jugador() {
	}
	
	public Jugador(String nombre, String apellidos, int edad, String posicion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.posicion = posicion;
	}

	public int getId_Jugador() {
		return id_Jugador;
	}

	public void setId_Jugador(int id_Jugador) {
		this.id_Jugador = id_Jugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Jugador --> ID: " + id_Jugador + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Edad: "
				+ edad + ", Posicion: " + posicion + "\n";
	}
}
