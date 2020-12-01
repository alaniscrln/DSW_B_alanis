<?php
    $dbhost = 'localhost'; // Servidor de la BD
    $user = 'root';
    $pass = '';
    $db = 'agenda';

    // Conexión

    $conn = mysqli_connect($dbhost, $user, $pass) 
    or die ('Error connecting to mysql');   // si entra en die, el programa deja de ejecutarse

    mysqli_select_db($conn, $db) or die('No se pudo seleccionar la base de datos');    ;

    if( isset($_REQUEST['btnCrear'])){
        $nombre = $_REQUEST['nombre'];
        $apellido = $_REQUEST['apellido'];
        $sql = "INSERT INTO direcciones (Nombre, Apellido) VALUES ('$nombre', '$apellido')";
        if ($conn->query($sql) === TRUE) {
            echo "Contacto creado con éxito<br>";
          } else {
            echo "Error: " . $sql . "<br>" . $conn->error;
          }
          
          $conn->close();
    }

    if( isset($_REQUEST['btnEliminar'])){
        $nombre = $_REQUEST['nombre'];
        $apellido = $_REQUEST['apellido'];
        $sql = "DELETE FROM direcciones WHERE Nombre ='$nombre' AND Apellido = '$apellido'";
        if ($conn->query($sql) === TRUE) {
            echo "Contacto eliminado con éxito<br>";
          } else {
            echo "Error: " . $sql . "<br>" . $conn->error;
          }
          
          $conn->close();
    }

    if( isset($_REQUEST['btnModificar'])){
        $nombre = $_REQUEST['nombre'];
        $apellido = $_REQUEST['apellido'];
        $nombre_mod = $_REQUEST['nombre_mod'];
        $apellido_mod = $_REQUEST['apellido_mod'];

        $sql = "UPDATE direcciones SET Nombre = '$nombre_mod', Apellido = '$apellido_mod' WHERE Nombre = '$nombre' AND Apellido = '$apellido'";
        if ($conn->query($sql) === TRUE) {
            echo "Contacto modificado con éxito<br>";
          } else {
            echo "Error: " . $sql . "<br>" . $conn->error;
          }
          
          $conn->close();
    }

    if( isset($_REQUEST['btnVer'])){
        
        $sql = "SELECT * FROM direcciones";
        
        $result = $conn->query($sql);

        if ($result->num_rows > 0) {
        while($row = $result->fetch_assoc()) {
            echo "Nombre: " . $row["Nombre"] . " - Apellido: " . $row["Apellido"] . "<br>";
        }
        } else {
        echo "0 results";
        }
        $conn->close();
    }


?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agenda</title>
</head>
<body>

<form action="Agenda.php" method="POST">

    <br>
    Nombre: <input type="text" name="nombre"> Apellido: <input type="text" name="apellido">
    <br><br>
    <input type="submit" value="Crear contacto" name="btnCrear"> <br>
    <input type="submit" value="Eliminar contacto" name="btnEliminar"> <br>
    <input type="submit" value="Ver contactos" name="btnVer"> <br>
    <br>
    Nombre modificado: <input type="text" name="nombre_mod"> Apellido modificado: <input type="text" name="apellido_mod"> 
    <br><input type="submit" value="Modificar contacto" name="btnModificar"> <br>

</form>

    
</body>
</html>