<%-- 
    Document   : index
    Created on : 04-oct-2020, 19:32:24
    Author     : Alanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fecha y Hora</title>
    </head>
    <body>
        <h1>Alanis Carolina Simoes Villalonga</h1>

        <%
            response.setIntHeader("Refresh", 1); //para que la pag se refresque cada segundo
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            String dia = formatoFecha.format(new Date());
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            String hora = formatoHora.format(new Date());
        %>

        <p>Fecha: <%=dia%></p>
        <p>Hora: <%=hora%></p>









    </body>
</html>
