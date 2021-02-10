<html>

<head>
    <title>Consulta a BD (Agenda)</title>
</head>

<body>
    <h1> Consulta a BD (Agenda) </h1>
    <?php
    if (isset($_REQUEST['nombre'])) {
        $servername = "localhost";
        $database = "agenda";
        $username = "agenda";
        $password = "agenda";
        $nombre = $_REQUEST['nombre'];
        // Create connection
        $conn = mysqli_connect($servername, $username, $password, $database);
    
        $sql = "SELECT * FROM direcciones where nombre = '$nombre'";
    
    
        $resultado = mysqli_query($conn, $sql);
    
        while ($row = mysqli_fetch_array($resultado)) {
            echo "$row[Nombre] $row[Apellido]<br>\n";
        }
    
        mysqli_close($conn);
    }

    ?>

    <form action="consulta_simple.php" method="POST">
        <p>Su nombre: <input type="text" name="nombre" /></p>
        <p><input type="submit" /></p>
    </form>

</body>

</html>