package py.com.ucsa.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.com.ucsa.jdbc.dao.ExposicionDao;
import py.com.ucsa.jdbc.dto.Exposicion;
import py.com.ucsa.jdbc.dto.Rol;
import py.com.ucsa.jdbc.dto.Usuario;
import py.com.ucsa.utilites.ConexionBD;
import py.com.ucsa.utilites.DateUtil;

public class ExposicionDaoImpl implements ExposicionDao {

	Connection cpg;
	Statement s;
	
	@Override
	public List<Exposicion> listar() {

		List<Exposicion> l_ex = new ArrayList<Exposicion>();
		Exposicion ex;

		try {
			cpg = ConexionBD.getConectionPG();
			s = cpg.createStatement();
			ResultSet rs = s.executeQuery("Select * from public.exposiciones ");

			while (rs.next()) {

				ex = new Exposicion();
				ex.setId(rs.getInt("id"));
				//ex.setNombreRol(rs.getString("nombre_rol"));
				ex.setNombre( rs.getString("nombre") );
				ex.setDescripcion( rs.getString("descripcion") );
				ex.setOrganiza( rs.getString("organiza") );
				ex.setUbicacion( rs.getString("ubicacion") );
				ex.setFechaExpo( rs.getTimestamp("fecha_expo").toLocalDateTime() );
				ex.setContacto( rs.getString("contacto") );
				ex.setFechaCreacion( rs.getTimestamp("fecha_creacion").toLocalDateTime() );
				ex.setUsuarioCreacion( new Usuario( rs.getInt("id_usuario_creacion")) );

				l_ex.add(ex);

			}
			s = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l_ex;

		
	}

	@Override
	public Exposicion getById(Integer id) {
		Exposicion ex = null;

		try {
			PreparedStatement ps = cpg.prepareStatement("select * from public.exposiciones s where s.id = ? ");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ex = new Exposicion();
				ex.setId(rs.getInt("id"));
				//ex.setNombreRol(rs.getString("nombre_rol"));
				ex.setNombre( rs.getString("nombre") );
				ex.setDescripcion( rs.getString("descripcion") );
				ex.setOrganiza( rs.getString("organiza") );
				ex.setUbicacion( rs.getString("ubicacion") );
				ex.setFechaExpo( rs.getTimestamp("fecha_expo").toLocalDateTime() );
				ex.setContacto( rs.getString("contacto") );
				ex.setFechaCreacion( rs.getTimestamp("fecha_creacion").toLocalDateTime() );
				ex.setUsuarioCreacion( new Usuario( rs.getInt("id_usuario_creacion")) );

			}
			s = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ex;
	}

	@Override
	public Exposicion insertar(Exposicion obj) {

		Exposicion s = new Exposicion();

		try {
			
			cpg = ConexionBD.getConectionPG();
			
			cpg.setAutoCommit(false);

			PreparedStatement ps = cpg.prepareStatement("INSERT INTO public.exposiciones "
					+ "(nombre, descripcion, organiza, ubicacion, fecha_expo, contacto, fecha_creacion, id_usuario_creacion) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, obj.getNombre());
			ps.setString(2, obj.getDescripcion());
			ps.setString(3, obj.getOrganiza());
			ps.setString(4, obj.getUbicacion());
			ps.setDate(5, DateUtil.getDateAsDateSql(obj.getFechaExpo()) );
			ps.setString(6, obj.getContacto());
			ps.setDate(7, DateUtil.getDateAsDateSql(obj.getFechaCreacion()) );
			ps.setInt(8, obj.getUsuarioCreacion().getId() );
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			obj.setId(rs.getInt("id"));
			s = obj;
			ps.close();

			ps.close();
			cpg.commit();
			
		} catch (SQLException e) {
			try {
				cpg.rollback();
				cpg.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;
		
	}

	@Override
	public Exposicion modificar(Exposicion obj) {

		Exposicion r = null;

		try {
			cpg = ConexionBD.getConectionPG();
			cpg.setAutoCommit(false);

			PreparedStatement ps;
			String sel_mod="UPDATE public.exposiciones "
					+ "SET nombre=?, descripcion=?, organiza=?, ubicacion=?, fecha_expo=?, contacto=?, fecha_creacion=?, id_usuario_creacion=? "
					+ "WHERE id=? ";

			ps = cpg.prepareStatement(sel_mod);
			
			ps.setString(1, obj.getNombre());
			ps.setString(2, obj.getDescripcion());
			ps.setString(3, obj.getOrganiza());
			ps.setString(4, obj.getUbicacion());
			ps.setDate(5, DateUtil.getDateAsDateSql(obj.getFechaExpo()) );
			ps.setString(6, obj.getContacto());
			ps.setDate(7, DateUtil.getDateAsDateSql(obj.getFechaCreacion()) );
			ps.setInt(8, obj.getUsuarioCreacion().getId() );
			
			ps.setInt(9, obj.getId() );
			
			ps.executeUpdate();
			ps.close();

			r = obj;

			cpg.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
		
	}

	@Override
	public void eliminar(Integer id) {
		try {
			cpg = ConexionBD.getConectionPG();
			cpg.setAutoCommit(false);

			PreparedStatement ps;
			ps = cpg.prepareStatement("DELETE FROM public.exposiciones  WHERE id=? ");
			
			ps.setInt(1, id );
			
			ps.executeUpdate();
			ps.close();

			cpg.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}


		
	}

}
