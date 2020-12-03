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
        $inactividad = 10;
        // Comprobar si $_SESSION["timeout"] está establecida
        if(isset($_SESSION["timeout-titulo"])){
            // Calcular el tiempo de vida de la sesión (TTL = Time To Live)
            $sessionTTL = time() - $_SESSION["timeout-titulo"];
            if($sessionTTL > $inactividad){
                session_destroy();
                echo "session de titulo terminada";
            }
        }

        if( isset( $_SESSION["titulo"] ) ){
            echo "Valor recuperado de session: " . $_SESSION["titulo"] . "<br>";
        }
        if( isset( $_REQUEST["nombre"]) ){
            $_SESSION["nombre"] = $_REQUEST["nombre"];
            $_SESSION["timeout"] = time();
            echo "Valor recuperado por request: " . $_REQUEST["nombre"];
        }

    ?>

    <form action="pagina1.php" method="post">
        <br><br>
        Título:
        <input type="text" name="titulo" id="titulo">
        <br>
        <input type="submit" value="enviar">
    </form>
</body>
</html>