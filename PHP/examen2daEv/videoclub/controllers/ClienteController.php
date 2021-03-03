<?php

    class ClienteController{
        use ValidadorDNI;
        use ValidadorCP;

        public function __construct(){

        }

        public function insertar(){
            if(!empty( $_POST["dni"]) && !empty( $_POST["nombre"]) && !empty( $_POST["apellidos"] ) && !empty( $_POST["edad"]) 
            && !empty($_POST["calle"]) && !empty($_POST["numero"]) && !empty($_POST["cp"]) && !empty($_POST["provincia"]) ){

                $direccion = new Direccion($_POST["calle"], $_POST["numero"], $_POST["cp"], $_POST["provincia"]);
                $cliente = new Cliente($_POST["dni"], $_POST["nombre"], $_POST["apellidos"], $_POST["edad"], $direccion);

                if( $this->validarDni($cliente->__get("dni")) && $this->soloNumeros($direccion->__get("cp")) ){
                    $respuesta;
                    $insertado = $cliente->insertar(
                        $cliente->__get("dni"), $cliente->__get("nombre"), $cliente->__get("apellidos"), $cliente->__get("edad"),
                        $direccion->__get("calle"), $direccion->__get("numero"), $direccion->__get("cp"), $direccion->__get("provincia")
                    );

                    if($insertado == true){
                        $respuesta = "Se ha introducido correctamente al cliente " . $cliente->__get("nombre");
                    }else{
                        $respuesta = "No se ha podido introducir al cliente " . $cliente->__get("nombre");
                    }

                }else{
                    $respuesta = "Por favor, introduzca el DNI y/o código postal correctamente";
                }

            }else{
                $respuesta = "Por favor, introduzca todos los datos";
            }

            return $respuesta;
        }

        public function eliminar(){
            if(!empty( $_GET["dni"])){
                if($this->validarDni($_GET["dni"])){
                    $cliente = new Cliente();
                    $dni = $_GET["dni"];

                    $respuesta;
                    if( $cliente->buscar("dni",$dni) != null && $cliente->eliminar($dni) ){
                        $respuesta = "Se ha eliminado correctamente al cliente";
                    }else{
                        $respuesta = "No se ha podido eliminar al cliente";
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
                $cliente = new Cliente();
                $dni = $_POST["dni"];
                $select = $_POST["select"];
                $valorNuevo = $_POST["valorNuevo"];
                if($this->validarDni($dni) && $cliente->buscar("dni", $dni) != null ){
                    $resultado;
                    $respuesta = "";
                    switch($select){
                        case "nombre":
                        case "apellidos":
                        case "edad":
                        case "calle":
                        case "provincia":
                        case "numero":
                            $resultado = $cliente->actualizar($dni, $select, $valorNuevo);
                            break;
                        case "cp":
                            if($this->soloNumeros($valorNuevo)){
                                $resultado = $cliente->actualizar($dni, $select, $valorNuevo);
                            }else{
                                $respuesta = "Por favor, introduzca los datos correctamente";
                            }
                    }
                    
                    if($respuesta == ""){
                        if($resultado){
                            $respuesta = "Se ha modificado correctamente el valor de " . $select . " a " . $valorNuevo;
                        }else{
                            $respuesta = "No se ha podido modificar el valor de " . $select;
                        }
                    }
                }else{
                    $respuesta = "No se ha podido modificar el valor de " . $select . " por DNI incorrecto";
                }

            }else{
                $respuesta = "Por favor, introduzca todos los datos";
            }

            return $respuesta;

        }


        public function buscar($columna){
            $respuesta="";
            $validado = true;
            if(!empty( $_GET[$columna])){
                if($_GET[$columna] == "dni"){
                    $validado = $this->validarDni($_GET[$columna]);
                }

                if($validado){
                    $cliente = new Cliente();
                    $id = $_GET[$columna];

                    $datos = $cliente->buscar($columna, $id);
                    $respuesta = '<h1 class="display-4">Datos</h1><br><table class="table">
                        <thead>
                            <tr>
                                <th scope="col">DNI</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Apellidos</th>
                                <th scope="col">Edad</th>
                                <th scope="col">Calle</th>
                                <th scope="col">Número</th>
                                <th scope="col">Código Postal</th>
                                <th scope="col">Provincia</th>
                            </tr>
                        </thead>
                        <tbody>';
    
                        if($datos != null){
                            foreach($datos as $p){
                                $respuesta = $respuesta . '<tr>
                                    <td>' . $p["dni"] . '</td>
                                    <td>' . $p["nombre"] . '</td>
                                    <td>' . $p["apellidos"] . '</td>
                                    <td>' . $p["edad"] . '</td>
                                    <td>' . $p["calle"] . '</td>
                                    <td>' . $p["numero"] . '</td>
                                    <td>' . $p["cp"] . '</td>
                                    <td>' . $p["provincia"] . '</td>
            
                                </tr>';
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

        public function getAll(){
            $respuesta="";
            $cliente = new Cliente();
            $datos = $cliente->getAll();

            $respuesta = '<table class="table">
                    <thead>
                        <tr>
                            <th scope="col">DNI</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellidos</th>
                            <th scope="col">Edad</th>
                            <th scope="col">Calle</th>
                            <th scope="col">Número</th>
                            <th scope="col">Código Postal</th>
                            <th scope="col">Provincia</th>
                        </tr>
                    </thead>
                    <tbody>';
            if($datos != 0){
                foreach($datos as $p){
                    $respuesta = $respuesta . '<tr>
                        <td>' . $p["dni"] . '</td>
                        <td>' . $p["nombre"] . '</td>
                        <td>' . $p["apellidos"] . '</td>
                        <td>' . $p["edad"] . '</td>
                        <td>' . $p["calle"] . '</td>
                        <td>' . $p["numero"] . '</td>
                        <td>' . $p["cp"] . '</td>
                        <td>' . $p["provincia"] . '</td>

                    </tr>';
                }
            }
            
            $respuesta = $respuesta . '</tbody></table>';

            return $respuesta;
        }
        
    }

?>