package pe.jakarta.lp1.appfaces.entity;

import java.io.Serializable;

public class Cliente implements Serializable {
	
	private int clienteId;
	private String nombre;
	private String apellido;
	private String email;
	
	
	public Cliente() {
		
	}
	
	public Cliente(int clienteId, String nombre, String apellido, String email) {
		super();
		this.clienteId = clienteId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [clienteId=");
		builder.append(clienteId);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellido=");
		builder.append(apellido);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	
	

}
