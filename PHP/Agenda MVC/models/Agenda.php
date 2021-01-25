<?php

    class Agenda{

        private $contactos;

        function __construct(){
            $this->contactos = new ArrayObject();
        }

        public function getContactos(){
            return $this->contactos;
        }

        public function setContactos($contactos){
            $this->contactos = $contactos;
        }

        public function agregarContacto($contacto){
            if( $this->existeContacto( $contacto->getId() ) ){
                return false;
            }else{
                $this->getContactos()->append($contacto);
                return true;
            }
        }

        public function eliminarContacto($id){
            foreach($this->getContactos() as $i => $contacto){
                if($contacto->getId() == $id){
                    unset($this->getContactos()[$i]);
                    //$this->setContactos( array_values( $this->contactos ) );
                    return true;
                }
            }
            return false;
        }

        public function existeContacto($id){
            if($this->getContactos() == null){
                return false;
            }
            foreach($this->getContactos() as $contacto){
                if($contacto->getId() == $id){
                    return true;
                }
            }
            return false;
        }

        public function buscaContacto($id){
            foreach($this->getContactos() as $i => $contacto){
                if($contacto->getId() == $id){
                    return $i;
                }
            }
            return false;
        }

        public function listarContactos(){
            foreach($this->getContactos() as $i => $contacto){
                echo $contacto->toString();
            }
        }

    }

?>