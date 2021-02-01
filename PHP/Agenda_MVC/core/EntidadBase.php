<?php

    class EntidadBase{
        private $tabla;
        private $conn;
        private $conectar;

        public function __construct($tabla){
            $this->tabla = (string) $tabla;
            require_once "Conectar.php";
            $this->conectar = new Conectar();
            $this->conn = $this->conectar->iniciarConexion();
        }

        public function getConectar(){
            return $this->conectar;
        }

        public function getConn(){
            return $this->conn;
        }

        public function getTabla(){
            return $this->tabla;
        }

        public function update($id, $tabla, $columna, $valor){
            $sql = $this->getConn()->query("UPDATE " . $tabla . " SET " . $columna . " = '" . $valor . "' WHERE id = '" . $id . "'");
            return $sql;
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

            return $resultSet;
        }

    }

?>