<%-- 
    Document   : index
    Created on : 22-oct-2020, 15:41:25
    Author     : Alanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dar de Alta</title>
    </head>
    <body>
        <h1>Dar de alta al alumno:</h1>

        <form method="post" action="dardealta">

            <input type="hidden" name ="accion" value="dardealta"/>
            
            <label>Nombre: </label>
            <input type="text" name="nombre"/>
            <br/>
            <label>Apellido 1: </label>
            <input type="text" name="apellido1"/>
            <br/>
            <label>Apellido 2: </label>
            <input type="text" name="apellido2"/>
            <br/>
            <label>DNI: </label>
            <input type="text" name="dni"/>
            <br/>
            <label>Curso: </label>
            <select name="curso" id="curso">
                <option value="1ESO">1º ESO</option>
                <option value="2ESO">2º ESO</option>
                <option value="3ESO">3º ESO</option>
                <option value="4ESO">4º ESO</option>
                <option value="1BACH">1º BACH</option>
                <option value="2BACH">2ºBACH</option>
            </select>
            <br/>
            <input type="submit" value="Dar de alta"/>

        </form>
    </body>
</html>
