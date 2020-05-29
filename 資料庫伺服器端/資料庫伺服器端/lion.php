<?php
	$db = '163.13.201.116';
	$db_account = 'luli';
	$db_password = '1234';
	$db_name = "baseball";

	$connection = mysqli_connect($db,$db_account,$db_password , $db_name);
	mysqli_query($connection, 'SET NAMES utf8');
	$sql = "select * from lion ORDER BY CAST(`number` AS UNSIGNED)ASC";
	
	
	
    $result = mysqli_query($connection, $sql) or die("error " . mysqli_error($connection));
    $emparray = array();
    while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }
    //echo json_encode($emparray,JSON_UNESCAPED_UNICODE);
	//echo json_encode(array($emparray),JSON_UNESCAPED_UNICODE);
	echo json_encode($emparray,JSON_UNESCAPED_UNICODE);
	


    mysqli_close($connection);

?>