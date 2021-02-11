<?php
    class PersonaControlador{
        use Validador;

        public function __construct(){}

        public function guardarDatosSession(){
            $resultado = "";
            if(isset( $_POST["id"]) && isset( $_POST["nombre"]) && isset( $_POST["apellido1"]) && isset( $_POST["apellido2"]) && isset( $_POST["fecha_nac"]) && isset( $_POST["tipo"]) ){
                $id = $_POST["id"];
                $nombre = $_POST["nombre"];
                $apellido1 = $_POST["apellido1"];
                $apellido2 = $_POST["apellido2"];
                $fecha_nac = $_POST["fecha_nac"];
                $tipo = $_POST["tipo"];

                $famControlador = new FamiliaControlador();
                $id_familia = $famControlador->getIDFamilia();
                
                $persona = new Persona($id, $nombre, $apellido1, $apellido2, $fecha_nac, $tipo, $id_familia);
                
                if($this->personaValida($persona)){
                    session_start();
                    $i = $_SESSION['cont'] + 1;
                    $_SESSION['cont'] = $i;

                    $cont = $_SESSION['cont'];
                    $_SESSION['persona'.$cont] = serialize($persona);
                    $resultado = $cont . "Persona(s) agregada(s) a la familia.";
                }else{
                    $resultado = "Datos de la persona no válidos.";
                }
            }else{
                $resultado = "No se pudo agregar a la persona.";
            }
            
             $_SESSION["mensaje"] = $resultado;
        }

        public function insertarFamilia(){

            $familia = new FamiliaControlador();

            session_start();
            $sessionLength = count($_SESSION);
            for($i = 1; $i < $sessionLength; $i++){
                if(isset($_SESSION["persona" . $i] )){
                    $persona = unserialize($_SESSION["persona" . $i]);
        
                    $idFam = $familia->getIDFamilia();
                    $personaNueva = new Persona();
                    $personaNueva->insertar($persona->__get("id"), $persona->__get("nombre"), $persona->__get("apellido1"), $persona->__get("apellido2"), $persona->__get("fecha_nacimiento"), $persona->__get("tipo"), $idFam);
            
                }
            }

            session_destroy();
        }

        public function listar(){
            $respuesta="";
            $persona = new Persona();
            $datos = $persona->getAll();

            $respuesta = '<table class="table">
                    <thead>
                        <tr>
                        <th scope="col">DNI</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido 1</th>
                        <th scope="col">Apellido 2</th>
                        <th scope="col">Fecha de nacimiento</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">ID Familiar</th>
                        </tr>
                    </thead>
                    <tbody>';
            if($datos != 0){
                foreach($datos as $p){
                    $respuesta = $respuesta . '<tr>
                        <td>' . $p["id"] . '</td>
                        <td>' . $p["nombre"] . '</td>
                        <td>' . $p["apellido1"] . '</td>
                        <td>' . $p["apellido2"] . '</td>
                        <td>' . $p["fecha_nacimiento"] . '</td>
                        <td>' . $p["tipo"] . '</td>
                        <td>' . $p["id_familia"] . '</td>
                    </tr>';
                }
            }

            $respuesta = $respuesta . '</tbody></table>';

            return $respuesta;
        }
    
    }

?>