<%-- 
    Document   : mostrarResultado
    Created on : 08-oct-2020, 16:17:41
    Author     : Alanis
--%>

<%@page import="es.iespuertodelacruz.alanissimoes.controlador.Division"%>
<%@page import="es.iespuertodelacruz.alanissimoes.controlador.Multiplicacion"%>
<%@page import="es.iespuertodelacruz.alanissimoes.controlador.Resta"%>
<%@page import="es.iespuertodelacruz.alanissimoes.controlador.Suma"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

    //Los recibo como string para luego en Operacion comprobar q sean numeros
    
    String num1 = request.getParameter("num1");
    String operacion = request.getParameter("operacion");
    String num2 = request.getParameter("num2");

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Caculadora JSP</title>
    </head>
    <body>
        <%
            char op = operacion.charAt(0);
            double resultado;
            switch (op) {
                    case '+':
                        Suma suma = new Suma();
                        resultado = suma.sumar(num1, num2); 
                        break;
                    case '-':
                        Resta resta = new Resta();
                        resultado = resta.restar(num1, num2);
                        break;
                    case '*':
                        Multiplicacion multiplicacion = new Multiplicacion();
                        resultado = multiplicacion.multiplicar(num1, num2);
                        break;
                    case '/':
                        Division division = new Division();
                        resultado = division.dividir(num1, num2);
                        break;
                    default:
                        throw new AssertionError();
                }

        %>

    <center>

        <h1> El resultado es: <%= resultado%> </h1>

    </center>

</body>
</html>
