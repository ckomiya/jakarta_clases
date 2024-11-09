package pe.jakarta.lp1.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.annotation.WebListener;
import pe.jakarta.lp1.servlets.ConfiguracionPorCodigoServlet;

@WebListener()
public class ServletContextListenerImpl implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		try {
			ConfiguracionPorCodigoServlet servlet = servletContext.createServlet(ConfiguracionPorCodigoServlet.class);
			servletContext.addServlet("ConfiguracionPorCodigoServlet", servlet);
			ServletRegistration servletRegistration = servletContext
					.getServletRegistration("ConfiguracionPorCodigoServlet");
			servletRegistration.addMapping("/ConfiguracionPorCodigoServlet");
		} catch (ServletException servletException) {
			servletContext.log(servletException.getMessage());
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}
}
