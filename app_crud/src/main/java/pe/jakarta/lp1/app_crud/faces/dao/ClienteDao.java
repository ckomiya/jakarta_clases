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

@Stateless
public class ClienteDao {

	@Resource
	private EJBContext ejbContext;

	@PersistenceContext
	private EntityManager em;
	
	public List<Cliente> encontrarClientes(){
		
		List<Cliente> clientes;
	    CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	    cq.select(cq.from(Cliente.class));
	    Query q = em.createQuery(cq);
	    clientes = q.getResultList();
	    return clientes;
	}
}
