package pe.jakarta.lp1.entity;

import java.io.Serializable;
import java.util.Objects;

public class ArticuloPedidoPK implements Serializable {

	public Integer pedidoId;
	public Integer articuloId;

	public ArticuloPedidoPK() {
	}

	public ArticuloPedidoPK(Integer pedidoId, Integer articuloId) {
		this.pedidoId = pedidoId;
		this.articuloId = articuloId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(articuloId, pedidoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticuloPedidoPK other = (ArticuloPedidoPK) obj;
		return Objects.equals(articuloId, other.articuloId) && Objects.equals(pedidoId, other.pedidoId);
	}

}
