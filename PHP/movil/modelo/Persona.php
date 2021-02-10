<?php

    class Persona extends EntidadBase{

        private $id;
        private $nombre;
        private $apellido1;
        private $apellido2;
        private $fecha_nacimiento;
        private $tipo;
        private $id_familia;
        private $moviles = array();

        public function __construct(){
            $params = func_get_args();
            $num_params = func_num_args();
            $func_constructor = "__construct" . $num_params;

            if(method_exists($this, $func_constructor)){
                call_user_func_array( array($this, $func_constructor), $params );
            }
        }

        public function __construct0(){
            parent::__construct();
        }

        public function __construct7($id, $nombre, $apellido1, $apellido2, $fecha_nacimiento, $tipo, $id_familia){
            parent::__construct();
            $this->id = $id;
            $this->nombre = $nombre;
            $this->apellido1 = $apellido1;
            $this->apellido2 = $apellido2;
            $this->fecha_nacimiento = $fecha_nacimiento;
            $this->tipo = $tipo;
            $this->id_familia = $id_familia;
        }
 
        public function __get($atributo) {
            if (property_exists($this, $atributo)) {
                return $this->$atributo;
            }
        }
    
        public function __set($atributo, $valor) {
            if (property_exists($this, $atributo)) {
                $this->$atributo = $valor;
            }
        }

        public function guardarMovil($movil){
            array_push($this->moviles, $movil);
        }
 
    }

?>