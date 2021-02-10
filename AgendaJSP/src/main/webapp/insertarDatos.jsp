<%-- 
    Document   : insertarDatos
    Created on : 11-ene-2021, 17:57:07
    Author     : Alanis
--%>
<%@ page import="es.iespuertodelacruz.jpexposito.controlador.UsuarioControlador" %>
<%@ page import="es.iespuertodelacruz.jpexposito.exception.DatosIncorrectosException" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            try {
                UsuarioControlador.insertar(dni, nombre, apellidos);
                System.out.println("salio bn");
            } catch (Exception ex) {
                System.out.println("erroooooooooooooor");
            }

        %>
        <h1>El usuario ha sido agregado.</h1>
    </body>
</html>
