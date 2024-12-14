package pe.jakarta.lp1.app_favfilms.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import pe.jakarta.lp1.app_favfilms.dao.PeliculaDao;
import pe.jakarta.lp1.app_favfilms.entity.Pelicula;

@Named
@SessionScoped
public class PeliculaController implements Serializable{
	
	
	
	private List<Pelicula> peliculas;
	
	private List<Pelicula> peliculasMasVotadas;
	
	private List<Pelicula> peliculasEncontradas;
	
	private Pelicula pelicula;
	
	@EJB
	private PeliculaDao dao;
	
	public String nuevaPelicula() {
		pelicula = new Pelicula();
		return "nueva_pelicula";
	}
	
	public String listarPeliculas() {
		return "index";
	}
	
	public String verPeliculaMasVotada() {
		return "mas_votada";
	}
	
	public String buscarPeliculas() {
		pelicula = new Pelicula();
		return "buscar_pelicula";
	}
	

	
	public String crearPelicula() {
		try {
			dao.crearPelicula(pelicula);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pelicula guardado de manera satisfactoria"));
		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al guardar el Pelicula"));
			return null;
		}
		
		return "index";
	}
	
	
	
	
	public String buscar() {
		
		peliculasEncontradas =  dao.obtenerPeliculaPorTitulo(pelicula.getTitulo());
	    
	    
	    return null;  
	}
	
	
	public String votar() {
		 int peliculaId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("peliculaId"));
		 
		 pelicula = dao.obtenerPeliculaPorId(peliculaId);
		 pelicula.setVotos(pelicula.getVotos()+1);
		 dao.actualizarPelicula(pelicula);
		 
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tu voto ha sido registrado")); 
		 
		 return "index";
	}
	
	
	public String reiniciarVotos() {
		
		for (Pelicula pelicula : peliculas) {
			pelicula.setVotos(0);
		}
		
		FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, 
	            "Éxito", "Los votos han sido reiniciados");
	    FacesContext.getCurrentInstance().addMessage(null, mensaje);
	    
	    
		return null;
	}

	public List<Pelicula> getPeliculas() {
		peliculas = dao.obtenerPeliculas();
		return peliculas;
	}
	
	
	public List<Pelicula> getPeliculasMasVotadas() {
		
		
	    int maxVotos = 0;


	    for (Pelicula pelicula : peliculas) {
	        if (pelicula.getVotos() > maxVotos) {
	            maxVotos = pelicula.getVotos(); 
	        }
	    }


	    List<Pelicula> peliculasMasVotadas = new ArrayList<>();

	   
	    for (Pelicula pelicula : peliculas) {
	        if (pelicula.getVotos() == maxVotos && pelicula.getVotos() != 0) {
	            peliculasMasVotadas.add(pelicula);
	        }
	    }

	    return peliculasMasVotadas;
	}
	
	

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	

	public void setPeliculasMasVotadas(List<Pelicula> peliculasMasVotadas) {
		this.peliculasMasVotadas = peliculasMasVotadas;
	}

	public List<Pelicula> getPeliculasEncontradas() {
		return peliculasEncontradas;
	}

	public void setPeliculasEncontradas(List<Pelicula> peliculasEncontradas) {
		this.peliculasEncontradas = peliculasEncontradas;
	}
	
	
	

}
