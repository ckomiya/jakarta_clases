package pe.jakarta.lp1.cdi.controller;

import java.io.Serializable;

import jakarta.enterprise.context.Conversation;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import pe.jakarta.lp1.cdi.beans.Empleado;
import pe.jakarta.lp1.cdi.event.NavegacionInfo;

@Named
@RequestScoped
public class EmpleadoInfoController implements Serializable {

	@Inject
	private Conversation conversation;

	@Inject
	private Empleado empleado;

	@Inject
	private Event<NavegacionInfo> navegacionInfoEvent;

	public String empleadoInfoEntrada() {
		conversation.begin();
		NavegacionInfo navegacionInfo = new NavegacionInfo();
		navegacionInfo.setPagina("1");
		navegacionInfo.setEmpleado(empleado);
		navegacionInfoEvent.fire(navegacionInfo);
		return "emp_pag_1";
	}

	public String navegarAPagina1() {
		NavegacionInfo navegacionInfo = new NavegacionInfo();
		navegacionInfo.setPagina("1");
		navegacionInfo.setEmpleado(empleado);
		navegacionInfoEvent.fire(navegacionInfo);
		return "emp_pag_1";
	}

	public String navegarAPagina2() {
		NavegacionInfo navegacionInfo = new NavegacionInfo();
		navegacionInfo.setPagina("2");
		navegacionInfo.setEmpleado(empleado);
		navegacionInfoEvent.fire(navegacionInfo);
		return "emp_pag_2";
	}

	public String navegarAPagina3() {
		NavegacionInfo navegacionInfo = new NavegacionInfo();
		navegacionInfo.setPagina("3");
		navegacionInfo.setEmpleado(empleado);
		navegacionInfoEvent.fire(navegacionInfo);
		return "emp_pag_3";
	}

	public String navegarAPaginaConfirmacion() {
		NavegacionInfo navegacionInfo = new NavegacionInfo();
		navegacionInfo.setPagina("confirmacion");
		navegacionInfo.setEmpleado(empleado);
		navegacionInfoEvent.fire(navegacionInfo);
		conversation.end();
		return "emp_confirmacion";
	}
}