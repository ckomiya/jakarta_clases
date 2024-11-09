package pe.jakarta.lp1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_DIRECCION")
public class TipoDireccion {

	@Id
	@Column(name = "TIPO_DIRECCION_ID")
	private int tipoDireccionId;

	@Column(name = "CODIGO_TIPO_DIRECCION")
	private String codigoTipoDireccion;

	@Column(name = "DESCRIPCION_TIPO_DIRECCION")
	private String descripcionTipoDireccion;

	public int getTipoDireccionId() {
		return tipoDireccionId;
	}

	public void setTipoDireccionId(int tipoDireccionId) {
		this.tipoDireccionId = tipoDireccionId;
	}

	public String getCodigoTipoDireccion() {
		return codigoTipoDireccion;
	}

	public void setCodigoTipoDireccion(String codigoTipoDireccion) {
		this.codigoTipoDireccion = codigoTipoDireccion;
	}

	public String getDescripcionTipoDireccion() {
		return descripcionTipoDireccion;
	}

	public void setDescripcionTipoDireccion(String descripcionTipoDireccion) {
		this.descripcionTipoDireccion = descripcionTipoDireccion;
	}

	
}
