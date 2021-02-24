
<?php

class ModeloEjemplo extends ModeloBase{

    private $tabla = "";
    private $clavePrimaria = "";
    public function __construct(){
        parent::__construct($this->tabla, $this->clavePrimaria);
    }

    public function insertar($a, $b, $c){
        $sql = "INSERT INTO $this->tabla VALUES('$a', '$b', '$c')";
        return parent::ejecutarSQL($sql);
    }
}

?>