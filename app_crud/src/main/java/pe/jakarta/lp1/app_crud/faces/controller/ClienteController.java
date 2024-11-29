package pe.jakarta.lp1.app_crud.faces.controller;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import pe.jakarta.lp1.app_crud.faces.dao.ClienteDao;
import pe.jakarta.lp1.app_crud.faces.dao.TipoClienteDao;
import pe.jakarta.lp1.app_crud.faces.entity.Cliente;
import pe.jakarta.lp1.app_crud.faces.entity.TipoCliente;

@Named
@SessionScoped
public class ClienteController implements Serializable {

	@EJB
	private ClienteDao dao;
	
	@EJB
	private TipoClienteDao tipoClienteDao;

	private List<Cliente> clientes;
	private List<TipoCliente> tiposCliente;
	private Cliente cliente;

	public String listarClientes() {
		return "/cliente/Lista";
	}
	
	public String editarCliente() {
		int clienteId = Integer.parseInt(
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("clienteId"));

		cliente = dao.obtenerClientePorId(clienteId);
		return "/cliente/Editar";
	}
	
	public String nuevoCliente() {

		cliente = new Cliente();

		return "/cliente/Nuevo";
	}
	

	public List<Cliente> getClientes() {
		clientes = dao.encontrarClientes();
		return clientes;
	}
	
	public String crear() {
		try {
			dao.crearCliente(cliente);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente guardado de manera satisfactoria"));
		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al guardar el Cliente"));
			return null;
		}
		
		return "/cliente/Lista";
	}
	
	
	public String actualizar() {
		try {
			dao.actualizarCliente(cliente);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Los datos del cliente se actualizaron de manera satisfactoria"));
		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al actualizar el Cliente"));
			return null;
		}
		
		return "/cliente/Lista";
	}
	
	
	

	public List<TipoCliente> getTiposCliente() {
		tiposCliente = tipoClienteDao.obtenerTiposDeClientes();
		return tiposCliente;
	}

	public void setTiposCliente(List<TipoCliente> tiposCliente) {
		this.tiposCliente = tiposCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	

}
