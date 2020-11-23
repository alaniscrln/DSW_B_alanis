<html>
<head>
<title>CALCULADORA</title>
</head>
<body>

    <?php
    
        $y = $_POST['a'];
        $z = $_POST['b'];
       
        if( isset ($_POST['btnsuma']) ){
            $c = $y + $z;
            echo "$y + $z = $c";
        }else if( isset ($_POST['btnresta']) ){
            $c = $y - $z;
            echo "$y - $z = $c";    
        }else if(isset ($_POST['btnmult']) ){
            $c = $y * $z;
            echo "$y * $z = $c";
        }else if(isset ($_POST['btndiv']) ){
            
            if( $z != 0 ){
                $c = $y / $z;
            }else{
                $c = 0;
            }
            echo "$y / $z = $c";
        }
    ?>

    <form name="calc" action="calculadora2.php" method="POST">
        A: <input type="text" name="a" size="10" value="<? echo $y; ?>">
        B: <input type="text" name="b" size="10" value="<? echo $z; ?>">
        <br>
        <input type="submit"value="sumar" name="btnsuma">
        <input type="submit"value="restar" name="btnresta">
        <input type="submit"value="multiplicar" name="btnmult">
        <input type="submit"value="dividir" name="btndiv">
    </form>

</body>
</html>