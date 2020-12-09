<?php
    require 'credenciales.php';

    $conn = mysqli_connect(SERVERNAME,USER, PASS, DATABASE);
    // Chequea conexión
    if (!$conn) {
        die("Se ha producido un error realizando la conexión con la BBDD: "
        . mysqli_connect_error());
    } else {
       // echo "Conectado con la base de datos '" .  DATABASE . "' correctamente.<br>";
    }
?>