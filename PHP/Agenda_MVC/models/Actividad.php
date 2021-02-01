<?php

    class Actividad extends EntidadBase{
        
        private $id;
        private $idContacto;
        private $hora;
        private $fecha;
        private $lugar;
        private $actividad;

        public function __construct(){
            $params = func_get_args();
            $num_params = func_num_args();
            $func_constructor = "__construct" . $num_params;

            if(method_exists($this, $func_constructor)){
                call_user_func_array( array($this, $func_constructor), $params );
            }
        }

        public function __construct0(){
            parent::__construct("actividades");
        }

        public function __construct6($id, $idContacto, $hora, $fecha, $lugar, $actividad){
            parent::__construct("actividades");
            $this->id = $id;
            $this->idContacto = $idContacto;
            $this->hora = $hora;
            $this->fecha = $fecha;
            $this->lugar = $lugar;
            $this->actividad = $actividad;
        }

        public function getId(){
            return $this->id;
        }

        public function setId($id){
            $this->id = $id;
        }        

        public function getIdContacto(){
            return $this->idContacto;
        }

        public function setIdContacto($idContacto){
            $this->idContacto = $idContacto;
        }

        public function getHora(){
            return $this->hora;
        }

        public function setHora($hora){
            $this->hora = $hora;
        }        

        public function getFecha(){
            return $this->fecha;
        }

        public function setFecha($fecha){
            $this->fecha = $fecha;
        } 

        public function getLugar(){
            return $this->lugar;
        }

        public function setLugar($lugar){
            $this->lugar = $lugar;
        }       
        
        public function getActividad(){
            return $this->actividad;
        }

        public function setActividad($actividad){
            $this->actividad = $actividad;
        }        

        public function insert(){
            $sql = "INSERT INTO actividades(id, idContacto, hora, fecha, lugar, actividad) VALUES("
            . "'" . $this->getId() . "',"      
            . "'" . $this->getIdContacto() . "',"      
            . "'" . $this->getHora() . "',"
            . "'" . $this->getFecha() . "',"
            . "'" . $this->getLugar() . "',"
            . "'" . $this->getActividad() . "'"
            . ")";

            $insert = $this->getConn()->query($sql);

            return $insert;
        }

        public function delete($id){
            if($this->getByID($id) != null)               
                return $this->getConn()->query("DELETE FROM actividades WHERE id = '" . $id . "'");
            else
                return false;
        }

        public function getByID($id){
            $sql = "SELECT * FROM actividades WHERE id = '" . $id . "'";

            $resultSet=false;
            $resultado = mysqli_query($this->getConn(), $sql);
            if ($resultado->num_rows > 0) {
                while($row = $resultado->fetch_assoc()) {
                    $resultSet = array("id"=>"$row[id]", "idContacto"=>"$row[idContacto]", "hora"=>"$row[hora]", "fecha"=>"$row[fecha]", "lugar"=>"$row[lugar]", "actividad"=>"$row[actividad]");
                }
            } 

            return $resultSet;
        }

        public function toString(){
            return "id: " . $this->getId() . " idContacto: " . $this->getIdContacto() . " hora: " . $this->getHora() . " lugar: " . $this->getLugar() . " actividad: "  . $this->getActividad();
        }

    }

?>