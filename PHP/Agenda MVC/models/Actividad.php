<?php

    trait Actividad{

        private $hora;
        private $lugar;
        private $actividad;

        public function setActividad($hora, $lugar, $actividad){
            $this->hora = $hora;
            $this->lugar = $lugar;
            $this->actividad = $actividad;
        }

        public function getActividad(){
            return "hora: " . $this->hora . " lugar: " . $this->lugar . " actividad: " . $this->actividad . " con " . parent::getNombre();
        }
        
    }

?>