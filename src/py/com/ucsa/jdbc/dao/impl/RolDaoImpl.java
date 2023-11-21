package py.com.ucsa.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.com.ucsa.jdbc.dao.RolDao;
import py.com.ucsa.jdbc.dto.Rol;
import py.com.ucsa.utilites.ConexionBD;

public class RolDaoImpl implements RolDao {

	Connection cpg;
	Statement s;

	@Override
	public List<Rol> listar() {
		List<Rol> l_rl = new ArrayList<Rol>();
		Rol rl;

		try {
			cpg = ConexionBD.getConectionPG();
			s = cpg.createStatement();
			ResultSet rs = s.executeQuery("Select * from public.roles ");

			while (rs.next()) {

				rl = new Rol();
				rl.setId(rs.getInt("id"));
				rl.setNombreRol(rs.getString("nombre_rol"));

				l_rl.add(rl);

			}
			s = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l_rl;

	}

	@Override
	public Rol getById(Integer id) {
		Rol rl = null;

		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("select * from public.roles s where s.id = ? ");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				rl = new Rol();
				rl.setId(rs.getInt("id"));
				rl.setNombreRol(rs.getString("nombre_rol"));

				s = null;
				return rl;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rl;

	}

	@Override
	public Rol insertar(Rol obj) {
		Rol rl = null;

		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("INSERT INTO public.roles " + "(nombre_rol) " + "VALUES(?) ",
					Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, obj.getNombreRol());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			obj.setId(rs.getInt("id"));
			rl = obj;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rl;

	}

	@Override
	public Rol modificar(Rol obj) {

		Rol r = null;

		try {
			cpg = ConexionBD.getConectionPG();
			cpg.setAutoCommit(false);

			PreparedStatement ps;

			ps = cpg.prepareStatement("UPDATE public.roles  SET  nombre_rol = ?  WHERE id = ? ");
			ps.setString(1, obj.getNombreRol());
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

			ps = cpg.prepareStatement("DELETE FROM public.roles WHERE id = ? ");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();

			cpg.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
