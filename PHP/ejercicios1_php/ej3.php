<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Uso de vectores</title>
</head>
<body>
    <?php
        $ciudad[] = "San cristobal";
        $ciudad[] = "Cucuta";
        $ciudad[] = "Maracaibo";
        $ciudad[] = "Caracas";
        $n = count($ciudad);

        echo "Número de elementos = " . $n . "<br>";
        for($i = 0; $i < $n; $i++){
            echo "<br>Ciudad $i<h1>$ciudad[$i]</h1>";
        }
    ?>
</body>
</html>