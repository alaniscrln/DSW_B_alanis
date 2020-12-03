<?php
    $servername = "localhost";
    $database = "agenda";
    $username = "agenda";
    $password = "agenda";

    // Crea Conección
    $conn = mysqli_connect($servername, $username, $password, $database);
    // Chequea conección
    if (!$conn) {
        die("Se ha producido un error realizando la conexión con la BBDD: "
        . mysqli_connect_error());
    }

?>