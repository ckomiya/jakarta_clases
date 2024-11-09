package pe.jakarta.lp1.cdi.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Cliente {
	
	private String nombre;
	private String apellido;

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
}
