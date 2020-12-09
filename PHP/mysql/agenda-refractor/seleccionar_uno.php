<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consulta a BD (Agenda)</title>
</head>

<body>
    <h1> Consulta a BD (Agenda) </h1>
    <?php
        if (isset($_REQUEST['dni'])) {
            require 'crear_conexion.php';
            $dni = $_REQUEST['dni'];

            $sql = "SELECT * FROM direcciones where dni = '$dni'";
            $resultado = mysqli_query($conn, $sql);
    
            if ($resultado->num_rows > 0) {
                echo "<br>Datos solicitados:";
                while($row = $resultado->fetch_assoc()) {
                    echo "<br>$row[dni] - $row[Nombre] - $row[Apellidos]<br>";
                }
            } else {
                echo "No existen los datos solicitados.<br>";
            }
        
            include 'cerrar_conexion.php';
        }
    ?>

    <form action="#" method="POST">
        <p>DNI: <input type="text" name="dni" /></p>
        <p><input type="submit" /></p>
    </form>

</body>
</html>
<html>
