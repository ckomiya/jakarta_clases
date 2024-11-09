package pe.jakarta.lp1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento {
	
	@Id
	@Column(name = "DEPARTAMENTO_ID")
    private int departamentoId;

    @Column(name = "CODIGO_DEPARTAMENTO")
    private String codigoDepartamento;

    @Column(name = "NOMBRE_DEPARTAMENTO")
    private String nombreDepartamento;

	public int getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(int departamentoId) {
		this.departamentoId = departamentoId;
	}

	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

    
    
}
