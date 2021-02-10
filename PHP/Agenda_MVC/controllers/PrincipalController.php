<?php
    require_once "Validador.php";
    require_once "PersonaController.php";
    require_once "EmpresaController.php";
    require_once "ActividadController.php";
    require_once "ContactoController.php";
    require_once './../config/database.php';
    require_once "./../core/EntidadBase.php";
    require_once "./../models/Actividad.php";
    require_once "./../models/Contacto.php";
    require_once "./../models/Persona.php";
    require_once "./../models/Empresa.php";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agenda</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="./../views/styles/styles.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="./../index.php">AGENDA</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="./../views/personaIndex.php">Persona</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./../views/empresaIndex.php">Empresa</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./../views/actividadIndex.php">Actividad</a>
                </li>
            </ul>
        </div>
    </nav>
    
	<div class="container text-center">
        <br><br><br><br>
        
        <?php

            $controladorPersona = new PersonaController();
            $controladorActividad = new ActividadController();
            $controladorEmpresa = new EmpresaController();
            $controladorContacto = new ContactoController();

            $tipo = $_REQUEST["tipo"];
            switch($tipo){
                case "insertarPersona":
                    echo "<h1>" . $controladorPersona->insert() . "</h1>"; 
                    break;
                case "eliminarPersona":
                    echo "<h1>" . $controladorPersona->delete() . "</h1>"; 
                    break;
                case "modificarPersona":
                    echo "<h1>" . $controladorPersona->update() . "</h1>"; 
                    break;
                case "buscarPersona": 
                    echo "<h1>" . $controladorPersona->getById() . "</h1>";
                    break;
                case "mostrarPersonas":
                    echo "<h1 class='display-4'>Lista personas</h1><br>" . $controladorPersona->getAll();
                    break;
            //--------------------------------------------------------------------------------------------------------
                case "insertarEmpresa":
                    echo "<h1>" . $controladorEmpresa->insert() . "</h1>"; 
                    break;
                case "eliminarEmpresa":
                    echo "<h1>" . $controladorEmpresa->delete() . "</h1>"; 
                    break;
                case "modificarEmpresa":
                    echo "<h1>" . $controladorEmpresa->update() . "</h1>"; 
                    break;
                case "buscarEmpresa": 
                    echo "<h1>" . $controladorEmpresa->getById() . "</h1>";
                    break;
                case "mostrarEmpresas":
                    echo "<h1 class='display-4'>Lista empresas</h1><br>" . $controladorEmpresa->getAll();
                    break;
            //--------------------------------------------------------------------------------------------------------
                case "insertarActividad":
                    echo "<h1>" . $controladorActividad->insert() . "</h1>"; 
                    break;
                case "eliminarActividad":
                    echo "<h1>" . $controladorActividad->delete() . "</h1>"; 
                    break;
                case "modificarActividad":
                    echo "<h1>" . $controladorActividad->update() . "</h1>"; 
                    break;
                case "buscarActividad": 
                    echo "<h1>" . $controladorActividad->getById() . "</h1>";
                    break;
                case "mostrarActividades":
                    $sql= "SELECT * FROM actividades";
                    echo "<h1 class='display-4'>Lista actividades</h1><br>" . $controladorActividad->getAll($sql);
                    break;
                case "mostrarActividadesPersonas":
                    $sql = "SELECT a.id, a.idContacto, a.hora, a.fecha, a.lugar, a.actividad FROM actividades a INNER JOIN personas p on a.idContacto = p.id";
                    echo "<h1 class='display-4'>Lista actividades con personas</h1><br>" . $controladorActividad->getAll($sql);
                    break;
                case "mostrarActividadesEmpresas":
                    $sql = "SELECT a.id, a.idContacto, a.hora, a.fecha, a.lugar, a.actividad FROM actividades a INNER JOIN empresas e on a.idContacto = e.id";
                    echo "<h1 class='display-4'>Lista actividades con empresas</h1><br>" . $controladorActividad->getAll($sql);
                    break;
            //--------------------------------------------------------------------------------------------------------
                case "mostrarContactos":
                    $sql = "SELECT c.id, c.tipo, c.nombre, c.telefono, p.cumpleanos, e.web FROM contactos c LEFT OUTER JOIN personas p ON c.id = p.id LEFT OUTER JOIN empresas e ON c.id = e.id ORDER BY c.nombre";
                    echo "<h1 class='display-4'>Lista contactos</h1><br>" . $controladorContacto->getAll($sql);
                    break;
            }

        ?>       

	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>
