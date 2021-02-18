<?php
include 'datos.php';

// Create connection
$conn = mysqli_connect(SERVER, NAME, PASS, BD);

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}
//echo "Connected successfully";
?>