/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.alanissimoes;

import es.iespuertodelacruz.alanissimoes.controlador.Division;
import es.iespuertodelacruz.alanissimoes.controlador.Multiplicacion;
import es.iespuertodelacruz.alanissimoes.controlador.Resta;
import es.iespuertodelacruz.alanissimoes.controlador.Suma;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alanis
 */
public class CalculadoraServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalculadoraServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculadoraServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        
        
        String num1 = request.getParameter("num1");
        String operacion = request.getParameter("operacion");
        String num2 = request.getParameter("num2");
        
        
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
        
            
            response(resp, "El resultado es: " + resultado);
        
        //processRequest(request, response);
        
        
        
    }

    private void response(HttpServletResponse resp, String mensaje) throws IOException {
        
        resp.setContentType("text/html"); // tipo de respuesta q voy a dar es html
        PrintWriter out = resp.getWriter(); // va a pintar
        out.println("<html><head>");
        out.println("<title>A Sample Servlet!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center><h1>" + mensaje + "</h1></center>");
        out.println("</body></html>");
        out.close(); // cerramos
    }
    
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
