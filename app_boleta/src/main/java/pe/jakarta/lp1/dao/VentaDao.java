package pe.jakarta.lp1.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.jakarta.lp1.entity.Venta;

@Stateless
public class VentaDao {

	@PersistenceContext
	EntityManager em;
	
	public void registrarVenta(Venta venta) {
		em.persist(venta);
	}
}
