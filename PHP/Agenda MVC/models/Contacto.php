<?php
    
    abstract class Contacto{
        private $tipo;
        private $id;
        private $nombre;
        private $telefono;

        function __construct($tipo, $id, $nombre, $telefono){
            $this->tipo = $tipo;
            $this->id = $id;
            $this->nombre = $nombre;
            $this->telefono = $telefono;
        }

        public function getTipo(){
            return $this->tipo;
        }

        public function getId(){
            return $this->id;
        }

        public function getNombre(){
            return $this->nombre;
        }
        
        public function getTelefono(){
            return $this->telefono;
        }

        abstract protected function toString();

    }

?>