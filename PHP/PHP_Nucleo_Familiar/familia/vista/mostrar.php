<?php
require '../modelo/conectar.php';
$consulta = "select * from " . TABLE;
$mostrar = mysqli_query($conn, $consulta);

echo '<h1>Lista de familiares</h1><br>';

while ($row = mysqli_fetch_array($mostrar)) {
    echo "NOMBRE: $row[nombre] <br>EDAD: $row[edad] <br>ROL: $row[rol]<br>\n";
}

echo '<a href="../vista/index.php">Volver al inicio</a><br>';
?>