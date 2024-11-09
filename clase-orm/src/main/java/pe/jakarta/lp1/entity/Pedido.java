package pe.jakarta.lp1.entity;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PEDIDO")
public class Pedido {

	@Id
	@Column(name = "PEDIDO_ID")
    private Integer pedidoId; 

    @Column(name = "NUMERO_PEDIDO", length = 10)
    private String numeroPedido;

    @Column(name = "DESCRIPCION_PEDIDO", length = 200)
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", nullable = false)
    private Cliente cliente;
    
    @ManyToMany
    @JoinTable(name = "ARTICULO_PEDIDO",
            joinColumns = @JoinColumn(name = "PEDIDO_ID",
                    referencedColumnName = "PEDIDO_ID"),
            inverseJoinColumns = @JoinColumn(name = "ARTICULO_ID",
                    referencedColumnName = "ARTICULO_ID"))
    private Collection<Articulo> articulos;

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Collection<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(Collection<Articulo> articulos) {
		this.articulos = articulos;
	} 
    
	
    
}
