package pe.jakarta.lp1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/multiplesvaloresservlet"})
public class MultiplesValoresServlet extends HttpServlet {
	
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
//	    String[] selectedOptions = request.getParameterValues("options");
//	    response.setContentType("text/html");
//	    try {
//	        PrintWriter printWriter = response.getWriter();
//	        printWriter.println("<p>");
//	        printWriter.print("Las siguientes opciones fueron seleccionadas:");
//	        printWriter.println("<br/>");
//	        if (selectedOptions != null) {
//	            for (String option : selectedOptions) {
//	                printWriter.print(option);
//	                printWriter.println("<br/>");
//	            }
//	        } else {
//	            printWriter.println("Ninguna");
//	        }
//	        printWriter.println("</p>");
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
	    String[] selectedOptions = request.getParameterValues("options");
	    ArrayList<String> selectedOptionLabels = null;
	    if (selectedOptions != null) {
	        selectedOptionLabels = new ArrayList<String>(selectedOptions.length);
	        for (String selectedOption : selectedOptions) {
	            if (selectedOption.equals("Opción1")) {
	                selectedOptionLabels.add("Opción 1");
	            } else if (selectedOption.equals("Opción2")) {
	                selectedOptionLabels.add("Opción 2");
	            } else if (selectedOption.equals("Opción3")) {
	                selectedOptionLabels.add("Opción 3");
	            }
	        }
	    }
	    request.setAttribute("checkedLabels", selectedOptionLabels);
	    try {
	        request.getRequestDispatcher("confirmacionservlet").forward(request, response);
	    } catch (ServletException | IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
}
