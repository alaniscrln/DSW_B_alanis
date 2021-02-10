<?php

    class ModeloBase{
        private $conn;
        private $conectar;
        private $tabla;

        public function __construct($tabla){
            require_once "Conectar.php";
            $this->conectar = new Conectar();
            $this->conn = $this->conectar->crearConn();
            $this->tabla = $tabla;
        }

        public function getConectar(){
            return $this->conectar;
        }

        public function getConn(){
            return $this->conn;
        }

        public function ejecutarSQL($sql){
            $resultado = $this->getConn()->query($sql); 
            $this->getConectar()->cerrarConn();
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
            
            $this->getConectar()->cerrarConn();
            return $resultSet;
        }


        public function actualizar($id, $dato, $valor){
            $sql = "UPDATE " . $this->tabla . " SET $dato = '$valor' WHERE id = '$id'";
            $resultado = $this->ejecutarSQL($sql);
            return $resultado;
        }

        public function eliminar($id){
            $sql = "DELETE FROM " . $this->tabla . " WHERE id = '$id'";
            $resultado = $this->ejecutarSQL($sql);
            return $resultado;
        }

        public function buscar($id){
            $sql = "SELECT * FROM " . $this->tabla . " WHERE id ='$id'";
            $resultado = $this->ejecutarSQL($sql);
            return $resultado;
        }

    }

?>