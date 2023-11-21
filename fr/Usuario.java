package py.edu.ucsa.aso.web.jdbc.dao.dto;

import java.time.LocalDate;

public class Usuario {

	private Integer id;
	private String usuario;
	private String email;
	private String clave;
	private boolean habilitado;
	private boolean cuentaExpirada;
	private LocalDate fecha_creacion_usuario;
	private Integer id_socio;
	
	
	
	public Usuario(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	public boolean isCuenta_expirada() {
		return cuentaExpirada;
	}
	public void setCuenta_expirada(boolean cuenta_expirada) {
		this.cuentaExpirada = cuenta_expirada;
	}
	public LocalDate getFecha_creacion_usuario() {
		return fecha_creacion_usuario;
	}
	public void setFecha_creacion_usuario(LocalDate fecha_creacion_usuario) {
		this.fecha_creacion_usuario = fecha_creacion_usuario;
	}
	public Integer getId_socio() {
		return id_socio;
	}
	public void setId_socio(Integer id_socio) {
		this.id_socio = id_socio;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", email=" + email + ", clave=" + clave + ", habilitado="
				+ habilitado + ", cuentaExpirada=" + cuentaExpirada + ", fecha_creacion_usuario="
				+ fecha_creacion_usuario + ", id_socio=" + id_socio + "]";
	}
	
	
	
}
