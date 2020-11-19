<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<!-- Diseñar un formulario web que pida la altura y el diámetro de un cilindro en metros.
Una vez el usuario introduzca los datos y pulse el botón calcular, deberá calcularse
el volumen del cilindro y mostrarse el resultado en el navegador. El envío de datos
debe hacerse por GET y la recuperación con REQUEST.-->

    VOLUMEN DE UN CILINDRO

    <?php
    
    if( isset($_REQUEST['altura']) && isset($_REQUEST['diametro']) ){
        $altura= $_REQUEST['altura'];
        $diametro= $_REQUEST['diametro'];

        $volumen= 3.14 * $diametro * $altura;

        echo "volumen: " . $volumen;
        echo "<br><br>";
    }


?>

    <form action="ej1.php" method="GET">
    
        Altura en metros:
        <input type="text" name="altura">
        <br>
        Diámetro en metros:
        <input type="text" name="diametro">
        <br>
        <input type="submit" value="Calcular">

    </form>


    
    
    <!--
        v = pi*r^2*h
        -->
</body>
</html>