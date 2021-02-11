<?php
require_once "header.php";
?>

<?php
    session_start();
    $_SESSION['cont'] = 0;
?>
<div class="container text-center">
    <br><br><br><br>
    <h1 class="display-4">FAMILIA</h1>
    <div class="row">
        <div class="col-4 offset-4">
            <div class="btn-group" role="group">
                <button type="button" class="btn btn-secondary" onclick="location.href='./familia/crear.php'">CREAR</button>
                <button type="button" class="btn btn-secondary" onclick="location.href='./familia/eliminar.php'">ELIMINAR</button>
                <button type="button" class="btn btn-secondary" onclick="location.href='./vista/familiaIndex.php'">MODIFICAR</button>
                <button type="button" class="btn btn-secondary" onclick="location.href='./familia/buscar.php'">BUSCAR</button>
            </div>
        </div>
    </div>
    <div class="row">
    <?php
        if( isset($_SESSION["listaPersonas"]) && $_SESSION["listaPersonas"] != null){
            echo "<br><br>" . $_SESSION["listaPersonas"];
        }
    ?>
    </div>
</div>

<?php
require_once "footer.php";
?>
