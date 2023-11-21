package py.com.ucsa.jdbc.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Socio {

	private Integer id;
	private String nombres;
	private String apellidos;
	private String email;
	private Integer nroSocio;
	private Integer nroCedula;
	private LocalDate fechaIngreso;
	private Opcion idEstadoActual;
	private LocalDateTime fechaEstadoActual;
	private boolean fundador;
	private Usuario usuarioCreacion;
	private LocalDateTime fechaCreacion;
	private Long idSocioProponente;
	private Long idTipoSocio;
	
	public Socio() {}

	public Socio(Integer id) {
		this.id = id;
	}
	
	public Socio(Integer id, String nombres, String apellidos, String email, Integer nroSocio, Integer nroCedula,
			LocalDate fechaIngreso, Opcion idEstadoActual, LocalDateTime fechaEstadoActual, boolean fundador,
			Usuario usuarioCreacion, LocalDateTime fechaCreacion, Long idSocioProponente, Long idTipoSocio) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.nroSocio = nroSocio;
		this.nroCedula = nroCedula;
		this.fechaIngreso = fechaIngreso;
		this.idEstadoActual = idEstadoActual;
		this.fechaEstadoActual = fechaEstadoActual;
		this.fundador = fundador;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaCreacion = fechaCreacion;
		this.idSocioProponente = idSocioProponente;
		this.idTipoSocio = idTipoSocio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNroSocio() {
		return nroSocio;
	}

	public void setNroSocio(Integer nroSocio) {
		this.nroSocio = nroSocio;
	}

	public Integer getNroCedula() {
		return nroCedula;
	}

	public void setNroCedula(Integer nroCedula) {
		this.nroCedula = nroCedula;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Opcion getIdEstadoActual() {
		return idEstadoActual;
	}

	public void setIdEstadoActual(Opcion idEstadoActual) {
		this.idEstadoActual = idEstadoActual;
	}

	public LocalDateTime getFechaEstadoActual() {
		return fechaEstadoActual;
	}

	public void setFechaEstadoActual(LocalDateTime fechaEstadoActual) {
		this.fechaEstadoActual = fechaEstadoActual;
	}

	public boolean isFundador() {
		return fundador;
	}

	public void setFundador(boolean fundador) {
		this.fundador = fundador;
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

	public Long getIdSocioProponente() {
		return idSocioProponente;
	}

	public void setIdSocioProponente(Long idSocioProponente) {
		this.idSocioProponente = idSocioProponente;
	}

	public Long getIdTipoSocio() {
		return idTipoSocio;
	}

	public void setIdTipoSocio(Long idTipoSocio) {
		this.idTipoSocio = idTipoSocio;
	}

	@Override
	public String toString() {
		return "Socio [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email
				+ ", nroSocio=" + nroSocio + ", nroCedula=" + nroCedula + ", fechaIngreso=" + fechaIngreso
				+ ", idEstadoActual=" + idEstadoActual + ", fechaEstadoActual=" + fechaEstadoActual + ", fundador="
				+ fundador + ", idUsuarioCreacion=" + usuarioCreacion + ", fechaCreacion=" + fechaCreacion
				+ ", idSocioProponente=" + idSocioProponente + ", idTipoSocio=" + idTipoSocio + "]";
	}


	
}
