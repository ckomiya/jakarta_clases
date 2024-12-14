package pe.jakarta.lp1.dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.jakarta.lp1.entity.TipoProducto;

@Stateless
public class TipoProductoDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<TipoProducto> obtenerTiposDeProducto(){
		List<TipoProducto> tipos = null;
		try {
			tipos = em.createQuery("select t from TipoProducto t", TipoProducto.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipos;
	}

}
