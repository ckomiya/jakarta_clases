package pe.jakarta.lp1.init;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;

@ApplicationScoped

@DataSourceDefinition(name = "java:app/jdbc/clienteBDDatasource",
		className = "com.mysql.cj.jdbc.Driver",
		url = "jdbc:mysql://localhost:3306/clientebd",
        user = "root",
        password = "mysql")
public class DbInitializer {
	
	private void init(@Observes @Initialized(ApplicationScoped.class) Object object) {
	    // Este método será invocado cuando se inicialice el ámbito de aplicación CDI, durante el despliegue.
	    // No se necesita lógica; la definición de @DataSourceDefinition a nivel de clase creará una fuente de datos que será utilizada por la aplicación.
	}
}
