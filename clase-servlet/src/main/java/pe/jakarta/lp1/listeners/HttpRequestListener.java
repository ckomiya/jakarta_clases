package pe.jakarta.lp1.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class HttpRequestListener implements ServletRequestListener {
    
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        ServletContext servletContext = servletRequestEvent.getServletContext();
        servletContext.log("Nueva solicitud inicializada");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        ServletContext servletContext = servletRequestEvent.getServletContext();
        servletContext.log("Solicitud destruida");
    }
}