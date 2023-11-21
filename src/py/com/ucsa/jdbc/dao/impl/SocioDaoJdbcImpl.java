package py.com.ucsa.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.com.ucsa.jdbc.dao.SocioDao;
import py.com.ucsa.jdbc.dto.Opcion;
import py.com.ucsa.jdbc.dto.Socio;
import py.com.ucsa.jdbc.dto.Usuario;
import py.com.ucsa.utilites.ConexionBD;
import py.com.ucsa.utilites.DateUtil;

public class SocioDaoJdbcImpl implements SocioDao {

	Connection cpg;

	@Override
	public List<Socio> listar() {
		List<Socio> l_socio = new ArrayList<Socio>();
		Socio s;

		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("select * from public.socios ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				s = new Socio();
				s.setId(rs.getInt("id"));
				s.setNombres(rs.getString("nombres"));
				s.setApellidos(rs.getString("apellidos"));
				s.setEmail(rs.getString("email"));
				s.setNroSocio(rs.getInt("nro_socio"));
				s.setNroCedula(rs.getInt("nro_cedula"));
				s.setFechaIngreso( rs.getDate("fecha_ingreso").toLocalDate() );
				s.setIdEstadoActual( new Opcion(rs.getInt("id_estado_actual"))  );
				s.setFechaEstadoActual(rs.getTimestamp("fecha_estado_actual").toLocalDateTime() );
				s.setFundador(rs.getBoolean("fundador"));
				s.setUsuarioCreacion( new Usuario(rs.getInt("id_usuario_creacion")) );
				s.setFechaCreacion(rs.getTimestamp("fecha_creacion").toLocalDateTime());
				s.setIdSocioProponente(rs.getLong("id_socio_proponente"));
				s.setIdTipoSocio(rs.getLong("id_socio_proponente"));

				l_socio.add(s);

				s = null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l_socio;
	}

	@Override
	public Socio getById(Integer id) {
		Socio s = new Socio();
		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("select * from public.socios s where s.id = ? ");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			s = null;
			while(rs.next()) {
				s = new Socio();
				s.setId(rs.getInt("id"));
				s.setNombres(rs.getString("nombres"));
				s.setApellidos(rs.getString("apellidos"));
				s.setEmail(rs.getString("email"));
				s.setNroSocio(rs.getInt("nro_socio"));
				s.setNroCedula(rs.getInt("nro_cedula"));
				s.setFechaIngreso( rs.getDate("fecha_ingreso").toLocalDate() );
				s.setIdEstadoActual( new Opcion(rs.getInt("id_estado_actual"))  );
				s.setFechaEstadoActual(rs.getTimestamp("fecha_estado_actual").toLocalDateTime() );
				s.setFundador(rs.getBoolean("fundador"));
				s.setUsuarioCreacion( new Usuario(rs.getInt("id_usuario_creacion")) );
				s.setFechaCreacion(rs.getTimestamp("fecha_creacion").toLocalDateTime());
				s.setIdSocioProponente(rs.getLong("id_socio_proponente"));
				s.setIdTipoSocio(rs.getLong("id_socio_proponente"));
			}
			ps.close();

		} catch (SQLException e) {
			s = null;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;
	}

	@Override
	public Socio insertar(Socio obj) {
		Socio s = new Socio();

		try {
			
			cpg = ConexionBD.getConectionPG();
			
			cpg.setAutoCommit(false);
			
			PreparedStatement ps = cpg.prepareStatement("INSERT INTO public.socios "
					+ "(nombres, apellidos, email, nro_socio, nro_cedula, fecha_ingreso, id_estado_actual, fecha_estado_actual, fundador, id_usuario_creacion, fecha_creacion, id_socio_proponente, id_tipo_socio) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, obj.getNombres());
			ps.setString(2, obj.getApellidos());
			ps.setString(3, obj.getEmail());
			ps.setLong(4, obj.getNroSocio());
			ps.setLong(5, obj.getNroCedula());
			ps.setDate(6, DateUtil.getDateAsDateSql(obj.getFechaIngreso()) );
			ps.setLong(7, obj.getIdEstadoActual().getId());
			ps.setDate(8, DateUtil.getDateAsDateSql(obj.getFechaEstadoActual()) );
			ps.setBoolean(9, obj.isFundador());
			ps.setLong(10, obj.getUsuarioCreacion().getId());
			ps.setDate(11, DateUtil.getDateAsDateSql(obj.getFechaCreacion()) );
			ps.setLong(12, obj.getIdSocioProponente() );
			ps.setLong(13, obj.getIdTipoSocio());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			obj.setId(rs.getInt("id"));
			s = obj;
			ps.close();

			
			String subSelectEstado = "(SELECT e.id FROM opciones e JOIN dominios d ON e.id_dominio = d.id "
					+ "WHERE d.codigo = 'ESTSOC' AND e.codigo = 'PEN')";
			String sentenciaInsert = "INSERT INTO estados_socios("
					+ "	id_socio, id_estado, fecha_estado, "
					+ " id_usuario_creacion, fecha_creacion, observacion) "
					+ "	VALUES (?, "+subSelectEstado+", ?, ?, ?, ?)";
			ps = cpg.prepareStatement(sentenciaInsert);
			
			ps.setInt(1, s.getId() );
			ps.setDate(2, DateUtil.getDateAsDateSql(obj.getFechaEstadoActual()) );
			ps.setInt(3, s.getUsuarioCreacion().getId() );
			ps.setDate(4, DateUtil.getDateAsDateSql(obj.getFechaEstadoActual()) );
			ps.setString(5, "ALTA DE SOCIO");
			ps.executeUpdate();
			
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
	public Socio modificar(Socio obj) {
		Socio s = new Socio();

		try {
			cpg = ConexionBD.getConectionPG();
			cpg.setAutoCommit(false);
			
			Integer ea=0;
			String selectSocio = "SELECT id_estado_actual FROM public.socios WHERE id = ? ";
			PreparedStatement  ps = cpg.prepareStatement(selectSocio);
			ps.setLong(1, obj.getId());
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				ea = rs.getInt(1);
			}
			ps.close();
			
			ps = cpg.prepareStatement("UPDATE public.socios SET "
					+ "nombres = ?, "
					+ "apellidos = ?, "
					+ "email = ?, "
					+ "nro_socio = ?, "
					+ "nro_cedula = ?, "
					+ "fecha_ingreso = ?, "
					+ "id_estado_actual = ?, "
					+ "fecha_estado_actual = ?, "
					+ "fundador = ?, "
					+ "id_usuario_creacion = ?, "
					+ "fecha_creacion = ?, "
					+ "id_socio_proponente = ?, "
					+ "id_tipo_socio = ?"
					+ " WHERE id = ? ");

			ps.setString(1, obj.getNombres());
			ps.setString(2, obj.getApellidos());
			ps.setString(3, obj.getEmail());
			ps.setLong(4, obj.getNroSocio());
			ps.setLong(5, obj.getNroCedula());
			ps.setDate(6, DateUtil.getDateAsDateSql(obj.getFechaIngreso()) );
			ps.setLong(7, obj.getIdEstadoActual().getId());
			ps.setDate(8, DateUtil.getDateAsDateSql(obj.getFechaEstadoActual()) );
			ps.setBoolean(9, obj.isFundador());
			ps.setLong(10, obj.getUsuarioCreacion().getId());
			ps.setDate(11, DateUtil.getDateAsDateSql(obj.getFechaCreacion()) );
			ps.setLong(12, obj.getIdSocioProponente() );
			ps.setLong(13, obj.getIdTipoSocio());
			ps.setLong(14, obj.getId());
			ps.executeUpdate();
			ps.close();
			//ResultSet rs = ps.getResultSet();
			//rs.next();
			//s = obj;
			//s = getById(obj.getId());


			
			if(ea != obj.getIdEstadoActual().getId()) {
			//SI CAMBIO DE ESTADO SE ACUTALIZA				
				String sentenciaInsert = "INSERT INTO estados_socios("
						+ "	id_socio, id_estado, fecha_estado, "
						+ " id_usuario_creacion, fecha_creacion, observacion) "
						+ "	VALUES (?, ?, ?, ?, ?, ?)";
				ps = cpg.prepareStatement(sentenciaInsert);
				
				ps.setInt(1, obj.getId() );
				ps.setInt(2, obj.getIdEstadoActual().getId() );
				ps.setDate(3, DateUtil.getDateAsDateSql(obj.getFechaEstadoActual()) );
				ps.setInt(4, obj.getUsuarioCreacion().getId() );
				ps.setDate(5, DateUtil.getDateAsDateSql(obj.getFechaEstadoActual()) );
				ps.setString(6, "MODIFICACION DE ESTADO");
				ps.executeUpdate();
				ps.close();
				
			}
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
	public void eliminar(Integer id) {
		
		try {
			cpg = ConexionBD.getConectionPG();
			
			PreparedStatement ps = cpg.prepareStatement("DELETE public.socios WHERE id = ? ");

			ps.setLong(1, id);
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public Socio getSocioByNroCedula(Integer cedula) {
		Socio s = new Socio();
		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("select * from public.socios s where s.nro_cedula = ? ");
			ps.setLong(1, cedula);
			ResultSet rs = ps.executeQuery();
			s = null;
			while(rs.next()) {
				s = new Socio();
				s.setId(rs.getInt("id"));
				s.setNombres(rs.getString("nombres"));
				s.setApellidos(rs.getString("apellidos"));
				s.setEmail(rs.getString("email"));
				s.setNroSocio(rs.getInt("nro_socio"));
				s.setNroCedula(rs.getInt("nro_cedula"));
				s.setFechaIngreso( rs.getDate("fecha_ingreso").toLocalDate() );
				s.setIdEstadoActual( new Opcion(rs.getInt("id_estado_actual"))  );
				s.setFechaEstadoActual(rs.getTimestamp("fecha_estado_actual").toLocalDateTime() );
				s.setFundador(rs.getBoolean("fundador"));
				s.setUsuarioCreacion( new Usuario(rs.getInt("id_usuario_creacion")) );
				s.setFechaCreacion(rs.getTimestamp("fecha_creacion").toLocalDateTime());
				s.setIdSocioProponente(rs.getLong("id_socio_proponente"));
				s.setIdTipoSocio(rs.getLong("id_socio_proponente"));
			}
			ps.close();
		} catch (SQLException e) {
			s = null;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;
	}

}
