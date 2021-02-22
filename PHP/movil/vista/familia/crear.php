<?php
require_once "./../header.php";
?>

<div class="container text-center">
    <br><br>
    <h1>CREAR MIEMBROS DE UNIDAD FAMILIAR</h1>

    <div class="row text-left">

        <?php  
            require_once "./../../controlador/Validador.php";
            require_once "./../../config/database.php";           
            require "./../../core/Conectar.php";
            require "./../../core/ModeloBase.php";
            require "./../../modelo/ModeloFamilia.php";
            require "./../../modelo/Familia.php";
            require_once "./../../controlador/FamiliaControlador.php";
            $famControlador = new FamiliaControlador();
            $famControlador->crearFamilia();
        ?>
        <div class="col-4 offset-4">
            <br><br><br>
            <form action="./../../controlador/ControladorPrincipal.php" method="post">
                <input type="hidden" name="accion" value="crearPersona">
                <div class="form-group">
                    <label for="dni">DNI:</label>
                    <input class="form-control" id="dni" name="id">
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input class="form-control" id="nombre" name="nombre">
                </div>
                <div class="form-group">
                    <label for="apellido1">Apellido 1:</label>
                    <input class="form-control" id="apellido1" name="apellido1">
                </div>
                <div class="form-group">
                    <label for="apellido2">Apellido 2:</label>
                    <input class="form-control" id="apellido2" name="apellido2">
                </div>
                <div class="form-group">
                    <label for="fecha_nac">Fecha de nacimiento:</label>
                    <input class="form-control" id="fecha_nac" name="fecha_nac" placeholder="yyyy-mm-dd">
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tipo" id="tipo-tutor" value="TUTOR" checked>
                    <label class="form-check-label" for="tipo-tutor">
                        TUTOR
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tipo" id="tipo-hijo" value="HIJO" checked>
                    <label class="form-check-label" for="tipo-hijo">
                        HIJO
                    </label>
                </div>

                <hr>

                <input type="submit" name="agregar" class="btn btn-lg btn-block btn-primary" value = "AGREGAR"></input>
                <input type="submit" name="guardar" class="btn btn-lg btn-block btn-success" value = "GUARDAR"></input>

            </form>
            
        </div>
        
    </div>

    <div class="row text-left">
        <?php
            session_start();
            if(isset($_SESSION["mensaje"]) && $_SESSION["mensaje"] != null){
                $mensaje = $_SESSION["mensaje"];
                echo "<h3> $mensaje </h3>";
            }
        ?>
    </div>
        
</div>

<?php
require_once "./../footer.php";
?>
