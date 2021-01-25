<?php
    require "./../../lang/lang.php";
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo $lang["titulo"]; ?></title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-light bg-light justify-content-between">
        <a class="navbar-brand" href="./../index.php"><?php echo $lang["logo"]; ?></a>
        <form class="form-inline" method="POST">
            <label class="mr-sm-2" for="inlineFormCustomSelectPref"><?php echo $lang["cambiar_idioma"]; ?></label>
            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="lang">
                <option value="es" selected><?php echo $lang["opcion_1"]; ?></option>
                <option value="en"><?php echo $lang["opcion_2"]; ?></option>
            </select>
            <button type="submit" class="btn btn-primary"><?php echo $lang["cambiar"]; ?></button>
        </form>
    </nav>
    
	<div class="container text-center">
        
        <form action="./../../controllers/Persona/insertar.php" method="POST">
            <br><h1><?php echo $lang["html_insertar"]; ?></h1><br>
            <p><?php echo $lang["dni"]; ?>: <input type="text" name="dni" /></p>
            <p><?php echo $lang["nombre"]; ?>: <input type="text" name="nombre" /></p>
            <p><?php echo $lang["telefono"]; ?>: <input type="text" name="telefono" /></p>
            <p><?php echo $lang["cumpleanos"]; ?>: <input type="text" name="cumpleanos" /></p>
            <input type="submit" value="<?php echo $lang["btn_insertar"]; ?>"/>
        </form>

	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>