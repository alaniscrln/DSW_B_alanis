<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        session_start();

        if( isset( $_SESSION["nombre"] ) ){
            echo "Valor recuperado de session: " . $_SESSION["nombre"] . "<br>";
        }
        if( isset( $_REQUEST["titulo"] ) ){
            $_SESSION["titulo"] = $_REQUEST["titulo"];
            echo "Valor recuperado por request: " . $_REQUEST["titulo"];
        }
    
    ?>

    <form action="pagina2.php" method="post">
        <br><br>
        Nombre:
        <input type="text" name="nombre" id="nombre">
        <br>
        <input type="submit" value="enviar">
    </form>
</body>
</html>