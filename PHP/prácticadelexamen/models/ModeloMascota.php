
<?php

class ModeloMascota extends ModeloBase{

    private $tabla = "mascotas";
    private $clavePrimaria = "id";
    public function __construct(){
        parent::__construct($this->tabla, $this->clavePrimaria);
    }

    public function insertar($raza, $fecha_nacimiento, $id_propietario){
        $sql = "INSERT INTO $tabla VALUES('null', '$raza', '$fecha_nacimiento', '$id_propietario')";
        $resultado = parent::ejecutarSQL($sql);
    }
}

?>