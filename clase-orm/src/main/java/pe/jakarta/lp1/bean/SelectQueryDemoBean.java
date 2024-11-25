package pe.jakarta.lp1.bean;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import pe.jakarta.lp1.entity.Departamento;

@Named
@RequestScoped
public class SelectQueryDemoBean {
	
	@PersistenceContext
	  private EntityManager entityManager;

	  private List<Departamento> departamentosEncontrados;

	  public String buscarDepartamento() {
	    String retVal = "confirmacion_JPQL";

	    try {
//	      Query query = entityManager
//	              .createQuery(
//	                      "SELECT d FROM Departamento d WHERE d.nombreDepartamento "
//	                      + "LIKE :nombre");
//
//	      query.setParameter("nombre", "San%");
	    	
	    	
	    	Query query = entityManager.createNativeQuery("SELECT * FROM DEPARTAMENTO WHERE NOMBRE_DEPARTAMENTO LIKE ?", Departamento.class);
	    	query.setParameter(1, "San%");		
	    			
	      departamentosEncontrados = query.getResultList();
	    } catch (Exception e) {
	      retVal = "error_JPQL";
	      e.printStackTrace();
	    }

	    return retVal;
	  }

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Departamento> getDepartamentosEncontrados() {
		return departamentosEncontrados;
	}

	public void setDepartamentosEncontrados(List<Departamento> departamentosEncontrados) {
		this.departamentosEncontrados = departamentosEncontrados;
	}

	
	  

	 
}
