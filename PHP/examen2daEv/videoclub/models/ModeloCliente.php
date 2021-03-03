
<?php

class ModeloCliente extends ModeloBase{

    private $tabla = "clientes";
    private $clavePrimaria = "dni";
    public function __construct(){
        parent::__construct($this->tabla, $this->clavePrimaria);
    }

    public function insertar($dni, $nombre, $apellidos, $edad, $calle, $numero, $cp, $provincia){
        $sql = "INSERT INTO $this->tabla VALUES('$dni', '$nombre', '$apellidos', '$edad', '$calle', '$numero' , '$cp', '$provincia')";
        return parent::ejecutarSQL($sql);
    }
}

?>