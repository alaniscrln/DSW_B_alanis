<?php

    class ContactoController{

        public function __construct(){

        }

        public function getAll($sql){
            $respuesta="";
            $entidad = new EntidadBase("contactos");
            $datos = $entidad->getAll($sql);

            $respuesta = '<table class="table">
                    <thead>
                        <tr>
                        <th scope="col">DNI/CIAL</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Teléfono</th>
                        <th scope="col">Fecha de cumpleaños</th>
                        <th scope="col">Página web</th>
                        </tr>
                    </thead>
                    <tbody>';
            if($datos != 0){
                foreach($datos as $p){
                    $respuesta = $respuesta . '<tr>
                        <td>' . $p["id"] . '</td>
                        <td>' . $p["tipo"] . '</td>
                        <td>' . $p["nombre"] . '</td>
                        <td>' . $p["telefono"] . '</td>';

                    if($p["cumpleanos"] == null) $respuesta = $respuesta . '<td> - </td>';
                    else $respuesta = $respuesta . '<td>' . $p["cumpleanos"] . '</td>';
                    
                    if($p["web"] == null) $respuesta = $respuesta . '<td> - </td>';
                    else $respuesta = $respuesta . '<td>' . $p["web"] . '</td>';

                    $respuesta = $respuesta . '</tr>';
                }
            }

            $respuesta = $respuesta . '</tbody></table>';

            return $respuesta;
        }
        
    }

?>