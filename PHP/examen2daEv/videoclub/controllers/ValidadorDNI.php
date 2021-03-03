<?php
    trait ValidadorDNI{

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