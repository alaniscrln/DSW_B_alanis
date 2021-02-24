<?php

    class ClaseEjemplo extends ModeloEjemplo{

        private $id;
        private $nombre;
        private $fecha_nacimiento;

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

        public function __construct3($id, $nombre, $fecha_nacimiento){
            parent::__construct();
            $this->id = $id;
            $this->nombre = $nombre;
            $this->fecha_nacimiento = $fecha_nacimiento;
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
 
    }

?>