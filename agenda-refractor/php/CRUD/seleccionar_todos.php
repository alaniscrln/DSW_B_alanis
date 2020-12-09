<?php
    require './../crear_conexion.php';

    $sql = "SELECT * FROM direcciones" ;            
    $resultado = mysqli_query($conn, $sql); 
            
    if($resultado->num_rows > 0){ 
        while ($row = mysqli_fetch_array($resultado)) {
            echo "$row[dni] -  $row[Nombre] $row[Apellidos]<br>";
        }
    }else{
        echo "Aún no hay nombres en la agenda<br>";
    }
    
    include './../cerrar_conexion.php';    
?>