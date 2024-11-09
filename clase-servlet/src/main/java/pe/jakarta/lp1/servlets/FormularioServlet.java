package pe.jakarta.lp1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/formularioservlet"})
public class FormularioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String valorIngresado;
        valorIngresado = request.getParameter("valorIngresado");
        response.setContentType("text/html");
        PrintWriter printWriter;
        try {
            printWriter = response.getWriter();
            printWriter.println("<p>");
            printWriter.print("Usted ingresó: ");
            printWriter.print(valorIngresado);
            printWriter.print("</p>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}