<%-- 
    Document   : insertar
    Created on : 11-ene-2021, 17:53:18
    Author     : Alanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar en Agenda</title>
    </head>
    <body>
        
        <form action="/insertarDatos.jsp">
            <label for="dni">DNI:</label><br>
            <input type="text" id="dni" name="dni"><br>
            <label for="nombre">Nombre:</label><br>
            <input type="text" id="nombre" name="nombre"><br>
            <label for="apellidos">Apellidos:</label><br>
            <input type="text" id="apellidos" name="apellidos"><br><br>
            <input type="submit" value="Submit">
        </form> 

        
        
    </body>
</html>
