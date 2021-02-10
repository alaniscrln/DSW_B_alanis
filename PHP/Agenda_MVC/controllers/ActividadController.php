<?php

    class ActividadController{
        use Validador;

        public function __construct(){

        }

        public function insert(){
            if(isset( $_POST["id"]) && isset( $_POST["idContacto"]) && isset( $_POST["hora"]) && isset( $_POST["fecha"]) && isset( $_POST["lugar"] ) && isset( $_POST["actividad"] ) ){
                $id =  $_POST["id"];
                $idContacto = $_POST["idContacto"];
                $hora = $_POST["hora"];
                $fecha = $_POST["fecha"];
                $lugar = $_POST["lugar"];
                $actividad = $_POST["actividad"];

                if($this->validarDni($idContacto) || $this->validarCial($idContacto)) $idContactoValido = true;
                else $idContactoValido = false;


                if( $idContactoValido && $this->validarHora($hora) && $this->validarFecha($fecha) ){

                    $actividad = new Actividad($id, $idContacto, $hora, $fecha, $lugar, $actividad);
                    $respuesta;
                    if($actividad->insert() ){
                        $respuesta = "Se ha introducido correctamente la actividad " . $id . " en la agenda";
                    }else{
                        $respuesta = "No se ha podido introducir la actividad " . $id . " en la agenda";
                    }
                }else{
                    $respuesta = "Por favor, introduzca los datos correctamente";
                }
            }else{
                $respuesta = "Por favor, introduzca todos los datos";
            }

            return $respuesta;
        }

        public function delete(){
            if(isset( $_GET["id"])){
                $actividad = new Actividad();
                $id = $_GET["id"];

                $respuesta;
                if( $actividad->delete($id) ){
                    $respuesta = "Se ha eliminado correctamente la actividad de la agenda";
                }else{
                    $respuesta = "No se ha podido eliminar la actividad de la agenda";
                }
            }else{
                $respuesta = "Por favor, introduzca todos los datos";
            }

            return $respuesta;

        }

        public function update(){
            if(isset( $_POST["id"]) && isset($_POST["valorNuevo"]) ){
                $select = $_POST["select"];
                $actividad = new Actividad();
                $id = $_POST["id"];
                $valorNuevo = $_POST["valorNuevo"];

                $resultado;
                $respuesta = "";

                if($id != null && $valorNuevo != null && $actividad->getById($id) != false){
                    switch($select){
                        case "idContacto":
                            if($this->validarDni($valorNuevo) || $this->validarCial($valorNuevo)){
                                $resultado = $actividad->update($id, "actividades", $select, $valorNuevo);
                            }else{
                                $respuesta = "Por favor, introduzca los datos correctamente";
                            }
                            break;
                        case "hora":
                            if($this->validarHora($valorNuevo)){
                                $resultado = $actividad->update($id, "actividades", $select, $valorNuevo);
                            }else{
                                $respuesta = "Por favor, introduzca los datos correctamente";
                            }
                            break;
                        case "fecha":
                            if($this->validarFecha($valorNuevo)){
                                $resultado = $actividad->update($id, "actividades", $select, $valorNuevo);
                            }else{
                                $respuesta = "Por favor, introduzca los datos correctamente";
                            }
                            break;
                        case "lugar":
                        case "actividad":
                            $resultado = $actividad->update($id, "actividades", $select, $valorNuevo);
                            break;
                    }
    
                    if($respuesta == ""){
                        if($resultado){
                            $respuesta = "Se ha modificado correctamente el valor de " . $select . " en la agenda";
                        }else{
                            $respuesta = "No se ha podido modificar el valor de " . $select . " en la agenda.";
                        }
                    }

                }else{
                    $respuesta = "Por favor, introduzca los datos correctamente";    
                }

            }else{
                $respuesta = "Por favor, introduzca todos los datos";
            }

            return $respuesta;

        }

        public function getById(){
            $respuesta="";
            if(isset( $_GET["id"])){
                $actividad = new Actividad();
                $id = $_GET["id"];

                if($id != null){
                    $datos = $actividad->getByID($id);
                    $respuesta = '<h1 class="display-4">Datos</h1><br><table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Título (ID)</th>
                                <th scope="col">ID Contacto</th>
                                <th scope="col">Hora</th>
                                <th scope="col">Fecha</th>
                                <th scope="col">Lugar</th>
                                <th scope="col">Actividad</th>
                            </tr>
                        </thead>
                        <tbody>';
    
                    if($datos != false){
                        $respuesta = $respuesta . '
                            <tr>
                                <td>' . $datos["id"] . '</td>
                                <td>' . $datos["idContacto"] . '</td>
                                <td>' . $datos["hora"] . '</td>
                                <td>' . $datos["fecha"] . '</td>
                                <td>' . $datos["lugar"] . '</td>
                                <td>' . $datos["actividad"] . '</td>
                            </tr>
                        </tbody>
                        </table>';
                    }
                }else{
                    $respuesta = "Por favor, introduzca todos los datos";
                }
            }else{
                $respuesta = "Por favor, introduzca todos los datos";
            }
            return $respuesta;
        }

        public function getAll($sql){
            $respuesta="";
            $actividad = new Actividad();
            $datos = $actividad->getAll($sql);

            $respuesta = '<table class="table">
                    <thead>
                        <tr>
                        <th scope="col">Título (ID)</th>
                        <th scope="col">ID Contacto</th>
                        <th scope="col">Hora</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Lugar</th>
                        <th scope="col">Actividad</th>
                        </tr>
                    </thead>
                    <tbody>';
            if($datos != 0){
                foreach($datos as $p){
                    $respuesta = $respuesta . '<tr>
                        <td>' . $p["id"] . '</td>
                        <td>' . $p["idContacto"] . '</td>
                        <td>' . $p["hora"] . '</td>
                        <td>' . $p["fecha"] . '</td>
                        <td>' . $p["lugar"] . '</td>
                        <td>' . $p["actividad"] . '</td>
                    </tr>';
                }
            }

            $respuesta = $respuesta . '</tbody></table>';

            return $respuesta;
        }
        
    }

?>