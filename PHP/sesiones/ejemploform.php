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


        if( isset( $_SESSION['usuario'] ) ){
            echo "Valor recuperado de la session: " . $_SESSION['usuario'] . "<br>";
        }

        if( isset( $_REQUEST['usuario'] ) ){
            $usuario = $_REQUEST['usuario'];
            $_SESSION["usuario"] = $usuario;
            echo "Usuario " . $usuario . " recuperado por request <br>";
        }
    ?>


    <form action="ejemploform.php" method="GET">
        Usuario:
        <input type="text" name="usuario" id="usuario">
        <br>
        <input type="submit" value="enviar">
    </form>

</body>
</html>