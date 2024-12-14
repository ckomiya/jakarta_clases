package pe.jakarta.lp1.app_crud.faces.dao;

import java.util.List;

import jakarta.annotation.Resource;
import jakarta.ejb.EJBContext;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import pe.jakarta.lp1.app_crud.faces.entity.Cliente;
import pe.jakarta.lp1.app_crud.faces.entity.TipoCliente;

@Stateless
public class ClienteDao {

//	@Resource
//	private EJBContext ejbContext;

	@PersistenceContext
	private EntityManager em;
	
	public List<Cliente> encontrarClientes(){
		
//		List<Cliente> clientes;
//	    CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//	    cq.select(cq.from(Cliente.class));
//	    Query q = em.createQuery(cq);
//	    clientes = q.getResultList();
	    
	    
	    List<Cliente> clientes = em.createQuery("select c from Cliente c", Cliente.class).getResultList();
	    
	    return clientes;
	}
	
	public void crearCliente(Cliente cliente) {
	    try {
	        em.persist(cliente);
	    } catch (Exception e) {
	        throw new RuntimeException("Error al crear el cliente: " + cliente, e);
	    }
	}

	public void actualizarCliente(Cliente cliente) {
		 try {
		        em.merge(cliente);
		    } catch (Exception e) {
		        throw new RuntimeException("Error al actualizar datos del cliente: " + cliente, e);
		    }
	}
	
	
	public Cliente obtenerClientePorId(int id) {
		Cliente cliente = em.find(Cliente.class, id) ;
		return cliente;
	}
	
	public void eliminarCliente(Cliente cliente) {
	    try {
	    	cliente = em.getReference(Cliente.class, cliente.getClienteId());
	        em.remove(cliente);
	    } catch (Exception e) {
	        throw new RuntimeException("Error al eliminar el cliente: " + cliente, e);
	    }
	}

	public List<Cliente> obtenerClientesPorTipo(TipoCliente tipoCliente) {
		return em.createQuery("select c from Cliente c where c.tipoCliente = :tipo", Cliente.class)
				.setParameter("tipo", tipoCliente)
				.getResultList();
	}

	public List<Cliente> obtenerClientesPorNombreYApellido(String nombre, String apellido) {
		return em.createQuery("select c from Cliente c where c.nombre like :nombre or c.apellido like :apellido", Cliente.class)
				.setParameter("nombre", "%" + nombre + "%")
				.setParameter("apellido","%" +  apellido+ "%")
				.getResultList();
	}
	
	
}
