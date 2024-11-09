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

	  private List<Departamento> departamantosEncontrados;

	  public String buscarDepartamento() {
	    String retVal = "confirmacion_JPQL";

	    try {
	      Query query = entityManager
	              .createQuery(
	                      "SELECT d FROM Departamento d WHERE d.nombreDepartamento "
	                      + "LIKE :nombre");

	      query.setParameter("nombre", "San%");

	      departamantosEncontrados = query.getResultList();
	    } catch (Exception e) {
	      retVal = "error_JPQL";
	      e.printStackTrace();
	    }

	    return retVal;
	  }

	public List<Departamento> getDepartamantosEncontrados() {
		return departamantosEncontrados;
	}

	public void setDepartamantosEncontrados(List<Departamento> departamantosEncontrados) {
		this.departamantosEncontrados = departamantosEncontrados;
	}

	  

	 
}
