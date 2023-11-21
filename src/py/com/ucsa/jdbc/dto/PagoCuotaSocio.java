package py.com.ucsa.jdbc.dto;

import java.time.LocalDateTime;

public class PagoCuotaSocio {

	private Integer id;
	private double anhoCuota;
	private boolean exonerado;
	private LocalDateTime fechaCreacion;
	private double mesCuota;
	private double montoCuota;
	private Integer idEstado;
	private Integer idMotivoExoneracion;
	private Integer idMovimientoSocio;
	private Integer idSocio;
	private Integer idUsuarioCreacion;
	
	public PagoCuotaSocio() {}
	
	public PagoCuotaSocio(Integer id, double anhoCuota, boolean exonerado, LocalDateTime fechaCreacion, double mesCuota,
			double montoCuota, Integer idEstado, Integer idMotivoExoneracion, Integer idMovimientoSocio,
			Integer idSocio, Integer idUsuarioCreacion) {
		this.id = id;
		this.anhoCuota = anhoCuota;
		this.exonerado = exonerado;
		this.fechaCreacion = fechaCreacion;
		this.mesCuota = mesCuota;
		this.montoCuota = montoCuota;
		this.idEstado = idEstado;
		this.idMotivoExoneracion = idMotivoExoneracion;
		this.idMovimientoSocio = idMovimientoSocio;
		this.idSocio = idSocio;
		this.idUsuarioCreacion = idUsuarioCreacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getAnhoCuota() {
		return anhoCuota;
	}

	public void setAnhoCuota(double anhoCuota) {
		this.anhoCuota = anhoCuota;
	}

	public boolean isExonerado() {
		return exonerado;
	}

	public void setExonerado(boolean exonerado) {
		this.exonerado = exonerado;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public double getMesCuota() {
		return mesCuota;
	}

	public void setMesCuota(double mesCuota) {
		this.mesCuota = mesCuota;
	}

	public double getMontoCuota() {
		return montoCuota;
	}

	public void setMontoCuota(double montoCuota) {
		this.montoCuota = montoCuota;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public Integer getIdMotivoExoneracion() {
		return idMotivoExoneracion;
	}

	public void setIdMotivoExoneracion(Integer idMotivoExoneracion) {
		this.idMotivoExoneracion = idMotivoExoneracion;
	}

	public Integer getIdMovimientoSocio() {
		return idMovimientoSocio;
	}

	public void setIdMovimientoSocio(Integer idMovimientoSocio) {
		this.idMovimientoSocio = idMovimientoSocio;
	}

	public Integer getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(Integer idSocio) {
		this.idSocio = idSocio;
	}

	public Integer getIdUsuarioCreacion() {
		return idUsuarioCreacion;
	}

	public void setIdUsuarioCreacion(Integer idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}
	
	
	
}