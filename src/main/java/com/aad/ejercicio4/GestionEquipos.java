package com.aad.ejercicio4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestionEquipos {
	public static void main(String[] args) {	    
	    try {
	    	Connection conn = Conexion.conectar();
            Statement stmnt = conn.createStatement();
            //Creacion de tablas
            stmnt.execute("DROP TABLE IF EXISTS equipo");
		    stmnt.execute("CREATE TABLE aadu2.equipo ("
		    		+ "id_equipo MEDIUMINT NOT NULL AUTO_INCREMENT,"
		    		+ "nombre varchar(50),"
		    		+ "fecha_fundacion DATE,"
		    		+ "ciudad varchar(50),"
		    		+ "PRIMARY KEY (id_equipo));");
		    
		    System.out.println("Tabla equipo creada");
		    
		    stmnt.execute("DROP TABLE IF EXISTS entrenador");
		    stmnt.execute("CREATE TABLE aadu2.entrenador ("
		    		+ "id_entrenador MEDIUMINT NOT NULL AUTO_INCREMENT,"
		    		+ "nombre varchar(50),"
		    		+ "apellidos varchar(50),"
		    		+ "edad TINYINT,"
		    		+ "id_equipo MEDIUMINT references equipo(id_equipo),"
		    		+ "PRIMARY KEY (id_entrenador));");
		    
		    System.out.println("Tabla entrenador creada");
		    
		    stmnt.execute("DROP TABLE IF EXISTS jugador");
		    stmnt.execute("CREATE TABLE aadu2.jugador ("
		    		+ "id_jugador MEDIUMINT NOT NULL AUTO_INCREMENT,"
		    		+ "nombre varchar(50),"
		    		+ "apellidos varchar(50),"
		    		+ "edad TINYINT,"
		    		+ "posicion varchar(50),"
		    		+ "id_equipo MEDIUMINT references equipo(id_equipo),"
		    		+ "PRIMARY KEY (id_jugador));");
		    
		    System.out.println("Tabla jugador creada");
		    
		    stmnt.execute("DROP TABLE IF EXISTS competicion");
		    stmnt.execute("CREATE TABLE aadu2.competicion ("
		    		+ "id_competicion MEDIUMINT NOT NULL AUTO_INCREMENT,"
		    		+ "nombre varchar(50),"
		    		+ "fechaInicio DATE,"
		    		+ "cantidadPremio INT,"
		    		+ "id_equipo MEDIUMINT references equipo(id_equipo),"
		    		+ "PRIMARY KEY (id_competicion));");
		    
		    System.out.println("Tabla competicion creada");
		    
		    //Entrenadores
		    Entrenador entrenador1 = new Entrenador(1, "Carlo", "Ancelotti", 62);
		    Entrenador entrenador2 = new Entrenador(2, "Xavi", "Hernandez", 41);
		    Entrenador entrenador3 = new Entrenador(3, "Diego Pablo", "Simeone", 51);
		    
		    //Jugadores
		    Jugador jugador1_1 = new Jugador("David", "Alaba", 29, "Defensa");
			Jugador jugador1_2 = new Jugador("Luka", "Modric", 36, "Mediocentro");
			Jugador jugador1_3 = new Jugador("Vinicius", "Junior", 21, "Delantero");
			Jugador jugador1_4 = new Jugador("Karim", "Benzema", 34, "Delantero");
			
			List<Jugador> jugadores1 = new ArrayList<Jugador>();
			jugadores1.add(jugador1_1);
			jugadores1.add(jugador1_2);
			jugadores1.add(jugador1_3);
			jugadores1.add(jugador1_4);
		
			Jugador jugador2_1 = new Jugador("Gerard", "Pique", 34, "Defensa");
			Jugador jugador2_2 = new Jugador("Frenkie", "De Jong", 24, "Mediocentro");
			Jugador jugador2_3 = new Jugador("Pablo", "Gavi", 17, "Mediocentro");
			Jugador jugador2_4 = new Jugador("Memphis", "Depay", 27, "Delantero");
		
			List<Jugador> jugadores2 = new ArrayList<Jugador>();
			jugadores2.add(jugador2_1);
			jugadores2.add(jugador2_2);
			jugadores2.add(jugador2_3);
			jugadores2.add(jugador2_4);
			
			Jugador jugador3_1 = new Jugador("Jose Maria", "Giménez", 26, "Defensa");
			Jugador jugador3_2 = new Jugador("Marcos", "Llorente", 26, "Mediocentro");
			Jugador jugador3_3 = new Jugador("Yannick", "Carrasco", 28, "Mediocentro");
			Jugador jugador3_4 = new Jugador("Luis", "Suárez", 34, "Delantero");
		
			List<Jugador> jugadores3 = new ArrayList<Jugador>();
			jugadores3.add(jugador3_1);
			jugadores3.add(jugador3_2);
			jugadores3.add(jugador3_3);
			jugadores3.add(jugador3_4);
			
			//Competiciones
			Competicion competicion1 = new Competicion("La Liga Santander", LocalDate.of(2021, 8, 13), 60000000);
	        Competicion competicion2 = new Competicion("Champions League", LocalDate.of(2021, 9, 14), 82000000);
	        Competicion competicion3 = new Competicion("Copa Del Rey", LocalDate.of(2021, 11, 17), 40000000);
	        
	        List<Competicion> competiciones1 = new ArrayList<Competicion>();
	        competiciones1.add(competicion1);
	        competiciones1.add(competicion2);
	        competiciones1.add(competicion3);
	        
	        List<Competicion> competiciones2 = new ArrayList<Competicion>();
	        competiciones2.add(competicion1);
	        competiciones2.add(competicion3);
	        
	        List<Competicion> competiciones3 = new ArrayList<Competicion>();
	        competiciones3.add(competicion1);
	        competiciones3.add(competicion2);
	        
	        //Equipos
		    Equipo equipo1 = new Equipo(1, "Real Madrdid", LocalDate.of(1902, 3, 6), "Madrid");
		    Equipo equipo2 = new Equipo(2, "FC Barcelona", LocalDate.of(1899, 11, 29), "Barcelona");
		    Equipo equipo3 = new Equipo(3, "Atletico de Madrid", LocalDate.of(1903, 4, 26), "Madrid");
		    

		    EquipoDAO_ dao = new EquipoDAO_();
		    System.out.println("\n1. Insertar Equipos");
			dao.insert(equipo1, entrenador1, competiciones1);
			dao.insert(equipo2, entrenador2, competiciones2);
			dao.insert(equipo3, entrenador3, competiciones3);
			dao.Batch(jugadores1, 1);
			dao.Batch(jugadores2, 2);
			dao.Batch(jugadores3, 3);
			System.out.println("Equipos insertados con sus entenadores, competiciones y jugadores correspondientes\n");
			
			System.out.println("2. Mostrar equipos, entrenadores, competiciones y jugadores");
			System.out.println("Datos del equipo: \n"+ dao.readEquipo(1));
			System.out.println("Datos del entrenador: \n" + dao.readEntrenador(1));
			System.out.println("Datos de los jugadores: \n" + dao.readJugadores(1));
			System.out.println("Datos de las competiciones: \n" + dao.readCompeticiones(1));
			System.out.println("------------------------------------------------------------");
			System.out.println("Datos del equipo: \n"+ dao.readEquipo(2));
			System.out.println("Datos del entrenador: \n" + dao.readEntrenador(2));
			System.out.println("Datos de los jugadores: \n" + dao.readJugadores(2));
			System.out.println("Datos de las competiciones: \n" + dao.readCompeticiones(2));
			System.out.println("------------------------------------------------------------");
			System.out.println("Datos del equipo: \n"+ dao.readEquipo(3));
			System.out.println("Datos del entrenador: \n" + dao.readEntrenador(3));
			System.out.println("Datos de los jugadores: \n" + dao.readJugadores(3));
			System.out.println("Datos de las competiciones: \n" + dao.readCompeticiones(3));
			
			System.out.println("\n3. Actualizar Equipo");
			equipo1.setNombre("SPORT_Real Madrid");
			dao.update(equipo1);
			System.out.println("Equipo actualizado\n");
			
			System.out.println("4. Borrar Equipo");
			dao.deleteById(3);
			System.out.println("Equipo borrado\n");
			
			System.out.println("5. Mostrar Equipo");
			System.out.println("Datos del Equipo: \n"+ dao.findAll());
			
	    }
	    catch (SQLException e) {
	    	e.printStackTrace();
	    } 
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}
