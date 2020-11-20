<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora</title>
</head>
<body>
    <?php  
        $y = $_POST['a'];
        $z = $_POST['b'];
        $c = $y + $z;

        echo "La suma de $y + $z es $c";
    ?>
</body>
</html>