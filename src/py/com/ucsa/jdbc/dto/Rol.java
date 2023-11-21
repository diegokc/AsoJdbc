package py.com.ucsa.jdbc.dto;

public class Rol {

	private Integer id;
	private String nombreRol;
	
	public Rol(Integer id) {
		this.id = id;
	}

	public Rol(Integer id, String nombreRol) {
		this.id = id;
		this.nombreRol=nombreRol;
	}
	
	public Rol() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombreRol=" + nombreRol + "]";
	}
	
	

}
