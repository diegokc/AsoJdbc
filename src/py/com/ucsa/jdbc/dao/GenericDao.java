package py.com.ucsa.jdbc.dao;

import java.util.List;

public interface GenericDao<T> {

	List<T> listar();
	T getById(Integer id);
	T insertar(T objeto);
	T modificar(T objeto);
	void eliminar(Integer id);
	
}
