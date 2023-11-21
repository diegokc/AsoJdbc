package py.edu.ucsa.aso.web.jdbc.dao.dto;

public class Menu {
	
	private Integer id;
	private String columnaMenu;
	private String estado;
	private String icono;
	private String nombre;
	private String tipoMenu;
	private String tipoUsuario;
	private String vista;
	private Integer subMenu;
	
	
	
	@Override
	public String toString() {
		return "Menu [id=" + id + ", columnaMenu=" + columnaMenu + ", estado=" + estado + ", icono=" + icono
				+ ", nombre=" + nombre + ", tipoMenu=" + tipoMenu + ", tipoUsuario=" + tipoUsuario + ", vista=" + vista
				+ ", subMenu=" + subMenu + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getColumnaMenu() {
		return columnaMenu;
	}
	public void setColumnaMenu(String columnaMenu) {
		this.columnaMenu = columnaMenu;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoMenu() {
		return tipoMenu;
	}
	public void setTipoMenu(String tipoMenu) {
		this.tipoMenu = tipoMenu;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getVista() {
		return vista;
	}
	public void setVista(String vista) {
		this.vista = vista;
	}
	public Integer getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(Integer subMenu) {
		this.subMenu = subMenu;
	}
	
	

}
