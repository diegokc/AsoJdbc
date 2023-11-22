package py.com.ucsa.jdbc.dao;

import py.com.ucsa.jdbc.dao.impl.DominioDaoImpl;
import py.com.ucsa.jdbc.dao.impl.ExposicionDaoImpl;
import py.com.ucsa.jdbc.dao.impl.MontoCuotaDaoImpl;
import py.com.ucsa.jdbc.dao.impl.OpcionDaoImpl;
import py.com.ucsa.jdbc.dao.impl.ParticExpoSocioDaoImpl;
import py.com.ucsa.jdbc.dao.impl.RolDaoImpl;
import py.com.ucsa.jdbc.dao.impl.RolUsuarioDaoImpl;
import py.com.ucsa.jdbc.dao.impl.SocioDaoJdbcImpl;
import py.com.ucsa.jdbc.dao.impl.TematicaParticExpoSocioDaoImpl;

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

	public static RolDao getRolDao() {
		return new RolDaoImpl();
	}
	
	public static RolUsuarioDao getRolUsuarioDao() {
		return new RolUsuarioDaoImpl();
	}

	public static ExposicionDao getExposicionDao() {
		return new ExposicionDaoImpl();
	}  
	
	public static ParticExpoSocioDao getParticExpoSocioDao() {
		return new ParticExpoSocioDaoImpl();
	}  
	
	public static TematicaParticExpoSocioDao getTematicaParticExpoSocioDao() {
		return new TematicaParticExpoSocioDaoImpl();
	}
	
}
