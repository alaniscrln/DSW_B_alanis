<?php
    trait ValidadorCP{

        public function soloNumeros($texto){
            return is_numeric($texto);
        }

    }

?>