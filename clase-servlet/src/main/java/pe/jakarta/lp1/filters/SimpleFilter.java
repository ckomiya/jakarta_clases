package pe.jakarta.lp1.filters;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

@WebFilter(initParams = { 
	    @WebInitParam(name = "filterparam1", value = "filtervalue1")
	}, urlPatterns = {"/InitParamsServlet"}) 
	public class SimpleFilter implements Filter { 
	    private static final Logger LOG = Logger.getLogger(SimpleFilter.class.getName()); 
	    private FilterConfig filterConfig; 
	    
	    @Override 
	    public void init(FilterConfig filterConfig) throws ServletException { 
	        this.filterConfig = filterConfig; 
	    } 
	    
	    @Override 
	    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) 
	            throws IOException, ServletException { 
	        LOG.log(Level.INFO, "Ingresando a doFilter()"); 
	        LOG.log(Level.INFO, "Inicialización de parámetros: "); 
	        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames(); 
	        String parameterName; 
	        String parameterValue; 
	        
	        while (initParameterNames.hasMoreElements()) { 
	            parameterName = initParameterNames.nextElement(); 
	            parameterValue = filterConfig.getInitParameter(parameterName); 
	            LOG.log(Level.INFO, "{0} = {1}", new Object[]{parameterName, parameterValue}); 
	        } 
	        
	        LOG.log(Level.INFO, "Invocando servlet..."); 
	        filterChain.doFilter(servletRequest, servletResponse); 
	        LOG.log(Level.INFO, "Regresando de la invocación del servlet"); 
	    } 
	    
	    @Override 
	    public void destroy() { 
	        filterConfig = null; 
	    } 
	}