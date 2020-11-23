<%-- 
    Document   : otraPagina
    Created on : 07-oct-2020, 19:08:40
    Author     : Alanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="java.util.Date"%>

<%

    Date d = (Date)session.getAttribute("fechahora");

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alanis Simoes</h1>
        
        Yo recuerdo que usted llegó a las: <b> <%=d%> </b>
    </body>
</html>
