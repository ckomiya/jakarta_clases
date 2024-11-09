package pe.jakarta.lp1.bean;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.Metamodel;
import jakarta.persistence.metamodel.SingularAttribute;
import pe.jakarta.lp1.entity.Departamento;

@Named
@RequestScoped
public class CriteriaApiDemoBean {
	
	@PersistenceContext
    private EntityManager entityManager;
    private List<Departamento> departamantosEncontrados;

    public String buscarDepartamento() {
        String retVal = "confirmacion_criteria";
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Departamento> criteriaQuery = criteriaBuilder.createQuery(Departamento.class);
            Root<Departamento> root = criteriaQuery.from(Departamento.class);
            Metamodel metamodel = entityManager.getMetamodel();
            EntityType<Departamento> departamentoEntityType = metamodel.entity(Departamento.class);
            SingularAttribute<Departamento, String> usStateAttribute = departamentoEntityType.getDeclaredSingularAttribute("nombreDepartamento", String.class);
            Path<String> path = root.get(usStateAttribute);
            Predicate predicate = criteriaBuilder.like(path, "San%");
            criteriaQuery = criteriaQuery.where(predicate);
            TypedQuery<Departamento> typedQuery = entityManager.createQuery(criteriaQuery);
            departamantosEncontrados = typedQuery.getResultList();
        } catch (Exception e) {
            retVal = "error";
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
