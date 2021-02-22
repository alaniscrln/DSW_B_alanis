<?php
    class ModeloFamilia extends ModeloBase{
        private $tabla = "familias";

        public function __construct(){
            parent::__construct($this->tabla);
        }

        public function insertar(){
            $sql = "INSERT INTO $this->tabla VALUES ('null')";
            $resultado = parent::ejecutarSQL($sql);
            return $resultado;
        }

        public function getIDUltimo(){
            $sql = "SELECT id FROM $this->tabla ORDER BY id DESC LIMIT 1";
            $resultado = parent::ejecutarSQL($sql);
            $row = mysqli_fetch_array($resultado);
            return $row["id"];
        }

    }

?>