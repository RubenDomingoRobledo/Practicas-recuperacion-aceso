package DaoTornillos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ejercicio 3.1
 *  * 
 * @author: 
 * 
 **/

public class Almacen {

	public static void main(String[] args) {
		try {
			Connection c = ConnectionH2.getDBConnection();
			Statement st  = c.createStatement();
			st.executeUpdate("create table if not exists tornillo (\r\n"
					+ "referencia int NOT NULL PRIMARY KEY,\r\n"
					+ "diametro int NOT NULL,\r\n"
					+ "longitud int NOT NULL,\r\n"
					+ "TipoDeRosca char(20) NOT NULL,\r\n"
					+ "material char(20) NOT NULL,\r\n"
					+ "tipoCabeza char(20) NOT NULL,\r\n"
					+ "enStock boolean NOT NULL,\r\n"
					+ "stock int NOT NULL);");
			
			TornillosImpl dao = new TornillosImpl();
			TornilloBuilder tb = new TornilloBuilder();
			Tornillo t1 = tb.tornilloRandomBuilder();
			Tornillo t2 = tb.tornilloRandomBuilder();
			dao.insert(t1);
			dao.insert(t2);
			System.out.println(dao.findAll());
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
