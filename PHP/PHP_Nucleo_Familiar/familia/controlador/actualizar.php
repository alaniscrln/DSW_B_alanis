<?php
require '../modelo/conectar.php';

if(isset($_REQUEST['rol']) && isset($_REQUEST['nombre']) ||
    isset($_REQUEST['rol']) && isset($_REQUEST['edad'])){

    $rol=$_REQUEST['rol'];
    $nombre=$_REQUEST['nombre'];
    $edad=$_REQUEST['edad'];

    $actualizar="update ".TABLE." set nombre='$nombre', edad='$edad' where rol like '$rol'";

    if($conn->query($actualizar)===true){
        echo 'Familia actualizada<br>';
        echo '<a href="../vista/index.php">Volver al formulario</a><br>';
    }else{
        echo "<br>Error al actualizar: ". $conn->error;
    }
}
mysqli_close($conn);
?>