<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vectores 3</title>
</head>
<body>

    <?php
        if( isset($_POST['vec']) ){
            $vector = $_POST['vec'];
            $n = count($vector);
            $suma = 0;
            echo "El vector tiene $n elementos <br>";
            for( $i = 0; $i < $n; $i++ ){
                echo "$i = $vector[$i]<br>";
                $suma = $suma + $vector[$i];
            }
            echo "La suma es $suma <br>";
            $n = $_POST['n'];
        }else{
            $n = 3;
            $vector[] = 0;
            $vector[] = 0;
            $vector[] = 0; 
        }
    ?>

    <form action="ej8.php" method="post">
        Número de elementos:
        <input type="text" name="n" size="5" value="<?php echo $n;?>">
        <br>
        <?php
            for($i=0; $i < $n; $i++){
                echo $i;
                echo "<input type='text' name='vec[]' value='$vector[$i]' >";
                echo "<br>";
            }
        ?>
        <input type="submit">
    </form>
    
</body>
</html>