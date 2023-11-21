package py.edu.ucsa.aso.web.jdbc.dao.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MontoCuota {

	private Integer id;
	private double monto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaInicioVigencia;
	private LocalDateTime fechaFinVigencia;
	private LocalDateTime fechaInactivacion;
	private String estado;
	private Usuario usuarioInactivacion;
	
	
	
	
	@Override
	public String toString() {
		return "MontoCuota [id=" + id + ", monto=" + monto + ", fechaCreacion=" + fechaCreacion
				+ ", fechaInicioVigencia=" + fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia
				+ ", fechaInactivacion=" + fechaInactivacion + ", estado=" + estado + ", usuarioInactivacion="
				+ usuarioInactivacion + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public LocalDateTime getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}
	public void setFechaInicioVigencia(LocalDateTime fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}
	public LocalDateTime getFechaFinVigencia() {
		return fechaFinVigencia;
	}
	public void setFechaFinVigencia(LocalDateTime fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}
	public LocalDateTime getFechaInactivacion() {
		return fechaInactivacion;
	}
	public void setFechaInactivacion(LocalDateTime fechaInactivacion) {
		this.fechaInactivacion = fechaInactivacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Usuario getUsuarioInactivacion() {
		return usuarioInactivacion;
	}
	public void setUsuarioInactivacion(Usuario usuarioInactivacion) {
		this.usuarioInactivacion = usuarioInactivacion;
	}
	
	

	
}
