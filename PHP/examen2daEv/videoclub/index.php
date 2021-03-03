<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VIDEOCLUB</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="./index.php">VIDEOCLUB</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>

<div class="container text-center">
    <div class="row mt-4">
        <div class="col-12">
            <h1 class="display-4">CLIENTES</h1>
            <div class="btn-group" role="group">
                <button type="button" class="btn btn-secondary" onclick="location.href='./views/insertar.php'">INSERTAR</button>
                <button type="button" class="btn btn-secondary" onclick="location.href='./views/eliminar.php'">ELIMINAR</button>
                <button type="button" class="btn btn-secondary" onclick="location.href='./views/modificar.php'">MODIFICAR</button>
                <button type="button" class="btn btn-secondary" onclick="location.href='./views/buscarDNI.php'">BUSCAR POR DNI</button>
                <button type="button" class="btn btn-secondary" onclick="location.href='./views/buscarNombre.php'">BUSCAR POR NOMBRE</button>
            </div>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="col-12">
        <?php
            require './config/database.php';
            require "./models/Conexion.php";
            require "./core/ModeloBase.php";
            require "./models/ModeloCliente.php";
            require "./controllers/Cliente.php";
            require "./controllers/Direccion.php";
            require "./controllers/ValidadorCP.php";
            require "./controllers/ValidadorDNI.php";
            require "./controllers/ClienteController.php";

            $clienteControl = new ClienteController();
        
            session_start();
            $_SESSION["listaClientes"] = $clienteControl->getAll();

            if( isset($_SESSION["resultado"]) && $_SESSION["resultado"] != null ){
                echo "<br><h4>" . $_SESSION["resultado"] . "</h4>"; 
            }
            if( isset($_SESSION["listaClientes"]) && $_SESSION["listaClientes"] != null){
                echo "<br><br>" . $_SESSION["listaClientes"];
            }
            session_destroy();
        ?>
        </div>
        
    </div>
    
</div>

<!-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>