<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!--Diseñar un desarrollo web simple con php que pida al usuario el precio de tres
productos en tres establecimientos distintos denominados “Tienda 1”, “Tienda 2” y
“Tienda 3”. Una vez se introduzca esta información se debe calcular y mostrar el
precio   medio   del   producto.   El   envío  de   datos  debe   hacerse   por   POST  y  la
recuperación con REQUEST-->

<?php
    
    if( isset($_REQUEST['tienda1']) && isset($_REQUEST['tienda2']) && isset($_REQUEST['tienda3']) ){
        $tienda1= $_REQUEST['altura'];
        $diametro= $_REQUEST['diametro'];

        $volumen= 3.14 * $diametro * $altura;

        echo "volumen: " . $volumen;
        echo "<br><br>";
    }


?>

    <form action="ej2.php" method="POST">
    
        Precio articulo en tienda 1:
        <input type="text" name="tienda1">
        <br>
        Precio articulo en tienda 2:
        <input type="text" name="tienda2">
        <br>
        Precio articulo en tienda 3:
        <input type="text" name="tienda3">
        <br>
        <input type="submit" value="Calcular precio medio">

    </form>

</body>
</html>