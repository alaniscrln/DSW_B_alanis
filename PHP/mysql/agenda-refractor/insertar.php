<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insertar datos BD (Agenda)</title>
</head>
<body>
    <form action="#" method="POST">
        <h1>Insertar datos BD (Agenda)</h1><br>
        <p>DNI: <input type="text" name="dni" /></p>
        <p>Nombre: <input type="text" name="nombre" /></p>
        <p>Apellido: <input type="text" name="apellido" /></p>
        <p><input type="submit" /></p>
    </form>

    <?php
        if (isset($_REQUEST['dni']) && isset($_REQUEST['nombre']) && isset($_REQUEST['apellido'])) {

            //comprobar tipo de dato



            require 'crear_conexion.php';
            $dni =  $_POST['dni'];
            $nombre =  $_POST['nombre'];
            $apellido =  $_POST['apellido'];
            
            $sql = "INSERT INTO direcciones (dni, nombre, apellido) VALUES ('$dni', '$nombre', '$apellido')";

            if(mysqli_query($conn, $sql)){
                echo "Datos insertados correctamente.<br>";
            } else{
                echo "ERROR: No se pudo ejecutar la sentencia '$sql'. " . mysqli_error($conn) . "<br>";
            }
            include 'cerrar_conexion.php';
        }
    ?>
</body>
</html>