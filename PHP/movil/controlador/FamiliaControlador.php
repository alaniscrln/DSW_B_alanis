<?php
    
    class FamiliaControlador{

        private $familia;

        public function __construct(){
            $this->familia = new Familia();
        }

        public function crearFamilia(){
            $this->familia->insertar();
        }
        public function getIDFamilia(){
            return $this->familia->getIDUltimo();
        }

        public function buscarFamilia($id){
            return $this->familia->buscar($id);
        }

        public function eliminarFamilia($id){
            return $this->familia->eliminar($id);
        }
    }
?>