package py.com.ucsa.jdbc.dto;

import java.time.LocalDateTime;

public class Usuario {

	private Integer id;
	private String usuario;
	private String email;
	private String clave;
	private boolean habilitado;
	private boolean cuentaBloqueada;
	private boolean cuentaExpirada;
	private LocalDateTime fechaCreacionUsuario;
	private Integer idSocio;

	public Usuario() {
	}

	public Usuario(Integer id) {
		this.id = id;
	}

	public Usuario(Integer id, String usuario) {
		this.id = id;
		this.usuario = usuario;
	}

	public Usuario(Integer id, String usuario, String email, String clave, boolean habilitado, boolean cuentaBloqueada,
			boolean cuentaExpirada, LocalDateTime fechaCreacionUsuario, Integer idSocio) {
		this.id = id;
		this.usuario = usuario;
		this.email = email;
		this.clave = clave;
		this.habilitado = habilitado;
		this.cuentaBloqueada = cuentaBloqueada;
		this.cuentaExpirada = cuentaExpirada;
		this.fechaCreacionUsuario = fechaCreacionUsuario;
		this.idSocio = idSocio;
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

	public boolean isCuentaBloqueada() {
		return cuentaBloqueada;
	}

	public void setCuentaBloqueada(boolean cuentaBloqueada) {
		this.cuentaBloqueada = cuentaBloqueada;
	}

	public boolean isCuentaExpirada() {
		return cuentaExpirada;
	}

	public void setCuentaExpirada(boolean cuentaExpirada) {
		this.cuentaExpirada = cuentaExpirada;
	}

	public LocalDateTime getFechaCreacionUsuario() {
		return fechaCreacionUsuario;
	}

	public void setFechaCreacionUsuario(LocalDateTime fechaCreacionUsuario) {
		this.fechaCreacionUsuario = fechaCreacionUsuario;
	}

	public Integer getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(Integer idSocio) {
		this.idSocio = idSocio;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", email=" + email + ", clave=" + clave + ", habilitado="
				+ habilitado + ", cuentaBloqueada=" + cuentaBloqueada + ", cuentaExpirada=" + cuentaExpirada
				+ ", fechaCreacionUsuario=" + fechaCreacionUsuario + ", idSocio=" + idSocio + "]";
	}

}
