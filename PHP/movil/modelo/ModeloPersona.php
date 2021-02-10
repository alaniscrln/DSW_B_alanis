<?php
    class ModeloPersona extends ModeloBase{
        private $tabla = "personas";

        public function __construct(){
            parent::__construct($this->tabla);
        }

        public function insertar($id, $nombre, $apellido1, $apellido2, $fecha_nac, $tipo, $id_familia){
            $sql = "INSERT INTO " . $tabla . " VALUES( null, '$id', '$nombre', '$apellido1', '$apellido2', '$fecha_nac', '$tipo', '$id_familia'";
            $resultado = parent::ejecutarSQL($sql);
            return $resultado;
        }

    }

?>