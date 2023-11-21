package py.com.ucsa.jdbc.dto;

public class Dominio {

	private Integer id;
	private String codigo;
	private String descripcion;
	private Dominio idDominioPadre;
	private String estado;
		
	public Dominio() {
		
	}
	
	public Dominio(Integer id) {
		this.id = id;
	}

	public Dominio(Integer id, String codigo, String descripcion, Dominio idDominioPadre, String estado) {
		this.id = id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.idDominioPadre = idDominioPadre;
		this.estado = estado;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Dominio getIdDominioPadre() {
		return idDominioPadre;
	}

	public void setIdDominioPadre(Dominio idDominioPadre) {
		this.idDominioPadre = idDominioPadre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Dominio [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", idDominioPadre="
				+ idDominioPadre + ", estado=" + estado + "]";
	}

	
}
