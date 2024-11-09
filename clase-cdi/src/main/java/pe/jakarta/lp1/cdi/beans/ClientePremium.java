package pe.jakarta.lp1.cdi.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import pe.jakarta.lp1.cdi.qualifiers.Premium;

@Named
@RequestScoped
@Premium
public class ClientePremium extends Cliente {

    private Integer codigoDescuento;

	public Integer getCodigoDescuento() {
		return codigoDescuento;
	}

	public void setCodigoDescuento(Integer codigoDescuento) {
		this.codigoDescuento = codigoDescuento;
	}

}