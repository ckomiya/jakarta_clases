package pe.jakarta.lp1.clase_ejb.bean;

import jakarta.ejb.Remote;
import pe.jakarta.lp1.clase_ejb.entity.Cliente;

@Remote
public interface ClienteDaoRollback {

	public abstract void guardarClienteNuevo(Cliente customer);

	public abstract void actualizarCliente(Cliente customer);

	public abstract Cliente obtenerCliente(Integer clienteId);

	public abstract void eliminarCliente(Cliente customer);

}
