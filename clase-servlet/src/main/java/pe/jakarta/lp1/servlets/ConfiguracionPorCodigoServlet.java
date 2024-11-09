package pe.jakarta.lp1.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConfiguracionPorCodigoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletOutputStream outputStream = response.getOutputStream();

		outputStream.println("Este mensaje fue generado desde un servlet que fue configurado programáticamente.");
	}
}
