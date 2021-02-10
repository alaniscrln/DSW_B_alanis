<?php
    if (isset($_REQUEST['dni'])) {
        require 'crear_conexion.php';
        $dni = $_REQUEST['dni'];

        $sql = "SELECT * FROM direcciones where dni = '$dni'";
        $resultado = mysqli_query($conn, $sql);

        if ($resultado->num_rows > 0) {
            echo "<br>Datos solicitados:";
            while($row = $resultado->fetch_assoc()) {
                echo "<br>$row[dni] - $row[Nombre] - $row[Apellido]<br>";
            }
        } else {
            echo "No existen los datos solicitados.<br>";
        }
    
        include 'cerrar_conexion.php';
    }
?>