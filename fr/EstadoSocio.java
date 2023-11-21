package py.edu.ucsa.aso.web.jdbc.dao.dto;

import java.time.LocalDateTime;

public class EstadoSocio {
	private Integer id;
	private Socio socio;
	private EstadoSocio estado;
	private LocalDateTime fechaEstado;
	private Usuario usuarioCreacion;
	private LocalDateTime fechaCreacion;
	private String observacion;
	
	
	
	
	@Override
	public String toString() {
		return "EstadoSocio [id=" + id + ", socio=" + socio + ", estado=" + estado + ", fechaEstado=" + fechaEstado
				+ ", usuarioCreacion=" + usuarioCreacion + ", fechaCreacion=" + fechaCreacion + ", observacion="
				+ observacion + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	public EstadoSocio getEstado() {
		return estado;
	}
	public void setEstado(EstadoSocio estado) {
		this.estado = estado;
	}
	public LocalDateTime getFechaEstado() {
		return fechaEstado;
	}
	public void setFechaEstado(LocalDateTime fechaEstado) {
		this.fechaEstado = fechaEstado;
	}
	public Usuario getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
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

	
}
