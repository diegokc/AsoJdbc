package py.com.ucsa.jdbc;

import java.sql.Date;

import py.com.ucsa.jdbc.dao.DAOFactory;
import py.com.ucsa.jdbc.dto.Opcion;
import py.com.ucsa.jdbc.dto.Socio;
import py.com.ucsa.jdbc.dto.Usuario;
import py.com.ucsa.utilites.DateUtil;

public class TestSocio {

	public static void main(String[] args) {

		System.out.println("1 DAOFactory.getSocioDao().listar()");
		Integer idgenerado=0;
		
		DAOFactory.getSocioDao().listar().forEach((n) -> {
			System.out.println(n.toString());
		});
		
		/*
		System.out.println("");
		System.out.println("2 DAOFactory.getSocioDao().insertar()");
	
		Socio s = new Socio();
		s.setNombres("Diego");
		s.setApellidos("Colman");
		s.setEmail("diegokc@msn.com");
		s.setNroSocio(1001);
		s.setNroCedula(3519445);
		
		s.setFechaIngreso(  DateUtil.getLocalDate("2020-04-01") );
		s.setIdEstadoActual( new Opcion(1) );
		s.setFechaEstadoActual( DateUtil.getLocalDateTime("2023-08-01 19:42:05") );
		s.setFundador( false );
		s.setIdUsuarioCreacion( new Usuario(1) );
		s.setFechaCreacion(  DateUtil.getLocalDateTime("2023-08-01 19:42:05") );
		s.setIdSocioProponente( 1L );
		s.setIdTipoSocio( 55L );
		
		//s = DAOFactory.getSocioDao().insertar(s);
		
		//System.out.println("ID generado: " + s.getId().toString());
		//idgenerado = s.getId();


		System.out.println("");
		System.out.println("3 DAOFactory.getSocioDao().modificar()");
		s =  DAOFactory.getSocioDao().getSocioByNroCedula(3519445);
		idgenerado = s.getId();
		
		s.setNombres("Diego 001");
		s.setApellidos("Colman 001");
		s.setEmail("diegokc@hotmail.com");
		//s.setNro_socio(1005L);
		s.setIdEstadoActual( new Opcion(6) ); // 4pen, 5act, 6sus

		Socio s2 = new Socio();
		s2 = DAOFactory.getSocioDao().modificar(s);
		System.out.println("Nombre: " + s2.getNombres());

		
		System.out.println("");
		System.out.println("4 DAOFactory.getSocioDao().getById()");
		Socio s3 = new Socio();
		s3 = DAOFactory.getSocioDao().getById(idgenerado);
		System.out.println("ID: " + s3.getId().toString());
		System.out.println("Nombre: " + s3.getNombres());
		System.out.println("Apellido: " + s3.getApellidos());
		
		System.out.println("");
		System.out.println("5 DAOFactory.getSocioDao().getSocioByNroCedula()");
		Socio s4 = new Socio();
		s4 = DAOFactory.getSocioDao().getSocioByNroCedula(3519445);
		System.out.println("Cedula: " + s4.getNroCedula().toString());
		System.out.println("Nombre: " + s4.getNombres());
		System.out.println("Apellido: " + s4.getApellidos());
		*/
	}

}
