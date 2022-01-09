package com.aad.ejercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Conexion {
	public static Connection conectar() {
		Connection con = null;

		String basedatos = "aadu2";
	    String host = "localhost";
	    String port = "3306";
	    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	    String user = "root";
	    String pwd = "Alcobendas99*";
	    
		try {
			con = DriverManager.getConnection(urlConnection, user, pwd);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}