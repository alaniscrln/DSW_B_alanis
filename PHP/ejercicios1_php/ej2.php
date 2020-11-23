<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Uso del FOR</title>
</head>
<body>
    <?php
        echo "<h1>Bienvenidos a mi página web</h1>";
        echo "<table align='center' border='1'>";
        for($i=0; $i < 10; $i++){
            echo"<tr><td>Mi correo es alanis.crln@gmail.com</td></tr>";
        }
        echo "</table>";
    ?>
    
</body>
</html>