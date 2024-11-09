package pe.jakarta.lp1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/simpleservlet"})
public class SimpleServlet extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse res) {
     try {
         res.setContentType("text/html");
         PrintWriter printWriter = res.getWriter();
         printWriter.println("<h2>");
         printWriter.println("¡Hola, mundo de servlets!");
         printWriter.println("</h2>");
     } catch (IOException ioException) {
         ioException.printStackTrace();
     }
 }
}