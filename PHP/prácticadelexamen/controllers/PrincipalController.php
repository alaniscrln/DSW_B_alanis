<?php
    require_once "Validador.php";
    require_once "PersonaController.php";
    require_once "MascotaController.php";
    require_once './../config/database.php';
    require_once "./../core/ModeloBase.php";
    require_once "./../models/ModeloPersona.php";
    require_once "./../models/ModeloMascota.php";
    require_once "Persona.php";
    require_once "Mascota.php";

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MASCOTA</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="./../views/styles/styles.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="./../index.php">MASCOTA</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="./../views/personaIndex.php">Persona</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./../views/mascotaIndex.php">Mascota</a>
                </li>
            </ul>
        </div>
    </nav>
    
	<div class="container text-center">
        <br><br><br><br>
        
        <?php

            $personaControl = new PersonaController();

            $tipo = $_REQUEST["tipo"];
            switch($tipo){
                case "insertarPersona":
                    session_start();
                    $_SESSION["resultado"] = $personaControl->insertar();
                    $_SESSION["listaPersona"] = $personaControl->getAll();
                    ?><script>window.location.replace("./../views/personaIndex.php");</script><?php
                    break;
                case "eliminarPersona":
                    echo "<h1>" . $personaControl->eliminar() . "</h1>"; 
                    break;
                case "modificarPersona":
                    echo "<h1>" . $personaControl->actualizar() . "</h1>"; 
                    break;
                case "buscarPersona": 
                    echo "<h1>" . $personaControl->buscar() . "</h1>";
                    break;
            
            }

        ?>       

	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>
