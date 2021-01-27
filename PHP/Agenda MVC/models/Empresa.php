<?php

    class Empresa extends Contacto{
        use Actividad;

        private $web;

        function __construct($cial, $nombre, $telefono, $web){
            parent::__construct("Empresa", $cial, $nombre, $telefono);
            $this->web = $web;
        }

        public function getWeb(){
            return $this->web;
        }

        public function setWeb($web){
            $this->web = $web;
        }

        public function toString(){
            return "<br/>Tipo: " . parent::getTipo() . " CIF: " . parent::getId() . " Nombre: " . parent::getNombre() . " Teléfono: " . parent::getTelefono() . " Web: " . $this->getWeb(); 
        }

    }

?>