package py.edu.ucsa.aso.web.jdbc.dao.dto;

import java.time.LocalDateTime;

public class CodigoDeSeguridad {
	private Integer id;
	private String codigo;
	private LocalDateTime horaPeticion;
	private Integer tipoActivacion;
	private Usuario usuario;
	
	
	
	@Override
	public String toString() {
		return "CodigoDeSeguridad [id=" + id + ", codigo=" + codigo + ", horaPeticion=" + horaPeticion
				+ ", tipoActivacion=" + tipoActivacion + ", usuario=" + usuario + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public LocalDateTime getHoraPeticion() {
		return horaPeticion;
	}
	public void setHoraPeticion(LocalDateTime horaPeticion) {
		this.horaPeticion = horaPeticion;
	}
	public Integer getTipoActivacion() {
		return tipoActivacion;
	}
	public void setTipoActivacion(Integer tipoActivacion) {
		this.tipoActivacion = tipoActivacion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
