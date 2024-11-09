package pe.jakarta.lp1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/confirmacionservlet"})
public class ConfirmacionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter printWriter;
            List<String> checkedLabels = (List<String>) request.getAttribute("checkedLabels");
            response.setContentType("text/html");
            printWriter = response.getWriter();
            printWriter.println("<p>");
            printWriter.print("Las siguientes opciones fueron seleccionadas:");
            printWriter.println("<br/>");
            if (checkedLabels != null) {
                for (String optionLabel : checkedLabels) {
                    printWriter.print(optionLabel);
                    printWriter.println("<br/>");
                }
            } else {
                printWriter.println("Ninguna");
            }
            printWriter.println("</p>");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
