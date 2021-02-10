<?php

    class Persona extends Contacto{
        
        private $cumpleanos;

        public function __construct(){
            $params = func_get_args();
            $num_params = func_num_args();
            $func_constructor = "__construct" . $num_params;

            if(method_exists($this, $func_constructor)){
                call_user_func_array( array($this, $func_constructor), $params );
            }
        }

        public function __construct0(){
            parent::__construct("Persona", "personas");
        }

        function __construct4($dni, $nombre, $telefono, $cumpleanos){
            parent::__construct("Persona", $dni, $nombre, $telefono, "personas");
            $this->cumpleanos = $cumpleanos;
        }

        public function getCumpleanos(){
            return $this->cumpleanos;
        }

        public function setCumpleanos($cumpleanos){
            $this->cumpleanos = $cumpleanos;
        }

        public function toString(){
            return "<br/>Tipo: " . parent::getTipo() . " DNI: " . parent::getId() . " Nombre: " . parent::getNombre() . " Teléfono: " . parent::getTelefono() . " Cumpleaños: " . $this->getCumpleanos(); 
        }

        public function insert(){
            $sql1 = "INSERT INTO contactos(id, tipo, nombre, telefono) VALUES("
            . "'" . $this->getId() . "',"
            . "'" . $this->getTipo() . "',"
            . "'" . $this->getNombre() . "',"
            . "'" . $this->getTelefono() . "'"
            . ")";

            $sql2 = "INSERT INTO personas(id, cumpleanos) VALUES("
            . "'" . $this->getId() . "',"
            . "'" . $this->getCumpleanos() . "'"
            . ")";

            $insert1 = $this->getConn()->query($sql1);
            $insert2 = $this->getConn()->query($sql2);

            return ($insert1 && $insert2);
        }

        public function delete($id){
            $sql2 = $this->getConn()->query("DELETE FROM personas WHERE id = '" . $id . "'");
            $sql1 = $this->getConn()->query("DELETE FROM contactos WHERE id = '" . $id . "'");

            return ($sql1 && $sql2);
        }
        
        public function getByID($id){
            $sql = "SELECT c.id, c.nombre, c.telefono, p.cumpleanos FROM contactos c INNER JOIN personas p on c.id = p.id WHERE c.id = '" . $id . "'";

            $resultSet = 0;
            $resultado = mysqli_query($this->getConn(), $sql);
            if ($resultado->num_rows > 0) {
                while($row = $resultado->fetch_assoc()) {
                    $resultSet = array("id"=>"$row[id]", "nombre"=>"$row[nombre]", "telefono"=>"$row[telefono]", "cumpleanos"=>"$row[cumpleanos]");
                }
            } 

            return $resultSet;
        }

    }

?>