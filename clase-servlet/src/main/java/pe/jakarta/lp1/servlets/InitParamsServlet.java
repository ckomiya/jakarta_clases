package pe.jakarta.lp1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(
	    name = "InitParamsServlet",
	    urlPatterns = {"/InitParamsServlet"},
	    initParams = {
	        @WebInitParam(name = "param1", value = "value1"),
	        @WebInitParam(name = "param2", value = "value2")
	    }
	)
	public class InitParamsServlet extends HttpServlet {
	    @Override
	    protected void doGet(HttpServletRequest request,
	                         HttpServletResponse response)
	                         throws ServletException, IOException {
	        ServletConfig servletConfig = getServletConfig();
	        String valor1 = servletConfig.getInitParameter("param1");
	        String valor2 = servletConfig.getInitParameter("param2");

	        response.setContentType("text/html");
	        PrintWriter printWriter = response.getWriter();
	        printWriter.println("<p>");
	        printWriter.println("El valor de param1 es " + valor1);
	        printWriter.println("</p>");
	        printWriter.println("<p>");
	        printWriter.println("El valor de param2 es " + valor2);
	        printWriter.println("</p>");
	    }
	}