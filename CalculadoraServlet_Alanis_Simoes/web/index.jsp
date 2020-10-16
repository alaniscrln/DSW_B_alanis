<%-- 
    Document   : index
    Created on : 16-oct-2020, 20:15:45
    Author     : Alanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora SERVLET</title>
    </head>

    <body>

        <form method="post" action="calcular">

            <center> <h1>CALCULADORA SERVLET</h1> </center>
            <br>
            Número 1: <input type="text" name="num1"/> <br>

            <label for="operacion">Escoja operación: </label>
            <select name="operacion" id="operacion">
                <option value="+">+</option>
                <option value="-">-</option>
                <option value="*">*</option>
                <option value="/">/</option>
            </select>
            <br>

            Número 2: <input type="text" name="num2"/> <br>

            <input type="submit" name = "calcular" value="calcular"/>
        </form>



    </body>

</html>
