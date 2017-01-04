<?php
$servername = "localhost";
$username = "alcointc_shopu";
$password = "u9DKw4g84h";
$dbname = "alcointc_shop";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}



$Name=$_POST['Name'];
$Email = $_POST['Email'];
$Trans = $_POST['Trans'];


$sql = "INSERT INTO alco (Name,Email,Trans,Amount,Option)
VALUES ('{$Name}','{$Email}','{$Trans}','{$Amount}','{$Option}')";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?> 