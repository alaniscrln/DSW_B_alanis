
<?php

    class ModeloBase{
        private $conexion;
        private $tabla;
        private $clave_primaria;

        public function __construct($conexion, $tabla, $clave_primaria){
            $this->conexion = $conexion;
            $this->tabla = $tabla;
            $this->clave_primaria = $clave_primaria;
        }

        public function insertar($argumentos, $valores){
            $sql = "INSERT INTO $this->tabla (" . implode(',', $argumentos) . ")" . " VALUES(" . implode(',', $valores) . ")"; 
        }

        public function modificar($array, $id){
            $sql = "UPDATE $this->tabla SET ";

            $cont = 0;
            $lengtharray = count($array);
            foreach($array as $clave => $valor){
                $coma = ($cont < $lengtharray)? ";" : " ";
                $sql .= $clave . " = " . "'$valor'" . $coma;
                $cont++;
            }

            $sql .= "WHERE $this->clave_primaria = '$id'";
        }

        public function eliminar($id){
            $sql = "DELETE FROM  $this->tabla WHERE $this->clave_primaria = '$id'";
        }

        public function listar($array, $operador){

            $sql = "SELECT * FROM $this->tabla WHERE ";

            $cont = 0;
            $lengtharray = count($array);
            foreach($array as $clave => $valor){
                $concatenar = ($cont < $lengtharray)? $operador : " ";
                $sql .= $clave . " = " . "'$valor'" . $concatenar;
                $cont++;
            }

        }

        public function buscar($id){
            $sql = "SELECT * FROM  $this->tabla WHERE $this->clave_primaria = '$id'";
        }
    }

