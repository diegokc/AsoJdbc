package py.com.ucsa.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.com.ucsa.jdbc.dao.PagoCuotaSocioDao;
import py.com.ucsa.jdbc.dto.PagoCuotaSocio;
import py.com.ucsa.utilites.ConexionBD;

public class PagoCuotaSocioDaoImpl implements PagoCuotaSocioDao {

	Connection cpg;
	Statement s;
	
	@Override
	public List<PagoCuotaSocio> listar() {
		List<PagoCuotaSocio> l_op = new ArrayList<PagoCuotaSocio>();
		PagoCuotaSocio op;

		try {
			cpg = ConexionBD.getConectionPG();
			s = cpg.createStatement();
			ResultSet rs = s.executeQuery("Select * from public.montos_cuota");
			
			while (rs.next()) {
				
				op = new PagoCuotaSocio();
				op.setId(rs.getInt("id"));
				op.setAnhoCuota( rs.getDouble("anho_cuota") );
				op.setExonerado( rs.getBoolean("exonerado") );
				op.setFechaCreacion( rs.getTimestamp("fecha_creacion").toLocalDateTime() );
				op.setMesCuota( rs.getDouble("mes_cuota") );
				op.setMontoCuota( rs.getDouble("monto_cuota") );
				op.setIdEstado( rs.getInt("id_estado") );
				op.setIdMotivoExoneracion( rs.getInt("id_motivo_exoneracion") );
				op.setIdSocio( rs.getInt("id_socio") );
				op.setIdUsuarioCreacion( rs.getInt("id_usuario_creacion") );

				l_op.add(op);

				s = null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l_op;
	}

	@Override
	public PagoCuotaSocio getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagoCuotaSocio insertar(PagoCuotaSocio objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagoCuotaSocio modificar(PagoCuotaSocio objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
