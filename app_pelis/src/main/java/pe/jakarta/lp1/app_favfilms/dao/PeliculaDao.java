package pe.jakarta.lp1.app_favfilms.dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.jakarta.lp1.app_favfilms.entity.Pelicula;

@Stateless
public class PeliculaDao {
	
	@PersistenceContext
	private EntityManager em;

	public List<Pelicula> obtenerPeliculas() {
		return em.createQuery("select p from Pelicula p",Pelicula.class).getResultList();
	}

	public void crearPelicula(Pelicula pelicula) {
		em.persist(pelicula);
		
	}

	public Pelicula obtenerPeliculaPorId(int id) {
		return em.find(Pelicula.class, id);
	}

	public void actualizarPelicula(Pelicula pelicula) {
		em.merge(pelicula);
		
	}

	public List<Pelicula> obtenerPeliculaPorTitulo(String titulo) {
		
		return em.createQuery("select p from Pelicula p where p.titulo like :titulo", Pelicula.class).setParameter("titulo","%" +  titulo + "%").getResultList();
	}
	
	

}
