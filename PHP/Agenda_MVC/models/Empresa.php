<?php

    class Empresa extends Contacto{

        private $web;

        public function __construct(){
            $params = func_get_args();
            $num_params = func_num_args();
            $func_constructor = "__construct" . $num_params;

            if(method_exists($this, $func_constructor)){
                call_user_func_array( array($this, $func_constructor), $params );
            }
        }

        public function __construct0(){
            parent::__construct("Empresa", "empresas");
        }

        function __construct4($cial, $nombre, $telefono, $web){
            parent::__construct("Empresa", $cial, $nombre, $telefono, "empresas");
            $this->web = $web;
        }

        public function getWeb(){
            return $this->web;
        }

        public function setWeb($web){
            $this->web = $web;
        }

        public function toString(){
            return "<br/>Tipo: " . parent::getTipo() . " CIF: " . parent::getId() . " Nombre: " . parent::getNombre() . " Teléfono: " . parent::getTelefono() . " Web: " . $this->getWeb(); 
        }

        public function insert(){
            $sql1 = "INSERT INTO contactos(id, tipo, nombre, telefono) VALUES("
            . "'" . $this->getId() . "',"
            . "'" . $this->getTipo() . "',"
            . "'" . $this->getNombre() . "',"
            . "'" . $this->getTelefono() . "'"
            . ")";

            $sql2 = "INSERT INTO empresas(id, web) VALUES("
            . "'" . $this->getId() . "',"
            . "'" . $this->getWeb() . "'"
            . ")";

            $insert1 = $this->getConn()->query($sql1);
            $insert2 = $this->getConn()->query($sql2);

            return ($insert1 && $insert2);
        }

        public function delete($id){
            if($this->getByID($id) != null){                
                $sql1 = "DELETE FROM contactos WHERE id = '" . $id . "'";
                $sql2 = "DELETE FROM empresas WHERE id = '" . $id . "'";

                $delete2 = $this->getConn()->query($sql2);
                $delete1 = $this->getConn()->query($sql1);
            
                return ($delete1 && $delete2);
            }else{
                return false;
            }
        }

        public function getByID($id){
            $sql = "SELECT c.id, c.nombre, c.telefono, e.web FROM contactos c INNER JOIN empresas e on c.id = e.id WHERE c.id = '" . $id . "'";

            $resultado = mysqli_query($this->getConn(), $sql);
            $resultSet = 0;
            if ($resultado->num_rows > 0) {
                while($row = $resultado->fetch_assoc()) {
                    $resultSet = array("id"=>"$row[id]", "nombre"=>"$row[nombre]", "telefono"=>"$row[telefono]", "web"=>"$row[web]");
                }
            } 

            return $resultSet;
        }
    }

?>