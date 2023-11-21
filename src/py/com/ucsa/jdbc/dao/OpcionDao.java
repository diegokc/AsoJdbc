package py.com.ucsa.jdbc.dao;

import java.util.List;

import py.com.ucsa.jdbc.dto.Opcion;

public interface OpcionDao  extends GenericDao<Opcion> {

	
	Opcion getOpcionByCodDominioCodOpcion(String codDominio, String codOpcion);
	
	List<Opcion> getOpcionByCodDominio(String dominio);
	
	List<Opcion> getOpcionByIdDominio(Integer idDominio);
}
