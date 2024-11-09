package pe.jakarta.lp1.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AsincronoServlet", urlPatterns = { "/AsincronoServlet" }, asyncSupported = true)
public class AsincronoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final Logger logger = Logger.getLogger(AsincronoServlet.class.getName());
		logger.log(Level.INFO, "--- Ingresando a doGet()");
		
		response.setContentType("text/html; charset=UTF-8");
		final AsyncContext ac = request.startAsync();
		logger.log(Level.INFO, "---- Invocando ac.start()");
		ac.start(new Runnable() {

			@Override
			public void run() {
				logger.log(Level.INFO, "Dentro del hilo");
				try {
					Thread.sleep(10000);
					ac.getResponse().getWriter().println("Deberías ver esto después de una breve espera.");
					ac.complete();
				} catch (Exception ex) {
					Logger.getLogger(AsincronoServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		logger.log(Level.INFO, "Saliendo del doGet()");
	}
}
