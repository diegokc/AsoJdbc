package py.com.ucsa.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.com.ucsa.jdbc.dao.RolUsuarioDao;
import py.com.ucsa.jdbc.dto.Rol;
import py.com.ucsa.jdbc.dto.RolUsuario;
import py.com.ucsa.jdbc.dto.Usuario;
import py.com.ucsa.utilites.ConexionBD;

public class RolUsuarioDaoImpl implements RolUsuarioDao {

	Connection cpg;
	Statement s;
	String sel = " SELECT ru.id_rol, ru.id_usuario, u.usuario, r.nombre_rol "
			+ " FROM public.roles_usuarios ru, public.usuarios u, public.roles r "
			+ " WHERE ru.id_rol = r.id "
			+ " AND ru.id_usuario = u.id ";

	@Override
	public List<RolUsuario> listar() {

		List<RolUsuario> l_rl = new ArrayList<RolUsuario>();
		RolUsuario rlu;

		try {
			cpg = ConexionBD.getConectionPG();
			s = cpg.createStatement();
			ResultSet rs = s.executeQuery(sel);

			while (rs.next()) {

				rlu = new RolUsuario();
				rlu.setRol( new Rol(rs.getInt("id_rol"),rs.getString("nombre_rol")) );
				rlu.setUsuario( new Usuario(rs.getInt("id_usuario"),rs.getString("usuario")) );

				l_rl.add(rlu);

			}
			s = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l_rl;


		
	}

	@Override
	public RolUsuario getById(Integer id) {

		RolUsuario rlu = null;

		try {
			cpg = ConexionBD.getConectionPG();
			s = cpg.createStatement();
			ResultSet rs = s.executeQuery(sel);

			while (rs.next()) {

				rlu = new RolUsuario();
				rlu.setRol( new Rol(rs.getInt("id_rol"),rs.getString("nombre_rol")) );
				rlu.setUsuario( new Usuario(rs.getInt("id_usuario"),rs.getString("usuario")) );

					}
			s = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rlu;

	}

	@Override
	public RolUsuario insertar(RolUsuario objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RolUsuario modificar(RolUsuario objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
