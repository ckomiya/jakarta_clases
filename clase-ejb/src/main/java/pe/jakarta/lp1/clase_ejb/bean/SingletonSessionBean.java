package pe.jakarta.lp1.clase_ejb.bean;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import pe.jakarta.lp1.clase_ejb.entity.Departamento;

@Singleton
public class SingletonSessionBean implements SingletonSessionBeanRemote {

	@PersistenceContext
	private EntityManager entityManager;
	private List<Departamento> listaDepartamentos;

	@PostConstruct
	public void init() {
		Query query = entityManager.createQuery("Select d from Departamento d");
		listaDepartamentos = query.getResultList();
	}

	@Override
	public List<Departamento> obtenerDepartamentos() {
		return listaDepartamentos;

	}

}