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
import pe.jakarta.lp1.entity.Pedido;

@Named
@RequestScoped
public class RelacionOneToManyDemoBean {
	
	@PersistenceContext
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    public String actualizarBD() {
        String retVal = "confirmacion";

        Cliente cliente;
        Pedido pedido1;
        Pedido pedido2;

        pedido1 = new Pedido();
        pedido1.setPedidoId(1);
        pedido1.setNumeroPedido("SFX12345");
        pedido1.setDescripcion("Pedido de prueba.");

        pedido2 = new Pedido();
        pedido2.setPedidoId(2);
        pedido2.setNumeroPedido("SFX23456");
        pedido2.setDescripcion("Otro pedido de prueba.");

        try {
            userTransaction.begin();

            cliente = entityManager.find(Cliente.class, 4);

            pedido1.setCliente(cliente);
            pedido2.setCliente(cliente);

            entityManager.persist(pedido1);
            entityManager.persist(pedido2);

            userTransaction.commit();

        } catch (NotSupportedException |
                SystemException |
                SecurityException |
                IllegalStateException |
                RollbackException |
                HeuristicMixedException |
                HeuristicRollbackException e) {
            retVal = "error";
            e.printStackTrace();
        }

        return retVal;
    }
}