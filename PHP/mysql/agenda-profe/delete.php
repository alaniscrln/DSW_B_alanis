<html>

<head>
    <title>Consulta a BD (Agenda)</title>
</head>

<body>
    <h1> Eliminación de la BD (Agenda) </h1>
    <?php

    /*
    1) No repetir cófigo (Saul)
    2) Comentarios en un idioma (Cristo)
    3) Mostrar información de las respuesta (Cristo)
    4) Consulta simple, consulta y crear en un unico fichero
    5) Validación formularios (Manuel)
    6) Verificar la conexión de BBDD (Cristo)
    7) Verificar si existe un elemento en la BBDD antes de insertar
    8) La Tabla direcciones no puede tener el campo nombre como clave primaria
    */

    include 'crear_coneccion.php';

    if (isset($_REQUEST['nombre'])) {
        $nombre = $_REQUEST['nombre'];
        
        $sql = "DELETE FROM direcciones where nombre = '$nombre'";
            
        if(mysqli_query($conn, $sql)){
            echo "Registro eliminado con éxito.";
        } else{
            echo "ERROR: No se pudo eliminar registro $sql. " . mysqli_error($link);
        }
    
        mysqli_close($conn);
    }

    ?>

    <form action="delete.php" method="POST">
        <p>Su nombre: <input type="text" name="nombre" /></p>
        <p><input type="submit" /></p>
    </form>

</body>

</html>