package py.edu.ucsa.aso.web.jdbc.dao.dto;

import java.time.LocalDate;

public class Socio {
	
	private int id;
	private String nombres;
	private String apellidos;
	private String email;
	private int nroSocio;
	private int nroCedula;
	private LocalDate fechaIngreso;
	private Opcion estadoActual;
	private LocalDate fechaEstadoActual;
	private boolean fundador;
	private Usuario usuarioCreacion;
	private LocalDate fecha_creacion;
	private Socio socioProponente;
	private Opcion tipoSocio;
	
	
	
	public Socio(int id) {
		super();
		this.id = id;
	}
	public Socio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getNroSocio() {
		return nroSocio;
	}
	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
	}
	public int getNroCedula() {
		return nroCedula;
	}
	public void setNroCedula(int nroCedula) {
		this.nroCedula = nroCedula;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Opcion getEstadoActual() {
		return estadoActual;
	}
	public void setEstadoActual(Opcion estadoActual) {
		this.estadoActual = estadoActual;
	}
	public LocalDate getFechaEstadoActual() {
		return fechaEstadoActual;
	}
	public void setFechaEstadoActual(LocalDate fechaEstadoActual) {
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
	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(LocalDate fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public Socio getSocioProponente() {
		return socioProponente;
	}
	public void setSocioProponente(Socio socioProponente) {
		this.socioProponente = socioProponente;
	}
	public Opcion getTipoSocio() {
		return tipoSocio;
	}
	public void setTipoSocio(Opcion tipoSocio) {
		this.tipoSocio = tipoSocio;
	}
	@Override
	public String toString() {
		return "Socio [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email
				+ ", nroSocio=" + nroSocio + ", nroCedula=" + nroCedula + ", fechaIngreso=" + fechaIngreso
				+ ", estadoActual=" + estadoActual + ", fechaEstadoActual=" + fechaEstadoActual + ", fundador="
				+ fundador + ", usuarioCreacion=" + usuarioCreacion + ", fecha_creacion=" + fecha_creacion
				+ ", socioProponente=" + socioProponente + ", tipoSocio=" + tipoSocio + "]";
	}
	
	
	
	
	
	
	
	

}
