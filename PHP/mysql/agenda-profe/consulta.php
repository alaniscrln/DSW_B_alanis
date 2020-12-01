<html>

<head>
    <title>Consulta a BD (Agenda)</title>
</head>

<body>
    <h1>Mostrar Nombres de la Agenda. BD </h1>
    <?php
        $servername = "localhost";
        $database = "agenda";
        $username = "agenda";
        $password = "agenda";
        // Create connection
        $conn = mysqli_connect($servername, $username, $password, $database);

        $sql = "SELECT * FROM direcciones" ;
        
        
        $resultado = mysqli_query($conn, $sql); 
        $extraido= mysqli_fetch_array($result);
                
        while ($row = mysqli_fetch_array($resultado)) {
        echo "$row[Nombre] $row[Apellido]<br>\n";
        }
        
        mysqli_close($conn);
    
    ?>
</body>

</html>