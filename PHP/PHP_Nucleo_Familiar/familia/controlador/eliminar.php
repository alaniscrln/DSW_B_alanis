<?php
require '../modelo/conectar.php';

if(isset($_REQUEST['rol'])){
    $rol=$_REQUEST['rol'];

    $eliminar="delete from ".TABLE." where rol like '$rol'";
   
       if($conn->query($eliminar)===true){
           echo 'Rol eliminado<br>';
           echo '<a href="../vista/index.php">Volver al formulario</a><br>';
       }else{
           echo "<br>Error al eliminar rol: ". $conn->error;
       }
    }
mysqli_close($conn);
?>