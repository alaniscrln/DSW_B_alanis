<?php

    class EmpresaController{
        use Validador;

        public function __construct(){

        }

        public function insert(){
            if(isset( $_POST["id"]) && isset( $_POST["nombre"]) && isset( $_POST["telefono"]) && isset( $_POST["web"] ) ){
                if($this->validarCial($_POST["id"]) && $this->soloNumeros($_POST["telefono"]) ){
                    $id = $_POST["id"];
                    $nombre = $_POST["nombre"];
                    $telefono = $_POST["telefono"];
                    $web = $_POST["web"];
                    
                    $empresa = new Empresa($id, $nombre, $telefono, $web);
                    $respuesta;
                    if($empresa->insert() ){
                        $respuesta = "Se ha introducido correctamente a " . $nombre . " en la agenda";
                    }else{
                        $respuesta = "No se ha podido introducir a " . $nombre . " en la agenda";
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
                if($this->validarCial($_GET["id"])){
                    $empresa = new Empresa();
                    $id = $_GET["id"];

                    $respuesta;
                    if( $empresa->delete($id) ){
                        $respuesta = "Se ha eliminado correctamente a la empresa de la agenda";
                    }else{
                        $respuesta = "No se ha podido eliminar a la empresa de la agenda";
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
            if(isset( $_POST["id"]) && isset($_POST["valorNuevo"]) ){
                $select = $_POST["select"];
                $empresa = new Empresa();
                $id = $_POST["id"];
                $valorNuevo = $_POST["valorNuevo"];
                $resultado = false;
                $respuesta = "";
                if($this->validarCial($id) && $valorNuevo != null){
                    switch($select){
                        case "nombre":
                        case "web":
                            $resultado = $empresa->update($id, "empresas", $select, $valorNuevo);
                            break;
                        case "telefono":
                            if($this->soloNumeros($valorNuevo)){
                                $resultado = $empresa->update($id, "empresas", $select, $valorNuevo);
                            }else{
                                $respuesta = "Por favor, introduzca los datos correctamente";
                            }
                            break;
                    }
                    
                }

                if($respuesta == ""){
                    if($resultado){
                        $respuesta = "Se ha modificado correctamente el valor de " . $select . " en la agenda";
                    }else{
                        $respuesta = "No se ha podido modificar el valor de " . $select . " en la agenda";
                    }
                }

            }else{
                $respuesta = "Por favor, introduzca todos los datos";
            }

            return $respuesta;

        }

        public function getById(){
            $respuesta="";
            if(isset( $_GET["id"])){
                if($this->validarCial($_GET["id"])){
                    $empresa = new Empresa();
                    $id = $_GET["id"];
                    $datos = $empresa->getByID($id);
                    $respuesta = '<h1 class="display-4">Datos</h1><br><table class="table">
                    <thead>
                        <tr>
                            <th scope="col">CIAL</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Teléfono</th>
                            <th scope="col">Página web</th>
                        </tr>
                    </thead>
                    <tbody>';
                    if($datos != false){
                        $respuesta = $respuesta .
                            '<tr>
                                <td>' . $datos["id"] . '</td>
                                <td>' . $datos["nombre"] . '</td>
                                <td>' . $datos["telefono"] . '</td>
                                <td>' . $datos["web"] . '</td>
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
            $sql= "SELECT c.id, c.nombre, c.telefono, e.web FROM contactos c INNER JOIN empresas e on c.id = e.id WHERE c.tipo = 'Empresa'";
            $datos = $persona->getAll($sql);

            $respuesta = '<table class="table">
                    <thead>
                        <tr>
                            <th scope="col">CIAL</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Teléfono</th>
                            <th scope="col">Página web</th>
                        </tr>
                    </thead>
                    <tbody>';
            if($datos != 0){
                foreach($datos as $p){
                    $respuesta = $respuesta . '<tr>
                        <td>' . $p["id"] . '</td>
                        <td>' . $p["nombre"] . '</td>
                        <td>' . $p["telefono"] . '</td>
                        <td>' . $p["web"] . '</td>
                    </tr>';
                }
            }
            
            $respuesta = $respuesta . '</tbody></table>';

            return $respuesta;
        }
        
    }

?>