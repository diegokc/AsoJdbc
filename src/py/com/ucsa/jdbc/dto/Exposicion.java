package py.com.ucsa.jdbc.dto;

import java.time.LocalDateTime;

public class Exposicion {

	private Integer id;
	private String nombre;
	private String descripcion;
	private String organiza;
	private String ubicacion;
	private LocalDateTime fechaExpo;
	private String contacto;
	private LocalDateTime fechaCreacion;
	private Usuario usuarioCreacion;
	
	
	public Exposicion() {
	}
	
	
	public Exposicion(Integer id) {
		this.id = id;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getOrganiza() {
		return organiza;
	}
	public void setOrganiza(String organiza) {
		this.organiza = organiza;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public LocalDateTime getFechaExpo() {
		return fechaExpo;
	}
	public void setFechaExpo(LocalDateTime fechaExpo) {
		this.fechaExpo = fechaExpo;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
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
		return "Exposicion [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", organiza=" + organiza
				+ ", ubicacion=" + ubicacion + ", fechaExpo=" + fechaExpo + ", contacto=" + contacto
				+ ", fechaCreacion=" + fechaCreacion + ", usuarioCreacion=" + usuarioCreacion + "]";
	}


	
	
}
