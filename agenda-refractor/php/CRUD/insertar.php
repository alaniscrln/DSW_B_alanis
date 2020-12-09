<?php
    if (isset($_REQUEST['dni']) && isset($_REQUEST['nombre']) && isset($_REQUEST['apellido'])) {

        //comprobar tipo de dato



        require './../crear_conexion.php';
        $dni =  $_POST['dni'];
        $nombre =  $_POST['nombre'];
        $apellido =  $_POST['apellido'];
        
        $sql = "INSERT INTO direcciones (dni, nombre, apellidos) VALUES ('$dni', '$nombre', '$apellido')";

        if(mysqli_query($conn, $sql)){
            echo "Datos insertados correctamente.<br>";
        } else{
            echo "ERROR: No se pudo ejecutar la sentencia '$sql'. " . mysqli_error($conn) . "<br>";
        }
        include './../cerrar_conexion.php';
    }
?>