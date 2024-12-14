package pe.jakarta.lp1.app_favfilms.entity;

import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class Pelicula implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String titulo;
    private String director;
    private int votos;
    
    
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
