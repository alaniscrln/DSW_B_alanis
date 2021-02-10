<?php

    class Movil extends EntidadBase{

        private $marca;
        private $modelo;
        private $fecha_compra;
        private $propietario;

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

        public function __construct4($marca, $modelo, $fecha_compra, $propietario){
            parent::__construct();
            $this->marca = $marca;
            $this->modelo = $modelo;
            $this->fecha_compra = $fecha_compra;
            $this->propietario = $propietario;
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