package py.com.ucsa.utilites;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManejadorConexiones {

	private static String defaultBD = "postgres";
	
	public static Connection getConection() throws SQLException {
		return obtenerConexion(defaultBD);
	}
	
	public static Connection getConectionPG() throws SQLException {
		return obtenerConexion("postgres");
	}
	
	public static Connection obtenerConexionPG() throws SQLException {
		return obtenerConexion("postgres");
	}
	
	

	public static Connection getConectionMDB() throws SQLException {
		return obtenerConexion("mariadb");
	}
	
	public static Connection obtenerConexion(String fileName) throws SQLException {
		
		ResourceBundle bun = ResourceBundle.getBundle(fileName);

		Connection con = DriverManager.getConnection(bun.getString("jdbc.url"),bun.getString("jdbc.user"),bun.getString("jdbc.pass"));
	
		return con;
		
	}

}
