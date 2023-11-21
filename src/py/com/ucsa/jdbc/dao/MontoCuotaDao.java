package py.com.ucsa.jdbc.dao;

import py.com.ucsa.jdbc.dto.MontoCuota;

public interface MontoCuotaDao extends GenericDao<MontoCuota> {

	MontoCuota getMontoCuotaByMesAnho(int mes, int anho);

}
