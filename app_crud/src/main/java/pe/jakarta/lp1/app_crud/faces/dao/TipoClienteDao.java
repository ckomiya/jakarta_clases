package pe.jakarta.lp1.app_crud.faces.dao;

import java.util.List;

import jakarta.annotation.Resource;
import jakarta.ejb.EJBContext;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.jakarta.lp1.app_crud.faces.entity.Cliente;
import pe.jakarta.lp1.app_crud.faces.entity.TipoCliente;

@Stateless
public class TipoClienteDao {
	
	@Resource
	private EJBContext ejbContext;

	@PersistenceContext
	private EntityManager em;
	
public List<TipoCliente> obtenerTiposDeClientes(){
		
	    
	    List<TipoCliente> tipos = em.createQuery("select t from TipoCliente t", TipoCliente.class).getResultList();
	    
	    return tipos;
	}

}
