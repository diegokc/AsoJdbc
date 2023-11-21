package py.com.ucsa.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.com.ucsa.jdbc.dao.DominioDao;
import py.com.ucsa.jdbc.dto.Dominio;
import py.com.ucsa.utilites.ConexionBD;

public class DominioDaoImpl implements DominioDao {

	Connection cpg;
	Statement s;
	
	@Override
	public List<Dominio> listar() {

		List<Dominio> l_dm = new ArrayList<Dominio>();
		Dominio dm;

		try {
			cpg = ConexionBD.getConectionPG();
			s = cpg.createStatement();
			ResultSet rs = s.executeQuery("Select * from public.dominios ");
			
			while (rs.next()) {
					
				dm = new Dominio();
				dm.setId(rs.getInt("id"));
				dm.setCodigo( rs.getString("codigo") );
				dm.setDescripcion( rs.getString("descripcion") );
				dm.setIdDominioPadre( new Dominio(rs.getInt("id_dominio_padre")) );
				dm.setEstado( rs.getString("estado") );

				l_dm.add(dm);
				
			}
			s = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l_dm;
		
	}

	@Override
	public Dominio getById(Integer id) {
		Dominio dm = null;
		
		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("select * from public.dominios s where s.id = ? ");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
					
				dm = new Dominio();
				dm.setId(rs.getInt("id"));
				dm.setCodigo( rs.getString("codigo") );
				dm.setDescripcion( rs.getString("descripcion") );
				dm.setIdDominioPadre( new Dominio(rs.getInt("id_dominio_padre")) );
				dm.setEstado( rs.getString("estado") );

				s = null;
				return dm;	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dm;
	}

	@Override
	public Dominio getDominioByCodigo(String codigo) {
		Dominio dm = null;
		
		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("select * from public.dominios s where s.codigo = ? ");
			ps.setString(1, codigo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
					
				dm = new Dominio();
				dm.setId(rs.getInt("id"));
				dm.setCodigo( rs.getString("codigo") );
				dm.setDescripcion( rs.getString("descripcion") );
				dm.setIdDominioPadre( new Dominio(rs.getInt("id_dominio_padre")) );
				dm.setEstado( rs.getString("estado") );

				s = null;
				return dm;	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dm;
	}
	
	@Override
	public Dominio insertar(Dominio obj) {
		Dominio dm = null;

		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("INSERT INTO public.dominios "
					+ "(codigo, descripcion, id_dominio_padre, estado) "
					+ "VALUES(?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, obj.getCodigo());
			ps.setString(2,obj.getDescripcion() );
			ps.setInt(3, obj.getIdDominioPadre().getId() );
			ps.setString(4, obj.getEstado());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			obj.setId(rs.getInt("id"));
			dm = obj;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dm;
	}

	@Override
	public Dominio modificar(Dominio objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
