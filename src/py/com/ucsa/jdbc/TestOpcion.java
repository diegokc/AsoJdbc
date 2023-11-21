package py.com.ucsa.jdbc;

import py.com.ucsa.jdbc.dao.DAOFactory;

public class TestOpcion {

	public static void main(String[] args) {
		
		System.out.println("1 DAOFactory.getOpcionesDao().listar()");
		DAOFactory.getOpcionesDao().listar().forEach((n) -> {
			System.out.println(n.toString());
		});
		
		System.out.println("-------------------------");
		
		System.out.println("1 DAOFactory.getOpcionByCodDominio().listar()");
		DAOFactory.getOpcionesDao().getOpcionByCodDominio("PAIS").forEach((n) -> {
			System.out.println(n.toString());
		});
		System.out.println(" ");
		DAOFactory.getOpcionesDao().getOpcionByCodDominio("CIUD").forEach((n) -> {
			System.out.println(n.toString());
		});

		
	}
}
