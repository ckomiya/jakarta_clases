package pe.jakarta.lp1.et2.controller;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import pe.jakarta.lp1.et2.dao.EmpleadoDao;
import pe.jakarta.lp1.et2.entity.Empleado;

@Named
@SessionScoped
public class EmpleadoController implements Serializable{
	
	@EJB
	private EmpleadoDao empleadoDao;
	
	private List<Empleado> empleados;
	
	private Empleado empleado = new Empleado();

	public String guardarYPreparar() {
		
		
		
		try {
			empleadoDao.guardarEmpleado(empleado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado guardado de manera satisfactoria"));
		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al guardar el empleado"));
			return null;
		}
		
		
		
		empleado = new Empleado();
		return null;
	}
	
	
	public String guardarYListar() {
		
		try {
			empleadoDao.guardarEmpleado(empleado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado guardado de manera satisfactoria"));
		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al guardar el empleado"));
			return null;
		}
		
		empleados = empleadoDao.obtenerEmpleados();
		
		return "listado";
	}
	
	
	public String nuevoEmpleado() {
		
		empleado = new Empleado();
		
		return "index";
	}
	
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
	

}
