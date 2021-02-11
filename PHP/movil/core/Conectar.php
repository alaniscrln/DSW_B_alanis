<?php

    class Conectar{
        private $host, $user, $pass, $database;

        public function __construct(){
            $this->host = SERVERNAME;
            $this->user = USER;
            $this->pass = PASS;
            $this->database = DATABASE;
        }

        public function crearConn(){
            $conn = mysqli_connect($this->host,$this->user, $this->pass, $this->database);
            return $conn;
        }
/*
        public function cerrarConn($conn){
            mysqli_close($conn);
        }
*/
    }

?>