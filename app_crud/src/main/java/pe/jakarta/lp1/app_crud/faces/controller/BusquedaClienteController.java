package pe.jakarta.lp1.app_crud.faces.controller;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import pe.jakarta.lp1.app_crud.faces.dao.ClienteDao;
import pe.jakarta.lp1.app_crud.faces.dao.TipoClienteDao;
import pe.jakarta.lp1.app_crud.faces.entity.Cliente;
import pe.jakarta.lp1.app_crud.faces.entity.TipoCliente;

@Named
@SessionScoped
public class BusquedaClienteController implements Serializable {
	
	private Cliente clienteFilter =  new Cliente();
	private List<Cliente> clientes;
	private List<TipoCliente> tiposCliente;
	
	@EJB
	private ClienteDao dao;
	
	@EJB
	private TipoClienteDao tipoClienteDao;
	
	public String buscarClientePorNombreyApellido() {
		clientes = dao.obtenerClientesPorNombreYApellido(clienteFilter.getNombre(), clienteFilter.getApellido());
		return null;
	}
	
	
//	public String buscarClientePorTipo() {
//		clientes = dao.obtenerClientesPorTipo(clienteFilter.getTipoCliente());
//		return null;
//	}
	
	
	
	public List<TipoCliente> getTiposCliente() {
		if(tiposCliente == null) {
			tiposCliente = tipoClienteDao.obtenerTiposDeClientes();
		}
		
		return tiposCliente;
	}

	public Cliente getClienteFilter() {
		return clienteFilter;
	}

	public void setClienteFilter(Cliente clienteFilter) {
		this.clienteFilter = clienteFilter;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	public void setTiposCliente(List<TipoCliente> tiposCliente) {
		this.tiposCliente = tiposCliente;
	}
	
	
	
}
