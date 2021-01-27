<?php

    class Persona extends Contacto{
        use Actividad;
        
        private $cumpleanos;

        function __construct($dni, $nombre, $telefono, $cumpleanos){
            parent::__construct("Persona", $dni, $nombre, $telefono);
            $this->cumpleanos = $cumpleanos;
        }

        public function getCumpleanos(){
            return $this->cumpleanos;
        }

        public function setCumpleanos($cumpleanos){
            $this->cumpleanos = $cumpleanos;
        }

        public function toString(){
            return "<br/>Tipo: " . parent::getTipo() . " DNI: " . parent::getId() . " Nombre: " . parent::getNombre() . " Teléfono: " . parent::getTelefono() . " Cumpleaños: " . $this->getCumpleanos(); 
        }

    }

?>