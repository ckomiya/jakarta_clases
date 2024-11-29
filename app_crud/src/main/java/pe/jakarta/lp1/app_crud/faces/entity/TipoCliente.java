package pe.jakarta.lp1.app_crud.faces.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_CLIENTE")
public class TipoCliente implements Serializable{
	
	@Id
	@Column(name = "TIPO_CLIENTE_ID")
	private Integer id;
	private String descripcion;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
