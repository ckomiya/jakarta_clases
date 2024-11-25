package pe.jakarta.lp1.facesapp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import pe.jakarta.lp1.facesapp.entity.Cliente;

@Named
@SessionScoped
public class ClienteController implements Serializable {


	private List<Cliente> clientes;

	// Este objeto representa el formulario
	private Cliente cliente = new Cliente();

	public String listarClientes() {
		return "/cliente/Lista";
	}

	public String nuevoCliente() {
		cliente = new Cliente();
		return "/cliente/Nuevo";
	}

	public String editarCliente() {

		// Obtenemos el id de <f:param>
		int clienteId = Integer.parseInt(
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("clienteId"));

		// buscamos al cliente con ese id.
		for (Cliente cliente : clientes) {
			if (cliente.getClienteId() == clienteId) {
				this.cliente = cliente;
				break;
			}
		}

		return "/cliente/Editar";
	}

	public String crear() {


		// creamos el cliente id a partir de la longitud de la lista de clientes
		int clienteId = clientes.size() + 1;

		// asignamos al objeto que representa el formulario
		cliente.setClienteId(clienteId);

		clientes.add(cliente);

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Guardado",
				"Los datos del cliente han sido guardados de manera satisfactoria");

		FacesContext.getCurrentInstance().addMessage(null, message);

		return "/cliente/Lista";
	}
	
	
	public String actualizar() {
		
		/*
		 * 1. Obtengo los datos del formulario (objeto cliente)
		 * 2. Voy a buscar al cliente (clienteOriginal) antes de ser modificado. La busqueda seria por id
		 * 3. Actualizo al cliente (clienteOriginal) con los valores con el nuevo cliente
		 */
		
		int clienteId = this.cliente.getClienteId();
		
		for (Cliente cliente : clientes) {
			if (cliente.getClienteId() == clienteId) {
				cliente.setNombre(this.cliente.getNombre());
				cliente.setApellido(this.cliente.getNombre());
				cliente.setEmail(this.cliente.getEmail());
				break;
			}
		}
		
		
		
		return "/cliente/Lista";
	}

	public String verDetalleCliente() {

		// Obtenemos el id de <f:param>
		int clienteId = Integer.parseInt(
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("clienteId"));
		
		// buscamos al cliente con ese id.
		for (Cliente cliente : clientes) {
			if (cliente.getClienteId() == clienteId) {
				this.cliente = cliente;
				break;
			}
		}

		System.out.println(cliente);

		return null;

	}

	public List<Cliente> getClientes() {

		if (clientes == null) {

			// creamos una lista de prueba y lo agregamos a la sesion
			poblarClientes();
		}

		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void poblarClientes() {
		if (clientes == null) {
			clientes = new ArrayList<Cliente>();
			clientes.add(new Cliente(1, "Juan", "Pérez", "juan.perez@mail.com"));
			clientes.add(new Cliente(2, "María", "Gómez", "maria.gomez@mail.com"));
			clientes.add(new Cliente(3, "Carlos", "López", "carlos.lopez@mail.com"));
			clientes.add(new Cliente(4, "Ana", "Fernández", "ana.fernandez@mail.com"));

		}
	}

}
