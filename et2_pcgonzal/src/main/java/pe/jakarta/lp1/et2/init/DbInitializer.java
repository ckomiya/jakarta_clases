package pe.jakarta.lp1.et2.init;



import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
@DataSourceDefinition(
    name = "java:app/jdbc/empleadoBDDatasource",
    className = "com.mysql.cj.jdbc.Driver",
    url = "jdbc:mysql://localhost:3306/empleadobd?serverTimezone=UTC",
    user = "root",
    password = "mysql"
)
public class DbInitializer {
    
    private void init(@Observes @Initialized(ApplicationScoped.class) Object object) {
        // Método vacío que se activa al inicializar la aplicación
    }
}