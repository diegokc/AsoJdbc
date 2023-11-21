package py.com.ucsa.jdbc.dto;

public class Opcion {

	private Integer id;
	private Dominio dominio;
	private String codigo;
	private String descripcion;
	private String estado;
	private Opcion opcionPadre;

	public Opcion() {
	}

	public Opcion(Integer id) {
		this.id = id;
	}

	public Opcion(Integer id, Dominio dominio, String codigo, String descripcion, String estado, Opcion opcionPadre) {
		this.id = id;
		this.dominio = dominio;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.opcionPadre = opcionPadre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dominio getDominio() {
		return dominio;
	}

	public void setDominio(Dominio dominio) {
		this.dominio = dominio;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Opcion getOpcionPadre() {
		return opcionPadre;
	}

	public void setOpcionPadre(Opcion opcionPadre) {
		this.opcionPadre = opcionPadre;
	}

	@Override
	public String toString() {
		String tos = "Opcion [id=" + id + ", ";
		if (dominio != null) {
			tos += "dominio=" + dominio;
		}
		tos += ", codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado;
		if (opcionPadre!= null) {
			tos += ", opcionPadre=" + opcionPadre;
		}
		tos += "]";
		return tos;
	}

}
