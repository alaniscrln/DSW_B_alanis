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
    <a class="navbar-brand" href="./../index.php">VIDEOCLUB</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>

<div class="container text-center">
    <div class="row mt-4">
        <div class="col-12">
            <h2>INSERTAR</h2>
        </div>
        <hr>
    </div>
    <div class="row mt-4 mb-4">
    <div class="col-4 offset-4">
            <form action="./../controllers/PrincipalController.php" method="POST">
                <input type="hidden" name="tipo" value="insertarCliente">
                <div class="form-group text-left">
                    <label for="dni">DNI</label>
                    <input type="text" class="form-control" id="dni" name="dni">
                </div>

                <div class="form-group text-left">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre">
                </div>
                
                <div class="form-group text-left">
                    <label for="apellidos">Apellidos</label>
                    <input type="text" class="form-control" id="apellidos" name="apellidos">
                </div>

                <div class="form-group text-left">
                    <label for="edad">Edad</label>
                    <input type="text" class="form-control" id="edad" name="edad">
                </div>
                <div class="form-group text-left">
                    <label for="calle">Calle</label>
                    <input type="text" class="form-control" id="calle" name="calle">
                </div>

                <div class="form-group text-left">
                    <label for="numero">Número</label>
                    <input type="text" class="form-control" id="numero" name="numero">
                </div>
            
                <div class="form-group text-left">
                    <label for="cp">Código Postal</label>
                    <input type="text" class="form-control" id="cp" name="cp">
                </div>

                <div class="form-group text-left">
                    <label for="provincia">Provincia</label>
                    <input type="text" class="form-control" id="provincia" name="provincia">
                </div>

                <hr>
                <button type="submit" class="btn btn-primary">INSERTAR</button>
            </form>

        </div>
    </div>
</div>

<!-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>