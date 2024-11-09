package pe.jakarta.lp1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "ARTICULO_PEDIDO")
@IdClass(value = ArticuloPedidoPK.class)
public class ArticuloPedido {
	
	@Id
    @Column(name = "PEDIDO_ID")
    private Integer pedidoId;

    @Id
    @Column(name = "ARTICULO_ID")
    private Integer articuloId;

    @Column(name = "CANTIDAD_ARTICULO")
    private Integer cantidadArticulo;

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Integer getArticuloId() {
		return articuloId;
	}

	public void setArticuloId(Integer articuloId) {
		this.articuloId = articuloId;
	}

	public Integer getCantidadArticulo() {
		return cantidadArticulo;
	}

	public void setCantidadArticulo(Integer cantidadArticulo) {
		this.cantidadArticulo = cantidadArticulo;
	}
    
    
    
}
