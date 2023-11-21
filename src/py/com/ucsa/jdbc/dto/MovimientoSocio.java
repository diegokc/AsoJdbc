package py.com.ucsa.jdbc.dto;

import java.time.LocalDateTime;

public class MovimientoSocio {
	private Integer id;
	private LocalDateTime fechaPago;
	private double monto;
	private Opcion concepto;
	private Opcion estado;
	private Opcion medioPago;
	private Socio socio;
	private TipoMovimiento tipoMovimiento;
	private Usuario usuarioAprobacion;
	private Usuario usuarioCreacion;

	public MovimientoSocio(Integer id) {
		super();
		this.id = id;
	}

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Opcion getConcepto() {
		return concepto;
	}

	public void setConcepto(Opcion concepto) {
		this.concepto = concepto;
	}

	public Opcion getEstado() {
		return estado;
	}

	public void setEstado(Opcion estado) {
		this.estado = estado;
	}

	public Opcion getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(Opcion medioPago) {
		this.medioPago = medioPago;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Usuario getUsuarioAprobacion() {
		return usuarioAprobacion;
	}

	public void setUsuarioAprobacion(Usuario usuarioAprobacion) {
		this.usuarioAprobacion = usuarioAprobacion;
	}

	public Usuario getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	@Override
	public String toString() {
		return "MovimientoSocio [id=" + id + ", fechaPago=" + fechaPago + ", monto=" + monto + ", concepto=" + concepto
				+ ", estado=" + estado + ", medioPago=" + medioPago + ", socio=" + socio + ", tipoMovimiento="
				+ tipoMovimiento + ", usuarioAprobacion=" + usuarioAprobacion + ", usuarioCreacion=" + usuarioCreacion
				+ "]";
	}

}
