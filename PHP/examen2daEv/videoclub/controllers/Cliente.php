<?php

    class Cliente extends ModeloCliente{

        private $dni;
        private $nombre;
        private $apellidos;
        private $edad;
        private $direccion;

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

        public function __construct5($dni, $nombre, $apellidos, $edad, $direccion){
            parent::__construct();
            $this->dni = $dni;
            $this->nombre = $nombre;
            $this->apellidos = $apellidos;
            $this->edad = $edad;
            $this->direccion = $direccion;
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