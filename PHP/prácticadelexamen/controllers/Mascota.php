<?php

    class Mascota extends ModeloMascota{

        private $raza;
        private $fecha_nacimiento;
        private $id_propietario;

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

        public function __construct3($nombre, $fecha_nacimiento, $id_propietario){
            parent::__construct();
            $this->nombre = $nombre;
            $this->fecha_nacimiento = $fecha_nacimiento;
            $this->id_propietario = $id_propietario;
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