<?php
    trait Validador{

        public function personaValida($persona){
            if( $this->validarDni( $persona->__get("dni") ) ){
                return true;
            }else{
                return false;
            }
        }


        public function mascotaValida($mascota){
            if( $this->validarFecha($mascota->__get("fecha_nacimiento")) 
            && $this->validarDni($mascota->__get("id_propietario")) ){
                return true;
            }else{
                return false;
            }

        }

        public function soloNumeros($texto){
            return is_numeric($texto);
        }

        public function validarHora($hora){
            $pattern = "/^([0-1][0-9]|[2][0-3])[\:]([0-5][0-9])$/";
            if(preg_match($pattern,$hora))
                return true;
            return false;
        }
    
        public function validarFecha($fecha){
            $pattern = "/^([0][1-9]|[1-2][0-9]|[3][0-1])[\/]([0][1-9]|[1][0-2])$/";
            if(preg_match($pattern,$fecha))
                return true;
            return false;
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

        public function validarCial($cial){
            $pattern = "/^[a-zA-Z0-9]+$/";
            if(preg_match($pattern,$cial))
                return true;
            return false;
        }

    }

?>