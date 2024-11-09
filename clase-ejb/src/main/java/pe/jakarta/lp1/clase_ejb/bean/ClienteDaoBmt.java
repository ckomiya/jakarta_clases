package pe.jakarta.lp1.clase_ejb.bean;

import java.util.List;

import jakarta.ejb.Remote;
import pe.jakarta.lp1.clase_ejb.entity.Cliente;

@Remote
public interface ClienteDaoBmt {

	public void guardarVariosNuevosCliente(List<Cliente> customerList) throws Exception;
}
