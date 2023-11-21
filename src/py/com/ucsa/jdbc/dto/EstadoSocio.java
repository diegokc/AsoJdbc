package py.com.ucsa.jdbc.dto;

import java.time.LocalDateTime;

public class EstadoSocio {

	private Integer id;
	private Socio idSocio;
	private Integer idEstado;
	private LocalDateTime fechaEstado;
	private Integer idUsuarioCreacion;
	private LocalDateTime fechaCreacion;
	private String observacion;
	
	public EstadoSocio() {
	}

	public EstadoSocio(Integer id) {
		this.id = id;
	}
			
	public EstadoSocio(Integer id, Socio idSocio, Integer idEstado, LocalDateTime fechaEstado,
			Integer idUsuarioCreacion, LocalDateTime fechaCreacion, String observacion) {
		this.id = id;
		this.idSocio = idSocio;
		this.idEstado = idEstado;
		this.fechaEstado = fechaEstado;
		this.idUsuarioCreacion = idUsuarioCreacion;
		this.fechaCreacion = fechaCreacion;
		this.observacion = observacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Socio getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(Socio idSocio) {
		this.idSocio = idSocio;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public LocalDateTime getFechaEstado() {
		return fechaEstado;
	}

	public void setFechaEstado(LocalDateTime fechaEstado) {
		this.fechaEstado = fechaEstado;
	}

	public Integer getIdUsuarioCreacion() {
		return idUsuarioCreacion;
	}

	public void setIdUsuarioCreacion(Integer idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public String toString() {
		return "EstadoSocio [id=" + id + ", idSocio=" + idSocio + ", idEstado=" + idEstado + ", fechaEstado="
				+ fechaEstado + ", idUsuarioCreacion=" + idUsuarioCreacion + ", fechaCreacion=" + fechaCreacion
				+ ", observacion=" + observacion + "]";
	}

	
	
}