<?php
    class ModeloMovil extends ModeloBase{
        private $tabla = "moviles";

        public function __construct(){
            parent::__construct();
        }

        public function insertar($marca, $modelo, $fecha_compra, $propietario){
            $sql = "INSERT INTO " . $tabla . " VALUES( null, '$marca', '$modelo', '$fecha_compra', '$propietario'";
            $resultado = parent::ejecutarSQL($sql);
            return $resultado;
        }

    }

?>