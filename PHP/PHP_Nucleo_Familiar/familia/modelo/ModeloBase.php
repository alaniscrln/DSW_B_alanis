<?php

    class ModeloBase{
        private $conexion;
        private $tabla;

        public function __construct($conexion, $tabla){
            $this->conexion = $conexion;
            $this->tabla = $tabla;
        }

        public function insertar($argumentos, $valores){
            $sql = "INSERT INTO $this->tabla (" . implode(',', $argumentos) . ")" . " VALUES(" . implode(',', $valores) . ")"; 
        }

        public function modificar($array){
            $sql = "UPDATE $this->tabla SET ";

            $cont = 0;
            $lengtharray = count($array);
            foreach($array as $clave => $valor){
                $coma = ($cont != $lengtharray)? ";" : " ";
                $sql += $clave . " = " . $valor . $coma;
            }
            
        }

        public function eliminar(){

        }

        public function listar(){

        }

        public function buscar(){

        }
    }

?>