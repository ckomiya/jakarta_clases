package pe.jakarta.lp1.bean;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.RollbackException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
import pe.jakarta.lp1.entity.Cliente;
import pe.jakarta.lp1.entity.Departamento;
import pe.jakarta.lp1.entity.Direccion;
import pe.jakarta.lp1.entity.TipoDireccion;

@Named
@RequestScoped
public class CriteriaUpdateDemoBean {

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    private int filasActualizadas;

    public String actualizarData() {
        String retVal = "confirmacion_criteria_update";

        try {

            userTransaction.begin();
            insertarDataTemporal();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaUpdate<Direccion> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Direccion.class);
            Root<Direccion> root = criteriaUpdate.from(Direccion.class);
            criteriaUpdate.set("ciudad", "Lima");
            criteriaUpdate.where(criteriaBuilder.equal(root.get("ciudad"), "Limacc"));

            Query query = entityManager.createQuery(criteriaUpdate);

            filasActualizadas = query.executeUpdate();
            userTransaction.commit();
        } catch (Exception e) {
            retVal = "error";
            e.printStackTrace();
        }
        return retVal;
    }

   

    private void insertarDataTemporal() throws NotSupportedException,
            SystemException, RollbackException, HeuristicMixedException,
            HeuristicRollbackException {
        Cliente cliente = entityManager.find(Cliente.class, 4);

        TipoDireccion direccionTipoCasa = entityManager.find(TipoDireccion.class, 1);
        TipoDireccion direccionTipoCorrespondencia = entityManager.find(TipoDireccion.class, 2);
        TipoDireccion direccionTipoEnvio = entityManager.find(TipoDireccion.class, 3);

        Departamento departamento = entityManager.find(Departamento.class, 13);

        Direccion direccionCasa = new Direccion(1, "Av. Pardo y Aliaga 540", "Piso 10", "Limacc", "15073", departamento, cliente, direccionTipoCasa);
        Direccion direccionCorrespondencia = new Direccion(2, "Av. Benavides 1234", "Oficina 201", "Miraflores", "15073", departamento, cliente,  direccionTipoCorrespondencia);
        Direccion direccionEnvio = new Direccion(3, "Av. La Marina 3000", "Piso 5", "San Isidro", "15073", departamento, cliente, direccionTipoEnvio);  


        entityManager.persist(direccionCasa);
        entityManager.persist(direccionCorrespondencia);
        entityManager.persist(direccionEnvio);

    }


	public UserTransaction getUserTransaction() {
		return userTransaction;
	}



	public void setUserTransaction(UserTransaction userTransaction) {
		this.userTransaction = userTransaction;
	}



	public int getFilasActualizadas() {
		return filasActualizadas;
	}



	public void setFilasActualizadas(int filasActualizadas) {
		this.filasActualizadas = filasActualizadas;
	}
    
    
}
