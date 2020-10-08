<%-- 
    Document   : index
    Created on : 08-oct-2020, 15:48:27
    Author     : Alanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora JSP</title>
    </head>

    <body>

        <form action="mostrarResultado.jsp">

            <center> <h1>CALCULADORA JSP</h1> </center>
            <br>
            Número 1: <input type="text" name="num1"/> <br>
            
            Escoja operación: <br>
            
            <input type="radio" id="suma" name="operacion" value="suma"/>
            <label for="suma"> + </label>
            <br>
            <input type="radio" id="resta" name="operacion" value="resta"/>
            <label for="resta"> - </label>
            <br>
            <input type="radio" id="multiplicacion" name="operacion" value="multiplicacion"/>
            <label for="multiplicacio"> * </label>
            <br>
            <input type="radio" id="division" name="operacion" value="division"/>
            <label for="division"> / </label>
            <br>
            
            Número 2: <input type="text" name="num2"/> <br>
            
            <input type="submit" value="calcular"/>
        </form>



    </body>

</html>
