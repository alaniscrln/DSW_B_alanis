<?php
require '../modelo/conectar.php';

if(isset($_REQUEST['nombre']) && isset($_REQUEST['edad']) && isset($_REQUEST['rol'])){
    $nombre=$_REQUEST['nombre'];
    $edad=$_REQUEST['edad'];
    $rol=$_REQUEST['rol'];

    if($edad<18){
        echo 'No se puede insertar un usuario menor de 18 años<br>';
        echo '<a href="../vista/index.php">Volver al índice</a><br>';
    }else{
        $insertar="insert into ".TABLE."(nombre,edad,rol)
        values('$nombre','$edad','$rol')";
   
       if($conn->query($insertar)===true){
           echo 'Usuario añadido<br>';
           echo '<a href="../vista/index.php">Volver al formulario</a><br>';
       }else{
           echo "<br>Error al introducir usuario: ". $conn->error;
       }
    }
}
mysqli_close($conn);
?>
