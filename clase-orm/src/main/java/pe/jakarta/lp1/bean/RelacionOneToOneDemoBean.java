package pe.jakarta.lp1.bean;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;
import pe.jakarta.lp1.entity.Cliente;
import pe.jakarta.lp1.entity.Login;

@Named
@RequestScoped
public class RelacionOneToOneDemoBean {

	@PersistenceContext
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    public String actualizarBD() {
        String retVal = "confirmacion";
        Cliente cliente;
        Login login = new Login();
        login.setLoginId(1);
        login.setNombre("cpalacios");
        login.setContrasena("1234");

        try {
            userTransaction.begin();
            cliente = entityManager.find(Cliente.class, 4);
            login.setCliente(cliente);
            entityManager.persist(login);
            userTransaction.commit();
        } catch (Exception e) {
            retVal = "error";
            e.printStackTrace();
        }

        return retVal;
    }
}
