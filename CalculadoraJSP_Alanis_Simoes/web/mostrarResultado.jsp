<%-- 
    Document   : mostrarResultado
    Created on : 08-oct-2020, 16:17:41
    Author     : Alanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    double resultado = Double.parseDouble(request.getParameter("resultado"));    
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Caculadora JSP</title>
    </head>
    <body>
    <center>
        
        <h1> El resultado es: <%= resultado%> </h1>
        
    </center>
        
    </body>
</html>
