package py.com.ucsa.jdbc.dao;

import py.com.ucsa.jdbc.dto.Dominio;

public interface DominioDao  extends GenericDao<Dominio> {

	Dominio getDominioByCodigo(String codigo);
	
}
