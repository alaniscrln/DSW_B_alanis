<?php

    class EjemploController{
        use Validador;

        public function __construct(){

        }

        public function insert(){
            if(!empty( $_POST["id"]) && !empty( $_POST["nombre"]) && !empty( $_POST["cumpleanos"] ) ){
                $persona = new Persona($_POST["id"], $_POST["nombre"], $_POST["cumpleanos"]);
                if($this->validar($persona) ){
                    $respuesta;
                    if($persona->insert("","","","","") ){
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

        public function delete(){
            if(!empty( $_GET["id"])){
                if($this->validarDni($_GET["id"])){
                    $persona = new Persona();
                    $id = $_GET["id"];

                    $respuesta;
                    if( $persona->delete($id) ){
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

        public function update(){
            if(!empty( $_POST["id"]) && !empty($_POST["valorNuevo"]) ){
                $persona = new Persona();
                $id = $_POST["id"];
                $select = $_POST["select"];
                $valorNuevo = $_POST["valorNuevo"];
                if($this->validarDni($id) && $persona->getByID($id) != 0 ){
                    $resultado;
                    $respuesta = "";
                    switch($select){
                        case "nombre":
                            $resultado = $persona->update($id, "contactos", $select, $valorNuevo);
                            break;
                        case "telefono":
                            if($this->soloNumeros($valorNuevo)){
                                $resultado = $persona->update($id, "contactos", $select, $valorNuevo);
                            }else{
                                $respuesta = "Por favor, introduzca los datos correctamente";
                            }
                            break;
                        case "cumpleanos":
                            if($this->validarFecha($valorNuevo)){
                                $resultado = $persona->update($id, "personas", $select, $valorNuevo);
                            }else{
                                $respuesta = "Por favor, introduzca los datos correctamente";
                            }
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

        public function getById(){
            $respuesta="";
            if(!empty( $_GET["id"])){
                if($this->validarDni($_GET["id"])){
                    $persona = new Persona();
                    $id = $_GET["id"];

                    $datos = $persona->getByID($id);
                    $respuesta = '<h1 class="display-4">Datos</h1><br><table class="table">
                        <thead>
                            <tr>
                            <th scope="col">DNI</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Teléfono</th>
                            <th scope="col">Cumpleaños</th>
                            </tr>
                        </thead>
                        <tbody>';
    
                    if($datos != false){
                        $respuesta = $respuesta . '
                            <tr>
                                <td>' . $datos["id"] . '</td>
                                <td>' . $datos["nombre"] . '</td>
                                <td>' . $datos["telefono"] . '</td>
                                <td>' . $datos["cumpleanos"] . '</td>
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
            $sql= "SELECT c.id, c.nombre, c.telefono, p.cumpleanos FROM contactos c INNER JOIN personas p on c.id = p.id WHERE c.tipo = 'Persona'";
            $datos = $persona->getAll($sql);

            $respuesta = '<table class="table">
                    <thead>
                        <tr>
                            <th scope="col">DNI</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Teléfono</th>
                            <th scope="col">Cumpleaños</th>
                        </tr>
                    </thead>
                    <tbody>';
            if($datos != 0){
                foreach($datos as $p){
                    $respuesta = $respuesta . '<tr>
                        <td>' . $p["id"] . '</td>
                        <td>' . $p["nombre"] . '</td>
                        <td>' . $p["telefono"] . '</td>
                        <td>' . $p["cumpleanos"] . '</td>
                    </tr>';
                }
            }
            
            $respuesta = $respuesta . '</tbody></table>';

            return $respuesta;
        }
        
    }

?>