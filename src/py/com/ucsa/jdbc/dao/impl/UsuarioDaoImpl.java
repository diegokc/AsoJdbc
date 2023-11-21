package py.com.ucsa.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.com.ucsa.jdbc.dao.UsuarioDao;
import py.com.ucsa.jdbc.dto.Usuario;
import py.com.ucsa.utilites.ConexionBD;
import py.com.ucsa.utilites.DateUtil;

public class UsuarioDaoImpl implements UsuarioDao {


	Connection cpg;

	@Override
	public List<Usuario> listar() {
		List<Usuario> l_usuario = new ArrayList<Usuario>();
		Usuario s;

		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("select * from public.usuarios ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				s = new Usuario();
				s.setId(rs.getInt("id"));
				s.setUsuario(rs.getString("usuario"));
				s.setEmail(rs.getString("email"));
				s.setClave(rs.getString("clave"));
				s.setHabilitado(rs.getBoolean("habilitado"));
				s.setCuentaBloqueada(rs.getBoolean("cuenta_bloqueada"));
				s.setCuentaExpirada(rs.getBoolean("cuenta_expirada"));
				s.setFechaCreacionUsuario(rs.getTimestamp("fecha_creacion_usuario").toLocalDateTime());
				s.setIdSocio(rs.getInt("id_socio"));

				l_usuario.add(s);

				s = null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l_usuario;
	}

	@Override
	public Usuario getById(Integer id) {
		Usuario s = new Usuario();
		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("select * from public.usuarios s where s.id = ? ");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			s = null;
			while(rs.next()) {
				s = new Usuario();
				s.setId(rs.getInt("id"));
				s.setUsuario(rs.getString("usuario"));
				s.setEmail(rs.getString("email"));
				s.setClave(rs.getString("clave"));
				s.setHabilitado(rs.getBoolean("habilitado"));
				s.setCuentaBloqueada(rs.getBoolean("cuenta_bloqueada"));
				s.setCuentaExpirada(rs.getBoolean("cuenta_expirada"));
				s.setFechaCreacionUsuario(rs.getTimestamp("fecha_creacion_usuario").toLocalDateTime());
				s.setIdSocio(rs.getInt("id_socio"));
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
	public Usuario insertar(Usuario obj) {
		Usuario s = new Usuario();

		try {
			
			cpg = ConexionBD.getConectionPG();
			
			cpg.setAutoCommit(false);

			PreparedStatement ps = cpg.prepareStatement("INSERT INTO public.usuarios "
					+ "(usuario, email, clave, habilitado, cuenta_bloqueada, cuenta_expirada, fecha_creacionUsuario, id_socio) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, obj.getUsuario());
			ps.setString(2, obj.getEmail());
			ps.setString(3, obj.getClave());
			ps.setBoolean(4, obj.isHabilitado());
			ps.setBoolean(5, obj.isCuentaBloqueada());
			ps.setBoolean(6, obj.isCuentaExpirada());
			ps.setDate(7, DateUtil.getDateAsDateSql(obj.getFechaCreacionUsuario()) );
			ps.setInt(8, obj.getIdSocio());
			
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
	public Usuario modificar(Usuario obj) {
		Usuario s = new Usuario();
		try {
			cpg = ConexionBD.getConectionPG();
			cpg.setAutoCommit(false);
			/*
			 * 	private Integer id;
				private String usuario;
				private String email;
				private String clave;
				private boolean habilitado;
				private boolean cuentaBloqueada;
				private boolean cuentaExpirada;
				private LocalDate fechaCreacionUsuario;
				private Integer idSocio;
			 * */	
			PreparedStatement ps = cpg.prepareStatement("UPDATE public.usuarios SET "
					+ "usuario = ?, "
					+ "email = ?, "
					+ "clave = ?, "
					+ "habilitado = ?, "
					+ "cuenta_bloqueada = ?, "
					+ "cuenta_expirada = ?, "
					+ "fecha_creacion_usuario = ?, "
					+ "id_socio = ? "
					+ " WHERE id = ? ");

			ps.setString(1, obj.getUsuario());
			ps.setString(2, obj.getEmail());
			ps.setString(3, obj.getClave());
			ps.setBoolean(4, obj.isHabilitado());
			ps.setBoolean(5, obj.isCuentaBloqueada());
			ps.setBoolean(6, obj.isCuentaExpirada());
			ps.setDate(7, DateUtil.getDateAsDateSql(obj.getFechaCreacionUsuario()) );
			ps.setInt(8, obj.getIdSocio());
			ps.setInt(9, obj.getId());
			
			ps.executeUpdate();
			ps.close();
			//ResultSet rs = ps.getResultSet();
			//rs.next();
			s = obj;
			//s = getById(obj.getId());

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
			
			PreparedStatement ps = cpg.prepareStatement("DELETE public.usuarios WHERE id = ? ");

			ps.setInt(1, id);
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	@Override
	public Usuario getUsuarioByUsuarioClave(String usuario, String clave) {
		Usuario s = new Usuario();
		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("select * from public.usuarios s where s.usuario = ? AND s.clave = ? ");
			ps.setString(1, usuario);
			ps.setString(1, clave);
			
			ResultSet rs = ps.executeQuery();
			s = null;
			while(rs.next()) {
				s = new Usuario();
				s.setId(rs.getInt("id"));
				s.setUsuario(rs.getString("usuario"));
				s.setEmail(rs.getString("email"));
				s.setClave(rs.getString("clave"));
				s.setHabilitado(rs.getBoolean("habilitado"));
				s.setCuentaBloqueada(rs.getBoolean("cuenta_bloqueada"));
				s.setCuentaExpirada(rs.getBoolean("cuenta_expirada"));
				s.setFechaCreacionUsuario(rs.getTimestamp("fecha_creacion_usuario").toLocalDateTime());
				s.setIdSocio(rs.getInt("id_socio"));
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
