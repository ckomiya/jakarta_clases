package pe.jakarta.lp1.clase_ejb.controller;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import pe.jakarta.lp1.clase_ejb.bean.ClienteDaoBean;
import pe.jakarta.lp1.clase_ejb.entity.Cliente;

@Named
@RequestScoped
public class ClienteController {
	
	@EJB
	  private ClienteDaoBean clienteDaoBean;

	  private Cliente cliente;

	  private String nombre;
	  private String apellido;
	  private String email;

	  public ClienteController() {
		  cliente = new Cliente();
	  }

	  public String guardarCliente() {
	    String returnValue = "cliente_guardado";

	    try {
	    	poblarCliente();
	      clienteDaoBean.guardarCliente(cliente);
	    } catch (Exception e) {
	      e.printStackTrace();
	      returnValue = "error_guardando_cliente";
	    }

	    return returnValue;
	  }

	  private void poblarCliente() {
	    if (cliente == null) {
	    	cliente = new Cliente();
	    }
	    cliente.setNombre(getNombre());
	    cliente.setApellido(getApellido());
	    cliente.setEmail(getEmail());
	  }


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	  

}
