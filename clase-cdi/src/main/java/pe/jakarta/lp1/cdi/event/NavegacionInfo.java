package pe.jakarta.lp1.cdi.event;

import java.io.Serializable;

import pe.jakarta.lp1.cdi.beans.Empleado;

public class NavegacionInfo implements Serializable {

	private String pagina;
	private Empleado empleado;
	
	public String getPagina() {
		return pagina;
	}
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
}
