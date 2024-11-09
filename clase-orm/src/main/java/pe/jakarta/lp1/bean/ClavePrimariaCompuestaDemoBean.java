package pe.jakarta.lp1.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.jakarta.lp1.entity.ArticuloPedido;
import pe.jakarta.lp1.entity.ArticuloPedidoPK;

@Named
@RequestScoped
public class ClavePrimariaCompuestaDemoBean {

	@PersistenceContext
	private EntityManager entityManager;

	private ArticuloPedido articuloPedido;

	public String encontrarArticuloPedido() {
		String retVal = "confirmacion_pk";

		try {
			articuloPedido = entityManager.find(ArticuloPedido.class, new ArticuloPedidoPK(1, 2));
		} catch (Exception e) {
			retVal = "error_pk";
			e.printStackTrace();
		}

		return retVal;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public ArticuloPedido getArticuloPedido() {
		return articuloPedido;
	}

	public void setArticuloPedido(ArticuloPedido articuloPedido) {
		this.articuloPedido = articuloPedido;
	}

}
