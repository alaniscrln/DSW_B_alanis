<?php

    // Crea la coneccion
    $servername = "localhost";
    $database = "agenda";
    $username = "agenda";
    $password = "agenda";
    // Create connection
    $conn = mysqli_connect($servername, $username, $password, $database);
    // Check coneccion
    if (!$conn) {
        die("Se ha producido un error en la conexión: " . mysqli_connect_error());
    }
   
    $nombre =  $_POST['nombre'];

    $apellido =  $_POST['apellido'];
    
    $sql = "INSERT INTO direcciones (nombre, apellido) VALUES ('$nombre', '$apellido')";
if(mysqli_query($conn, $sql)){
    echo "Records inserted successfully.";
} else{
    echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
}
 
// Close connection
mysqli_close($link);
?>
?>