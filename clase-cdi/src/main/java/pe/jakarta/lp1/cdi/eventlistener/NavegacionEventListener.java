package pe.jakarta.lp1.cdi.eventlistener;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.event.Observes;
import pe.jakarta.lp1.cdi.event.NavegacionInfo;


@SessionScoped
public class NavegacionEventListener implements Serializable {

	private static final Logger LOG = Logger.getLogger(NavegacionEventListener.class.getName());

    public void procesarEventoDeNavegacion(@Observes NavegacionInfo navegacionInfo) {
    	LOG.info("Evento de navegación activado");
        LOG.log(Level.INFO, "Página: {0}", navegacionInfo.getPagina());
        LOG.log(Level.INFO, "Empleado: {0}", navegacionInfo.getEmpleado());
    }
}

