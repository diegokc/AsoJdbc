package py.com.ucsa.jdbc.dto;

public class RolUsuario {

	private Usuario usuario;
	private Rol rol;
	
	
	public RolUsuario() {
	}
	
	public RolUsuario(Usuario usuario, Rol rol) {
		this.usuario = usuario;
		this.rol = rol;
	}

	public RolUsuario(Integer id_usuario, Integer id_rol) {
		this.usuario = new Usuario(id_usuario);
		this.rol = new Rol(id_rol);
	}
		
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "RolUsuario [usuario=" + usuario + ", rol=" + rol + "]";
	}
	
	
	
}
