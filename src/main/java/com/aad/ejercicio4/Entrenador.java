package com.aad.ejercicio4;

public class Entrenador {
	private int id_Entrenador;
	private String nombre;
	private String apellidos;
	private int edad;
	private Equipo equipo;

	public Entrenador() {
	}

	public Entrenador(int id_Entrenador, String nombre, String apellidos, int edad) {
		this.id_Entrenador = id_Entrenador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public int getId_Entrenador() {
		return id_Entrenador;
	}

	public void setId_Entrenador(int id_Entrenador) {
		this.id_Entrenador = id_Entrenador;
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

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Entrenador --> ID: " + id_Entrenador + ", Nombre: " + nombre + ", Apellidos: " + apellidos
				+ ", Edad: " + edad + "\n";
	}
}
