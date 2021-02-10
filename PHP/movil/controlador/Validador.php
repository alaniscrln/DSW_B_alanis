<?php
    trait Validador{

        public function soloNumeros($texto){
            return is_numeric($texto);
        }

        public function validarFecha($fecha){
            if (preg_match("/^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/",$fecha)) {
                return true;
            } else {
                return false;
            }
        }

        public function validarDni($dni){
            $letra = substr($dni, -1);
            $numeros = substr($dni, 0, -1);
            if(is_numeric($numeros) && strlen($numeros) == 8){
                if (substr("TRWAGMYFPDXBNJZSQVHLCKE", $numeros%23, 1) == $letra && strlen($letra) == 1 && strlen ($numeros) == 8 )
                    return true;
                return false;                            
            }

            return false;            
        }

    }
?>