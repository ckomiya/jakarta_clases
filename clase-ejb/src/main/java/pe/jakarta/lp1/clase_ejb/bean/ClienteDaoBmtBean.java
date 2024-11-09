package pe.jakarta.lp1.clase_ejb.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;
import pe.jakarta.lp1.clase_ejb.entity.Cliente;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class ClienteDaoBmtBean implements ClienteDaoBmt {

	
	@Resource
	  private UserTransaction userTransaction;

	  @PersistenceContext
	  private EntityManager entityManager;

	  @Resource(name = "java:app/jdbc/clienteBDDatasource")
	  private DataSource dataSource;

	  @Override
	  public void guardarVariosNuevosCliente(List<Cliente> clientes)
	      throws Exception {
	    for (Cliente cliente : clientes) {
	      userTransaction.begin();
	      cliente.setClienteId(obtenerNuevoIdCliente());
	      entityManager.persist(cliente);
	      userTransaction.commit();
	    }
	  }

	  private Integer obtenerNuevoIdCliente() {
	    Connection connection;
	    Integer nuevoClienteId = null;
	    try {
	      connection = dataSource.getConnection();
	      PreparedStatement preparedStatement = connection
	          .prepareStatement("select max(cliente_id)+1 as nuevo_cliente_id from cliente");

	      ResultSet resultSet = preparedStatement.executeQuery();

	      if (resultSet != null && resultSet.next()) {
	    	  nuevoClienteId = resultSet.getInt("nuevo_cliente_id");
	      }

	      connection.close();

	    } catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return nuevoClienteId;
	  }
	  
}
