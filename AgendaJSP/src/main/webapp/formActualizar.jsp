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
        <title>Actualizar en Agenda</title>
    </head>
    <body>

        <form action="">
            <label for="dni">DNI:</label><br>
            <input type="text" id="dni" name="dni"><br>
            <label for="nombreNuevo">Nombre nuevo:</label><br>
            <input type="text" id="nombreNuevo" name="nombreNuevo"><br>
            <label for="apellidosNuevo">Apellidos nuevos:</label><br>
            <input type="text" id="apellidosNuevo" name="apellidosNuevo"><br><br>
            <input type="submit" value="Actualizar">
            <input type="reset" value="Reset">
            
            <%

                String dni = request.getParameter("dni");
                String nombreNuevo = request.getParameter("nombreNuevo");
                String apellidosNuevo = request.getParameter("apellidosNuevo");
                try {
                    UsuarioControlador uc = new UsuarioControlador();
                    uc.modificar(dni, nombreNuevo, apellidosNuevo);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }

            %>
            
        </form> 



    </body>
</html>
