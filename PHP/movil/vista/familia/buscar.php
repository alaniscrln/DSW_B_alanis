<?php
require_once "./../header.php";
?>

<div class="container text-center">
    <br><br>
    <h1>BUSCAR MIEMBROS DE UNIDAD FAMILIAR</h1>

    <div class="row text-left">

        <div class="col-4 offset-4">
            <br><br><br>
            <form action="./../../controlador/ControladorPrincipal.php" method="post">
                <input type="hidden" name="accion" value="buscarFamilia">
                <div class="form-group">
                    <label for="id">ID Familiar:</label>
                    <input class="form-control" id="id" name="idFam">
                </div>
                
                <hr>

                <input type="submit" name="buscar" class="btn btn-lg btn-block btn-primary" value = "BUSCAR"></input>

            </form>
            
        </div>
        
    </div>
        
</div>

<?php
require_once "./../footer.php";
?>
