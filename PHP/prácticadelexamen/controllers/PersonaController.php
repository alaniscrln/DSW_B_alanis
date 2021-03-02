<?php

    class PersonaController{
        use Validador;

        public function __construct(){

        }

        public function insertar(){
            if(!empty( $_REQUEST["dni"]) && !empty( $_REQUEST["nombre"]) ){
                $persona = new Persona($_REQUEST["dni"], $_REQUEST["nombre"]);
                if($this->personaValida($persona) ){
                    $respuesta;
                    if($persona->insertar($persona->__get("dni"), $persona->__get("nombre")) ){
                        $respuesta = "Se ha introducido correctamente a " . $persona->nombre . " en la agenda";
                    }else{
                        $respuesta = "No se ha podido introducir a " . $persona->nombre . " en la agenda";
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
            if(!empty( $_GET["dni"])){
                $persona = new Persona();
                $dni = $_GET["dni"];
                if($this->validarDni($dni) && $persona->buscar($dni) != 0){
                    $respuesta;
                    if( $persona->eliminar($dni) ){
                        $respuesta = "Se ha eliminado correctamente a la persona de la agenda";
                    }else{
                        $respuesta = "No se ha podido eliminar a la persona de la agenda";
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
            if(!empty( $_POST["dni"]) && !empty($_POST["valorNuevo"]) ){
                $persona = new Persona();
                $dni = $_POST["dni"];
                $select = $_POST["select"];
                $valorNuevo = $_POST["valorNuevo"];
                if($this->validarDni($dni) && $persona->buscar($dni) != 0 ){
                    $resultado;
                    $respuesta = "";
                    switch($select){
                        case "nombre":
                            $resultado = $persona->actualizar($dni, $select, $valorNuevo);
                            break;
                    }
                    
                    if($respuesta == ""){
                        if($resultado){
                            $respuesta = "Se ha modificado correctamente el valor de " . $select . " a " . $valorNuevo . " en la agenda";
                        }else{
                            $respuesta = "No se ha podido modificar el valor de " . $select . " en la agenda";
                        }
                    }
                }else{
                    $respuesta = "No se ha podido modificar el valor de " . $select . " en la agenda";
                }

            }else{
                $respuesta = "Por favor, introduzca todos los datos";
            }

            return $respuesta;

        }

        public function buscar(){
            $respuesta="";
            if(!empty( $_GET["dni"])){
                if($this->validarDni($_GET["dni"])){
                    $persona = new Persona();
                    $id = $_GET["dni"];

                    $datos = $persona->buscar($id);
                    $respuesta = '<h1 class="display-4">Datos</h1><br><table class="table">
                        <thead>
                            <tr>
                            <th scope="col">DNI</th>
                            <th scope="col">Nombre</th>
                            </tr>
                        </thead>
                        <tbody>';
    
                    if($datos != false){
                        $respuesta = $respuesta . '
                            <tr>
                                <td>' . $datos["dni"] . '</td>
                                <td>' . $datos["nombre"] . '</td>
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
            $persona = new Persona();
            $datos = $persona->getAll();

            $respuesta = '<table class="table">
                    <thead>
                        <tr>
                            <th scope="col">DNI</th>
                            <th scope="col">Nombre</th>
                        </tr>
                    </thead>
                    <tbody>';
            if($datos != 0){
                foreach($datos as $p){
                    $respuesta = $respuesta . '<tr>
                        <td>' . $p["dni"] . '</td>
                        <td>' . $p["nombre"] . '</td>
                    </tr>';
                }
            }
            
            $respuesta = $respuesta . '</tbody></table>';

            return $respuesta;
        }
        
    }

?>