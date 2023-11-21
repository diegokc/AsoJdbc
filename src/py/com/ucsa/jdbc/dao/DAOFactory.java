package py.com.ucsa.jdbc.dao;

import py.com.ucsa.jdbc.dao.impl.DominioDaoImpl;
import py.com.ucsa.jdbc.dao.impl.MontoCuotaDaoImpl;
import py.com.ucsa.jdbc.dao.impl.OpcionDaoImpl;
import py.com.ucsa.jdbc.dao.impl.SocioDaoJdbcImpl;

public abstract class DAOFactory {

	public static DominioDao getDominiosDao() {
		return new DominioDaoImpl();
	}

	public static MontoCuotaDao getMontosCuotaDao() {
		return new MontoCuotaDaoImpl();
	}

	public static OpcionDao getOpcionesDao() {
		return new OpcionDaoImpl();
	}

	public static SocioDao getSocioDao() {
		return new SocioDaoJdbcImpl();
	}


}
