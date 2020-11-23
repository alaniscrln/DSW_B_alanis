<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<!--. Diseñar un desarrollo web simple con PHP que dé respuesta a la necesidad que se
plantea a continuación. Un operario de una fábrica recibe cada cierto tiempo un
depósito cilíndrico de dimensiones variables, que debe llenar de aceite a través de
una toma con cierto caudal disponible. Se desea crear una aplicación web que le
indique cuánto tiempo transcurrirá hasta el llenado del depósito. El caudal
disponible se considera estable para los tiempos que tardan los llenados de
depósitos y lo facilita el propio operario, aportando el dato en litros por minuto.
    -->
    <?php
    
    if( isset($_REQUEST['altura']) && isset($_REQUEST['diametro']) && isset($_REQUEST['litros_minuto'])){
        $altura= $_REQUEST['altura'];
        $diametro= $_REQUEST['diametro'];
        $litros_minuto = $_REQUEST['litros_minuto'];

        $volumen = 3.14 * ($diametro / 2) * ($diametro / 2) * $altura;   //m^3
        //en 1m^3 caben 1000 litros
        $capacidad = $volumen * 1000;   //en litros

        $tiempo = $capacidad / $litros_minuto;
        echo "Volumen: " . $volumen . " metros cúbicos <br>";
        echo "Capacidad: " . $capacidad . " litros <br>";
        echo "Tiempo en llenarse: " . $tiempo . " minutos";

        echo "<br><br>";
    }

    ?>
    
    <form action="ej3.php" method="post">
        Dimensiones del depósito cilíndrico: 
        <br>
        Altura en metros:
        <input type="text" name="altura">
        <br>
        Diámetro en metros:
        <input type="text" name="diametro">
        <br>
        Tiempo que tarde en llenarse (litros/minuto):
        <input type="text" name="litros_minuto">
        <br>
        <input type="submit" value="Calcular tiempo total de llenado">
    </form>
    
</body>
</html>