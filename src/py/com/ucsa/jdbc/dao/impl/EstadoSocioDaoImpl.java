package py.com.ucsa.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.com.ucsa.jdbc.dao.EstadoSocioDao;
import py.com.ucsa.jdbc.dto.Dominio;
import py.com.ucsa.jdbc.dto.EstadoSocio;
import py.com.ucsa.jdbc.dto.Opcion;
import py.com.ucsa.jdbc.dto.Socio;
import py.com.ucsa.jdbc.dto.Usuario;
import py.com.ucsa.utilites.ConexionBD;
import py.com.ucsa.utilites.DateUtil;

public class EstadoSocioDaoImpl implements EstadoSocioDao {

	Connection cpg;
	Statement s;
	
	
	@Override
	public List<EstadoSocio> listar() {
		List<EstadoSocio> l_dm = new ArrayList<EstadoSocio>();
		EstadoSocio dm;

		try {
			cpg = ConexionBD.getConectionPG();
			s = cpg.createStatement();
			ResultSet rs = s.executeQuery("Select * from public.estados_socios  ");
			
			while (rs.next()) {
					
				dm = new EstadoSocio();
				dm.setId(rs.getInt("id"));
				dm.setIdSocio( new Socio(rs.getInt("id_socio")) );
				dm.setIdEstado( rs.getInt("id_estado") );
				dm.setFechaEstado( rs.getTimestamp("fecha_estado").toLocalDateTime() );
				dm.setIdUsuarioCreacion( rs.getInt("id_usuario_creacion") );
				dm.setFechaCreacion( rs.getTimestamp("fecha_creacion").toLocalDateTime() );
				dm.setObservacion( rs.getString("observacion") );

				l_dm.add(dm);
				s = null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l_dm;
	}

	@Override
	public EstadoSocio getById(Integer id) {
		EstadoSocio dm = new EstadoSocio();
		try {
			PreparedStatement ps = cpg.prepareStatement("select * from public.estados_socios s where s.id = ? ");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			dm = null;
			dm =  new EstadoSocio();
			dm.setId(rs.getInt("id"));
			dm.setIdSocio( new Socio(rs.getInt("id_socio")) );
			dm.setIdEstado( rs.getInt("id_estado") );
			dm.setFechaEstado( rs.getTimestamp("fecha_estado").toLocalDateTime() );
			dm.setIdUsuarioCreacion( rs.getInt("id_usuario_creacion") );
			dm.setFechaCreacion( rs.getTimestamp("fecha_creacion").toLocalDateTime() );
			dm.setObservacion( rs.getString("observacion") );

		} catch (SQLException e) {
			dm = null;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dm;
	}

	@Override
	public EstadoSocio insertar(EstadoSocio obj) {
		EstadoSocio s = new EstadoSocio();

		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("INSERT INTO  public.estados_socios "
					+ "(id_socio, id_estado, fecha_estado, id_usuario_creacion, fecha_creacion, observacion) "
					+ "VALUES(?, ?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

			ps.setInt(2, obj.getIdSocio().getId());
			ps.setInt(3, obj.getIdEstado());

			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			obj.setId(rs.getInt("id"));
			s = obj;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;
	}

	@Override
	public EstadoSocio modificar(EstadoSocio objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
