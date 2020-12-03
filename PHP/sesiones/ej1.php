<?php
// Comienzo de la sesión
session_start();
// Guardar datos de sesión
$_SESSION["usuario"] = "Alanis";

echo "Sesión iniciada y establecido nombre de usuario!" . "<br>";
?>
<a href="segundo.php">Segundo!</a>

