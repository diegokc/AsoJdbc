package py.com.ucsa.jdbc.dto;

import java.time.LocalDateTime;

public class ParticExpoSocio {

	private Integer id;
	private Socio socio;
	private Exposicion exposicion;
	private boolean canceloParticipacion;
	private LocalDateTime fechaCancelacion;
	private LocalDateTime fechaCreacion;
	private Usuario usuarioCreacion;
	
	
	public ParticExpoSocio() {
	}
	
	public ParticExpoSocio(Integer id) {
		this.id = id;
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

	public Exposicion getExposicion() {
		return exposicion;
	}

	public void setExposicion(Exposicion exposicion) {
		this.exposicion = exposicion;
	}

	public boolean isCanceloParticipacion() {
		return canceloParticipacion;
	}

	public void setCanceloParticipacion(boolean canceloParticipacion) {
		this.canceloParticipacion = canceloParticipacion;
	}

	public LocalDateTime getFechaCancelacion() {
		return fechaCancelacion;
	}

	public void setFechaCancelacion(LocalDateTime fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Usuario getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	@Override
	public String toString() {
		return "ParticExpoSocio [id=" + id + ", socio=" + socio + ", exposicion=" + exposicion
				+ ", canceloParticipacion=" + canceloParticipacion + ", fechaCancelacion=" + fechaCancelacion
				+ ", fechaCreacion=" + fechaCreacion + ", usuarioCreacion=" + usuarioCreacion + "]";
	}
		
	
	
}
