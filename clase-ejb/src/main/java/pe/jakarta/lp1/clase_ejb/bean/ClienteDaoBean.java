package pe.jakarta.lp1.clase_ejb.bean;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.jakarta.lp1.clase_ejb.entity.Cliente;

@Stateful
@LocalBean
public class ClienteDaoBean {

	
	@PersistenceContext
	  private EntityManager entityManager;

	  public void guardarCliente(Cliente cliente) {
	    if (cliente.getClienteId() == null) {
	      entityManager.persist(cliente);
	    } else {
	      entityManager.merge(cliente);
	    }
	  }

	  public Cliente obtenerCliente(Long customerId) {
		  Cliente cliente;

		  cliente = entityManager.find(Cliente.class, customerId);

	    return cliente;
	  }

	  public void eliminarCliente(Cliente cliente) {
	    entityManager.remove(cliente);
	  }

}
