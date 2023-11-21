package py.com.ucsa.jdbc.dto;

import java.time.LocalDateTime;

public class TematicaParticExpoSocio {

	private Integer id;
	private ParticExpoSocio particExpoSocio;
	private Opcion idTematicaGeneral;
	private String tematicaEspecifica;
	private boolean canceloParticTematica;
	private LocalDateTime fechaCancelacion;
	private LocalDateTime fechaCreacion;
	private Usuario usuarioCreacion;
	
	public TematicaParticExpoSocio(Integer id) {
		this.id = id;
	}
	
	public TematicaParticExpoSocio() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ParticExpoSocio getParticExpoSocio() {
		return particExpoSocio;
	}

	public void setParticExpoSocio(ParticExpoSocio particExpoSocio) {
		this.particExpoSocio = particExpoSocio;
	}

	public Opcion getIdTematicaGeneral() {
		return idTematicaGeneral;
	}

	public void setIdTematicaGeneral(Opcion idTematicaGeneral) {
		this.idTematicaGeneral = idTematicaGeneral;
	}

	public String getTematicaEspecifica() {
		return tematicaEspecifica;
	}

	public void setTematicaEspecifica(String tematicaEspecifica) {
		this.tematicaEspecifica = tematicaEspecifica;
	}

	public boolean isCanceloParticTematica() {
		return canceloParticTematica;
	}

	public void setCanceloParticTematica(boolean canceloParticTematica) {
		this.canceloParticTematica = canceloParticTematica;
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
		return "TematicaParticExpoSocio [id=" + id + ", particExpoSocio=" + particExpoSocio + ", idTematicaGeneral="
				+ idTematicaGeneral + ", tematicaEspecifica=" + tematicaEspecifica + ", canceloParticTematica="
				+ canceloParticTematica + ", fechaCancelacion=" + fechaCancelacion + ", fechaCreacion=" + fechaCreacion
				+ ", usuarioCreacion=" + usuarioCreacion + "]";
	}

	
	
}
