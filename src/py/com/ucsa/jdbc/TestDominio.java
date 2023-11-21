package py.com.ucsa.jdbc;

import py.com.ucsa.jdbc.dao.DAOFactory;
import py.com.ucsa.jdbc.dto.Dominio;

public class TestDominio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("1 DAOFactory.getDominiosDao().listar()");
		
		DAOFactory.getDominiosDao().listar().forEach((n) -> {
			System.out.println(n.toString());
		});
		
		System.out.println("-----------------------------------------------------");
		
		System.out.println("1 DAOFactory.getDominiosDao().getById(1)");
		Dominio d1 = DAOFactory.getDominiosDao().getById(1);
		System.out.println(d1.toString());
		
		System.out.println("-----------------------------------------------------");
		
		System.out.println("1 DAOFactory.getDominiosDao().getDominioByCodigo(CIUD)");
		Dominio d2 = DAOFactory.getDominiosDao().getDominioByCodigo("CIUD");
		System.out.println(d2.toString());
	}

}
