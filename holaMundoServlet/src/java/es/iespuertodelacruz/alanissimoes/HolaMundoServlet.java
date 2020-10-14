/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.alanissimoes;

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
public class HolaMundoServlet implements Servlet {
    
    private ServletConfig servletConfig;

    public void init(ServletConfig servletConfig) throws ServletException {        
        if (servletConfig != null) {
            this.servletConfig = servletConfig;
        }else{
            throw new UnsupportedOperationException("El servlet no se ha iniciado correctamente.");
        }
    }

    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        
        response.setContentType( "text/html" ); // tipo de respuesta q voy a dar es html
        PrintWriter out = response.getWriter(); // va a pintar
        out.println( "<html><head>" );
        out.println( "<title>A Sample Servlet!</title>" );
        out.println( "</head>" );
        out.println( "<body>" );
        out.println( "<h1>Hello, Servlet World!</h1>" );
        out.println( "</body></html>" );
        out.close(); // cerramos
    }

    public String getServletInfo() {
        return "Hello Servlet";
    }

    public void destroy() { }
}