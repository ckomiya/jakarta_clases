package pe.jakarta.lp1.entity;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ARTICULO")
public class Articulo {
	
	@Id
    @Column(name = "ARTICULO_ID")
    private Integer articuloId;

    @Column(name = "NUMERO_ARTICULO")
    private String numeroArticulo;

    @Column(name = "DESCRIPCION_CORTA")
    private String descripcionCorta;

    @Column(name = "DESCRIPCION_LARGA")
    private String descripcionLarga;
    
    @ManyToMany(mappedBy = "articulos")
    private Collection<Pedido> pedidos;

	public Integer getArticuloId() {
		return articuloId;
	}

	public void setArticuloId(Integer articuloId) {
		this.articuloId = articuloId;
	}

	public String getNumeroArticulo() {
		return numeroArticulo;
	}

	public void setNumeroArticulo(String numeroArticulo) {
		this.numeroArticulo = numeroArticulo;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getDescripcionLarga() {
		return descripcionLarga;
	}

	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

	public Collection<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Collection<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
  
}
