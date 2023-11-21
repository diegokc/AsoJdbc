package py.com.ucsa.jdbc.dto;

import java.time.LocalDateTime;

public class MensajeEnviadoSocio {
	
	private Integer id;
	private Socio socioDestino;
	private MensajeEnviadoSocio mensaje;
	private LocalDateTime fechaCreacion;
	private Usuario usuarioCreacion;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Socio getSocioDestino() {
		return socioDestino;
	}
	public void setSocioDestino(Socio socioDestino) {
		this.socioDestino = socioDestino;
	}
	public MensajeEnviadoSocio getMensaje() {
		return mensaje;
	}
	public void setMensaje(MensajeEnviadoSocio mensaje) {
		this.mensaje = mensaje;
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
		return "MensajeEnviadoSocio [id=" + id + ", socioDestino=" + socioDestino + ", mensaje=" + mensaje
				+ ", fechaCreacion=" + fechaCreacion + ", usuarioCreacion=" + usuarioCreacion + "]";
	}
	
	

}
