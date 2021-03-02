
<?php

class ModeloPersona extends ModeloBase{

    private $tabla = "personas";
    private $clavePrimaria = "dni";
    public function __construct(){
        parent::__construct($this->tabla, $this->clavePrimaria);
    }

    public function insertar($dni, $nombre){
        $sql = "INSERT INTO $this->tabla VALUES('$dni', '$nombre')";
        return parent::ejecutarSQL($sql);
    }
}

?>