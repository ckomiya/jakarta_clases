package pe.jakarta.lp1.bean;

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
import pe.jakarta.lp1.entity.Cliente;

@Named
@RequestScoped
public class JakartaPersistenceDemoBean {

	@PersistenceContext
	private EntityManager entityManager;

	@Resource
	private UserTransaction userTransaction;

	public String actualizarBD() {

		String retVal = "confirmacion";

		Cliente cliente = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3;

		cliente.setClienteId(3);
		cliente.setNombre("Pedro");
		cliente.setApellido("Salazar");
		cliente.setEmail("pedro@ejemplo.com");

		cliente2.setClienteId(4);
		cliente2.setNombre("Carlos");
		cliente2.setApellido("Perez");
		cliente2.setEmail("cperez@ejemplo.org");

		try {
			userTransaction.begin();
			entityManager.persist(cliente);
			entityManager.persist(cliente2);
			cliente3 = entityManager.find(Cliente.class, 4);
			cliente3.setApellido("Palacios");
			entityManager.persist(cliente3);
			entityManager.remove(cliente);

			userTransaction.commit();
		} catch (HeuristicMixedException | HeuristicRollbackException | IllegalStateException | NotSupportedException
				| RollbackException | SecurityException | SystemException e) {
			retVal = "error";
			e.printStackTrace();
		}

		return retVal;
	}
}
