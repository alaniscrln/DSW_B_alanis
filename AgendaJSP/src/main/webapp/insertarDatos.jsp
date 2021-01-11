<%-- 
    Document   : insertarDatos
    Created on : 11-ene-2021, 17:57:07
    Author     : Alanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="es.iespuertodelacruz.jpexposito.modelo.jdbc.dao.UsuarioDao" %>
<%@ page import="es.iespuertodelacruz.jpexposito.modelo.Usuario" %>


<%

    String dni = request.getParameter("dni");
    String nombre = request.getParameter("nombre");
    String apellidos = request.getParameter("apellidos");
    
    Usuario usuario = new Usuario(dni, nombre, apellidos);

    insertar(usuario);
    

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
