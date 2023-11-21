package py.com.ucsa.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import py.com.ucsa.jdbc.dao.MontoCuotaDao;
import py.com.ucsa.jdbc.dto.MontoCuota;
import py.com.ucsa.jdbc.dto.Usuario;
import py.com.ucsa.utilites.ConexionBD;

public class MontoCuotaDaoImpl implements MontoCuotaDao {

	Connection cpg;
	Statement s;
	
	@Override
	public List<MontoCuota> listar() {

		List<MontoCuota> l_mc = new ArrayList<MontoCuota>();
		MontoCuota mc;

		try {
			cpg = ConexionBD.getConectionPG();
			s = cpg.createStatement();
			ResultSet rs = s.executeQuery("Select * from public.montos_cuota");
			
			while (rs.next()) {
				
				mc = new MontoCuota();
				mc.setId(rs.getInt("id"));
				mc.setMonto( rs.getDouble("monto") );
				mc.setFechaCreacion( rs.getTimestamp("fecha_creacion").toLocalDateTime() );
				mc.setFechaInicioVigencia( rs.getTimestamp("fecha_inicio_vigencia").toLocalDateTime() );
				mc.setFechaFinVigencia( rs.getTimestamp("fecha_fin_vigencia").toLocalDateTime() );
				mc.setEstado( rs.getString("estado") );
				mc.setFechaInactivacion( rs.getTimestamp("fecha_inactivacion").toLocalDateTime() );
				mc.setIdUsuarioInactivacion( new Usuario( rs.getInt("id_usuario_inactivacion") ) );

				l_mc.add(mc);

				s = null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l_mc;
		
	}

	@Override
	public MontoCuota getById(Integer id) {

		MontoCuota mc = null;
		
		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("select * from public.montos_cuota s where s.id = ? ");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
					
				mc = new MontoCuota();
				mc.setId(rs.getInt("id"));
				mc.setMonto( rs.getDouble("monto") );
				mc.setFechaCreacion( rs.getTimestamp("fecha_creacion").toLocalDateTime() );
				mc.setFechaInicioVigencia( rs.getTimestamp("fecha_inicio_vigencia").toLocalDateTime() );
				mc.setFechaFinVigencia( rs.getTimestamp("fecha_fin_vigencia").toLocalDateTime() );
				mc.setEstado( rs.getString("estado") );
				mc.setFechaInactivacion( rs.getTimestamp("fecha_inactivacion").toLocalDateTime() );
				mc.setIdUsuarioInactivacion( new Usuario( rs.getInt("id_usuario_inactivacion") ) );

				s = null;
				return mc;	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mc;
		
	}

	@Override
	public MontoCuota insertar(MontoCuota obj) {
		MontoCuota mc = null;

		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("INSERT INTO public.montos_cuota "
					+ "(monto, fecha_creacion, fecha_inicio_vigencia, fecha_fin_vigencia, estado) "
					+ "VALUES(?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);


			ps.setDouble(1, obj.getMonto());
			ps.setTimestamp(2, Timestamp.valueOf( obj.getFechaCreacion() ) );
			ps.setTimestamp(3, Timestamp.valueOf( obj.getFechaInactivacion() ) );
			ps.setTimestamp(4, Timestamp.valueOf( obj.getFechaFinVigencia()));
			ps.setString(5, obj.getEstado());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			obj.setId(rs.getInt("id"));
			mc = obj;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mc;
	}

	@Override
	public MontoCuota modificar(MontoCuota obj) {
		MontoCuota mc = null;

		try {
			cpg = ConexionBD.getConectionPG();
			PreparedStatement ps = cpg.prepareStatement("UPDATE public.montos_cuota SET "
					+ "	monto = ?, fecha_creacion = ?, fecha_inicio_vigencia = ?, fecha_fin_vigencia = ?, estado = ?, fecha_inactivacion =  ?, id_usuario_inactivacion = ? "
					+ " WHERE id = ? ");


			ps.setDouble(1, obj.getMonto());
			ps.setTimestamp(2, Timestamp.valueOf( obj.getFechaCreacion() ) );
			ps.setTimestamp(3, Timestamp.valueOf( obj.getFechaInactivacion() ) );
			ps.setTimestamp(4, Timestamp.valueOf( obj.getFechaFinVigencia() ) );
			ps.setString(5, obj.getEstado());
			ps.setTimestamp(6, Timestamp.valueOf( obj.getFechaInactivacion() ) );
			ps.setInt(7, obj.getIdUsuarioInactivacion().getId());
			ps.setInt(8, obj.getId());

			ps.executeUpdate();

			mc = obj;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mc;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MontoCuota getMontoCuotaByMesAnho(int mes, int anho) {
		// TODO Auto-generated method stub
		return null;
	}

}
