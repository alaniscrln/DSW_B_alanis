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
        <title>Insertar en Agenda</title>
    </head>
    <body>
        <!--http://localhost:8080/AgendaJSP/formInsertar.jsp
        <form action="insertarDatos.jsp">
            <label for="dni">DNI:</label><br>
            <input type="text" id="dni" name="dni"><br>
            <label for="nombre">Nombre:</label><br>
            <input type="text" id="nombre" name="nombre"><br>
            <label for="apellidos">Apellidos:</label><br>
            <input type="text" id="apellidos" name="apellidos"><br><br>
            <input type="submit" value="Agregar">
        </form> 
        -->

        <form action="">
            <label for="dni">DNI:</label><br>
            <input type="text" id="dni" name="dni"><br>
            <label for="nombre">Nombre:</label><br>
            <input type="text" id="nombre" name="nombre"><br>
            <label for="apellidos">Apellidos:</label><br>
            <input type="text" id="apellidos" name="apellidos"><br><br>
            <input type="submit" value="Insertar">
            <input type="reset" value="Reset">
            
            <%

                String dni = request.getParameter("dni");
                String nombre = request.getParameter("nombre");
                String apellidos = request.getParameter("apellidos");
                try {
                    UsuarioControlador uc = new UsuarioControlador();
                    uc.insertar(dni, nombre, apellidos);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }

            %>
            
        </form> 



    </body>
</html>
