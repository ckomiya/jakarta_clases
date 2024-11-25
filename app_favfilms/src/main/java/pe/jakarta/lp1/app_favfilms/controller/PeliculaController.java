package pe.jakarta.lp1.app_favfilms.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import pe.jakarta.lp1.app_favfilms.entity.Pelicula;

@Named
@SessionScoped
public class PeliculaController implements Serializable{
	
	private List<Pelicula> peliculas;
	
	private List<Pelicula> peliculasMasVotadas;
	
	private List<Pelicula> peliculasEncontradas;
	
	private Pelicula pelicula;
	
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
		int peliculaId = peliculas.size()+1;
		pelicula.setId(peliculaId);
		peliculas.add(pelicula);
		
		return "index";
	}
	
	
	public String buscar() {
		
		peliculasEncontradas = new ArrayList<Pelicula>();
	 
	    for (Pelicula p : peliculas) {
	        
	        if (p.getTitulo().toLowerCase().contains(pelicula.getTitulo().toLowerCase())) {
	    
	            peliculasEncontradas.add(p);
	        }
	    }
	    
	    
	    return null;  
	}
	
	
	public String votar() {
		 int peliculaId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("peliculaId"));
		 
		 for (Pelicula p : peliculas) {
			if(p.getId() == peliculaId) {
				p.setVotos(p.getVotos()+1);
				break;
			}
		}
		 
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
		if(peliculas == null) {
			poblarPeliculas();
		}
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
	
	
	
	
	public void poblarPeliculas() {
	    if (peliculas == null) {
	        peliculas = new ArrayList<Pelicula>();

	        peliculas.add(new Pelicula(1, "Oppenheimer", "Christopher Nolan", 0));
	        peliculas.add(new Pelicula(2, "Barbie", "Greta Gerwig", 0));
	        peliculas.add(new Pelicula(3, "Mission: Impossible - Dead Reckoning Part One", "Christopher McQuarrie", 0));
	        peliculas.add(new Pelicula(4, "The Super Mario Bros. Movie", "Aaron Horvath & Michael Jelenic", 0));
	        peliculas.add(new Pelicula(5, "Spider-Man: Across the Spider-Verse", "Joaquim Dos Santos, Kemp Powers & Justin K. Thompson", 0));
	        peliculas.add(new Pelicula(6, "Guardians of the Galaxy Vol. 3", "James Gunn", 0));
	        peliculas.add(new Pelicula(7, "Fast X", "Louis Leterrier", 0));
	        peliculas.add(new Pelicula(8, "The Little Mermaid", "Rob Marshall", 0));
	        peliculas.add(new Pelicula(9, "John Wick: Chapter 4", "Chad Stahelski", 0));
	        peliculas.add(new Pelicula(10, "Dune: Part Two", "Denis Villeneuve", 0));
	    }
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
