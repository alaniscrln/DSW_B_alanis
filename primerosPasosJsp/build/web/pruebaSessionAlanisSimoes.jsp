<%-- 
    Document   : index
    Created on : 07-oct-2020, 19:03:12
    Author     : Alanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="java.util.Date"%>

<%
    // tomo de la session el atributo "fechahora". Si da null
    // significa q es la primera vez q pasa por aquí

    Date d = (Date) session.getAttribute("fechahora");
    if (d == null) {
        
        // creo un obj Date y lo meto en la session asociado
        // al nombre "fechahora"
        
        d = new Date(System.currentTimeMillis());
        session.setAttribute("fechahora", d);
    }

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prueba Session</title>
    </head>
    <body>
        <h1>Alanis Simoes</h1>

        Ud. llegó a las <b> <%=d%></b> <br>

        <a href="otraPaginaAlanisSimoes.jsp"> Ir a otra página... </a> 
    </body>
</html>
