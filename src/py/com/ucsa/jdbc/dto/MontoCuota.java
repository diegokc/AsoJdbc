package py.com.ucsa.jdbc.dto;

import java.time.LocalDateTime;

public class MontoCuota {

	private Integer id;
	private double monto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaInicioVigencia;
	private LocalDateTime fechaFinVigencia;
	private String estado;
	private LocalDateTime fechaInactivacion;
	private Usuario idUsuarioInactivacion;
	
	
	public MontoCuota() {}


	public MontoCuota(Integer id, double monto, LocalDateTime fechaCreacion, LocalDateTime fechaInicioVigencia,
			LocalDateTime fechaFinVigencia, String estado, LocalDateTime fechaInactivacion,
			Usuario idUsuarioInactivacion) {
		this.id = id;
		this.monto = monto;
		this.fechaCreacion = fechaCreacion;
		this.fechaInicioVigencia = fechaInicioVigencia;
		this.fechaFinVigencia = fechaFinVigencia;
		this.estado = estado;
		this.fechaInactivacion = fechaInactivacion;
		this.idUsuarioInactivacion = idUsuarioInactivacion;
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


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public LocalDateTime getFechaInactivacion() {
		return fechaInactivacion;
	}


	public void setFechaInactivacion(LocalDateTime fechaInactivacion) {
		this.fechaInactivacion = fechaInactivacion;
	}


	public Usuario getIdUsuarioInactivacion() {
		return idUsuarioInactivacion;
	}


	public void setIdUsuarioInactivacion(Usuario idUsuarioInactivacion) {
		this.idUsuarioInactivacion = idUsuarioInactivacion;
	}


	@Override
	public String toString() {
		return "MontoCuota [id=" + id + ", monto=" + monto + ", fechaCreacion=" + fechaCreacion
				+ ", fechaInicioVigencia=" + fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia
				+ ", estado=" + estado + ", fechaInactivacion=" + fechaInactivacion + ", idUsuarioInactivacion="
				+ idUsuarioInactivacion + "]";
	}

	
}
