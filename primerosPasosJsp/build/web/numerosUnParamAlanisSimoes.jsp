<%-- 
    Document   : index
    Created on : 07-oct-2020, 19:24:59
    Author     : Alanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String sN = request.getParameter("n");
    int n = Integer.parseInt(sN);
%>

<!--

http://localhost:8080/primerosPasosJsp/numerosUnParamAlanisSimoes.jsp?n=3

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
                for (int i = 0; i < n; i++) {
            %>
            <%= i%> <br>

            <%
                }
            %>

        </center>
    </body>
</html>
