package pe.jakarta.lp1.clase_ejb.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.ejb.EJBContext;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.jakarta.lp1.clase_ejb.entity.Cliente;

@Stateless
public class ClienteDaoRollbackBean implements ClienteDaoRollback {

	
	@Resource
	  private EJBContext ejbContext;

	  @PersistenceContext
	  private EntityManager entityManager;

	  @Resource(name = "java:app/jdbc/customerdbDatasource")
	  private DataSource dataSource;

	  @Override
	  public void guardarClienteNuevo(Cliente cliente) {
	    if (cliente == null || cliente.getClienteId() != null) {
	      ejbContext.setRollbackOnly();
	    } else {
	    	cliente.setClienteId(getNuevoClienteId());
	      entityManager.persist(cliente);
	    }
	  }

	  @Override
	  public void actualizarCliente(Cliente cliente) {
	    if (cliente == null || cliente.getClienteId() == null) {
	      ejbContext.setRollbackOnly();
	    } else {
	      entityManager.merge(cliente);
	    }
	  }

	  @Override
	  public Cliente obtenerCliente(Integer clienteId) {
	    Cliente cliente;

	    cliente = entityManager.find(Cliente.class, clienteId);

	    return cliente;
	  }

	  @Override
	  public void eliminarCliente(Cliente cliente) {
	    entityManager.remove(cliente);
	  }

	  private Integer getNuevoClienteId() {
	    Connection connection;
	    Integer nuevoClienteId = null;
	    try {
	      connection = dataSource.getConnection();
	      PreparedStatement preparedStatement = connection
	          .prepareStatement("select max(cliente_id)+1 as nuevoClienteID from cliente");

	      ResultSet resultSet = preparedStatement.executeQuery();

	      if (resultSet != null && resultSet.next()) {
	        nuevoClienteId = resultSet.getInt("nuevoClienteID");
	      }
	      connection.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return nuevoClienteId;
	  }
}
