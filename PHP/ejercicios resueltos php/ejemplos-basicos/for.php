<html>

    <head>
    </head>

    <body>
        <?php

            echo "<h1> Bienvenidos a mi pagina web</h1>";
            echo "<table align='center' border= '1'>";
            for($i=0; $i < 10; $i++){
                echo "<tr><td>mi correo es eduestudia@yahoo.com </td></tr>";
            }
            echo "</table>";

        ?>

        <h1>SEGUNDA TABLA EN PHP</h1>
        <table align="center" border = "1">
        <?php 
            for($i=0; $i < 10; $i++){
                echo "<tr><td>mi correo es eduestudia@yahoo.com </td></tr>";
            }
        ?>
        </table>


    </body>

</html>