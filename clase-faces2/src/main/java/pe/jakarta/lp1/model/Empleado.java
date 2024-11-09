package pe.jakarta.lp1.model;

import java.io.Serializable;

import jakarta.faces.flow.FlowScoped;
import jakarta.inject.Named;

@Named
@FlowScoped("empleadoinfo")
public class Empleado implements Serializable {
	
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String direccion;
	private String ciudad;
	private String departamento;
	private String codigoPostal;
	private String telefonoCasa;
	private String telefonoTrabajo;
	private String telefonoCelular;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getTelefonoCasa() {
		return telefonoCasa;
	}
	public void setTelefonoCasa(String telefonoCasa) {
		this.telefonoCasa = telefonoCasa;
	}
	public String getTelefonoTrabajo() {
		return telefonoTrabajo;
	}
	public void setTelefonoTrabajo(String telefonoTrabajo) {
		this.telefonoTrabajo = telefonoTrabajo;
	}
	public String getTelefonoCelular() {
		return telefonoCelular;
	}
	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Empleado [nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", ciudad=");
		builder.append(ciudad);
		builder.append(", departamento=");
		builder.append(departamento);
		builder.append(", codigoPostal=");
		builder.append(codigoPostal);
		builder.append(", telefonoCasa=");
		builder.append(telefonoCasa);
		builder.append(", telefonoTrabajo=");
		builder.append(telefonoTrabajo);
		builder.append(", telefonoCelular=");
		builder.append(telefonoCelular);
		builder.append("]");
		return builder.toString();
	}
	
	

}
