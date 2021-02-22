
<?php

    class ModeloIntegrantes extends ModeloBase{
        private $tabla= "integrantes";
        private $clave_primaria = "dni";

        public function __construct(){
            parent::__construct($tabla, $clave_primaria);
        }
    }

?>