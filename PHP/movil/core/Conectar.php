<?php

    class Conectar{
        private $host, $user, $pass, $database;
        private $conn;

        public function __construct(){
            $this->host = SERVERNAME;
            $this->user = USER;
            $this->pass = PASS;
            $this->database = DATABASE;
        }

        public function crearConn(){
            $this->conn = mysqli_connect($this->host,$this->user, $this->pass, $this->database);
            return $this->conn;
        }

        public function cerrarConn(){
            mysqli_close($this->conn);
        }

    }

?>