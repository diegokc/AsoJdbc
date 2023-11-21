package py.com.ucsa.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import py.com.ucsa.jdbc.dao.DAOFactory;
import py.com.ucsa.jdbc.dao.OpcionDao;
import py.com.ucsa.jdbc.dto.Opcion;
import py.com.ucsa.jdbc.dto.Usuario;
import py.com.ucsa.jdbc.dto.Dominio;
import py.com.ucsa.utilites.ConexionBD;
import py.com.ucsa.utilites.DateUtil;

public class OpcionDaoImpl implements OpcionDao {

	Connection cpg;
	Statement s;
	private final String QUERY_BASE = " select o.*, d.codigo cod_dominio, d.descripcion desc_dominio, "
			+" padre.codigo cod_opcion_padre, padre.descripcion desc_opcion_padre "
			+ " FROM public.opciones o JOIN dominios d ON o.id_dominio  = d.id  "
			+ " LEFT OUTER JOIN public.opciones padre ON o.id_opcion_padre = padre.id ";
	

	@Override
	public List<Opcion> listar() {
		List<Opcion> l_op = new ArrayList<Opcion>();

		try {
			cpg = ConexionBD.getConectionPG();
			s = cpg.createStatement();
			ResultSet rs = s.executeQuery(QUERY_BASE+ " order by descripcion asc");

			while (rs.next()) {

				l_op.add(setDatosOpcionFromDB(rs));

				s = null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l_op;
	}

	@Override
	public Opcion getById(Integer id) {
		Opcion op = null;

		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement(QUERY_BASE+ " where o.id = ? ");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				op = setDatosOpcionFromDB(rs);

				s = null;
				return op;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return op;
	}

	@Override
	public Opcion insertar(Opcion obj) {
		Opcion op = null;

		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("INSERT INTO public.opciones "
					+ "(id_dominio, codigo, descripcion, estado, id_opcion_padre) " + "VALUES(?, ?, ?, ?, ?) ",
					Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, obj.getDominio().getId());
			ps.setString(2, obj.getCodigo());
			ps.setString(3, obj.getDescripcion());
			ps.setString(4, obj.getEstado());
			if(obj.getOpcionPadre()!=null) {
				ps.setInt(5, obj.getOpcionPadre().getId());
			}
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			obj.setId(rs.getInt("id"));
			op = obj;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return op;
	}

	@Override
	public Opcion modificar(Opcion objeto) {

		try {
			cpg = ConexionBD.getConectionPG();
			cpg.setAutoCommit(false);

			PreparedStatement ps = cpg.prepareStatement("UPDATE public.opciones SET "
					+ "codigo = ?, "
					+ "id_dominio = ?, "
					+ "descripcion = ?, "
					+ "estado = ?, "
					+ "id_opcion_padre = ? "
					+ " WHERE id = ? ");

			ps.setString(1, objeto.getCodigo());
			ps.setInt(2, objeto.getDominio().getId());
			ps.setString(3, objeto.getDescripcion());
			ps.setString(4, objeto.getEstado());
			ps.setInt(5, objeto.getOpcionPadre().getId());
			ps.setInt(6, objeto.getId());
			
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

		return objeto;
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Opcion getOpcionByCodDominioCodOpcion(String codDominio, String codOpcion) {
		Opcion op = new Opcion();
		;

		try {
			op = null;
			cpg = ConexionBD.getConectionPG();
			s = cpg.createStatement();
			PreparedStatement ps = cpg.prepareStatement(QUERY_BASE + " WHERE d.codigo = '?' and o.codigo = '?' ");
			ps.setString(1, codDominio);
			ps.setString(2, codOpcion);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				op = setDatosOpcionFromDB(rs);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return op;

	}

	@Override
	public List<Opcion> getOpcionByCodDominio(String codDominio) {
		List<Opcion> l_op = new ArrayList<Opcion>();
		Opcion op;

		try {

			cpg = ConexionBD.getConectionPG();
			s = cpg.createStatement();
			PreparedStatement ps = cpg.prepareStatement(QUERY_BASE + " WHERE d.codigo = ? ");
			ps.setString(1, codDominio);
			ResultSet rs = ps.executeQuery();


			while (rs.next()) {
				op = null;
				op = setDatosOpcionFromDB(rs);
				
				l_op.add(op);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l_op;
	}
	

	@Override
	public List<Opcion> getOpcionByIdDominio(Integer idDominio) {
		List<Opcion> l_op = new ArrayList<Opcion>();
		Opcion op;

		try {

			cpg = ConexionBD.getConectionPG();
			s = cpg.createStatement();
			PreparedStatement ps = cpg.prepareStatement(QUERY_BASE + " WHERE d.id = ? ");
			ps.setInt(1, idDominio);
			ResultSet rs = ps.executeQuery();


			while (rs.next()) {
				op = null;
				op = setDatosOpcionFromDB(rs);
				
				l_op.add(op);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l_op;
	}
	
	private Opcion setDatosOpcionFromDB(ResultSet rs) throws SQLException {
		Opcion opcion = new Opcion();
		opcion.setId(rs.getInt("id"));
		opcion.setCodigo(rs.getString("codigo"));
		opcion.setDescripcion(rs.getString("descripcion"));
		opcion.setEstado(rs.getString("estado"));
		Dominio dominio = new Dominio();
		dominio.setId(rs.getInt("id_dominio"));
		dominio.setCodigo(rs.getString("cod_dominio"));
		dominio.setDescripcion(rs.getString("desc_dominio"));
		opcion.setDominio(dominio);
		if (Objects.nonNull(rs.getInt("id_opcion_padre"))) {
			Opcion opcPadre = new Opcion();
			opcPadre.setId(rs.getInt("id_opcion_padre"));
			opcPadre.setCodigo(rs.getString("cod_opcion_padre"));
			opcPadre.setDescripcion(rs.getString("desc_opcion_padre"));
			opcion.setOpcionPadre(opcPadre);
		}
		return opcion;
	}

}
