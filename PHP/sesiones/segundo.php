<?php
// Continuamos la sesión
session_start();
// Devolver los valores de sesión
echo "Nombre de usuario: " . $_SESSION["usuario"];
?>
