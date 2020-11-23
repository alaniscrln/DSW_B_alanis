<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vector 2</title>
</head>
<body>
    <?php
        if( isset( $_POST['vec'] ) ){
            $vector = $_POST['vec'];
            $longitud = count($vector);
            $suma = 0;
            echo "El vector tiene $longitud elementos<br>";
            for($i=0; $i < $longitud; $i++){
                echo "$i = $vector[$i] <br>";
                $suma = $suma + $vector[$i];
            }
            echo "La suma es " . $suma . "<br>";
        }
    ?>
    <form action="ej7.php" method="GET">
        Número de elementos:
        <input type="text" name="n" size="5">
        <input type="submit" value="Aceptar">
    </form>
    <br><br>

    <form action="ej7.php" method="post">
        <?php
            if( isset( $_GET['n']) ){
                $n = $_GET['n'];
            }else{
                $n = 3;
            }

            for( $i = 1; $i <= $n; $i++ ){
                echo $i;
                echo "<input type='text' name='vec[]' size='10'>";
                echo "<br>";
            }

        ?>
        <input type="submit">
    </form>
    
</body>
</html>