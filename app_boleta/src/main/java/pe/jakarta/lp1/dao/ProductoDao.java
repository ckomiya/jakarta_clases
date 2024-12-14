package pe.jakarta.lp1.dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.jakarta.lp1.entity.Producto;
import pe.jakarta.lp1.entity.TipoProducto;

@Stateless
public class ProductoDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Producto> obtenerProductos(){
		
		List<Producto> productos = null;
		try {
			productos= em.createQuery("select p from Producto p", Producto.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productos;
	}

	public void guardar(Producto producto) {
		try {
			em.persist(producto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<Producto> obtenerProductosPorTipo(TipoProducto tipoProducto) {
		List<Producto> productos = null;
		try {
			productos= em.createQuery("select p from Producto p where p.tipoProducto = :tipo", Producto.class)
					.setParameter("tipo", tipoProducto)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productos;
	}
	

}
