<html>

    <head>
    </head>

    <body>
        <?php

            $ciudad[] = "San cristobal";
            $ciudad[] = "Cucuta";
            $ciudad[] = "Maracaibo";
            $ciudad[] = "Caracas";
            $n = count($ciudad);

            echo "numero de elementos " . $n;
            for($i = 0; $i < $n; $i++){
                echo "<br> Ciudad $i <h1> $ciudad[$i] </h1>";
            }

        ?>

    </body>

</html>