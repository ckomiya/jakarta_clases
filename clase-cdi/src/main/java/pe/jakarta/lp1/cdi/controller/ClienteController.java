package pe.jakarta.lp1.cdi.controller;

import java.util.logging.Logger;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import pe.jakarta.lp1.cdi.beans.Cliente;
import pe.jakarta.lp1.cdi.beans.ClientePremium;
import pe.jakarta.lp1.cdi.qualifiers.Premium;

@Named
@RequestScoped
public class ClienteController {
	private static final Logger logger = Logger.getLogger(ClienteController.class.getName());

    @Inject
    @Premium
    private Cliente cliente;

//    public String guardarCliente() {
//        logger.info("Guardanado la siguiente información \n" + cliente.toString());
//        // Si esto fuera una aplicación real,
//        // tendríamos código para guardar los datos del cliente en la
//        // base de datos aquí.
//        return "confirmacion";
//    }
    
    
    public String guardarCliente() {
    	ClientePremium clientePremium = (ClientePremium) cliente;
        logger.info("Guardando la siguiente información \n" + cliente.toString()
        + ", discount code = " 
        + clientePremium.getCodigoDescuento());
        
        // Si esto fuera una aplicación real,
        // tendríamos código para guardar los datos del cliente en la
        // base de datos aquí.
        
        return "confirmacion_premium";
    }
}