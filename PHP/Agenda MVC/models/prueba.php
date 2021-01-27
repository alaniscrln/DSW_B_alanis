<?php
    require "./Contacto.php";
    require "./Actividad.php";
    require "./Persona.php";

    $p1 = new Persona("12345678k", "cristina", "98765432", "08/01");
    $p2 = new Persona("65431235g", "eduardo", "76543212", "08/09");

    $p1->setActividad("12:55", "estacion", "coger la guagua");
    echo $p1->getActividad();

    echo "<br>";

    $p2->setActividad("20:15", "casa", "ver pelis");
    echo $p2->getActividad();

    echo "<br>";

    echo $p1->getActividad();

?>