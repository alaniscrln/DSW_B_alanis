<?php

    class EntidadBase{
        private $conn;
        private $conectar;

        public function __construct(){
            require_once "Conectar.php";
            $this->conectar = new Conectar();
            $this->conn = $this->conectar->crearConn();
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

        public function getAll($sql){
            $resultado = mysqli_query($this->getConn(), $sql);

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

    }

?>