package py.com.ucsa.jdbc.dao;

import java.util.List;

import py.com.ucsa.jdbc.dto.Socio;

public interface SocioDao extends GenericDao<Socio> {

	public Socio getSocioByNroCedula(Integer cedula);
	public List<Socio> listar();
	
}
