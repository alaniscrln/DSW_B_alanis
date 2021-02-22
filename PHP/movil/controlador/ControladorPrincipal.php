<?php

    require_once "./../config/database.php";
    require_once "Validador.php";
    require_once "FamiliaControlador.php";
    require_once "PersonaControlador.php";
    //require_once "MovilControlador.php";
    require_once "./../core/ModeloBase.php";
    require_once "./../modelo/ModeloFamilia.php";
    require_once "./../modelo/ModeloPersona.php";
    require_once "./../modelo/ModeloMovil.php";
    require_once "./../modelo/Familia.php";
    require_once "./../modelo/Movil.php";
    require_once "./../modelo/Persona.php";

    $personaControlador = new PersonaControlador();
    $famControlador = new FamiliaControlador();
    
    $accion = $_REQUEST["accion"];
    switch($accion){
        case "crearPersona":
            if($_SERVER['REQUEST_METHOD'] == "POST" and isset($_POST['agregar'])){
                $personaControlador->guardarDatosSession();    
                ?><script>window.location.replace("./../vista/familia/crear.php");</script><?php
                //guardar en session los datos 
            }else{
                $resultado = $personaControlador->insertarFamilia();
                session_start();
                $_SESSION["listaPersonas"] = $personaControlador->listar();
                ?><script>window.location.replace("./../vista/familiaIndex.php");</script><?php
                //coger todos los obj de personas y guardarlos en bbdd
                
            }
            break;
        case "buscarFamilia":
            if($_REQUEST["idFam"] != null){
                $famControlador->buscarFamilia($_REQUEST["idFam"]);
            }
            break;
        case "eliminarFamilia":
            if($_REQUEST["idFam"] != null){
                $famControlador->eliminarFamilia($_REQUEST["idFam"]);
            }
            break;
        
    }

?>












