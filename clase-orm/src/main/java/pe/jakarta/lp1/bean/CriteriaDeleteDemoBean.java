package pe.jakarta.lp1.bean;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
import pe.jakarta.lp1.entity.Direccion;

@Named
@RequestScoped
public class CriteriaDeleteDemoBean {

	  @PersistenceContext
	  private EntityManager entityManager;

	  @Resource
	  private UserTransaction userTransaction;

	  private int filasEliminadas;

	  public String eliminarData() {
	    String retVal = "confirmacion";

	    try {

	      userTransaction.begin();

	      CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	      CriteriaDelete<Direccion> criteriaDelete
	              = criteriaBuilder.createCriteriaDelete(Direccion.class);
	      Root<Direccion> root = criteriaDelete.from(Direccion.class);
	      criteriaDelete.where(
	    		    criteriaBuilder.equal(root.get("ciudad"), "Lima")
	    		);

	      Query query = entityManager.createQuery(criteriaDelete);

	      filasEliminadas = query.executeUpdate();
	      userTransaction.commit();
	    } catch (HeuristicMixedException
	            | HeuristicRollbackException
	            | NotSupportedException
	            | RollbackException
	            | SystemException
	            | IllegalStateException
	            | SecurityException e) {
	      retVal = "error";
	      e.printStackTrace();
	    }
	    return retVal;
	  }

	public int getFilasEliminadas() {
		return filasEliminadas;
	}

	public void setFilasEliminadas(int filasEliminadas) {
		this.filasEliminadas = filasEliminadas;
	}
	  
}
