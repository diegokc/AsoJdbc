package py.com.ucsa.jdbc.dao;


import py.com.ucsa.jdbc.dto.Usuario;

public interface UsuarioDao extends GenericDao<Usuario> {

	public Usuario getUsuarioByUsuarioClave(String usuario, String clave);
	
}
