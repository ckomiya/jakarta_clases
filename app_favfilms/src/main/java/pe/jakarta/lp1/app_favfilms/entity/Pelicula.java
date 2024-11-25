package pe.jakarta.lp1.app_favfilms.entity;

import java.io.Serializable;

public class Pelicula implements Serializable{
	
	private int id;
    private String titulo;
    private String director;
    private int votos = 0;
    
    
    public Pelicula() {
    }
    
    
	public Pelicula(int id, String titulo, String director, int votos) {
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.votos = votos;
	}

	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getVotos() {
		return votos;
	}
	public void setVotos(int votos) {
		this.votos = votos;
	}
    
    

}
