/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.alanissimoes.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Alanis
 */
public class CalculadoraServlet implements Servlet {

    private ServletConfig servletConfig;

    public void init(ServletConfig servletConfig) throws ServletException {
        if (servletConfig != null) {
            this.servletConfig = servletConfig;
        } else {
            throw new UnsupportedOperationException("El servlet no se ha iniciado correctamente.");
        }
    }

    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html"); // tipo de respuesta q voy a dar es html
        PrintWriter out = response.getWriter(); // va a pintar
        out.println("<html><head>");
        out.println("<title>A Sample Servlet!</title>");
        out.println("</head>");
        out.println("<body>");

        String num1 = request.getParameter("num1");
        String operacion = request.getParameter("operacion");
        String num2 = request.getParameter("num2");
        String calcular = request.getParameter("calcular");

        if (calcular != null) {

            char op = operacion.charAt(0);
            double resultado;
            switch (op) {
                case '+':
                    Suma suma = new Suma();
                    resultado = suma.sumar(num1, num2);
                    break;
                case '-':
                    Resta resta = new Resta();
                    resultado = resta.restar(num1, num2);
                    break;
                case '*':
                    Multiplicacion multiplicacion = new Multiplicacion();
                    resultado = multiplicacion.multiplicar(num1, num2);
                    break;
                case '/':
                    Division division = new Division();
                    resultado = division.dividir(num1, num2);
                    break;
                default:
                    throw new AssertionError();
            }

            out.println("</br><h1>El resultado es:</h1> resultado");
        }

        out.println("</body></html>");
        out.close(); // cerramos
    }

    public String getServletInfo() {
        return "Hello Servlet";
    }

    public void destroy() {
    }
}
