package pe.jakarta.lp1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/redireccionrespuestaservlet"})
public class RedireccionRespuestaServlet extends HttpServlet {

	@Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {
        String url = request.getParameter("searchEngine");
        if (url != null) {
            response.sendRedirect(url);
        } else {
            PrintWriter printWriter = response.getWriter();
            printWriter.println("No se seleccionó ningún motor de búsqueda.");
        }
    }
}
