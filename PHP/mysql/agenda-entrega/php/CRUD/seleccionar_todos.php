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
        require 'crear_conexion.php';

        $sql = "SELECT * FROM direcciones" ;            
        $resultado = mysqli_query($conn, $sql); 
                
        if($resultado->num_rows > 1){ 
            while ($row = mysqli_fetch_array($resultado)) {
                echo "$row[dni] -  $row[Nombre] - $row[Apellido]<br>";
            }
        }else{
            echo "Aún no hay nombres en la agenda<br>";
        }
        
        include 'cerrar_conexion.php';    
    ?>
</body>
</html>
<html>
