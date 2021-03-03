<?php
    require "./../models/Conexion.php";
    require "ValidadorCP.php";
    require "ValidadorDNI.php";
    require "ClienteController.php";
    require './../config/database.php';
    require "./../core/ModeloBase.php";
    require "./../models/ModeloCliente.php";
    require "Cliente.php";
    require "Direccion.php";

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Videoclub</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="./../views/styles/styles.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="./../index.php">VIDEOCLUB</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </nav>
    
	<div class="container text-center">
        <br><br><br><br>
        
        <?php

            $clienteControl = new ClienteController();
            session_start();
            $tipo = $_REQUEST["tipo"];
            switch($tipo){
                case "insertarCliente":
                    $_SESSION["resultado"] = $clienteControl->insertar();
                    ?><script>window.location.replace("./../index.php");</script><?php
                    break;

                case "eliminarCliente":

                    $_SESSION["resultado"] = $clienteControl->eliminar();
                    ?><script>window.location.replace("./../index.php");</script><?php

                    break;
                case "modificarCliente":
                    $_SESSION["resultado"] = $clienteControl->actualizar();
                    ?><script>window.location.replace("./../index.php");</script><?php
                    break;
                case "buscarClienteDNI": 
                    echo "<h1>" . $clienteControl->buscar("dni") . "</h1>";
                    break;
                case "buscarClienteNombre":
                    echo "<h1>" . $clienteControl->buscar("nombre") . "</h1>";
                    break;

            }

        ?>       

	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>
