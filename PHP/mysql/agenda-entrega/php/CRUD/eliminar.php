<?php
    if (isset($_REQUEST['dni'])) {
        require 'crear_conexion.php';
        $dni = $_REQUEST['dni'];
        
        $sql = "DELETE FROM direcciones where dni = '$dni'";
            
        if(mysqli_query($conn, $sql)){
            echo "Registro eliminado con éxito.<br>";
        } else{
            echo "ERROR: No se pudo eliminar registro $sql. " . mysqli_error($conn);
        }
        
        include 'cerrar_conexion';
    }
?>