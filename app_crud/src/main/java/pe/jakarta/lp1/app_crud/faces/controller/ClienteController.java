package pe.jakarta.lp1.app_crud.faces.controller;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import pe.jakarta.lp1.app_crud.faces.dao.ClienteDao;
import pe.jakarta.lp1.app_crud.faces.entity.Cliente;

@Named
@SessionScoped
public class ClienteController implements Serializable {

	@EJB
	private ClienteDao dao;

	private List<Cliente> clientes = null;
	private Cliente cliente;

	public String listarClientes() {

		// Espacio para incializar valores

		return "/cliente/Lista";
	}
	
	public String nuevoCliente() {

		cliente = new Cliente();

		return "/cliente/Nuevo";
	}
	

	public List<Cliente> getClientes() {
		if (clientes == null) {
			clientes = dao.encontrarClientes();
		}
		return clientes;
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
