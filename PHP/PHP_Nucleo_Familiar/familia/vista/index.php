<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Núcleo Familiar</title>
</head>

<body>
    <h3>Registrar un familiar</h3><br>
    <form action="../controlador/insertar.php" method="post">
        Nombre: <input type="text" name="nombre"><br>
        Edad: <input type="text" name="edad"><br>
        Rol: <input type="text" name="rol"><br>
        <input type="submit" value="Registrar">
    </form><br>
    <h3>Eliminar un familiar</h3><br>
    <form action="../controlador/eliminar.php" method="post">
        Rol: <input type="text" name="rol"><br>
        <input type="submit" value="Eliminar">
    </form><br>
    <h3>Listar un núcleo familiar</h3><br>
    <form action="./mostrar.php" method="post">
        <input type="submit" value="Visualizar">
    </form><br>
    <h3>Actualizar un familiar</h3><br>
    <form action="../controlador/actualizar.php" method="post">
        Nombre: <input type="text" name="nombre"><br>
        Edad: <input type="text" name="edad"><br>
        Rol: <input type="text" name="rol" placeholder="Requerido"><br>
        <input type="submit" value="Actualizar">
    </form><br>
</body>

</html>