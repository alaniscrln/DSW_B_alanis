<%-- 
    Document   : insertar
    Created on : 11-ene-2021, 17:53:18
    Author     : Alanis
--%>

<%@ page import="es.iespuertodelacruz.jpexposito.controlador.UsuarioControlador" %>
<%@ page import="es.iespuertodelacruz.jpexposito.exception.DatosIncorrectosException" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar en Agenda</title>
    </head>
    <body>
        
        <form action="">
            <label for="dni">DNI:</label><br>
            <input type="text" id="dni" name="dni"><br>
            <input type="submit" value="Buscar">
            <input type="reset" value="Reset">
            
            <%

                String dni = request.getParameter("dni");
                String usuario = null;
                try {
                    UsuarioControlador uc = new UsuarioControlador();
                    usuario = uc.buscar(dni);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }

            %>
            
            <br>
            <h1>El usuario es: <%=usuario %></h1>
            
        </form> 



    </body>
</html>
