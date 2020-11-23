<%-- 
    Document   : index
    Created on : 07-oct-2020, 18:42:14
    Author     : Alanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    int desde = Integer.parseInt( request.getParameter("desde") );
    int hasta = Integer.parseInt( request.getParameter("hasta") );
    
%>


<!--
Paso de varios param: 
http://localhost:8080/primerosPasosJsp/numerosDosParamAlanisSimoes.jsp?desde=0&hasta=5
-->

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alanis Simoes</h1>
        
        <center>
        <%
            for (int i = desde; i < hasta; i++) {
        %>
                <%= i%> <br>

        <%
            }
        %>

    </center>
    </body>
</html>
