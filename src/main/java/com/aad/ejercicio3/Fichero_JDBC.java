package com.aad.ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fichero_JDBC {
	public static void main(String[] args) {
		String basedatos = "aadu2";
	    String host = "localhost";
	    String port = "3306";
	    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	    String user = "root";
	    String pwd = "root";
	    
	    try { 
            File fichero = new File("ficheros/quijote.txt");
            String nombre = fichero.getName();
            long tamanio = fichero.length();
            String permisos = "Lectura: " + fichero.canRead() + ". Escritura: " + fichero.canWrite();
            
            BufferedReader bf = new BufferedReader(new FileReader("ficheros/quijote.txt"));
            long numerolineas = 0;
            while ((bf.readLine())!=null) {
           	  numerolineas++;
            }
            bf.close();
            
            Connection conn = DriverManager.getConnection(urlConnection, user, pwd);
            Statement stmnt = conn.createStatement();
            stmnt.execute("DROP TABLE IF EXISTS ficheros");
		    stmnt.execute("CREATE TABLE aadu2.ficheros ("
		    		+ "id MEDIUMINT NOT NULL AUTO_INCREMENT,"
		    		+ "nombre varchar(50),"
		    		+ "numerolineas MEDIUMINT,"
		    		+ "tamanio MEDIUMINT,"
		    		+ "permisos varchar(50),"
		    		+ "PRIMARY KEY (id));");
		    
		    System.out.println("Tabla ficheros creada");
            
            PreparedStatement sInsert = conn.prepareStatement("INSERT INTO ficheros (nombre, numerolineas, tamanio, permisos) VALUES (?,?,?,?);"); 
            sInsert.setString(1, nombre);
            sInsert.setLong(2, numerolineas);
            sInsert.setLong(3, tamanio);
            sInsert.setString(4, permisos);
            sInsert.executeUpdate();
            
            sInsert.close();
            System.out.println("Datos insertados"); 
            
            ResultSet rs = stmnt.executeQuery("SELECT * FROM ficheros");
			int i=1;
				while (rs.next()) {
		    	  System.out.println("----------------");    
		    	  System.out.println("Id: "+ i++);        
		    	  System.out.println("Nombre: " + rs.getString("nombre"));
		    	  System.out.println("Número de lineas: " + rs.getLong("numerolineas"));
		    	  System.out.println("Tamaño: " + rs.getLong("tamanio"));
		    	  System.out.println("Permisos: " + rs.getString("permisos"));
				} 
		    rs.close();
            
            stmnt.close();
            conn.close();
	    } 
	    catch (SQLException e) {
	    	System.out.println("Error SQL");
	    } 
	    catch (FileNotFoundException e){
	   	  System.out.println("No se ha encontrado el archivo");
	    } 
	    catch (IOException e){
	    	System.out.println("Error de entrada y de salida");
	   	}
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}
