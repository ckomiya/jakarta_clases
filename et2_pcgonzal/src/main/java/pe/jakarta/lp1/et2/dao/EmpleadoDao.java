package pe.jakarta.lp1.et2.dao;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.jakarta.lp1.et2.entity.Empleado;

@Stateless
public class EmpleadoDao implements Serializable{
	
	@PersistenceContext
	EntityManager em;

	public void guardarEmpleado(Empleado empleado) {
		
		em.persist(empleado);
		
	}

	public List<Empleado> obtenerEmpleados() {
		
		List<Empleado> empleados = em.createQuery("select e from Empleado e", Empleado.class).getResultList();
		
		return empleados;
	}
	
	

}
