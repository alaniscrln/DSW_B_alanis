<?php

    class MascotaController{
        use Validador;

        public function __construct(){

        }

        public function insertar(){
            if( !empty( $_POST["raza"]) && !empty( $_POST["fecha_nacimiento"] ) && !empty( $_POST["id_propietario"] ) ){
                $mascota = new Mascota($_POST["raza"], $_POST["fecha_nacimiento"], $_POST["id_propietario"]);
                $persona = new Persona();
                if($this->mascotaValida($mascota) 
                && $persona->buscar($mascota->__get("id_propietario"))!= 0 ){

                    $respuesta;
                    if($mascota->insertar() ){
                        $respuesta = "Se ha introducido correctamente a " . $mascota->__get("nombre");
                    }else{
                        $respuesta = "No se ha podido introducir a " . $mascota->__get("nombre");
                    }
                }else{
                    $respuesta = "Por favor, introduzca los datos correctamente";
                }
            }else{
                $respuesta = "Por favor, introduzca todos los datos";
            }

            return $respuesta;
        }

        public function eliminar(){
            if(!empty( $_GET["id"])){
                if($this->soloNumeros($_GET["id"])){
                    $mascota = new Mascota();
                    $id = $_GET["id"];

                    $respuesta;
                    if( $mascota->eliminar($id) ){
                        $respuesta = "Se ha eliminado correctamente a la mascota";
                    }else{
                        $respuesta = "No se ha podido eliminar a la mascota";
                    }
                }else{
                    $respuesta = "Por favor, introduzca los datos correctamente";
                }
            }else{
                $respuesta = "Por favor, introduzca todos los datos";
            }

            return $respuesta;
        }

        public function actualizar(){
            if(!empty( $_POST["id"]) && !empty($_POST["valorNuevo"]) ){
                $mascota = new Mascota();
                $id = $_POST["id"];
                $select = $_POST["select"];
                $valorNuevo = $_POST["valorNuevo"];
                if($this->soloNumeros($id)){
                    $resultado;
                    $respuesta = "";
                    switch($select){
                        case "id_propietario":
                            $persona = new Persona();
                            if($persona->buscar($valorNuevo) != 0 ){
                                $resultado = $mascota->actualizar($id, $select, $valorNuevo);
                            }else{
                                $respuesta = "Por favor, introduzca los datos correctamente";
                            }
                            break;
                        case "fecha_nacimiento":
                            if($this->validarFecha($valorNuevo)){
                                $resultado = $mascota->actualizar($id, $select, $valorNuevo);
                            }else{
                                $respuesta = "Por favor, introduzca los datos correctamente";
                            }
                            break;
                    }
                    
                    if($respuesta == ""){
                        if($resultado){
                            $respuesta = "Se ha modificado correctamente el valor de " . $select . " a " . $valorNuevo;
                        }else{
                            $respuesta = "No se ha podido modificar el valor de " . $select;
                        }
                    }
                }else{
                    $respuesta = "No se ha podido modificar el valor de " . $select;
                }

            }else{
                $respuesta = "Por favor, introduzca todos los datos";
            }

            return $respuesta;

        }

        public function buscar(){
            $respuesta="";
            if(!empty( $_GET["id"])){
                if($this->soloNumeros($_GET["id"])){
                    $mascota = new Mascota();
                    $id = $_GET["id"];

                    $datos = $mascota->buscar($id);
                    $respuesta = '<h1 class="display-4">Datos</h1><br><table class="table">
                        <thead>
                            <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Raza</th>
                            <th scope="col">Fecha nacimiento</th>
                            <th scope="col">DNI propietario</th>
                            </tr>
                        </thead>
                        <tbody>';
    
                    if($datos != false){
                        $respuesta = $respuesta . '
                            <tr>
                                <td>' . $datos["id"] . '</td>
                                <td>' . $datos["raza"] . '</td>
                                <td>' . $datos["fecha_nacimiento"] . '</td>
                                <td>' . $datos["id_propietario"] . '</td>
                            </tr>
                        </tbody>
                        </table>';
                    }
                }else{
                    $respuesta = "Por favor, introduzca los datos correctamente"; 
                }
            }else{
                $respuesta = "Por favor, introduzca todos los datos";
            }
            return $respuesta;
        }

        public function getAll(){
            $respuesta="";
            $mascota = new Mascota();
            $sql= "SELECT * FROM $mascota->tabla";
            $datos = $mascota->getAll($sql);

            $respuesta = '<table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Raza</th>
                            <th scope="col">Fecha nacimiento</th>
                            <th scope="col">DNI propietario</th>
                        </tr>
                    </thead>
                    <tbody>';
            if($datos != 0){
                foreach($datos as $p){
                    $respuesta = $respuesta . '<tr>
                        <td>' . $datos["id"] . '</td>
                        <td>' . $datos["raza"] . '</td>
                        <td>' . $datos["fecha_nacimiento"] . '</td>
                        <td>' . $datos["id_propietario"] . '</td>
                    </tr>';
                }
            }
            
            $respuesta = $respuesta . '</tbody></table>';

            return $respuesta;
        }
        
    }

?>