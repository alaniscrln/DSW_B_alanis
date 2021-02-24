<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="./../index.php">PERSONA</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">Ejemplo1</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="#">Ejemplo2</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container text-center">
    <div class="row mt-4">

        <div class="col-4 offset-4">
            <h1 class="display-4">PERSONA</h1>
            <div class="btn-group" role="group">
                <button type="button" class="btn btn-secondary" onclick="location.href='./persona/insertar.php'">CREAR</button>
                <button type="button" class="btn btn-secondary" onclick="location.href='./persona/eliminar.php'">ELIMINAR</button>
                <button type="button" class="btn btn-secondary" onclick="location.href='./persona/modificar.php'">MODIFICAR</button>
                <button type="button" class="btn btn-secondary" onclick="location.href='./persona/buscar.php'">BUSCAR</button>
            </div>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="col-12">
        <?php
            session_start();
            if( isset($_SESSION["resultado"]) && $_SESSION["resultado"] != null ){
                echo "<br><h4>" . $_SESSION["resultado"] . "</h4>"; 
            }
            if( isset($_SESSION["listaPersona"]) && $_SESSION["listaPersona"] != null){
                echo "<br><br>" . $_SESSION["listaPersona"];
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