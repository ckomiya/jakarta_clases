package pe.jakarta.lp1.appfaces.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import pe.jakarta.lp1.appfaces.entity.Cliente;

@Named
@SessionScoped
public class ClienteController implements Serializable {

//	@Inject
//	private HttpSession session;

	private List<Cliente> clientes;

	private Cliente cliente = new Cliente();

	public String listarClientes() {
		return "/cliente/Lista";
	}

	public List<Cliente> getClientes() {

		if (clientes == null) {
			poblarClientes();
		}

		return clientes;
	}
	
	 public String verDetalleCliente() {
	       
	        int clienteId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("clienteId"));
	        // System.out.println(" clienteId : " + clienteId);
	     
	        for (Cliente cliente : clientes) {
				if(cliente.getClienteId() == clienteId) {
					this.cliente = cliente;
					break;
				}
			}
	        
	        
	        
	        return "/cliente/Editar";
	 }
	
	 
	 public String actualizarCliente() {
		 
		 System.out.println(cliente);
		 for (Cliente c : clientes) {
				if(c.getClienteId() == cliente.getClienteId()) {
					c.setEmail(cliente.getEmail());
					c.setNombre(cliente.getNombre());
					c.setApellido(cliente.getApellido());
					break;
				}
			}
		 
		 return "/cliente/Lista"; 
		 
	 }

	public String nuevoCliente() {
		cliente = new Cliente();
		return "/cliente/Nuevo";
	}

	public String crear() {

		cliente.setClienteId(clientes.size() + 1);

		clientes.add(cliente);

		// return "/cliente/Lista?faces-redirect=true";
		return "/cliente/Lista";
	}

	/**
	 * Método que inicializa la lista de clientes ficticios y los guarda en sesión.
	 */
	public void poblarClientes() {
		if (clientes == null) {
			clientes = new ArrayList<Cliente>();
			clientes.add(new Cliente(1, "Juan", "Pérez", "juan.perez@mail.com"));
			clientes.add(new Cliente(2, "María", "Gómez", "maria.gomez@mail.com"));
			clientes.add(new Cliente(3, "Carlos", "López", "carlos.lopez@mail.com"));
			clientes.add(new Cliente(4, "Ana", "Fernández", "ana.fernandez@mail.com"));
		}
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

}
