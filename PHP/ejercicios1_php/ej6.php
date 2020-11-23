<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vectores</title>
</head>
<body>
    <?php
    
        if( isset( $_POST['vec'] )){
            $vector = $_POST['vec'];
            $longitud = count($vector);
            $suma = 0;
            
            for($i=0; $i < $longitud; $i++){
                echo "$i = $vector[$i] <br>";
                $suma = $suma + $vector[$i];
            }
            echo "La suma es " . $suma . "<br>";
        }

    ?>

    <form action="ej6.php" method="POST">
        <?php
            $n = 3;
            for($i = 0; $i <= $n; $i++){
                echo $i;
                echo "<input type='text' name='vec[]' size='10'>";
                echo "<br>"; 
            }
        ?>
        <input type="submit" value="Sumar">
    </form>

</body>
</html>