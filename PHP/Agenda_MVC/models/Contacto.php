<?php
    
    abstract class Contacto extends EntidadBase{

        private $tipo;
        private $id;
        private $nombre;
        private $telefono;
        private $actividades = array();

        public function __construct(){
            $params = func_get_args();
            $num_params = func_num_args();
            $func_constructor = "__construct" . $num_params;

            if(method_exists($this, $func_constructor)){
                call_user_func_array( array($this, $func_constructor), $params );
            }
        }

        public function __construct2($tipo, $tabla){
            parent::__construct($tabla);
            $this->tipo = $tipo;            
        }

        function __construct5($tipo, $id, $nombre, $telefono, $tabla){
            parent::__construct($tabla);
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

        public function getActividades(){
            return $this->actividades;
        }

        public function setActividades($actividad){
            array_push($this->actividades, $actividad);
        }

        abstract protected function toString();

    }

?>