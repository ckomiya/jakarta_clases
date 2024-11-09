package pe.jakarta.lp1.bean;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
import pe.jakarta.lp1.entity.Articulo;
import pe.jakarta.lp1.entity.Pedido;

@Named
@RequestScoped
public class RelacionManyToManyDemoBean {
	
	@PersistenceContext
	  private EntityManager entityManager;

	  @Resource
	  private UserTransaction userTransaction;

	  public String actualizarBD() {
	    String retVal = "confirmacion";

	    Pedido pedido;
	    Collection<Articulo> articulos = new ArrayList<Articulo>();
	    Articulo articulo1 = new Articulo();
	    Articulo articulo2 = new Articulo();

	    articulo1.setArticuloId(1);
	    articulo1.setNumeroArticulo("BCD1234");
	    articulo1.setDescripcionCorta("Computadora Notebook");
	    articulo1.setDescripcionLarga("64 bit Quad core CPU, 4GB memory");

	    articulo2.setArticuloId(2);
	    articulo2.setNumeroArticulo("CDF2345");
	    articulo2.setDescripcionCorta("Mouse Inalámbrico");
	    articulo2.setDescripcionLarga("Tres botones, infrarrojo, ruedas de desplazamiento vertical y horizontal");

	    articulos.add(articulo1);
	    articulos.add(articulo2);

	    try {
	      userTransaction.begin();

	      entityManager.persist(articulo1);
	      entityManager.persist(articulo2);

	      pedido = entityManager.find(Pedido.class, 1);
	      pedido.setArticulos(articulos);

	      entityManager.persist(pedido);

	      userTransaction.commit();

	    } catch (NotSupportedException
	            | SystemException
	            | SecurityException
	            | IllegalStateException
	            | RollbackException
	            | HeuristicMixedException
	            | HeuristicRollbackException e) {
	      retVal = "error";
	      e.printStackTrace();
	    }

	    return retVal;
	  }

}
