package py.com.ucsa.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.com.ucsa.jdbc.dao.ParticExpoSocioDao;
import py.com.ucsa.jdbc.dto.Exposicion;
import py.com.ucsa.jdbc.dto.ParticExpoSocio;
import py.com.ucsa.jdbc.dto.Rol;
import py.com.ucsa.jdbc.dto.Socio;
import py.com.ucsa.jdbc.dto.Usuario;
import py.com.ucsa.utilites.ConexionBD;

public class ParticExpoSocioDaoImpl implements ParticExpoSocioDao {

	Connection cpg;
	Statement s;
	String v_selec = "SELECT es.*, e.nombre as exp_nombre, e.descripcion as exp_descripcion, e.organiza exp_organiza, e.fecha_expo exp_fecha, s.nro_socio as socio_nro, s.nombres as socio_nombre, s.apellidos as socio_apellido "
			+ "FROM public.partic_expo_socios es, public.exposiciones e, public.socios s "
			+ "WHERE es.id_exposicion = e.id "
			+ "AND es.id_socio = s.id ";
	
	@Override
	public List<ParticExpoSocio> listar() {

		List<ParticExpoSocio> l_ex = new ArrayList<ParticExpoSocio>();
		ParticExpoSocio ex;

		try {
			cpg = ConexionBD.getConectionPG();
			s = cpg.createStatement();
			ResultSet rs = s.executeQuery(v_selec);

			while (rs.next()) {

				ex = extractedPES(rs);

				l_ex.add(ex);

			}
			s = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l_ex;

	}



	@Override
	public ParticExpoSocio getById(Integer id) {

		ParticExpoSocio ex = null;

		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement(v_selec+" AND id = ? ");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ex = extractedPES(rs);

				s = null;
				return ex;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ex;
		
	}

	@Override
	public ParticExpoSocio insertar(ParticExpoSocio objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParticExpoSocio modificar(ParticExpoSocio objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	private ParticExpoSocio extractedPES(ResultSet rs) throws SQLException {
		ParticExpoSocio ex = new ParticExpoSocio();
		ex.setId(rs.getInt("id"));
		ex.setSocio( new Socio(rs.getInt("id_socio"), rs.getString("socio_nombre"), rs.getString("socio_apellido"), rs.getInt("socio_nro") )  );
		ex.setExposicion( new Exposicion(rs.getInt("id_exposicion"), rs.getString("exp_nombre"), rs.getString("exp_descripcion"), rs.getString("exp_organiza"), rs.getTimestamp("exp_fecha").toLocalDateTime()) );
		ex.setCanceloParticipacion( rs.getBoolean("cancelo_participacion") );
		if(rs.getTimestamp("fecha_cancelacion")!=null) {
		ex.setFechaCancelacion( rs.getTimestamp("fecha_cancelacion").toLocalDateTime() );
		}
		if(rs.getTimestamp("fecha_creacion")!=null) {
		ex.setFechaCreacion( rs.getTimestamp("fecha_creacion").toLocalDateTime() );
		}
		ex.setUsuarioCreacion( new Usuario( rs.getInt("id_usuario_creacion")) );
		return ex;
	}
}
