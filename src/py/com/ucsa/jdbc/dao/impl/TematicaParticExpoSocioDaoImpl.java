package py.com.ucsa.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.com.ucsa.jdbc.dao.TematicaParticExpoSocioDao;
import py.com.ucsa.jdbc.dto.Exposicion;
import py.com.ucsa.jdbc.dto.TematicaParticExpoSocio;
import py.com.ucsa.jdbc.dto.Usuario;
import py.com.ucsa.utilites.ConexionBD;

public class TematicaParticExpoSocioDaoImpl implements TematicaParticExpoSocioDao {

	Connection cpg;
	Statement s;
	String v_sele ="SELECT t.*, e.nombre as exp_nombre, e.descripcion as exp_descripcion, e.organiza exp_organiza, s.nro_socio as socio_nro, s.nombres as socio_nombre, s.apellidos as socio_apellido "
			+ "FROM public.tematica_partic_expo_socios t, public.partic_expo_socios es, public.exposiciones e, public.socios s "
			+ "WHERE t.id_partic_expo_socios = es.id "
			+ "AND es.id_exposicion = e.id "
			+ "AND es.id_socio = s.id ";
	
	@Override
	public List<TematicaParticExpoSocio> listar() {

		List<TematicaParticExpoSocio> l_ex = new ArrayList<TematicaParticExpoSocio>();
		TematicaParticExpoSocio ex;

		try {
			cpg = ConexionBD.getConectionPG();
			s = cpg.createStatement();
			ResultSet rs = s.executeQuery(v_sele);

			while (rs.next()) {

				
				ex = new TematicaParticExpoSocio();
				/*
				ex.setId(rs.getInt("id"));

				ex.setNombre( rs.getString("nombre") );
				ex.setDescripcion( rs.getString("descripcion") );
				ex.setOrganiza( rs.getString("organiza") );
				ex.setUbicacion( rs.getString("ubicacion") );
				ex.setFechaExpo( rs.getTimestamp("fecha_expo").toLocalDateTime() );
				ex.setContacto( rs.getString("contacto") );
				ex.setFechaCreacion( rs.getTimestamp("fecha_creacion").toLocalDateTime() );
				ex.setUsuarioCreacion( new Usuario( rs.getInt("id_usuario_creacion")) );
*/
				l_ex.add(ex);

			}
			s = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l_ex;
		
	}

	@Override
	public TematicaParticExpoSocio getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TematicaParticExpoSocio insertar(TematicaParticExpoSocio objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TematicaParticExpoSocio modificar(TematicaParticExpoSocio objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub

	}

}
