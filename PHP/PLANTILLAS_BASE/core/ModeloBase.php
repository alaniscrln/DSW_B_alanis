<?php

    class ModeloBase{
        private $conn;
        private $conectar;
        private $tabla;
        private $clavePrimaria;

        public function __construct($tabla,$clavePrimaria){
            require_once "./../models/Conexion.php";
            $this->conectar = new Conexion();
            $this->conn = $this->conectar->crearConn();
            $this->tabla = $tabla;
            $this->clavePrimaria = $clavePrimaria;
        }

        public function getConn(){
            return $this->conn;
        }

        public function ejecutarSQL($sql){
            $resultado = $this->getConn()->query($sql); 
            return $resultado;
        }

        public function getAll(){
            $resultado = mysqli_query($this->getConn(), "SELECT * FROM $this->tabla");

            if($resultado->num_rows > 0){ 
                while ($row = mysqli_fetch_array($resultado)) {
                    $resultSet[] = $row;
                }
            }else{
                $resultSet = 0;
            }
            
            return $resultSet;
        }

        public function actualizar($id, $dato, $valor){
            $sql = "UPDATE " . $this->tabla . " SET $dato = '$valor' WHERE $clavePrimaria = '$id'";
            $resultado = $this->ejecutarSQL($sql);
            return $resultado;
        }

        public function eliminar($id){
            $sql = "DELETE FROM " . $this->tabla . " WHERE $clavePrimaria = '$id'";
            $resultado = $this->ejecutarSQL($sql);
            return $resultado;
        }

        public function buscar($id){
            $sql = "SELECT * FROM " . $this->tabla . " WHERE $clavePrimaria ='$id'";
            $resultado = $this->ejecutarSQL($sql);
            return $resultado;
        }

    }

?>